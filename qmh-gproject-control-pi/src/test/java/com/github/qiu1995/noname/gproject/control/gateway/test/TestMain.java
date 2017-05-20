package com.github.qiu1995.noname.gproject.control.gateway.test;

import java.util.concurrent.TimeUnit;

import com.github.qiu1995.noname.gproject.control.core.message.Message;
import com.github.qiu1995.noname.gproject.control.core.message.MessageType;
import com.github.qiu1995.noname.gproject.control.gateway.CenterClient;

public class TestMain {
	public static void main(String[] args) throws Exception {
		CenterClient client = new CenterClient("localhost", 8090);
		client.start();
		while (true) {
			TimeUnit.SECONDS.sleep(5);
			Message msg = new Message();
			msg.setType(MessageType.CLI_PING);
			client.send(msg);
		}
	}
}
