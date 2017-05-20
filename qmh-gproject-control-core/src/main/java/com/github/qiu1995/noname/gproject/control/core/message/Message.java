package com.github.qiu1995.noname.gproject.control.core.message;

import java.io.Serializable;
import java.util.HashMap;

import com.google.common.collect.Maps;

public class Message implements Serializable {

	private static final long serialVersionUID = 4892071603449539593L;

	private long ID = 1;
	private MessageType type = MessageType.CLI_PING;
	private HashMap<Integer, Long> data = Maps.newHashMap();

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public HashMap<Integer, Long> getData() {
		return data;
	}
}
