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
	
}
