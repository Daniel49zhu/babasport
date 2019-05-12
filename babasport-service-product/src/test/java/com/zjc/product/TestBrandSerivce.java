package com.zjc.product;


import cn.itcast.common.page.Pagination;
import com.zjc.core.service.product.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestBrandSerivce {
    @Autowired
    private BrandService brandService;

    @Test
    public void testGetPagination() {
        Pagination  page = brandService.selectPaginationByQuery(null,1,null);
        System.out.println(page.getPageView());
    }
}
