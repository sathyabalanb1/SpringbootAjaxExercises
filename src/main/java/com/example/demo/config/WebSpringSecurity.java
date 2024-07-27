package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSpringSecurity {
	
	
	
	/*
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	*/
	
	/*
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeHttpRequests((authorize) ->
		authorize.requestMatchers(new AntPathRequestMatcher("/resources/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/static/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/register/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/form/**")).permitAll()
		.anyRequest().authenticated()
		 )
		.formLogin( form  -> form
				.loginPage("/login")
				.defaultSuccessUrl("/admin/posts")
				.loginProcessingUrl("/login")
				.permitAll()
				).logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.permitAll()
						);
		
		return http.build();
				
		
	}
	
	*/
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeHttpRequests((authorize) ->
		authorize.requestMatchers(new AntPathRequestMatcher("/resources/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/static/component/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/register/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/form/**")).permitAll()
		.anyRequest().authenticated()
		 )
		.formLogin()
		.and().httpBasic();
									
		return http.build();
				
		
	}

}
