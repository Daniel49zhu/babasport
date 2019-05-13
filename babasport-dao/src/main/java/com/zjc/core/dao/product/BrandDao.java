package com.zjc.core.dao.product;

import com.zjc.core.bean.product.*;

import java.util.List;

public interface BrandDao {
    //查询结果集
    List<Brand> selectBrandListByQuery(BrandQuery brandQuery);

    //查询总条数
    Integer selectCount(BrandQuery brandQuery);

    //通过ID查询品牌
    Brand selectBrandById(Long id);

    //修改品牌
    void updateBrandById(Brand brand);
}
