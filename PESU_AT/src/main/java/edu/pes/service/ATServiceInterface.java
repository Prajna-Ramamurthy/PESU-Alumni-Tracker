package edu.pes.service;

import java.util.List;
import edu.pes.entity.PESU_AT;


public interface ATServiceInterface {

	public List<PESU_AT> findAll();

	public void save(PESU_AT at);

	public PESU_AT findById(int theId); 

	public void deleteById(int theId);
	
	public List<PESU_AT> findByYear(String div);

	public List<PESU_AT> findByDept(String div);
	
	public List<PESU_AT> findByCourse(String div);
	
	public PESU_AT findBySrn(String div);
	

}
