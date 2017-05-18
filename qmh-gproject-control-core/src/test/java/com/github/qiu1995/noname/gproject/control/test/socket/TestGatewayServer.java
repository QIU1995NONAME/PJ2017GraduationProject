package com.github.qiu1995.noname.gproject.control.test.socket;

import org.junit.Test;

import com.github.qiu1995.noname.gproject.control.core.socket.GatewayServer;

public class TestGatewayServer {
	@Test
	public void testServerStart() {
		GatewayServer server = new GatewayServer(8090);
		server.start();
		System.out.println("Server is running...");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
