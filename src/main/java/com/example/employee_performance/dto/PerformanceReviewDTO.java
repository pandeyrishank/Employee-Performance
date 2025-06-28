package com.example.employee_performance.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerformanceReviewDTO {
	private LocalDate reviewDate;
    private Integer score;
    private String reviewComments;

}
