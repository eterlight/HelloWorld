package com.qige.entity;

public class Reservation {
	private int id;
	private int userId;
	private int mrId;
	private String user_name;
	private String start_booktime;
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMrId() {
		return mrId;
	}
	public void setMrId(int mrId) {
		this.mrId = mrId;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getStart_booktime() {
		return start_booktime;
	}
	public void setStart_booktime(String start_booktime) {
		this.start_booktime = start_booktime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
