package org.jsp.springmock.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springmock.dto.Employeedto;
import org.jsp.springmock.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Employeedao {

	@Autowired 
	EmployeeRepository employeeRepository;

	public Employeedto save(Employeedto employeedto) {
		
		return employeeRepository.save(employeedto);
	}

	public Employeedto fetchById(int id) {
		
		Optional<Employeedto> optional=employeeRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
		
	}

	public List<Employeedto> fetchByMobile(long mobile) {
		return employeeRepository.findByMobile(mobile);
		}

	public List<Employeedto> fetchAll() {
		return employeeRepository.findAll();
	}

	public void deleteById(int id) {
		
		employeeRepository.deleteById(id);
	}
	
}
