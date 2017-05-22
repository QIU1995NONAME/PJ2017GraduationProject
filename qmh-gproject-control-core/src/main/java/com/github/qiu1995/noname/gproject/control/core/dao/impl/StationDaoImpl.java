package com.github.qiu1995.noname.gproject.control.core.dao.impl;

import org.hibernate.Session;

import com.github.qiu1995.noname.gproject.control.core.dao.BaseDao;
import com.github.qiu1995.noname.gproject.control.core.dao.StationDao;

public class StationDaoImpl extends BaseDao implements StationDao {

	protected StationDaoImpl(Session session) {
		super(session);
	}

}
