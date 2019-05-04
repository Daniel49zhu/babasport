package com.zjc.core.dao.product;

import com.zjc.core.bean.product.Product;
import com.zjc.core.query.product.ProductQuery;

import java.util.List;


public interface ProductDao {

    /**
     * 添加
     *
     * @param product
     */
    Integer addProduct(Product product);

    /**
     * 根据主键查找
     */
    Product getProductByKey(Integer id);

    /**
     * 根据主键批量查找
     */
    List<Product> getProductsByKeys(List<Integer> idList);

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
    Integer updateProductByKey(Product product);

    /**
     * 分页查询
     *
     * @param productQuery
     */
    List<Product> getProductListWithPage(ProductQuery productQuery);

    /**
     * 集合查询
     *
     * @param productQuery
     */
    List<Product> getProductList(ProductQuery productQuery);

    /**
     * 总条数
     *
     * @param productQuery
     */
    int getProductListCount(ProductQuery productQuery);
}
