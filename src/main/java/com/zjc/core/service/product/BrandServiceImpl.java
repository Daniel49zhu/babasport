package com.zjc.core.service.product;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Brand;
import com.zjc.core.dao.product.BrandDao;
import com.zjc.core.query.product.BrandQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Transactional(readOnly = true)
    public Pagination getBrandListWithPage(Brand brand) {
        //1:起始页  startRow = (pageNo - 1)*pageSize
        //2:每页数
        //3:总记录数
        Pagination pagination = new Pagination(brand.getPageNo(), brand.getPageSize(), brandDao.getBrandCount(brand));
        //Brand集合
        pagination.setList(brandDao.getBrandListWithPage(brand));

        return pagination;
    }

    @Transactional(rollbackFor = Exception.class)
    public void addBrand(Brand brand) {
        brandDao.addBrand(brand);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteBrandByKey(Integer id) {
        brandDao.deleteBrandByKey(id);

    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteBrandByKeys(Integer[] ids) {
        brandDao.deleteBrandByKeys(ids);

    }

    @Transactional(rollbackFor = Exception.class)
    public void updateBrandByKey(Brand brand) {
        brandDao.updateBrandByKey(brand);
    }

    @Transactional(rollbackFor = Exception.class)
    public Brand getBrandByKey(Integer id) {
        // TODO Auto-generated method stub
        return brandDao.getBrandByKey(id);
    }

    public List<Brand> getBrandList(BrandQuery brandQuery) {
        // TODO Auto-generated method stub
        return brandDao.getBrandList(brandQuery);
    }
}
