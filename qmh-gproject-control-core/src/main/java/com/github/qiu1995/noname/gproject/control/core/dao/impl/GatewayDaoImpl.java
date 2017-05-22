package com.github.qiu1995.noname.gproject.control.core.dao.impl;

import org.hibernate.Session;

import com.github.qiu1995.noname.gproject.control.core.dao.BaseDao;
import com.github.qiu1995.noname.gproject.control.core.dao.GatewayDao;

public class GatewayDaoImpl extends BaseDao implements GatewayDao {

	protected GatewayDaoImpl(Session session) {
		super(session);
	}

}
