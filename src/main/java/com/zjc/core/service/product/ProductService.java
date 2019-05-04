package com.zjc.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Product;
import com.zjc.core.query.product.ProductQuery;

public interface ProductService {
    /**
     * 基本插入
     *
     * @return
     */
    Integer addProduct(Product product);

    /**
     * 根据主键查询
     */
    Product getProductByKey(Integer id);

    /**
     * 根据主键批量查询
     */
    List<Product> getProductsByKeys(List<Integer> idList);

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
    Integer updateProductByKey(Product product);

    /**
     * 根据条件查询分页查询
     *
     * @param productQuery 查询条件
     * @return
     */
    Pagination getProductListWithPage(ProductQuery productQuery);

    /**
     * 根据条件查询
     *
     * @param productQuery 查询条件
     * @return
     */
    List<Product> getProductList(ProductQuery productQuery);
}
