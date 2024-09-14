package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSpringSecurity {
	
//	private UserRepository userRepository;
	
	private UserDetailsService userDetailsService;
	
	public WebSpringSecurity(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
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
	
	/*
	@Bean
    UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(userRepository);
    }
    */
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(getPasswordEncoder());
         
        return authProvider;
    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeHttpRequests((authorize) ->
		authorize.requestMatchers(new AntPathRequestMatcher("/resources/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/static/component/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/mobile/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/static/js/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/register/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/form/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/player/**")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/playerselectionform")).authenticated()
		.anyRequest().authenticated()
		 )
		.formLogin()
		.and().httpBasic();
									
		return http.build();
				
		
	}

}
