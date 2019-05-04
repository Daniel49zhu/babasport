package com.zjc.core.service.product;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Brand;
import com.zjc.core.query.product.BrandQuery;

import java.util.List;

public interface BrandService {
    Pagination getBrandListWithPage(Brand brand);

    void addBrand(Brand brand);

    //删除
    void deleteBrandByKey(Integer id);

    //删除 批量
    void deleteBrandByKeys(Integer[] ids);//List<Integer>  ids

    //修改
    void updateBrandByKey(Brand brand);

    //
    Brand getBrandByKey(Integer id);

    //查询集合
    List<Brand> getBrandList(BrandQuery brandQuery);
}