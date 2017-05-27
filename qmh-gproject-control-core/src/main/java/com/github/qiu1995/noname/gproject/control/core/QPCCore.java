package com.github.qiu1995.noname.gproject.control.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QPCCore {
	private static QPCCore _S_instance = null;

	public static QPCCore getInstance() {
		if (_S_instance == null) {
			_S_instance = new QPCCore();
		}
		return _S_instance;
	}

	////////////////////////////////////////////////
	private Configuration _M_config = null;
	private SessionFactory _M_factory = null;

	private QPCCore() {
		_M_config = new Configuration().configure();
	}

	public boolean isEnabled() {
		return _M_factory != null;
	}

	public void enable() {
		if (_M_factory == null) {
			_M_factory = _M_config.buildSessionFactory();
		}
	}

	public void disable() {
		if (_M_factory != null) {
			_M_factory.close();
			_M_factory = null;
		}
	}

	public Session getSession() {
		return _M_factory.openSession();
	}
}
