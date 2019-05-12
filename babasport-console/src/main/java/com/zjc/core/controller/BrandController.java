package com.zjc.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BrandController {
    //查询
    @RequestMapping(value = "/brand/list.do")
    public String list(String name, Integer isDisplay, Integer pageNo, Model model) {

        return "brand/list";
    }

    //去修改页面
    @RequestMapping(value = "/brand/toEdit.do")
    public String toEdit(Long id, Model model) {

        return "brand/edit";
    }

    @RequestMapping(value = "/brand/deletes.do")
    public String deletes(Long[] ids) {

        return "forward:/brand/list.do";
    }
}
