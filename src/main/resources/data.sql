
-- Delete existing data (clear all tables due to foreign key constraints)
DELETE FROM budget_item;
DELETE FROM actions;
DELETE FROM sub_tasks;
DELETE FROM tasks;
DELETE FROM functions;
DELETE FROM finance_sources;
DELETE FROM paragraphs;
DELETE FROM sub_sections;
DELETE FROM sections;
DELETE FROM budget_parts;
DELETE FROM users;
DELETE FROM departments;

-- Departments
INSERT INTO departments (id, name) VALUES
                                       (1, 'Centrum Informatyki'),
                                       (2, 'Dział Analiz Budżetowych'),
                                       (3, 'Departament Finansów'),
                                       (4, 'Biuro Planowania'),
                                       (5, 'Sekcja Cyberbezpieczeństwa');

-- Users
INSERT INTO users (id, username, password, role, organization_unit_id) VALUES
                                                                           (1, 'admin_user', 'Qwerty1', 'SUPER_ADMIN', 1),
                                                                           (2, 'budget_manager', 'Qwerty1', 'DEP_ADMIN', 2),
                                                                           (3, 'analyst_user', 'Qwerty1', 'DEP_USER', 3),
                                                                           (4, 'viewer_user', 'Qwerty1', 'DEP_USER', 1),
                                                                           (5, 'dept_head', 'Qwerty1', 'DEP_USER', 2);

-- Budget Parts (Części Budżetowe)
INSERT INTO budget_parts (id, name) VALUES
                                        ('BP001', 'Część Bieżąca'),
                                        ('BP002', 'Część Majątkowa'),
                                        ('BP003', 'Część Bieżąca - Wynagrodzenia'),
                                        ('BP004', 'Część Majątkowa - Inwestycje IT'),
                                        ('BP005', 'Część Bieżąca - Zakupy');

-- Sections (Działy)
INSERT INTO sections (id, name) VALUES
                                    ('S001', 'Ogólne zadania publiczne'),
                                    ('S002', 'Obronę i bezpieczeństwo publiczne'),
                                    ('S003', 'Edukacja'),
                                    ('S004', 'Ochronę zdrowia'),
                                    ('S005', 'Sztuczną inteligencję');

-- SubSections (Rozdziały)
INSERT INTO sub_sections (id, name) VALUES
                                        ('SS001', 'Wymiar sprawiedliwości'),
                                        ('SS002', 'Bezpieczeństwo publiczne'),
                                        ('SS003', 'Cyberbezpieczeństwo'),
                                        ('SS004', 'Nauka i badania'),
                                        ('SS005', 'Infrastruktura cyfrowa');

-- Paragraphs (Paragrafy)
INSERT INTO paragraphs (id, name) VALUES
                                      ('P001', 'Wynagrodzenia i składki pracowników'),
                                      ('P002', 'Zakup materiałów i usług'),
                                      ('P003', 'Remontów i utrzymania'),
                                      ('P004', 'Projektów i badań naukowych'),
                                      ('P005', 'Inwestycji w technologię');

-- Finance Sources (Źródła Finansowania)
INSERT INTO finance_sources (id, name) VALUES
                                           ('FS001', 'Budżet Państwa'),
                                           ('FS002', 'Fundusze Europejskie'),
                                           ('FS003', 'Kredyty i pożyczki'),
                                           ('FS004', 'Dotacje'),
                                           ('FS005', 'Źródła własne');

-- Functions (Funkcje)
INSERT INTO functions (id, name) VALUES
                                     (1, 'Bezpieczeństwo informacyjne'),
                                     (2, 'Transformacja cyfrowa'),
                                     (3, 'Zarządzanie projektami IT'),
                                     (4, 'Administracja sieciowa'),
                                     (5, 'Wsparcie użytkowników');

-- Tasks (Zadania)
INSERT INTO tasks (id, name, function_id) VALUES
                                              (1, 'Wdrożenie systemu do zarządzania budżetem', 1),
                                              (2, 'Modernizacja infrastruktury serwerowej', 2),
                                              (3, 'Audyt bezpieczeństwa IT', 1),
                                              (4, 'Szkolenia pracowników z zakresu cyberbezpieczeństwa', 5),
                                              (5, 'Implementacja sztucznej inteligencji w procesach biznesowych', 3);

-- Sub Tasks (Podzadania)
INSERT INTO sub_tasks (id, name, task_id) VALUES
                                              (1, 'Analiza wymagań systemu', 1),
                                              (2, 'Projektowanie bazy danych', 1),
                                              (3, 'Testy penetracyjne', 3),
                                              (4, 'Przygotowanie raportów z audytu', 3),
                                              (5, 'Organizacja sesji szkoleniowych', 4);

-- Actions (Akcje)
INSERT INTO actions (id, description, subtask_id) VALUES
                                                      (1, 'Przeprowadzić spotkanie z interesariuszami', 1),
                                                      (2, 'Przygotować dokumentację techniczną', 2),
                                                      (3, 'Wykonać testy bezpieczeństwa', 3),
                                                      (4, 'Opracować raport final', 4),
                                                      (5, 'Zaplanować harmonogram szkoleń', 5);

-- Budget Items
INSERT INTO budget_item (id,
    budget_part_id, section_id, sub_section_id, paragraph_id, finance_source_id,
    expense_group, action_id, project_name, department_id, planwi, administrator_of_funds,
    budget, task_name, detailed_task_justification, allocation_of_expenses,
    financial_needs_for2026, limit_of_expenses_for2026, first_money_for_realization_in2026,
    money_in_agreement_for2026, agreement_number_for2026,
    financial_needs_for2027, limit_of_expenses_for2027, second_money_for_realization_in2026,
    money_in_agreement_for2027, agreement_number_for2027,
    financial_needs_for2028, limit_of_expenses_for2028, third_money_for_realization_in2026,
    money_in_agreement_for2028, agreement_number_for2028,
    financial_needs_for2029, limit_of_expenses_for2029, forth_money_for_realization_in2026,
    money_in_agreement_for2029, agreement_number_for2029,
    contract_with, legal_basis_for_subsidy, comments
) VALUES
      (
          1, 'BP001', 'S001', 'SS001', 'P001', 'FS001',
          'IT', 1, 'System Zarządzania Budżetem', 1, 'WI-2026-001', 'Jan Kowalski',
          '500000', 'Wdrożenie systemu', 'System niezbędny do efektywnego zarządzania budżetem organizacji',
          'Sztuczna inteligencja',
          500000, 500000, 0, 250000, 'UZP-2026-001',
          450000, 450000, 0, 225000, 'UZP-2027-001',
          450000, 450000, 0, 225000, 'UZP-2028-001',
          400000, 400000, 0, 200000, 'UZP-2029-001',
          'ABC Systems Sp. z o.o.', 'Uchwała nr 15/2026', 'Projekt kluczowy'
      ),
      (
          2, 'BP002', 'S002', 'SS003', 'P005', 'FS002',
          'Cyberbezpieczeństwo', 3, 'Audyt Bezpieczeństwa', 5, 'WI-2026-002', 'Anna Nowak',
          '150000', 'Przeprowadzenie audytu IT', 'Audyt wymagany zgodnie z regulacjami branżowymi',
          'Cyberbezpieczeństwo',
          150000, 150000, 0, 75000, 'UZP-2026-002',
          0, 0, 0, 0, NULL,
          0, 0, 0, 0, NULL,
          0, 0, 0, 0, NULL,
          'CyberSec Consulting', 'Uchwała nr 22/2026', 'Audyt obowiązkowy'
      ),
      (
          3, 'BP001', 'S005', 'SS005', 'P002', 'FS003',
          'Infrastruktura', 5, 'Modernizacja Serwerów', 2, 'WI-2026-003', 'Piotr Lewandowski',
          '800000', 'Upgrade infrastruktury', 'Obecne serwery wymagają modernizacji z powodu wiekuu',
          'Koszty funkcjonowania',
          800000, 600000, 200000, 400000, 'UZP-2026-003',
          600000, 500000, 100000, 300000, 'UZP-2027-002',
          500000, 400000, 100000, 250000, 'UZP-2028-002',
          400000, 300000, 100000, 200000, 'UZP-2029-002',
          'Dell Technologies Poland', 'Umowa nr 45/2026', 'Wieloletni projekt'
      ),
      (
          4, 'BP003', 'S001', 'SS004', 'P001', 'FS001',
          'Zasobów ludzkich', 4, 'Szkolenia Cyberbezpieczeństwa', 1, 'WI-2026-004', 'Maria Jasińska',
          '75000', 'Szkolenia pracowników', 'Podniesienie świadomości bezpieczeństwa wśród zespołu',
          'Cyberbezpieczeństwo',
          75000, 75000, 0, 37500, 'UZP-2026-004',
          80000, 80000, 0, 40000, 'UZP-2027-003',
          85000, 85000, 0, 42500, 'UZP-2028-003',
          90000, 90000, 0, 45000, 'UZP-2029-003',
          'Training Plus Sp. z o.o.', 'Umowa nr 56/2026', 'Program roczny'
      ),
      (
          5, 'BP002', 'S005', 'SS005', 'P005', 'FS004',
          'Sztuczna inteligencja', 1, 'Implementacja AI', 2, 'WI-2026-005', 'Tomasz Zieliński',
          '600000', 'Wdrożenie AI w procesach', 'Automatyzacja procesów biznesowych za pomocą AI',
          'Sztuczna inteligencja',
          600000, 600000, 0, 300000, 'UZP-2026-005',
          550000, 550000, 0, 275000, 'UZP-2027-004',
          500000, 500000, 0, 250000, 'UZP-2028-004',
          450000, 450000, 0, 225000, 'UZP-2029-004',
          'AI Solutions GmbH', 'Dotacja nr 12/2026', 'Projekt finansowany z UE'
      );

-- Sequence initialization
ALTER SEQUENCE user_id_seq RESTART WITH 6;
ALTER SEQUENCE budget_item_id_seq RESTART WITH 6;