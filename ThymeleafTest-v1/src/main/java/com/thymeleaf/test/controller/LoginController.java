package com.thymeleaf.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleaf.test.model.User;

@Controller
public class LoginController {

	@Value("${User.username}")
	private String username = "";
	@Value("${User.password}")
	private String password = "";

	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("user", new User());

		return "login";
	}

	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute User user, Model model) {

		if (!this.username.equalsIgnoreCase(user.getUsername())
				|| !this.password.equals(user.getPassword())) {
			model.addAttribute("status", "error");

			return "login-result";

		}

		model.addAttribute("status", "success");

		return "login-result";
	}

}
