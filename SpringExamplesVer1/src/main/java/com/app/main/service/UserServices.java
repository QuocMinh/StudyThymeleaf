package com.app.main.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.main.model.Account;
import com.app.main.repository.AccountRepository;

public class UserServices {

	@Autowired
	AccountRepository accountRepository;
	
	public UserServices(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public void findAllUser() {
		for (Account username : accountRepository.findAll()) {
			System.out.println(username.getUsername());
		}
	}
	
	public void saveAccount(Account account) {
		accountRepository.save(account);
	}
	
}
