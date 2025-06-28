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
public class Project {
	 @Id @GeneratedValue
	    private Long id;

	    private String name;
	    private LocalDate startDate;
	    private LocalDate endDate;

	    @ManyToOne
	    @JoinColumn(name = "department_id")
	    private Department department;

}
