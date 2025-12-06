package com.team1.hackathonbackend.repositories;

import com.team1.hackathonbackend.domain.entities.Department;
import com.team1.hackathonbackend.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByDepartment(Department department);
}
