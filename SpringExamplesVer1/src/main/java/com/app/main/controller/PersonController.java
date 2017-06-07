package com.app.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.main.model.Accounts;
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
		model.addAttribute("person", new Person());
		model.addAttribute("account", new Accounts());
		
		return "person-page";
	}
	
	@PostMapping("/register-person")
	public String handleForm(Model model, @ModelAttribute Person person,
			@ModelAttribute Accounts account, HttpServletRequest request) {
		
		// Set dob for person by birthDate String
		person.setDobString(request.getParameter("birthDate"));
		
		System.out.println(account.getUsername());
		System.out.println(account.getPassword());
		
		// Save account if not exist
		boolean accountIsSaved = saveAccount(account);
		
		// Save Person if not exist
		if(accountIsSaved) {
			person.setAccount(account);
			personRepo.save(person);
			
			model.addAttribute("msg", "Dang ky thanh cong");
		} else {
			model.addAttribute("msg", "Username da co nguoi su dung");
		}
		
		model.addAttribute("person", new Person());
		model.addAttribute("account", new Accounts());
		
		return "redirect:/";
	}
	
	/**
	 * Save person if it doesn't existed yet
	 * 
	 * @param person
	 * @return <br>
	 * 		FALSE	: If person already exists <br>
	 * 		TRUE	: If save person successfully
	 */
	public boolean savePerson(Person person) {
		
		return false;
	}
	
	/**
	 * Save account if it doesn't existed yet
	 * 
	 * @param account
	 * @return <br>
	 * 		FALSE	: If account already exists <br>
	 * 		TRUE	: If save account successfully
	 */
	public boolean saveAccount(Accounts account) {
		// Get account by username:
		Accounts acc = accRepo.findAccountByUsername(account.getUsername());
		boolean accountExisted = false;
		
		try {
			// Check account existed
			accountExisted = accRepo.exists(acc.getId());
		} catch (NullPointerException e) {
			System.out.println("Account chua ton tai");
		}
		
		if(accountExisted) {
			System.out.println("Account da ton tai");
		} else {
			accRepo.save(account);
			System.out.println("Account saved");
			
			return true;
		}
		
		return false;
	}
	
}
