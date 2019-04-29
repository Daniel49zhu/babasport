package com.zjc.core.service.product;

import com.zjc.core.bean.product.Brand;
import com.zjc.core.dao.product.BrandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Transactional(readOnly = true)
    public void getBrandListWithPage(Brand brand) {
        //Brand集合
        List<Brand> brandList =  brandDao.getBrandListWithPage(brand);
        for(Brand temp : brandList) {
            System.out.println(temp);
        }
    }
}
