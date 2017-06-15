package com.app.sum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.sum.model.Product;
import com.app.sum.repository.ProductRepository;

@Controller
public class MatHangController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/list-product")
	public String showPage(Model model){
		Product product = productRepository.findOne("NHCHSO25");
		
		model.addAttribute("product", product);
		
		return "bill-test";
	}

}
