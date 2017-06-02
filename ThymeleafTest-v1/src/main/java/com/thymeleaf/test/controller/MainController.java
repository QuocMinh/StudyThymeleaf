package com.thymeleaf.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/abc")
	public String test(Model model) {
		model.addAttribute("message", "Spring boot - thymeleaf");
		
		return "test";
	}
	
}
