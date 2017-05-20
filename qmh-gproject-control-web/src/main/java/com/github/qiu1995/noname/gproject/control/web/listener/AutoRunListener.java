package com.github.qiu1995.noname.gproject.control.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.github.qiu1995.noname.gproject.control.core.QPCCore;
import com.github.qiu1995.noname.gproject.control.core.socket.GatewayServer;

/**
 * 网站启动时自动运行的程序 用来调用核心的启动程序以及其他需要初始化的部分
 * 
 * @author QMH
 */
@WebListener
public class AutoRunListener implements ServletContextListener {

	GatewayServer server = null;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		if (server != null) {
			server.stop();
			server = null;
		}
		QPCCore.getInstance().disable();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		QPCCore.getInstance().enable();
		if (server == null) {
			server = new GatewayServer(8090);
			server.start();
		}
	}
}
