package com.zjc.core.dao.product;

import com.zjc.core.bean.product.Sku;
import com.zjc.core.query.product.SkuQuery;

import java.util.List;


public interface SkuDao {

    /**
     * 添加
     *
     * @param sku
     */
    Integer addSku(Sku sku);

    /**
     * 根据主键查找
     */
    Sku getSkuByKey(Integer id);

    /**
     * 根据主键批量查找
     */
    List<Sku> getSkusByKeys(List<Integer> idList);

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
    Integer updateSkuByKey(Sku sku);

    /**
     * 分页查询
     *
     * @param skuQuery
     */
    List<Sku> getSkuListWithPage(SkuQuery skuQuery);

    /**
     * 集合查询
     *
     * @param skuQuery
     */
    List<Sku> getSkuList(SkuQuery skuQuery);

    /**
     * 总条数
     *
     * @param skuQuery
     */
    int getSkuListCount(SkuQuery skuQuery);

}
