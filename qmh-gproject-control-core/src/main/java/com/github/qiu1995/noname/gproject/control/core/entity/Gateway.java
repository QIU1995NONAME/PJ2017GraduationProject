package com.github.qiu1995.noname.gproject.control.core.entity;

public class Gateway {
	private int ID;
	private int status;
	private String name;
	private String comment;

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
