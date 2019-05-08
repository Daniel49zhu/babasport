package com.zjc.core.controller;

import com.zjc.core.bean.TestTb;
import com.zjc.core.service.TestTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author 22576
 */
@Controller
public class CenterController {
    @Autowired
    private TestTbService testTbService;
    //入口
    /**
     * ModelAndView  : 跳转视图+数据     不用
     * void  : 异步时 ajax
     * String  : 跳转视图      +  Model
     */
    @RequestMapping(value = "/test/index.do")
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value="/test/testDubbo.do")
    public String testDubbo() {
        TestTb  testTb = new TestTb();
        testTb.setName("Dubbo");
        testTb.setBirthday(new Date());
        testTbService.insertTestTb(testTb);
        return "index";
    }
}
