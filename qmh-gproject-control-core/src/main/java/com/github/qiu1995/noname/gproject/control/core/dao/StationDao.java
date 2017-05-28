package com.github.qiu1995.noname.gproject.control.core.dao;

import java.util.List;

import com.github.qiu1995.noname.gproject.control.core.entity.Station;

public interface StationDao {
	/**
	 * 获取所有站点数量
	 * 
	 * @return
	 */
	int getAllStationsCount();

	/**
	 * 获取所有允许通信的站点数量
	 * 
	 * @return
	 */
	int getAllowedStationsCount();

	/**
	 * 获取所有被拒绝的站点数量
	 * 
	 * @return
	 */
	int getDeniedStationsCount();

	/**
	 * 获取所有未经判断的站点数量
	 * 
	 * @return
	 */
	int getUncheckedStationsCount();

	/**
	 * 获取所有站点
	 * 
	 * @return
	 */
	List<Station> getAllStations();

	/**
	 * 获取所有允许通信的站点
	 * 
	 * @return
	 */
	List<Station> getAllowedStations();

	/**
	 * 获取所有被拒绝的站点
	 * 
	 * @return
	 */
	List<Station> getDeniedStations();

	/**
	 * 获取所有未经判断的站点
	 * 
	 * @return
	 */
	List<Station> getUncheckedGateway();

	/**
	 * 根据ID查找站点
	 * 
	 * @param id
	 * @return
	 */
	Station getStationByID(int id);

	/**
	 * 添加一个站点
	 * 
	 * @param station
	 * @return
	 */
	int addStation(Station station);

	/**
	 * 根据ID删除站点
	 * 
	 * @param id
	 * @return
	 */
	int deleteStationByID(int id);

	/**
	 * 更改站点信息
	 * 
	 * @param station
	 * @return
	 */
	int modifyStation(Station station);

}
