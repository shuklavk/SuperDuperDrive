package com.udacity.jwdnd.course1.cloudstorage.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.models.File;
import com.udacity.jwdnd.course1.cloudstorage.models.User;

@Service
public class FileService {
	
	private FileMapper fileMapper;
	private UserMapper userMapper;
	
	public FileService(FileMapper fileMapper, UserMapper userMapper) {
		this.fileMapper = fileMapper;
		this.userMapper = userMapper;
	}
	
	public List<File> getUserFiles(String username){
		User user = this.userMapper.getUser(username);
		return this.fileMapper.getAllFiles(user.getUserid());
	}
	
	public File getFile(int fileid) {
		return this.fileMapper.getFile(fileid);
	}
	
	public int uploadFile(MultipartFile file, String username) throws SerialException, SQLException, IOException {
		String filename = file.getOriginalFilename();
		String contentType = file.getContentType();
		String fileSize = Long.toString(file.getSize());
		byte[] filedata = file.getBytes();
		Integer userid = this.userMapper.getUser(username).getUserid();
		File uploadedFile = new File(null, contentType, filename, fileSize, userid, filedata);
		return this.fileMapper.insertFile(uploadedFile);
	}
	
	public void deleteFile(int fileid) {
		this.fileMapper.deleteFile(fileid);
	}

}
