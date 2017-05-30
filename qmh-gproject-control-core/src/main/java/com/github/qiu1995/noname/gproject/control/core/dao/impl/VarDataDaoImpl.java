package com.github.qiu1995.noname.gproject.control.core.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.github.qiu1995.noname.gproject.control.core.dao.BaseDao;
import com.github.qiu1995.noname.gproject.control.core.dao.VarDataDao;
import com.github.qiu1995.noname.gproject.control.core.dao.VariableDao;
import com.github.qiu1995.noname.gproject.control.core.entity.VarData;
import com.github.qiu1995.noname.gproject.control.core.entity.Variable;

public class VarDataDaoImpl extends BaseDao implements VarDataDao {
	public VarDataDaoImpl() {
		super();
	}

	public VarDataDaoImpl(Session session) {
		super(session);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public VarData getVariableCurrentData(long variable_id) {
		VariableDao vardao = new VariableDaoImpl(this._M_session);
		Variable var = vardao.getVariableByID(variable_id);
		if (var == null) {
			return null;
		}
		List<VarData> li = this._M_session.createCriteria(VarData.class)//
				.add(Restrictions.eq("var", var))//
				.addOrder(Order.desc("timestamp"))//
				.setMaxResults(1)//
				.list();
		if (li == null || li.size() == 0) {
			return null;
		}
		return li.get(0);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<VarData> getVariableHistoryData(long variable_id, int count) {
		VariableDao vardao = new VariableDaoImpl(this._M_session);
		Variable var = vardao.getVariableByID(variable_id);
		if (var == null) {
			return new LinkedList<VarData>();
		}
		return this._M_session.createCriteria(VarData.class)//
				.add(Restrictions.eq("var", var))//
				.addOrder(Order.desc("timestamp"))//
				.setMaxResults(count)//
				.list();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<VarData> getVariableHistoryData(long variable_id, long time_from, long time_to) {
		VariableDao vardao = new VariableDaoImpl(this._M_session);
		Variable var = vardao.getVariableByID(variable_id);
		if (var == null) {
			return new LinkedList<VarData>();
		}
		return this._M_session.createCriteria(VarData.class)//
				.add(Restrictions.eq("var", var))//
				.add(Restrictions.between("timestamp", time_from, time_to))//
				.addOrder(Order.desc("timestamp"))//
				.list();
	}

}
