package org.jsp.springmock.service;

import java.util.List;

import org.jsp.springmock.dao.Employeedao;
import org.jsp.springmock.dto.Employeedto;
import org.jsp.springmock.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
	
	@Autowired
	Employeedao employeedao;

	public ResponseStructure<Employeedto> save(Employeedto employeedto) {
		
		ResponseStructure<Employeedto> structure = new ResponseStructure<>();
		structure.setMessage("saved Successfully");
		structure.setData(employeedao.save(employeedto));
		structure.setStatusCode(HttpStatus.CREATED.value());

		return structure;
	}

	public ResponseStructure<Employeedto> fetchById(int id) {

		ResponseStructure<Employeedto> structure = new ResponseStructure<>();
		Employeedto  employeedto =employeedao.fetchById(id);
		if(employeedto==null) {
			structure.setMessage("Data Not Found");
			structure.setData(null);
			structure.setStatusCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setMessage("Data Found");
			structure.setData(employeedto);
			structure.setStatusCode(HttpStatus.FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Employeedto>> fetchByMobile(long mobile) {
		ResponseStructure<List<Employeedto>> structure = new ResponseStructure<>();
		List<Employeedto>  list =employeedao.fetchByMobile(mobile);
		if(list==null) {
			structure.setMessage("Data Not Found");
			structure.setData(null);
			structure.setStatusCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setMessage("Data Found");
			structure.setData(list);
			structure.setStatusCode(HttpStatus.FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Employeedto>> fetchAll() {
		ResponseStructure<List<Employeedto>> structure = new ResponseStructure<>();
		List<Employeedto>  list =employeedao.fetchAll();
		if(list==null) {
			structure.setMessage("Data Not Found");
			structure.setData(null);
			structure.setStatusCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setMessage("Data Found");
			structure.setData(list);
			structure.setStatusCode(HttpStatus.FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<Employeedto> deleteById(int id) {
		employeedao.deleteById(id);
		ResponseStructure<Employeedto> structure = new ResponseStructure<>();
		structure.setMessage("Data deleted");
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setData(null);
		
		return structure;
	}

}
