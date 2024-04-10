package edu.pes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pes.entity.PESU_AT;


@Repository("atRepository")
public interface ATRepository extends JpaRepository<PESU_AT, Integer> {

	List<PESU_AT> findByYear(String div);

	List<PESU_AT> findByDept(String div);
	
	List<PESU_AT> findByCourse(String div);
	
	PESU_AT findBySrn(String div);
}