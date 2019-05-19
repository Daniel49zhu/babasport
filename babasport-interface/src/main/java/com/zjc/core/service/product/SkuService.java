package com.zjc.core.service.product;

import com.zjc.core.bean.product.Sku;

import java.util.List;


public interface SkuService {
	
	//商品ID 查询 库存结果集
	List<Sku> selectSkuListByProductId(Long productId);
	
	//修改
	void updateSkuById(Sku sku);

}
