package com.zjc.core.service.product;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Brand;
import org.springframework.stereotype.Service;

public interface BrandService {
	void getBrandListWithPage(Brand brand);
}