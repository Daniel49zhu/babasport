package com.zjc.product;

import com.zjc.core.bean.product.Product;
import com.zjc.core.bean.product.ProductQuery;
import com.zjc.core.dao.product.ProductDao;
import com.zjc.core.service.product.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestProductService {
    @Autowired
    private ProductDao productDao;

    @Test
    public void test() {
        ProductQuery productQuery = new ProductQuery();
        productQuery.createCriteria().andBrandIdEqualTo(4L);
        List<Product> products = productDao.selectByExample(productQuery);
        System.out.println(products);
    }
}
