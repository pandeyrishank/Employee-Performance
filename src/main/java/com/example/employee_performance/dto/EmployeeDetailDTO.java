package com.example.employee_performance.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDetailDTO {
	private Long id;
    private String name;
    private String email;
    private String departmentName;
    private List<String> projectNames;
    private List<PerformanceReviewDTO> lastReviews;

}
