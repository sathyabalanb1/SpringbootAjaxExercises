package com.example.demo.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
private UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepository.findByEmail(username);
		
		if (user != null) {
		    org.springframework.security.core.userdetails.User authenticatedUser =
		            new org.springframework.security.core.userdetails.User(
		              user.getEmail(),
		              user.getPassword(),
		              user.getRoles().stream()
		                      .map((role) -> new SimpleGrantedAuthority(role.getName()))
		                      .collect(Collectors.toList()) 
		            );
		    return authenticatedUser;
		}else {
			
			throw new UsernameNotFoundException("Invalid username and password");
		}

	}


}
