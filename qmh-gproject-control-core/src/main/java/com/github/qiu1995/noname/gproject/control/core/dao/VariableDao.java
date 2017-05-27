package com.github.qiu1995.noname.gproject.control.core.dao;

import com.github.qiu1995.noname.gproject.control.core.entity.Variable;

public interface VariableDao {
	/**
	 * 根据ID查询Variable
	 * 
	 * @param id
	 * @return
	 */
	Variable getVariableByID(long id);

}
