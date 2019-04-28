package com.zjc;

import com.zjc.core.bean.TestTb;
import com.zjc.core.service.TestTbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestTestTb {
    @Autowired
    private TestTbService testTbService;

    @Test
    public void testAdd() throws Exception {
        TestTb testTb = new TestTb();
        testTb.setName("刘德华");

        testTbService.addTestTb(testTb);
    }
}
