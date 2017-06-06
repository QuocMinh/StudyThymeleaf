package com.app.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.main.model.Accounts;
import com.app.main.model.Customer;
import com.app.main.repository.AccountRepository;
import com.app.main.repository.CustomerRepository;
import com.app.main.repository.PersonRepository;

@SpringBootApplication
public class SpringExamplesVer1Application implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository customRepository;
	@Autowired
	private PersonRepository personRepository;
	private AccountRepository accountRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringExamplesVer1Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		// repository.deleteAll();
		
		// Customer customer = new Customer("Chau", "Quoc Minh");
		//repository.save(customer);
		
		/*
		for (Customer customer : customRepository.findAll()) {
			System.out.println(customer.toString());
		}
		
		Customer cust = repository.findByFirstName("Chau");
		System.out.println(cust.toString());
		
		repository.findByFirstName("Chau");
		*/
		/*
		personRepository.deleteAll();
		
		Person person = new Person("Chau", "Quoc Minh", "28/10/1995");
		Account account = new Account("cqm1995", "123456");
		person.setAccount(account);
		
		personRepository.save(person);
		
		for (Person person1 : personRepository.findAll()) {
			System.out.println(person1.getDobString());
		}
		*/
		
	}
	
}
