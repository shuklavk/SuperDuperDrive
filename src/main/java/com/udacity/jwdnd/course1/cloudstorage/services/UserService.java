package com.udacity.jwdnd.course1.cloudstorage.services;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.models.User;

@Service
public class UserService {
	private final UserMapper userMapper;
	private final HashService hashService;

	public UserService(UserMapper userMapper, HashService hashService) {
		this.hashService = hashService;
		this.userMapper = userMapper;
	}
	
	public boolean isUsernameAvailable(String username) {
		return this.userMapper.getUser(username) == null;
	}
	
	public User getUser(String username) {
		return this.userMapper.getUser(username);
	}
	
	public int createUser(User user) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        return this.userMapper.insert(new User(null,user.getUsername(), hashedPassword, encodedSalt, user.getFirstname(), user.getLastname()));
	}
}
