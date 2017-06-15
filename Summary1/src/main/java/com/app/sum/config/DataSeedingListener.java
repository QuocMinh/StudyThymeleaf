package com.app.sum.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.app.sum.model.Customer;
import com.app.sum.model.CustomerType;
import com.app.sum.model.Product;
import com.app.sum.model.Role;
import com.app.sum.model.UnitPrice;
import com.app.sum.model.User;
import com.app.sum.repository.CustomerRepository;
import com.app.sum.repository.CustomerTypeRepository;
import com.app.sum.repository.ProductRepository;
import com.app.sum.repository.RoleRepository;
import com.app.sum.repository.UnitPriceRepository;
import com.app.sum.repository.UserRepository;
import com.app.sum.service.Constant;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerTypeRepository customerTypeRepository;
	
	@Autowired
	private UnitPriceRepository unitPriceRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// CREATE ROLE:
		if(roleRepository.findOne(Constant.ROLE_ADMIN) == null) {
			roleRepository.save(new Role(Constant.ROLE_ADMIN,
					Constant.ROLE_ADMIN_DETAIL));
			
		}if(roleRepository.findOne(Constant.ROLE_MEMBER) == null) {
			roleRepository.save(new Role(Constant.ROLE_MEMBER,
					Constant.ROLE_MEMBER_DETAIL));
		}
		
		// ADMIN ACCOUNT:
		if(userRepository.findOne("admin") == null) {
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("admin"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByRoleName(Constant.ROLE_ADMIN));
			roles.add(roleRepository.findByRoleName(Constant.ROLE_MEMBER));
			admin.setUserRole(roles);
			
			userRepository.save(admin);
		}
		
		// MEMBER ACCOUNT:
		if(userRepository.findOne("member") == null) {
			User member = new User();
			member.setUsername("member");
			member.setPassword(passwordEncoder.encode("member"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByRoleName(Constant.ROLE_MEMBER));
			member.setUserRole(roles);
			
			userRepository.save(member);
		}
		
		// CUSTOMER_TYPE:
		if(customerTypeRepository.findByCustomerType("LE") == null) {
			customerTypeRepository.save(new CustomerType("LE", "Khach ban le"));
		}
		if(customerTypeRepository.findByCustomerType("SI") == null) {
			customerTypeRepository.save(new CustomerType("SI", "Khach ban si"));
		}
		
		// CUSTOMER:
		if(customerRepository.findByCustomerFullName("MINH") == null) {
			Customer customer = new Customer();
			customer.setFullName("MINH");
			customer.setCustomerTypeId(customerTypeRepository.findByCustomerType("LE"));
			customerRepository.save(customer);
		}
		if(customerRepository.findByCustomerFullName("NHI") == null) {
			Customer customer = new Customer();
			customer.setFullName("NHI");
			customer.setCustomerTypeId(customerTypeRepository.findByCustomerType("SI"));
			customerRepository.save(customer);
		}
		
		// UNIT_PRICE
		CustomerType customerType = customerTypeRepository.findByCustomerType("LE");
		if(unitPriceRepository.findByCustomerType(customerType.getCustomerTypeId()) == null) {
			UnitPrice unitPrice = new UnitPrice();
			unitPrice.setCustomerType(customerType);
			unitPrice.setPrice(100000);
			unitPrice.setDecription("Gia ban le");
			
			unitPriceRepository.save(unitPrice);
		}
		
		customerType = customerTypeRepository.findByCustomerType("SI");
		if(unitPriceRepository.findByCustomerType(customerType.getCustomerTypeId()) == null) {
			UnitPrice unitPrice = new UnitPrice();
			unitPrice.setCustomerType(customerType);
			unitPrice.setPrice(50000);
			unitPrice.setDecription("Gia ban si");
			
			unitPriceRepository.save(unitPrice);
		}
		
		// PRODUCT:
		if(productRepository.findOne("NHCHSO25") == null) {
			Product product = new Product();
			product.setProductId("NHCHSO25");
			product.setProductName("So sexy 25ml");
			List<UnitPrice> unitPrices = unitPriceRepository.findAll();
			product.setUnitPrices(unitPrices);
			
			productRepository.save(product);
		}
	}

}
