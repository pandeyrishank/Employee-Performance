package com.example.employee_performance.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PerformanceReview {
	 @Id @GeneratedValue
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "employee_id")
	    private Employee employee;

	    private LocalDate reviewDate;
	    private Integer score;
	    private String reviewComments;

}
