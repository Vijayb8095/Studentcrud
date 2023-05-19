package org.jsp.strudentcrud.service;

import java.util.List;

import org.jsp.strudentcrud.dao.Studentdao;
import org.jsp.strudentcrud.dto.Studentdto;
import org.jsp.strudentcrud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	Studentdao studentdao;

	public ResponseStructure<Studentdto> save(Studentdto studentdto) {
		double percentage = studentdto.getScienceMarks() + studentdto.getMathMarks()
				+ studentdto.getEnglishMarks() / 3.0;
		studentdto.setPercentage(percentage);
		if (percentage > 85) {

			studentdto.setResult("Distinction");
		} else {
			if (percentage > 60) {
				studentdto.setResult("Firstclass");
			} else if (percentage > 35) {
				studentdto.setResult("just pass");
			} else {
				studentdto.setResult("Fail");
			}
		}
		ResponseStructure<Studentdto> structure = new ResponseStructure<>();
		structure.setMessage("saved Successfully");
		structure.setData(studentdao.save(studentdto));
		structure.setStatusCode(HttpStatus.CREATED.value());

		return structure;
	}

	public ResponseStructure<List<Studentdto>> saveAll(List<Studentdto> studentdtos) {

		for (Studentdto studentdto : studentdtos) {

			double percentage = studentdto.getScienceMarks() + studentdto.getMathMarks()
					+ studentdto.getEnglishMarks() / 3.0;
			studentdto.setPercentage(percentage);
			if (percentage > 85) {

				studentdto.setResult("Distinction");
			} else {
				if (percentage > 60) {
					studentdto.setResult("Firstclass");
				} else if (percentage > 35) {
					studentdto.setResult("just pass");
				} else {
					studentdto.setResult("Fail");
				}
			}

		}
		ResponseStructure<List<Studentdto>> structure = new ResponseStructure<>();
		structure.setMessage("saved Successfully");
		structure.setData(studentdao.saveall(studentdtos));

		return structure;
	}

	public ResponseStructure<Studentdto> fetchById(int id) {
		ResponseStructure<Studentdto> responseStructure = new ResponseStructure<>();
		Studentdto studentdto = studentdao.fetchById(id);
		if (studentdto == null) {
			responseStructure.setMessage("Data not found");
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(studentdto);
		} else {
			responseStructure.setMessage("Data found");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(studentdto);
		}
		return responseStructure;

	}

	public ResponseStructure<List<Studentdto>> fetchByMobile(long mobile) {
		ResponseStructure<List<Studentdto>> responseStructure = new ResponseStructure<>();

		List<Studentdto> list = studentdao.fetchByMobile(mobile);

		if (list.isEmpty()) {
			responseStructure.setMessage("Data not found");
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		} else {
			responseStructure.setMessage("Data found");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(list);
		}
		return responseStructure;
	}

	public ResponseStructure<List<Studentdto>> fetchByResult(String result) {
		ResponseStructure<List<Studentdto>> responseStructure = new ResponseStructure<>();

		List<Studentdto> list = studentdao.fetchByResult(result);

		if (list.isEmpty()) {
			responseStructure.setMessage("Data not found");
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		} else {
			responseStructure.setMessage("Data found");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(list);
		}
		return responseStructure;
	}

	public ResponseStructure<List<Studentdto>> fetch(String name, double percentage) {
		ResponseStructure<List<Studentdto>> responseStructure = new ResponseStructure<>();

		List<Studentdto> list = studentdao.fetch(name, percentage);

		if (list.isEmpty()) {
			responseStructure.setMessage("Data not found");
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		} else {
			responseStructure.setMessage("Data found");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(list);
		}
		return responseStructure;
	}

	public ResponseStructure<List<Studentdto>> fetchAll() {
		ResponseStructure<List<Studentdto>> responseStructure = new ResponseStructure<>();

		List<Studentdto> list = studentdao.fetchAll();

		if (list.isEmpty()) {
			responseStructure.setMessage("Data not found");
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		} else {
			responseStructure.setMessage("Data found");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(list);
		}
		return responseStructure;
	}

	public ResponseStructure<Studentdto> delete(int id) {
		
		studentdao.delete(id);
		ResponseStructure<Studentdto> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Data deleted");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(null);
		
		return responseStructure;
	
		
		
	}

}
