package com.github.qiu1995.noname.gproject.control.core.dao;

import java.util.List;

import com.github.qiu1995.noname.gproject.control.core.entity.VarData;

public interface VarDataDao {
	/**
	 * 获取一个变量的当前值
	 * 
	 * @param variable_id
	 *            变量ID
	 * @return
	 */
	VarData getVariableCurrentData(long variable_id);

	/**
	 * 获取距离最近的数据
	 * 
	 * @param variable_id
	 *            变量ID
	 * @param count
	 *            想要获取的数据数量 如果传入不大于0的数,则获取变量所有的数据
	 * @return
	 */
	List<VarData> getVariableHistoryData(long variable_id, int count);

	/**
	 * 获取一个变量两个时间点内的数据
	 * 
	 * @param variable_id 变量ID
	 * @param time_from 第一个时间点
	 * @param time_to 第二个时间点
	 * @return
	 */
	List<VarData> getVariableHistoryData(long variable_id, long time_from, long time_to);

}
