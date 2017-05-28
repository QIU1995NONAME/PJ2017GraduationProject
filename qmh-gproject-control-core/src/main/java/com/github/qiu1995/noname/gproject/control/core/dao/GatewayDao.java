package com.github.qiu1995.noname.gproject.control.core.dao;

import java.util.List;

import com.github.qiu1995.noname.gproject.control.core.entity.Gateway;

public interface GatewayDao {
	/**
	 * 获取数据库中所有的Gateway数量
	 * 
	 * @return
	 */
	int getAllGatewaysCount();

	/**
	 * 获取所有允许通信的Gateway数量
	 * 
	 * @return
	 */
	int getAllowedGatewaysCount();

	/**
	 * 获取所有被拒绝的Gateway数量
	 * 
	 * @return
	 */
	int getDeniedGatewaysCount();

	/**
	 * 获取所有未经判断的Gateway数量
	 * 
	 * @return
	 */
	int getUncheckedGatewaysCount();

	/**
	 * 获取数据库中所有的Gateway
	 * 
	 * @return
	 */
	List<Gateway> getAllGateways();

	/**
	 * 获取所有允许通信的Gateway
	 * 
	 * @return
	 */
	List<Gateway> getAllowedGateways();

	/**
	 * 获取所有被拒绝的Gateway
	 * 
	 * @return
	 */
	List<Gateway> getDeniedGateways();

	/**
	 * 获取所有未经判断的Gateway
	 * 
	 * @return
	 */
	List<Gateway> getUncheckedGateways();

	/**
	 * 根据ID查找Gateway
	 * 
	 * @param id
	 * @return
	 */
	Gateway getGatewayByID(int id);

	/**
	 * 添加一个新的Gateway
	 * 
	 * @param gateway
	 * @return
	 */
	int addGateway(Gateway gateway);

	/**
	 * 删除一个Gateway
	 * 
	 * @param id
	 * @return
	 */
	int deleteGatewayByID(int id);

	/**
	 * 更改一个Gateway
	 * 
	 * @param gateway
	 * @return
	 */
	int modifyGateway(Gateway gateway);
}
