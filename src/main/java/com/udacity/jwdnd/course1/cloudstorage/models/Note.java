package com.udacity.jwdnd.course1.cloudstorage.models;

public class Note {
	private Integer nodeid;
	private String notetitle;
	private String notedescription;
	private Integer userid;

	public Note(Integer nodeid, String notetitle, String notedescription, Integer userid) {
		super();
		this.nodeid = nodeid;
		this.notetitle = notetitle;
		this.notedescription = notedescription;
		this.userid = userid;
	}
	public Integer getNodeid() {
		return nodeid;
	}
	public void setNodeid(Integer nodeid) {
		this.nodeid = nodeid;
	}
	public String getNotetitle() {
		return notetitle;
	}
	public void setNotetitle(String notetitle) {
		this.notetitle = notetitle;
	}
	public String getNotedescription() {
		return notedescription;
	}
	public void setNotedescription(String notedescription) {
		this.notedescription = notedescription;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}
