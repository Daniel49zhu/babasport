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
@RequestMapping(value="/control")
public class CenterController {
    @Autowired
    private TestTbService testTbService;
    //入口
    /**
     * ModelAndView  : 跳转视图+数据     不用
     * void  : 异步时 ajax
     * String  : 跳转视图      +  Model
     */
    @RequestMapping(value = "/index.do")
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value="/testDubbo.do")
    public String testDubbo() {
        TestTb  testTb = new TestTb();
        testTb.setName("Dubbo");
        testTb.setBirthday(new Date());
        testTbService.insertTestTb(testTb);
        return "index";
    }


    //头
    @RequestMapping(value = "/top.do")
    public String top(Model model){

        return "top";
    }
    //身体
    @RequestMapping(value = "/main.do")
    public String main(Model model){

        return "main";
    }
    //身体--左
    @RequestMapping(value = "/left.do")
    public String left(Model model){

        return "left";
    }
    //身体-右
    @RequestMapping(value = "/right.do")
    public String right(Model model){

        return "right";
    }
    //商品身体-
    @RequestMapping(value = "/frame/product_main.do")
    public String product_main(Model model){

        return "frame/product_main";
    }
    @RequestMapping(value = "/frame/product_left.do")
    public String product_left(Model model){

        return "frame/product_left";
    }
}
