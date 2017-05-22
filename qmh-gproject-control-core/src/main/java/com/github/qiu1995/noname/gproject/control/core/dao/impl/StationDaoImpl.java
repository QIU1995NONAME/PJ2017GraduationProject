package com.github.qiu1995.noname.gproject.control.core.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.github.qiu1995.noname.gproject.control.core.dao.BaseDao;
import com.github.qiu1995.noname.gproject.control.core.dao.StationDao;
import com.github.qiu1995.noname.gproject.control.core.entity.Station;

public class StationDaoImpl extends BaseDao implements StationDao {

	protected StationDaoImpl(Session session) {
		super(session);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Station> getAllStations() {
		return this._M_session.createCriteria(Station.class)//
				.list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Station> getAllowedStations() {
		return this._M_session.createCriteria(Station.class)//
				.list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Station> getDeniedStations() {
		return this._M_session.createCriteria(Station.class)//
				.list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Station> getUncheckedGateway() {
		return this._M_session.createCriteria(Station.class)//
				.list();
	}

	@Override
	public Station getStationByID(int id) {
		return this._M_session.get(Station.class, id);
	}

	@Override
	public int addStation(Station station) {
		if (station.getID() <= 0) {
			throw new IllegalArgumentException("Station ID 应该大于0！");
		}
		Transaction tx = this._M_session.beginTransaction();
		Station tmp = this.getStationByID(station.getID());
		if (tmp != null) {
			tx.rollback();
			throw new IllegalArgumentException("Station ID 已存在！");
		}
		this._M_session.saveOrUpdate(station.clone());
		tx.commit();
		return 0;
	}

	@Override
	public int deleteStationByID(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("Station ID 应该大于0！");
		}
		Transaction tx = this._M_session.beginTransaction();
		Station tmp = this.getStationByID(id);
		if (tmp == null) {
			tx.rollback();
			throw new IllegalArgumentException("Station ID 不存在！");
		}
		this._M_session.delete(tmp);
		tx.commit();
		return 0;
	}

	@Override
	public int modifyStation(Station station) {
		if (station.getID() <= 0) {
			throw new IllegalArgumentException("Station ID 应该大于0！");
		}
		Transaction tx = this._M_session.beginTransaction();
		Station tmp = this.getStationByID(station.getID());
		if (tmp == null) {
			tx.rollback();
			throw new IllegalArgumentException("Station ID 不存在！");
		}
		this._M_session.saveOrUpdate(station.clone());
		tx.commit();
		return 0;
	}

}
