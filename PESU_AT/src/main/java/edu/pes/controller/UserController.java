package edu.pes.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.pes.entity.PESU_AT;
import edu.pes.service.ATService;


@Controller
@RequestMapping("/user")
public class UserController {
	

	private ATService atService;
	@Autowired   
	public UserController(ATService obj)
	{
		this.atService=obj;
	
	}

	
	
	@GetMapping("/alumni")
	public String Allalumni(@RequestParam("id") int theId,Model theModel) {

		PESU_AT list=(PESU_AT) atService.findById(theId);
		
		int click=list.getClick();
		
		click++;
		
		list.setClick(click);
		

		atService.save(list);
	
		
		theModel.addAttribute("list",list);
		
		System.out.println(list);
		return "user/alumni-details";
	}



	@GetMapping("/index")
	public String all(Model theModel) {

		List<PESU_AT> list=atService.findAll();
		
		theModel.addAttribute("allalumni",list);
		
		return "user/index";
	}
	
	
	

//	@GetMapping("/id")
//	public String getById(@RequestParam("id") int theId,Model theModel) {
//
//		String srn= String.valueOf(theId);
//		List<PESU_AT> list=atService.findById(srn);
//		
//		theModel.addAttribute("allalumni",list);
//		
//		return "admin/2021";
//	}
}


//
//
//@GetMapping("/alumni-count-chart")
//public String Chart(Model theModel) {
//
//	List<PESU_AT> list=atService.findAll();
//	 
//	theModel.addAttribute("allalumni",list);
//	
//	int a=0;
//	int b=0;
//	int c=0;
//	
//	for(PESU_AT obj:list)
//	{
//		if(obj.getDivision().equals("North"))
//		{
//			a+=obj.getCount();
//		}
//		else if(obj.getDivision().equals("South"))
//		{
//			b+=obj.getCount();
//		}
//		else if(obj.getDivision().equals("Central"))
//		{
//			c+=obj.getCount();
//		}
//		
//	}
//	theModel.addAttribute("a",a);
//	
//	theModel.addAttribute("b",b);
//	
//	theModel.addAttribute("c",c);
//	
//	System.out.println("a="+a+"b="+b+"c="+c);
//	return "admin/chart";
//}














//
//
//@GetMapping("/alumni/2017")
//public String Northalumni(Model theModel) {
//
//	List<PESU_AT> list=atService.findByDivision("North");
//	
//	theModel.addAttribute("allalumni",list);
//	
//	
//	
//	return "admin/northalumniList";
//}
//
//@GetMapping("/alumni/2018")
//public String centralalumni(Model theModel) {
//
//	List<PESU_AT> list=atService.findByDivision("Central");
//	
//	theModel.addAttribute("allalumni",list);
//	
//	return "admin/centralalumniList";
//}
//
//@GetMapping("/south-kolkata")
//public String southalumni(Model theModel) {
//
//	List<PESU_AT> list=atService.findByDivision("South");
//	
//	theModel.addAttribute("allalumni",list);
//	
//	return "admin/southalumniList";
//}

