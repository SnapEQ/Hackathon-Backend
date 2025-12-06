package com.team1.hackathonbackend.repositories;


import com.team1.hackathonbackend.domain.entities.Role;
import com.team1.hackathonbackend.domain.entities.User;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String name);

    @EntityGraph(attributePaths = "department")
    Optional<User> findByDepartmentId(Long departmentId);

    List<User> findAllByRole(Role role);

}
