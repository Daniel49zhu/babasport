package com.zjc.core.service.product;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Color;

import java.util.List;

public interface ProductService {
    //分页对象
    Pagination selectPaginationByQuery(Integer pageNo, String name, Long brandId, Boolean isShow);

    //颜色结果集
    List<Color> selectColorList();
}
