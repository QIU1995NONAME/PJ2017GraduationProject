package com.github.qiu1995.noname.gproject.control.core.entity;

public class Variable {
	private long ID;
	private Station owner;
	private int num;
	private int length;
	private String comment;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public Station getOwner() {
		return owner;
	}

	public void setOwner(Station owner) {
		this.owner = owner;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
