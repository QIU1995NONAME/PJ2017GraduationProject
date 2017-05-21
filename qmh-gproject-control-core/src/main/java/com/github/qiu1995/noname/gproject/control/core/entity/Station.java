package com.github.qiu1995.noname.gproject.control.core.entity;

import java.util.Set;

public class Station {
	private int ID;
	private int status;
	private String name;
	private String comment;
	private Set<Variable> vars;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public Set<Variable> getVars() {
		return vars;
	}

	public void setVars(Set<Variable> vars) {
		this.vars = vars;
	}

}
