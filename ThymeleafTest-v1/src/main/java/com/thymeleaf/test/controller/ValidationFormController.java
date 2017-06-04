package com.thymeleaf.test.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleaf.test.model.Person;

@Controller
public class ValidationFormController {
	
	@GetMapping("/validation")
	public String showForm(Person person) {
		
		return "input-page";
	}
	
	@PostMapping("/validation")
	public String checkPersionInfo(@Valid Person person, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "input-page";
		}
		
		return "result-page";
	}

}
