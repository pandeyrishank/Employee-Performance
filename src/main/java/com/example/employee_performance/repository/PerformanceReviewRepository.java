package com.example.employee_performance.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_performance.entity.PerformanceReview;

@Repository
public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {
	 List<PerformanceReview> findByEmployeeIdOrderByReviewDateDesc(Long employeeId);

	 List<PerformanceReview> findByReviewDateAndScore(LocalDate reviewDate, Integer score);

}
