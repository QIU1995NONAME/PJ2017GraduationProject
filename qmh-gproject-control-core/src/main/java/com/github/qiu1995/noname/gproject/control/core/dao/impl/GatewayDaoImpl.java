package com.github.qiu1995.noname.gproject.control.core.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.github.qiu1995.noname.gproject.control.core.dao.BaseDao;
import com.github.qiu1995.noname.gproject.control.core.dao.GatewayDao;
import com.github.qiu1995.noname.gproject.control.core.entity.Gateway;

public class GatewayDaoImpl extends BaseDao implements GatewayDao {
	public GatewayDaoImpl() {
		super();
	}

	public GatewayDaoImpl(Session session) {
		super(session);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getAllGatewaysCount() {
		return Integer.parseInt(this._M_session.createCriteria(Gateway.class)//
				.setProjection(Projections.rowCount())//
				.uniqueResult().toString());
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getAllowedGatewaysCount() {
		return Integer.parseInt(this._M_session.createCriteria(Gateway.class)//
				.add(Restrictions.eq("status", 127))//
				.setProjection(Projections.rowCount())//
				.uniqueResult().toString());
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getDeniedGatewaysCount() {
		return Integer.parseInt(this._M_session.createCriteria(Gateway.class)//
				.add(Restrictions.eq("status", -128))//
				.setProjection(Projections.rowCount())//
				.uniqueResult().toString());
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getUncheckedGatewaysCount() {
		return Integer.parseInt(this._M_session.createCriteria(Gateway.class)//
				.add(Restrictions.eq("status", 0))//
				.setProjection(Projections.rowCount())//
				.uniqueResult().toString());
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Gateway> getAllGateways() {
		return this._M_session.createCriteria(Gateway.class)//
				.list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Gateway> getAllowedGateways() {
		return this._M_session.createCriteria(Gateway.class)//
				.add(Restrictions.eq("status", 127))//
				.list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Gateway> getDeniedGateways() {
		return this._M_session.createCriteria(Gateway.class)//
				.add(Restrictions.eq("status", -128))//
				.list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Gateway> getUncheckedGateways() {
		return this._M_session.createCriteria(Gateway.class)//
				.add(Restrictions.eq("status", 0))//
				.list();
	}

	@Override
	public Gateway getGatewayByID(int id) {
		return this._M_session.get(Gateway.class, id);
	}

	@Override
	public int addGateway(Gateway gateway) {
		if (gateway.getID() <= 0) {
			throw new IllegalArgumentException("Gateway ID 应该大于0！");
		}
		Transaction tx = this._M_session.beginTransaction();
		Gateway tmp = this.getGatewayByID(gateway.getID());
		if (tmp != null) {
			tx.rollback();
			throw new IllegalArgumentException("Gateway ID 已存在！");
		}
		this._M_session.saveOrUpdate(gateway.clone());
		tx.commit();
		return 0;
	}

	@Override
	public int deleteGatewayByID(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("Gateway ID 应该大于0！");
		}
		Transaction tx = this._M_session.beginTransaction();
		Gateway tmp = this.getGatewayByID(id);
		if (tmp == null) {
			tx.rollback();
			throw new IllegalArgumentException("Gateway ID 不存在！");
		}
		this._M_session.delete(tmp);
		tx.commit();
		return 0;
	}

	@Override
	public int modifyGateway(Gateway gateway) {
		if (gateway.getID() <= 0) {
			throw new IllegalArgumentException("Gateway ID 应该大于0！");
		}
		Transaction tx = this._M_session.beginTransaction();
		Gateway tmp = this.getGatewayByID(gateway.getID());
		if (tmp == null) {
			tx.rollback();
			throw new IllegalArgumentException("Gateway ID 不存在！");
		}
		// this._M_session.saveOrUpdate(gateway.clone());
		this._M_session.saveOrUpdate(gateway);
		tx.commit();
		return 0;
	}

}
