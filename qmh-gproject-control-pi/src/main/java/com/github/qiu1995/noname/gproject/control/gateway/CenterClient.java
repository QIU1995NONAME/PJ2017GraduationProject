package com.github.qiu1995.noname.gproject.control.gateway;

import com.github.qiu1995.noname.gproject.control.core.message.Message;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * 用于和中心交互的客户端
 * 
 * @author QMH
 *
 */
public class CenterClient {

	private Bootstrap boot = null;
	private SocketChannel _M_channel = null;
	private EventLoopGroup workerGroup = null;
	private String host = "localhost";
	private int port = 8090;

	public CenterClient(String host, int port) {
		this.host = host;
		this.port = port;
		this.boot = new Bootstrap();
		this.workerGroup = new NioEventLoopGroup();
		boot.group(this.workerGroup);
		boot.channel(NioSocketChannel.class);
		boot.option(ChannelOption.SO_KEEPALIVE, true);
		boot.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(new ObjectEncoder());
				ch.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
				ch.pipeline().addLast(new CenterClientHandler());
			}
		});
	}

	public void stop() {
		if (_M_channel != null) {
			if (!this.workerGroup.isShutdown()) {
				this.workerGroup.shutdownGracefully();
			}
			_M_channel.shutdown();
			_M_channel = null;
		}
	}

	public void start() {
		try {
			ChannelFuture future = this.boot.connect(host, port).sync();
			if (future.isSuccess()) {
				_M_channel = (SocketChannel) future.channel();
				System.out.println("Running!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void send(Message msg) {
		if (_M_channel == null) {
			System.err.println("Client is NOT running!");
		} else {
			_M_channel.writeAndFlush(msg);
		}
	}
}
