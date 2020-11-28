package com.udacity.jwdnd.course1.cloudstorage.models;

import java.sql.Blob;

public class File {
	private Integer fileid;
	private String contentType;
	private String filename;
	private String filesize;
	private Integer userid;
	private Blob filedata;
	
	public File(Integer fileid, String contentType, String filename, String filesize, Integer userid, Blob filedata) {
		super();
		this.fileid = fileid;
		this.contentType = contentType;
		this.filename = filename;
		this.filesize = filesize;
		this.userid = userid;
		this.filedata = filedata;
	}
	public Integer getFileid() {
		return fileid;
	}
	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilesize() {
		return filesize;
	}
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Blob getFiledata() {
		return filedata;
	}
	public void setFiledata(Blob filedata) {
		this.filedata = filedata;
	}

}
