package com.example.employee_performance.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_performance.dto.EmployeeDTO;
import com.example.employee_performance.dto.EmployeeDetailDTO;
import com.example.employee_performance.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	 @Autowired
	    private EmployeeService employeeService;

	    @GetMapping("/search")
	    public List<EmployeeDTO> searchEmployees(
	            @RequestParam(required = false) Integer score,
	            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reviewDate,
	            @RequestParam(required = false) List<String> departments,
	            @RequestParam(required = false) List<String> projects) {
	        return employeeService.searchEmployees(score, reviewDate, departments, projects);
	    }

	    @GetMapping("/{id}")
	    public EmployeeDetailDTO getEmployeeDetail(@PathVariable Long id) {
	        return employeeService.getEmployeeDetail(id);
	    }

}
