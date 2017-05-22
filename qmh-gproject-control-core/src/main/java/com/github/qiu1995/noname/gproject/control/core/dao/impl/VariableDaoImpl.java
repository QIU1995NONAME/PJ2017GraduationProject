package com.github.qiu1995.noname.gproject.control.core.dao.impl;

import org.hibernate.Session;

import com.github.qiu1995.noname.gproject.control.core.dao.BaseDao;
import com.github.qiu1995.noname.gproject.control.core.dao.VariableDao;

public class VariableDaoImpl extends BaseDao implements VariableDao {

	protected VariableDaoImpl(Session session) {
		super(session);
	}

}
