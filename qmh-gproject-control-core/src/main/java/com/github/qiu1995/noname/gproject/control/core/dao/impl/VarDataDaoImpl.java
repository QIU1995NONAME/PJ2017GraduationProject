package com.github.qiu1995.noname.gproject.control.core.dao.impl;

import org.hibernate.Session;

import com.github.qiu1995.noname.gproject.control.core.dao.BaseDao;
import com.github.qiu1995.noname.gproject.control.core.dao.VarDataDao;

public class VarDataDaoImpl extends BaseDao implements VarDataDao {
	public VarDataDaoImpl() {
		super();
	}

	public VarDataDaoImpl(Session session) {
		super(session);
	}

}
