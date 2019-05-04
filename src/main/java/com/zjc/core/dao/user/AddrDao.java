package com.zjc.core.dao.user;


import com.zjc.core.bean.user.Addr;
import com.zjc.core.query.user.AddrQuery;

import java.util.List;

public interface AddrDao {

    /**
     * 添加
     *
     * @param addr
     */
    Integer addAddr(Addr addr);

    /**
     * 根据主键查找
     */
    Addr getAddrByKey(Integer id);

    /**
     * 根据主键批量查找
     */
    List<Addr> getAddrsByKeys(List<Integer> idList);

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
    Integer updateAddrByKey(Addr addr);

    /**
     * 分页查询
     *
     * @param addrQuery
     */
    List<Addr> getAddrListWithPage(AddrQuery addrQuery);

    /**
     * 集合查询
     *
     * @param addrQuery
     */
    List<Addr> getAddrList(AddrQuery addrQuery);

    /**
     * 总条数
     *
     * @param addrQuery
     */
    int getAddrListCount(AddrQuery addrQuery);
}
