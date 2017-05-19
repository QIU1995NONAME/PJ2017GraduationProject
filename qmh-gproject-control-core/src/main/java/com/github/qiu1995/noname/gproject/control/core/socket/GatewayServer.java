package com.github.qiu1995.noname.gproject.control.core.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 为Gateway通信设定的Server
 * 
 * @author QMH
 *
 */
public class GatewayServer {
	private ServerBootstrap boot;
	private EventLoopGroup bossGroup;
	private EventLoopGroup workerGroup;
	private int port;

	public GatewayServer(int port) {
		this.boot = new ServerBootstrap();
		this.bossGroup = new NioEventLoopGroup();
		this.workerGroup = new NioEventLoopGroup();
		this.port = port;
		boot.group(this.bossGroup, this.workerGroup);
		boot.option(ChannelOption.SO_BACKLOG, 128);
		boot.childOption(ChannelOption.SO_KEEPALIVE, true);
		boot.channel(NioServerSocketChannel.class);
		boot.childHandler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(new GatewayServerHandler());
			}
		});
	}

	public void stop() {
		try {
			this.bossGroup.shutdownGracefully().sync();
			this.workerGroup.shutdownGracefully().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		try {
			ChannelFuture future = boot.bind(this.port).sync();
			if (future.isSuccess()) {
				System.out.println("Server is Running!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
