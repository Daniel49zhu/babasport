package com.zjc.core.dao.user;


import com.zjc.core.bean.user.Buyer;
import com.zjc.core.query.user.BuyerQuery;

import java.util.List;

public interface BuyerDao {

    /**
     * 添加
     *
     * @param buyer
     */
    Integer addBuyer(Buyer buyer);

    /**
     * 根据主键查找
     */
    Buyer getBuyerByKey(String id);

    /**
     * 根据主键批量查找
     */
    List<Buyer> getBuyersByKeys(List<String> idList);

    /**
     * 根据主键删除
     */
    Integer deleteByKey(String id);

    /**
     * 根据主键批量删除
     */
    Integer deleteByKeys(List<String> idList);

    /**
     * 根据主键更新
     */
    Integer updateBuyerByKey(Buyer buyer);

    /**
     * 分页查询
     *
     * @param buyerQuery
     */
    List<Buyer> getBuyerListWithPage(BuyerQuery buyerQuery);

    /**
     * 集合查询
     *
     * @param buyerQuery
     */
    List<Buyer> getBuyerList(BuyerQuery buyerQuery);

    /**
     * 总条数
     *
     * @param buyerQuery
     */
    int getBuyerListCount(BuyerQuery buyerQuery);
}
