package edu.pes.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.pes.entity.PESU_AT;
import edu.pes.service.ATService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	

	private ATService atService;
	@Autowired   
	public AdminController(ATService obj)
	{
		this.atService=obj;
	
	}

	@GetMapping("/add-alumni")
	public String Addalumni(Model theModel) {
	
		PESU_AT alumni=new PESU_AT();
		
		theModel.addAttribute("alumni",alumni);
		
		return "admin/addAlumni";
	}
	
	@PostMapping("/add-alumni")
	public String Savealumni(@ModelAttribute("alumni") PESU_AT alumni) {

	
		atService.save(alumni);
	
		return "redirect:/admin/add-alumni";
	}
	
	@GetMapping("/all-alumni")
	public String Allalumni(Model theModel) {

		List<PESU_AT> list=atService.findAll();
		
		theModel.addAttribute("allalumni",list);
		
		return "admin/alumniList";
	}

	
	@GetMapping("/update-alumni")
	public String Updatealumni(@RequestParam("id") int theId,Model theModel) {

		PESU_AT alumni=atService.findById(theId);
		
		theModel.addAttribute("alumni",alumni);
		
		return "admin/addAlumni";
	}
	
	@GetMapping("/delete-alumni")
	public String Deletealumni(@RequestParam("id") int theId) {

		atService.deleteById(theId);
	
		return "redirect:/admin/all-alumni";
	}
	
}
