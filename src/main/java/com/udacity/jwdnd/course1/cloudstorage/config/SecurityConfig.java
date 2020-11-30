package com.udacity.jwdnd.course1.cloudstorage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.udacity.jwdnd.course1.cloudstorage.services.AuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private AuthenticationService authService;
	
	public SecurityConfig(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/signup", "/css/**", "/js/**").permitAll().anyRequest().authenticated();
		
		http.formLogin().loginPage("/signin").permitAll();
		
		http.formLogin().defaultSuccessUrl("/", true);
	}


}
