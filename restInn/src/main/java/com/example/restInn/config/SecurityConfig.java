package com.example.restInn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.restInn.service.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
		
	
	// configure authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService);
		
	}
	
	// configure our authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.cors().and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/Users/**").permitAll()
		.antMatchers("/Auth/login").permitAll()
		.antMatchers("/logout").permitAll()
		.antMatchers("/Properties/**").permitAll()
		.anyRequest().authenticated();
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
		
	}
}
