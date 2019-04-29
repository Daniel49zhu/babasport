package com.zjc.product;

import com.zjc.core.service.product.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestBrandService {
    @Autowired
    private BrandService brandService;

    @Test
    public void testGet() {
        brandService.getBrandListWithPage(null);
    }
}
