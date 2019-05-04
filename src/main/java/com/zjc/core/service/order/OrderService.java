package com.zjc.core.service.order;

import java.util.List;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.order.Order;
import com.zjc.core.query.order.OrderQuery;

 public interface OrderService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	 Integer addOrder(Order order);

	/**
	 * 根据主键查询
	 */
	 Order getOrderByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	 List<Order> getOrdersByKeys(List<Integer> idList);

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
	 Integer updateOrderByKey(Order order);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param orderQuery
	 *            查询条件
	 * @return
	 */
	 Pagination getOrderListWithPage(OrderQuery orderQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param orderQuery
	 *            查询条件
	 * @return
	 */
	 List<Order> getOrderList(OrderQuery orderQuery);
}
