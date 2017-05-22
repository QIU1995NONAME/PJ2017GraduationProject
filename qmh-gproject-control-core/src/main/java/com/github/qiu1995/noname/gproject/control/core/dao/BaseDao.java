package com.github.qiu1995.noname.gproject.control.core.dao;

import org.hibernate.Session;

public class BaseDao {
	protected Session _M_session = null;

	protected BaseDao(Session session) {
		if (session == null) {
			throw new IllegalArgumentException("Session 无效！");
		}
		this._M_session = session;
	}
}
