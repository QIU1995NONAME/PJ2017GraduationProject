package com.github.qiu1995.noname.gproject.control.core.message;

public enum MessageType {
	SRV_BYE, //服务器主动断开连接
	CLI_BYE, //客户端主动断开连接 
	SRV_PONG, //服务器回应客户端的PING
	CLI_PING, //向服务器发送PING
	SRV_ASK, //服务器请求客户端回应
	CLI_ASK, //客户端请求服务器回应
	SRV_REPLY, //服务器回应客户端请求
	CLI_REPLY, //客户端回应服务器请求
}
