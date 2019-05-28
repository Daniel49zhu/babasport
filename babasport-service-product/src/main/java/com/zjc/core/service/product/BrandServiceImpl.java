package com.zjc.core.service.product;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Brand;
import com.zjc.core.bean.product.BrandQuery;
import com.zjc.core.dao.product.BrandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service(value = "brandService")
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    //查询分页对象
    public Pagination selectPaginationByQuery(String name, Integer isDisplay, Integer pageNo) {
        BrandQuery brandQuery = new BrandQuery();
        //当前页
        brandQuery.setPageNo(Pagination.cpn(pageNo));
        //每页数
        brandQuery.setPageSize(5);

        StringBuilder params = new StringBuilder();

        //条件
        if (null != name) {
            brandQuery.setName(name);
            params.append("name=").append(name);
        }
        if (null != isDisplay) {
            brandQuery.setIsDisplay(isDisplay);
            params.append("&isDisplay=").append(isDisplay);
        } else {
            brandQuery.setIsDisplay(1);
            params.append("&isDisplay=").append(1);
        }

        Pagination pagination = new Pagination(
                brandQuery.getPageNo(),
                brandQuery.getPageSize(),
                brandDao.selectCount(brandQuery)
        );
        //设置结果集
        pagination.setList(brandDao.selectBrandListByQuery(brandQuery));
        //分页展示
        String url = "/brand/list.do";

        pagination.pageView(url, params.toString());

        return pagination;
    }

    public Brand selectBrandById(Long id) {
        return brandDao.selectBrandById(id);
    }

    @Autowired
    private Jedis jedis;
    //修改
    @Override
    public void updateBrandById(Brand brand) {
        //修改Redis
        jedis.hset("brand", String.valueOf(brand.getId()), brand.getName());
        brandDao.updateBrandById(brand);
    }
    //查询 从Redis中
    public List<Brand> selectBrandListFromRedis(){
        List<Brand> brands = new ArrayList<Brand>();
        //Redis中查
        Map<String, String> hgetAll = jedis.hgetAll("brand");
        Set<Map.Entry<String, String>> entrySet = hgetAll.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            Brand brand = new Brand();
            brand.setId(Long.parseLong(entry.getKey()));
            brand.setName(entry.getValue());
            brands.add(brand);
        }
        return brands;
    }
    @Override
    public void deletes(Long[] ids) {
        brandDao.deletes(ids);
    }

    @Override
    public List<Brand> selectBrandListByQuery(Integer isDisplay) {
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setIsDisplay(isDisplay);
        // TODO Auto-generated method stub
        return brandDao.selectBrandListByQuery(brandQuery);
    }
}
