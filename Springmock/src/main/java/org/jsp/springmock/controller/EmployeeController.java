package org.jsp.springmock.controller;

import java.util.List;

import org.jsp.springmock.dto.Employeedto;
import org.jsp.springmock.helper.ResponseStructure;
import org.jsp.springmock.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("employees")
	public ResponseStructure<Employeedto> saveEmployee(@RequestBody Employeedto employeedto){
		return employeeService.save(employeedto);
	}
	
	@GetMapping("employees/{id}")
	public ResponseStructure<Employeedto> fetchByid(@PathVariable int id){
		return employeeService.fetchById(id);
	}
	
	
	@GetMapping("employees/mobile/{mobile}")
	public ResponseStructure<List<Employeedto>> fetchByMobile(@PathVariable long mobile){
		return employeeService.fetchByMobile(mobile);
	}
	
	@GetMapping("employees/multiple")
	public ResponseStructure<List<Employeedto>> fetchAll(){
		return employeeService.fetchAll();
	}
	
	@DeleteMapping("employees/{id}")
	public ResponseStructure<Employeedto> deleteById(@PathVariable int id){
		return employeeService.deleteById(id);
	}
	
	@PutMapping("employees")
	public ResponseStructure<Employeedto> saveStudent1(@RequestBody Employeedto employeedto){
		return employeeService.save(employeedto);
	}
	
}
