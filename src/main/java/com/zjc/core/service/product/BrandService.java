package com.zjc.core.service.product;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Brand;

public interface BrandService {
	Pagination  getBrandListWithPage(Brand brand);

    void addBrand(Brand brand);
}