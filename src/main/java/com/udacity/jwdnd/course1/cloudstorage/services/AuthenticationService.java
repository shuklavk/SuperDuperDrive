package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.models.User;

@Service
public class AuthenticationService implements AuthenticationProvider{
	private UserMapper userMapper;
	private HashService hashService;
	
	public AuthenticationService(UserMapper userMapper, HashService hashService) {
		this.userMapper = userMapper;
		this.hashService = hashService;
	}
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException{
		String username = auth.getName();
		String password = auth.getCredentials().toString();
		
		User user = this.userMapper.getUser(username);
		
		if(user!= null) {
			String encodedSalt = user.getSalt();
			String hashedPassword = hashService.getHashedValue(password, encodedSalt);
			if(user.getPassword().equals(hashedPassword)) {
				return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
			}
		}
		
		return null;
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
