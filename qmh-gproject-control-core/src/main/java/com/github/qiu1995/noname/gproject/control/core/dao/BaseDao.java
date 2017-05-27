package com.github.qiu1995.noname.gproject.control.core.dao;

import org.hibernate.Session;

import com.github.qiu1995.noname.gproject.control.core.QPCCore;

public class BaseDao {
	protected Session _M_session = null;

	protected BaseDao() {
		this._M_session = QPCCore.getInstance().getSession();
	}

	protected BaseDao(Session session) {
		if (session == null) {
			throw new IllegalArgumentException("Session 无效！");
		}
		this._M_session = session;
	}
}
