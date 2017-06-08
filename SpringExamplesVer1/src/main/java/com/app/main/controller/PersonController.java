package com.app.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.main.model.Account;
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
		model.addAttribute("account", new Account());
		
		return "person-page";
	}
	
	@PostMapping("/register-person")
	public String handleForm(Model model, @ModelAttribute Person person,
			@ModelAttribute Account account, HttpServletRequest request) {
		
		// Set dob for person by birthDate String
		person.setDobString(request.getParameter("birthDate"));
		
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
		model.addAttribute("account", new Account());
		
		return "redirect:/";
	}
	
	/**
	 * Save account if it doesn't existed yet
	 * <br>
	 * 
	 * @param account : Model
	 * @return
	 * <ul>
	 * 	<li>FALSE	: If account already exists</li>
	 * 	<li>TRUE	: If save account successfully</li>
	 * </ul>
	 */
	public boolean saveAccount(Account account) {
		// Get account by username:
		Account acc = accRepo.findAccountByUsername(account.getUsername());
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
