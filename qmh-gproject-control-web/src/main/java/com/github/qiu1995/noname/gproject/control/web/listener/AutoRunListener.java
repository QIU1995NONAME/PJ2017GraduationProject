package com.github.qiu1995.noname.gproject.control.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 网站启动时自动运行的程序
 * 用来调用核心的启动程序以及其他需要初始化的部分
 * @author QMH
 */
@WebListener
public class AutoRunListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// DO NOTHING
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO AutoRUN
	}

}
/*
 * public class MyListener implements ServletContextListener {
 * 
 * private java.util.Timer timer = null ; public void
 * contextDestroyed(ServletContextEvent event) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * public void contextInitialized(ServletContextEvent event) {
 * 
 * timer = new java.util.Timer(true) ; event.getServletContext().log("定时器已启动。")
 * ; timer.schedule(new MyTask(event.getServletContext()), 0, 5000) ;
 * event.getServletContext().log("已经添加任务调度表。" ) ;
 * 
 * }
 * 
 * }
 */