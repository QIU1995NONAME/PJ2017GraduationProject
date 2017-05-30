package com.github.qiu1995.noname.gproject.control.core.entity;

import java.util.Set;

import com.google.gson.JsonObject;

public class Variable {
	private long ID;
	private Station owner;
	private int num;
	private int length;
	private String comment;
	private Set<VarData> dataset;

	public long getID() {
		return ID;
	}

	public void setID(long id) {
		ID = id;
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

	public Set<VarData> getDataset() {
		return dataset;
	}

	public void setDataset(Set<VarData> dataset) {
		this.dataset = dataset;
	}

	public JsonObject toJsonObj() {
		JsonObject res = new JsonObject();
		res.addProperty("ID", this.getID());
		res.addProperty("owner", this.owner.getID());
		res.addProperty("num", this.getNum());
		res.addProperty("length", this.getLength());
		res.addProperty("comment", this.getComment());
		return res;
	}

}
