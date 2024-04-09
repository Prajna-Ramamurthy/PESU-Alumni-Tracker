package edu.pes.service;

import java.util.List;
import edu.pes.entity.PESU_AT;
import edu.pes.entity.User;


public interface ATServiceInterface {

	public List<PESU_AT> findAll();

	public void save(PESU_AT at);

	public PESU_AT findById(int theId); 

	public void deleteById(int theId);
	
	public List<PESU_AT> findByYear(String year);

	public List<PESU_AT> findByDept(String dept);
	
	public List<PESU_AT> findByCourse(String course);
	
	public PESU_AT findBySrn(String srn);
	
	public void updateUser(User user);
}
