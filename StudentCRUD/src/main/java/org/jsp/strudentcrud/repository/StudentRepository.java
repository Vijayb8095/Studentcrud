package org.jsp.strudentcrud.repository;

import java.util.List;

import org.jsp.strudentcrud.dto.Studentdto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Studentdto, Integer> {

	List<Studentdto> findByMobile(long mobile);

	List<Studentdto> findByResult(String result);

	@Query("Select x from Studentdto x where name=?1 and percentage>=?2")
	List<Studentdto> findByNameandPercentageGreater(String name, double percentage);

}
