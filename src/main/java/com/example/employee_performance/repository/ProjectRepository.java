package com.example.employee_performance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_performance.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
