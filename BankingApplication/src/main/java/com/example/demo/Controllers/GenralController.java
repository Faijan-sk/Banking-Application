package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenralController {
	
	@RequestMapping("/addUser")
	public String one() {
		
		return "createUser";
	}
	
	@RequestMapping("/")
	public String two() {
		return "homePage";
	}
	
	@RequestMapping("/operationPerform")
	public String three() {
		return "Operation";
	}


}
