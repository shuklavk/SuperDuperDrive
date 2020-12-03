package com.udacity.jwdnd.course1.cloudstorage.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.udacity.jwdnd.course1.cloudstorage.models.File;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;

@Controller
public class FileController {
	
	private FileService fileService;
	
	public FileController(FileService fileService) {
		this.fileService = fileService;
	}
	@GetMapping("/file")
	public List<File> getFiles(Authentication auth){
		return this.fileService.getUserFiles(auth.getName());
	}
	
	@GetMapping("/downloadfile/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		File newFile = this.fileService.getFile(Integer.valueOf(id));
		return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + newFile.getFilename() + "\"")
		        .body(newFile.getFiledata());
	}
	
	@PostMapping("/file")
	public String uploadFile(@RequestParam("fileUpload")MultipartFile file, Authentication authentication) throws SerialException, SQLException, IOException {
		String username = authentication.getName();
		this.fileService.uploadFile(file, username);
		return "redirect:/";
	}
	
	@GetMapping("/deletefile/{fileid}")
	public String deleteFile(@PathVariable String fileid) {
		this.fileService.deleteFile(Integer.valueOf(fileid));
		return "redirect:/";
	}

}
