package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		
		return new BCryptPasswordEncoder();
		
	}
	
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		 UserDetails normalUser = User.builder()
		            .username("customer_01")
		            .password(passwordEncoder().encode("12345"))
		            .roles("CUSTOMER")
		            .build();
		
		 UserDetails adminUser = User.withUsername("Admin_01")
		            .password(passwordEncoder().encode("1234512345"))
		            .roles("ADMIN")
		            .build();
		
	InMemoryUserDetailsManager inmemoryUserDetailManager =     new InMemoryUserDetailsManager(normalUser, adminUser);
	
	
	return inmemoryUserDetailManager; 
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		 httpSecurity.csrf().disable()
	        .authorizeHttpRequests(auth -> auth
	            .antMatchers("/admins/**").hasRole("ADMIN")
	            .antMatchers("/users/allUser").hasRole("ADMIN")
	            .anyRequest().authenticated()
	        )
	        .formLogin()
	            .permitAll() // Allow everyone to access the login page
	        .and()
	        .logout()
	            .permitAll(); // Allow everyone to log out

	    return httpSecurity.build();

		
	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
