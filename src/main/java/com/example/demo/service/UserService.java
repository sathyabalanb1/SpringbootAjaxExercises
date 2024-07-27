package com.example.demo.service;

import com.example.demo.dto.RegistrationDto;
import com.example.demo.entity.User;

public interface UserService {
	
	User findByEmail(String email);
	
	void saveUser(RegistrationDto registrationDto);


}
