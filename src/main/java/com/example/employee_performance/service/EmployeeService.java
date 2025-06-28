package com.example.employee_performance.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_performance.dto.EmployeeDTO;
import com.example.employee_performance.dto.EmployeeDetailDTO;
import com.example.employee_performance.dto.PerformanceReviewDTO;
import com.example.employee_performance.entity.Employee;
import com.example.employee_performance.entity.PerformanceReview;
import com.example.employee_performance.entity.Project;
import com.example.employee_performance.repository.EmployeeRepository;
import com.example.employee_performance.repository.PerformanceReviewRepository;

@Service
public class EmployeeService {
	    
		@Autowired
	    private EmployeeRepository employeeRepository;

	    @Autowired
	    private PerformanceReviewRepository performanceReviewRepository;

	    public List<EmployeeDTO> searchEmployees(Integer score, LocalDate reviewDate, List<String> departments, List<String> projects) {
	        return employeeRepository.findAll().stream()
	            .filter(emp -> {
	                boolean matches = true;

	                if (departments != null && !departments.isEmpty()) {
	                    matches &= departments.stream()
	                        .anyMatch(dep -> emp.getDepartment() != null && emp.getDepartment().getName().toLowerCase().contains(dep.toLowerCase()));
	                }

	                if (projects != null && !projects.isEmpty()) {
	                    matches &= emp.getProjects().stream()
	                        .anyMatch(proj -> projects.stream()
	                            .anyMatch(p -> proj.getName().toLowerCase().contains(p.toLowerCase())));
	                }

	                if (score != null && reviewDate != null) {
	                    List<PerformanceReview> reviews = performanceReviewRepository.findByReviewDateAndScore(reviewDate, score);
	                    matches &= reviews.stream().anyMatch(r -> r.getEmployee().getId().equals(emp.getId()));
	                }

	                return matches;
	            })
	            .map(emp -> {
	                EmployeeDTO dto = new EmployeeDTO();
	                dto.setId(emp.getId());
	                dto.setName(emp.getName());
	                dto.setEmail(emp.getEmail());
	                dto.setDepartmentName(emp.getDepartment() != null ? emp.getDepartment().getName() : null);
	                return dto;
	            })
	            .collect(Collectors.toList());
	    }
	    
	    
	    public EmployeeDetailDTO getEmployeeDetail(Long id) {
	        Employee employee = employeeRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	        EmployeeDetailDTO detailDTO = new EmployeeDetailDTO();
	        detailDTO.setId(employee.getId());
	        detailDTO.setName(employee.getName());
	        detailDTO.setEmail(employee.getEmail());
	        detailDTO.setDepartmentName(employee.getDepartment() != null ? employee.getDepartment().getName() : null);
	        detailDTO.setProjectNames(employee.getProjects().stream()
	            .map(Project::getName)
	            .collect(Collectors.toList()));

	        List<PerformanceReviewDTO> reviews = performanceReviewRepository.findByEmployeeIdOrderByReviewDateDesc(id)
	            .stream()
	            .limit(3)
	            .map(review -> {
	                PerformanceReviewDTO dto = new PerformanceReviewDTO();
	                dto.setReviewDate(review.getReviewDate());
	                dto.setScore(review.getScore());
	                dto.setReviewComments(review.getReviewComments());
	                return dto;
	            })
	            .collect(Collectors.toList());

	        detailDTO.setLastReviews(reviews);
	        return detailDTO;
	    }

}
