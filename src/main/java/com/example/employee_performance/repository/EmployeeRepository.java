package com.example.employee_performance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_performance.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
