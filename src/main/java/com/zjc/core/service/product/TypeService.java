package com.zjc.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Type;
import com.zjc.core.query.product.TypeQuery;

 public interface TypeService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	 Integer addType(Type type);

	/**
	 * 根据主键查询
	 */
	 Type getTypeByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	 List<Type> getTypesByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	 Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	 Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	 Integer updateTypeByKey(Type type);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param typeQuery
	 *            查询条件
	 * @return
	 */
	 Pagination getTypeListWithPage(TypeQuery typeQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param typeQuery
	 *            查询条件
	 * @return
	 */
	 List<Type> getTypeList(TypeQuery typeQuery);
}
