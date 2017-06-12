package com.app.sum.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.app.sum.model.Role;
import com.app.sum.model.User;
import com.app.sum.repository.RoleRepository;
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
		
		if(roleRepository.findOne(Constant.ROLE_USER) == null) {
			roleRepository.save(new Role(Constant.ROLE_USER,
					Constant.ROLE_USER_DETAIL));
		}
		
		// ADMIN ACCOUNT:
		if(userRepository.findOne("admin") == null) {
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword("admin");
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
			member.setPassword("member");
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByRoleName(Constant.ROLE_MEMBER));
			member.setUserRole(roles);
			
			userRepository.save(member);
		}
	}

}
