package com.app.main.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.main.model.Accounts;
import com.app.main.repository.AccountRepository;

public class UserServices {

	@Autowired
	AccountRepository accountRepository;
	
	public UserServices(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public void findAllUser() {
		for (Accounts username : accountRepository.findAll()) {
			System.out.println(username.getUsername());
		}
	}
	
	public void saveAccount(Accounts account) {
		accountRepository.save(account);
	}
	
}
