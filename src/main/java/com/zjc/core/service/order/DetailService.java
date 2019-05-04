package com.zjc.core.service.order;

import java.util.List;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.order.Detail;
import com.zjc.core.query.order.DetailQuery;


public interface DetailService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	 Integer addDetail(Detail detail);

	/**
	 * 根据主键查询
	 */
	 Detail getDetailByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	 List<Detail> getDetailsByKeys(List<Integer> idList);

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
	 Integer updateDetailByKey(Detail detail);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param detailQuery
	 *            查询条件
	 * @return
	 */
	 Pagination getDetailListWithPage(DetailQuery detailQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param detailQuery
	 *            查询条件
	 * @return
	 */
	 List<Detail> getDetailList(DetailQuery detailQuery);
}
