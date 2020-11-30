package com.udacity.jwdnd.course1.cloudstorage.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udacity.jwdnd.course1.cloudstorage.services.FileService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private FileService fileService;
	
	public HomeController(FileService fileService) {
		this.fileService = fileService;
	}
	
	@GetMapping()
	public String homeView(Model model, Authentication auth) {
		model.addAttribute("uploadedFiles", this.fileService.getUserFiles(auth.getName()));
		return "home";
	}
}
