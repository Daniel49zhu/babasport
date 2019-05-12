package com.zjc.core.service.product;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Brand;

public interface BrandService {

    //查询分页对象
    Pagination selectPaginationByQuery(String name, Integer isDisplay, Integer pageNo);
    //通过ID查询品牌
    Brand selectBrandById(Long id);
}
