package org.jsp.strudentcrud.contoller;

import java.util.List;

import org.jsp.strudentcrud.dto.Studentdto;
import org.jsp.strudentcrud.helper.ResponseStructure;
import org.jsp.strudentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("students")
	public ResponseStructure<Studentdto> saveStudent(@RequestBody Studentdto studentdto) {
		return service.save(studentdto);
	}

	@PostMapping("students/multiple")
	public ResponseStructure<List<Studentdto>> saveAll(@RequestBody List<Studentdto> studentdtos) {

		return service.saveAll(studentdtos);
	}

	@GetMapping("students")
	public ResponseStructure<Studentdto> fetchById(@RequestParam int id) {
		return service.fetchById(id);
	}

	@GetMapping("students/{id}")
	public ResponseStructure<Studentdto> fetchById2(@PathVariable int id) {
		return service.fetchById(id);
	}

	@GetMapping("students/mobile/{mobile}")
	public ResponseStructure<List<Studentdto>> fetchByMobile(@PathVariable long mobile) {
		return service.fetchByMobile(mobile);
	}

	@GetMapping("students/result/{result}")
	public ResponseStructure<List<Studentdto>> fetchByResult(@PathVariable String result) {

		return service.fetchByResult(result);
	}

	@GetMapping("students/{name}/{percentage}")
	public ResponseStructure<List<Studentdto>> fetch(@PathVariable String name, @PathVariable double percentage) {
		return service.fetch(name, percentage);
	}

	@GetMapping("students/multiple")
	public ResponseStructure<List<Studentdto>> fetchAll() {
		return service.fetchAll();
	}

	@DeleteMapping("students/{id}")
	public ResponseStructure<Studentdto> delete(@PathVariable int id) {
		return service.delete(id);
	}

	@PutMapping("students")
	public ResponseStructure<Studentdto> saveStudent1(@RequestBody Studentdto studentdto) {
		return service.save(studentdto);
	}

}
