package edu.pes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pes.repository.ATRepository;
import edu.pes.entity.PESU_AT;


@Service
public class ATService implements ATServiceInterface {

	
	private ATRepository atRepository;
	

	@Autowired   
	public ATService(ATRepository obj)
	{
		atRepository=obj;
	}
	
	
	@Override
	public List<PESU_AT> findAll() {
	
		return atRepository.findAll();
	}

	@Override
	public void save(PESU_AT pesu_at) {
		
		atRepository.save(pesu_at);
	}

	@Override
	public PESU_AT findById(int theId) {
		
		Optional<PESU_AT> result=atRepository.findById(theId);
		
		PESU_AT pesu_at=null;
		
		if(result.isPresent())
		{
			pesu_at=result.get();
		}
		else {
			throw new RuntimeException("Did not find pesu_at id - " + theId);
		}
		return  pesu_at;
	}


	@Override
	public void deleteById(int theId) {
		atRepository.deleteById(theId);
	}


	@Override
	public List<PESU_AT> findByYear(String year) {
		
	return atRepository.findByYear(year);
	}


	@Override
	public List<PESU_AT> findByDept(String dept) {
		
		return atRepository.findByDept(dept);
	}


	@Override
	public List<PESU_AT> findByCourse(String course) {
		
		return atRepository.findByCourse(course);
	}

	@Override
	public PESU_AT findBySrn(String course) {
		
		return atRepository.findBySrn(course);
	}
//
//	@Override
//	public List<PESU_AT> findByDivision(String div) {
//	
////		Optional<pesu_at> result=atRepository.findByDivision(div);
////		
////		List<pesu_at> pesu_at=null;
////		
////		if(result.isPresent())
////		{
////			pesu_at.add(result.get());
////		}
////		else {
////			throw new RuntimeException("Did not find pesu_at div - " + div);
////		}
//		
//		return atRepository.findByDivision(div);
//	}
//
//
//	@Override
//	public List<PESU_AT> findByArea(String area) {
//		
//		return atRepository.findByArea(area);
//	}

}
