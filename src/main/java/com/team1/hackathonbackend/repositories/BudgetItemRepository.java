package com.team1.hackathonbackend.repositories;

import com.team1.hackathonbackend.domain.entities.BudgetItem;
import com.team1.hackathonbackend.domain.entities.Department;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetItemRepository extends JpaRepository<BudgetItem, Long> {
    List<BudgetItem> findAllByDepartmentId(Long departmentId);

    List<BudgetItem> findAllByDepartment(Department department);
//
//    /**
//     * Acquire PESSIMISTIC_WRITE lock for editing
//     * Prevents other transactions from reading or modifying
//     */
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    @QueryHints({
//            @QueryHint(name = "jakarta.persistence.lock.timeout", value = "5000")  // 5 second timeout
//    })
//    Optional<BudgetItem> findByIdForUpdate(Long id);
//
//    /**
//     * Acquire PESSIMISTIC_READ lock for viewing
//     * Prevents modifications but allows other reads
//     */
//    @Lock(LockModeType.PESSIMISTIC_READ)
//    @QueryHints({
//            @QueryHint(name = "jakarta.persistence.lock.timeout", value = "3000")
//    })
//    Optional<BudgetItem> findByIdForRead(Long id);
//
//    /**
//     * NO_WAIT variant - fails immediately if locked
//     * Use for non-blocking attempts
//     */
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    @QueryHints({
//            @QueryHint(name = "jakarta.persistence.lock.timeout", value = "0")  // NO_WAIT
//    })
//    Optional<BudgetItem> findByIdNoWait(Long id);
}
