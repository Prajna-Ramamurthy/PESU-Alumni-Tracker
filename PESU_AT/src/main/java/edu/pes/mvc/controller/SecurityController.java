package edu.pes.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SecurityController {


	@RequestMapping("/adminlogin")
	public String showHome()
	{
		
		return "security/login";
	}

}
