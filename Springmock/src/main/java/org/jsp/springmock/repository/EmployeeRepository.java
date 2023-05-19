package org.jsp.springmock.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.springmock.dto.Employeedto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employeedto, Integer> {

	List<Employeedto> findByMobile(long mobile);

	

}
