package com.app.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.main.model.Customer;
import com.app.main.repository.CustomerRepository;
import com.app.main.service.CustomerServices;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	CustomerServices services = new CustomerServices();
	
	
	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "customer-page";
	}
	
	@PostMapping("/handle")
	public String handleForm(@ModelAttribute Customer customer, Model model) {
		
		System.out.println(customer.toString());
		
		customerRepo.save(customer);
		
		model.addAttribute("customer", new Customer());
		
		services.findByLastName();
		
		return "customer-page";
	}

}
