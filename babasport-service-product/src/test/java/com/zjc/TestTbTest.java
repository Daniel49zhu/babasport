package com.zjc;

import com.zjc.core.bean.TestTb;
import com.zjc.core.service.TestTbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestTbTest {

    @Autowired
    private TestTbService testTbService;

    @Test
    public void testAdd() throws Exception {
        TestTb testTb = new TestTb();
        testTb.setName("史蒂夫");
        testTb.setBirthday(new Date());

        testTbService.insertTestTb(testTb);
    }
}
