package com.app.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.main.model.Accounts;
import com.app.main.model.Customer;
import com.app.main.model.Person;
import com.app.main.repository.AccountRepository;
import com.app.main.repository.PersonRepository;

@Controller
public class PersonController {
	
	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	AccountRepository accRepo;
	
	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("account", new Accounts());
		
		return "person-page";
	}
	
	@PostMapping("/register-person")
	public String handleForm(Model model, @ModelAttribute Customer customer,
			@ModelAttribute Accounts accounts) {
		
		System.out.println(customer.toString());
		System.out.println(accounts.getUsername());
		
		accRepo.save(accounts);
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("account", new Accounts());
		
		return "person-page";
	}

}
