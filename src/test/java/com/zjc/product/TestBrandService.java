package com.zjc.product;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Brand;
import com.zjc.core.service.product.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestBrandService {
    @Autowired
    private BrandService brandService;

    @Test
    public void testGet() {
        Pagination pagination =  brandService.getBrandListWithPage(new Brand());
        List<Brand> result = (List<Brand>) pagination.getList();
        System.out.println(Arrays.toString(result.toArray()));
    }

    @Test
    public void testBlank() {
        System.out.println(StringUtils.isNotBlank(null));
        System.out.println(StringUtils.isNotBlank(""));
        System.out.println(StringUtils.isNotBlank("    "));
        System.out.println(StringUtils.isNotBlank("   s"));
    }


    @Test
    public void testGetBeanById() {
        System.out.println(brandService.getBrandByKey(83));
    }

}
