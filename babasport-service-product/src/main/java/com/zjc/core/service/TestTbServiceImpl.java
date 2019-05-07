package com.zjc.core.service;

import com.zjc.core.bean.TestTb;
import com.zjc.core.dao.TestTbDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试
 *
 * @author 22576
 */
@Service("testTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService {


    @Autowired
    private TestTbDao testTbDao;

    public void insertTestTb(TestTb testTb) {
        testTbDao.insertTestTb(testTb);
        //throw new RuntimeException();
    }

}

