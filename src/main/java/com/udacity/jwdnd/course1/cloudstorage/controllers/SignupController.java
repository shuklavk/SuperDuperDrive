package com.udacity.jwdnd.course1.cloudstorage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udacity.jwdnd.course1.cloudstorage.models.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
@RequestMapping("/signup")
public class SignupController {
	
	private UserService userService;
	
	public SignupController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping()
	public String signupView() {
		return "signup";
	}
	
	@PostMapping()
	public String signup(@ModelAttribute User user, Model model) {
		String signupError = null;

		if(!this.userService.isUsernameAvailable(user.getUsername())) {
			signupError = "Username already exists!";
		}
		
		if(signupError == null) {
			int inputIntoDB = this.userService.createUser(user);
			if(inputIntoDB < 0) {
				signupError = "There was an error in the signup process. Please try again.";
			}
		}
		
		if(signupError == null) {
			model.addAttribute("signupSuccess", true);
		}
		else {
			model.addAttribute("signupError", signupError);
		}

		return "signup";
	}
}
