package com.zjc.core.service;


import com.zjc.core.bean.TestTb;
import com.zjc.core.dao.TestTbDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTbServiceImpl implements TestTbService{
    @Autowired
    private TestTbDao testTbDao;

    @Transactional
    public void addTestTb(TestTb testTb) {
        testTbDao.addTestTb(testTb);
        throw new RuntimeException("something wrong");
    }
}
