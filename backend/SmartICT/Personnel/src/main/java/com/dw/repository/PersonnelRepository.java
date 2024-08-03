package com.dw.repository;

import com.dw.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonnelRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findByUserNameOrEmail(String userName, String Email);
    void deleteByUserNameOrEmail(String userName, String Email);
}
