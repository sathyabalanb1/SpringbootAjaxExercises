package com.example.demo.service.impl;


import java.util.Arrays;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegistrationDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
//	private PasswordEncoder passwordEncoder;
	private RoleRepository roleRepository;

	/*
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}
	*/
	
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	
	@Override
	public void saveUser(RegistrationDto registrationDto) {
		User user = new User();
		user.setName(registrationDto.getFirstName()+""+registrationDto.getLastName());
		//user.setEmail(registrationDto.getEmail());
		user.setEmail(registrationDto.getEmail());
		user.setPassword(registrationDto.getPassword());
	//	user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		
		Role role = roleRepository.findByName("ROLE_USER");
		
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
		
		
	}

}
