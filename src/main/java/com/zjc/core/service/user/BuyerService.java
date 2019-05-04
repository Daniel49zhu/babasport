package com.zjc.core.service.user;

import java.util.List;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.user.Buyer;
import com.zjc.core.query.user.BuyerQuery;

public  interface BuyerService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	 Integer addBuyer(Buyer buyer);

	/**
	 * 根据主键查询
	 */
	 Buyer getBuyerByKey(String id);

	/**
	 * 根据主键批量查询
	 */
	 List<Buyer> getBuyersByKeys(List<String> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	 Integer deleteByKey(String id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	 Integer deleteByKeys(List<String> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	 Integer updateBuyerByKey(Buyer buyer);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param buyerQuery
	 *            查询条件
	 * @return
	 */
	 Pagination getBuyerListWithPage(BuyerQuery buyerQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param buyerQuery
	 *            查询条件
	 * @return
	 */
	 List<Buyer> getBuyerList(BuyerQuery buyerQuery);
}
