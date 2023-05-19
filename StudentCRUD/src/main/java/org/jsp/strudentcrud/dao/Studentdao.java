package org.jsp.strudentcrud.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.strudentcrud.dto.Studentdto;
import org.jsp.strudentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Studentdao {

	@Autowired
	StudentRepository repository;

	public Studentdto save(Studentdto studentdto) {
		return repository.save(studentdto);
	}

	public List<Studentdto> saveall(List<Studentdto> studentdtos) {

		return repository.saveAll(studentdtos);
	}

	public Studentdto fetchById(int id) {

		Optional<Studentdto> optional = repository.findById(id);
		if (optional.isEmpty()) {
			return null;

		} else {
			return optional.get();
		}
	}

	public List<Studentdto> fetchByMobile(long mobile) {

		return repository.findByMobile(mobile);
	}

	public List<Studentdto> fetchByResult(String result) {

		return repository.findByResult(result);
	}

	public List<Studentdto> fetch(String name, double percentage) {

		return repository.findByNameandPercentageGreater(name, percentage);

	}

	public List<Studentdto> fetchAll() {

		return repository.findAll();
	}

	public void delete(int id) {
	
		repository.deleteById(id);
		
	}

}
