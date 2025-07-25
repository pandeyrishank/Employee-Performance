package com.example.employee_performance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {
	  @Id @GeneratedValue
	    private Long id;

	    private String name;
	    private Double budget;

}
