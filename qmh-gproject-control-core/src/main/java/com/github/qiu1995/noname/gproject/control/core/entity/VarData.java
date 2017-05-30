package com.github.qiu1995.noname.gproject.control.core.entity;

import java.sql.Blob;
import java.sql.SQLException;

import com.github.qiu1995.noname.gproject.control.core.helper.NumberHelper;
import com.google.gson.JsonObject;

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

	public JsonObject toJsonObj() {
		JsonObject res = new JsonObject();
		res.addProperty("ID", this.getID());
		res.addProperty("var", this.getVar().getID());
		res.addProperty("timestamp", this.getTimestamp());
		byte[] b;
		long data = 0;
		try {
			b = this.getData().getBytes(1, this.getVar().getLength());
			switch (b.length) {
			case 8:
				data = NumberHelper.bytes2long(b);
				break;
			case 4:
				data = NumberHelper.bytes2int(b);
				break;
			case 2:
				data = NumberHelper.bytes2short(b);
				break;
			default:
				data = b[0];
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		res.addProperty("data", data);
		return res;
	}
}
