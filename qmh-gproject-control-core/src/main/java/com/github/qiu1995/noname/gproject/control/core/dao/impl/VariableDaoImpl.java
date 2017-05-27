package com.github.qiu1995.noname.gproject.control.core.dao.impl;

import org.hibernate.Session;

import com.github.qiu1995.noname.gproject.control.core.dao.BaseDao;
import com.github.qiu1995.noname.gproject.control.core.dao.VariableDao;
import com.github.qiu1995.noname.gproject.control.core.entity.Variable;

public class VariableDaoImpl extends BaseDao implements VariableDao {
	public VariableDaoImpl() {
		super();
	}

	public VariableDaoImpl(Session session) {
		super(session);
	}

	@Override
	public Variable getVariableByID(long id) {
		return this._M_session.get(Variable.class, id);
	}

}
