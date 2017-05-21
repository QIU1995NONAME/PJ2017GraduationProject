package com.github.qiu1995.noname.gproject.control.core.entity;

import java.sql.Blob;

public class VarData {
	private long ID;
	private Variable var;
	private long timestamp;
	private Blob data;

	public long getID() {
		return ID;
	}

	public void setID(long id) {
		ID = id;
	}

	public Variable getVar() {
		return var;
	}

	public void setVar(Variable var) {
		this.var = var;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Blob getData() {
		return data;
	}

	public void setData(Blob data) {
		this.data = data;
	}
}
