package com.zjc.core.service.user;

import java.util.List;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.user.Addr;
import com.zjc.core.query.user.AddrQuery;


public interface AddrService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	 Integer addAddr(Addr addr);

	/**
	 * 根据主键查询
	 */
	 Addr getAddrByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	 List<Addr> getAddrsByKeys(List<Integer> idList);

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
	 Integer updateAddrByKey(Addr addr);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param addrQuery
	 *            查询条件
	 * @return
	 */
	 Pagination getAddrListWithPage(AddrQuery addrQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param addrQuery
	 *            查询条件
	 * @return
	 */
	 List<Addr> getAddrList(AddrQuery addrQuery);
}
