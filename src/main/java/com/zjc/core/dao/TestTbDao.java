package com.zjc.core.dao;

import com.zjc.core.bean.TestTb;
import org.apache.ibatis.annotations.Insert;

public interface TestTbDao {
    @Insert("insert into test_tb (name,birthday) values (#{name},#{birthday})")
    void addTestTb(TestTb testTb);
}
