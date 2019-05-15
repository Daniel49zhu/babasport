package com.zjc.core.service.product;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Brand;

import java.util.List;

public interface BrandService {

    //查询分页对象
    Pagination selectPaginationByQuery(String name, Integer isDisplay, Integer pageNo);
    //通过ID查询品牌
    Brand selectBrandById(Long id);

    void updateBrandById(Brand brand);

    void deletes(Long[] ids);
    //查询结果集
    List<Brand> selectBrandListByQuery(Integer isDisplay);
}
