package com.zjc.core.dao.order;

import com.zjc.core.bean.order.Order;
import com.zjc.core.query.order.OrderQuery;

import java.util.List;


public interface OrderDao {

    /**
     * 添加
     *
     * @param order
     */
    Integer addOrder(Order order);

    /**
     * 根据主键查找
     */
    Order getOrderByKey(Integer id);

    /**
     * 根据主键批量查找
     */
    List<Order> getOrdersByKeys(List<Integer> idList);

    /**
     * 根据主键删除
     */
    Integer deleteByKey(Integer id);

    /**
     * 根据主键批量删除
     */
    Integer deleteByKeys(List<Integer> idList);

    /**
     * 根据主键更新
     */
    Integer updateOrderByKey(Order order);

    /**
     * 分页查询
     *
     * @param orderQuery
     */
    List<Order> getOrderListWithPage(OrderQuery orderQuery);

    /**
     * 集合查询
     *
     * @param orderQuery
     */
    List<Order> getOrderList(OrderQuery orderQuery);

    /**
     * 总条数
     *
     * @param orderQuery
     */
    int getOrderListCount(OrderQuery orderQuery);
}
