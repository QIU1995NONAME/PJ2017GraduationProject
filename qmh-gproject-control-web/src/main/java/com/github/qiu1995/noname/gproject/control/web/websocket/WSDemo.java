package com.github.qiu1995.noname.gproject.control.web.websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws/demo.ws")
public class WSDemo {

	@OnOpen
	public void onOpen(Session session) {
		final RemoteEndpoint.Basic basic = session.getBasicRemote();
		System.out.println("pathParams:" + session.getPathParameters());
		System.out.println("requestParams" + session.getRequestParameterMap());
		try {
			basic.sendText("open success on server");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.currentThread();
					Thread.sleep(8000);
					basic.sendText("server get you a msg: what your name?");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
	}

	/**
	 * 收到客户端消息时触发
	 * 
	 * @param relationId
	 * @param userCode
	 * @param message
	 * @return
	 */
	@OnMessage
	public String onMessage(Session session, String message) {
		System.out.println("pathParams:" + session.getPathParameters());
		System.out.println("requestParams" + session.getRequestParameterMap());
		return "Got you msg !" + message;
	}

	/**
	 * 异常时触发
	 * 
	 * @param relationId
	 * @param userCode
	 * @param session
	 */
	@OnError
	public void onError(Throwable throwable, Session session) {
		System.out.println("pathParams:" + session.getPathParameters());
		System.out.println("requestParams" + session.getRequestParameterMap());
		System.out.print("onError" + throwable.toString());
	}

	/**
	 * 关闭连接时触发
	 * 
	 * @param relationId
	 * @param userCode
	 * @param session
	 */
	@OnClose
	public void onClose(Session session) {
		System.out.println("pathParams:" + session.getPathParameters());
		System.out.println("requestParams" + session.getRequestParameterMap());
		System.out.print("onClose ");
	}
}