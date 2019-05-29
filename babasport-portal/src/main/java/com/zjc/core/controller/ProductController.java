package com.zjc.core.controller;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Brand;
import com.zjc.core.service.SearchService;
import com.zjc.core.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 前台商品
 * @author lx
 *
 */
@Controller
public class ProductController {
	@Autowired
	private BrandService brandService;
	//去首页  入口
	@RequestMapping(value = "/")
	public String index(){
		
		return "index";
	}

	@Autowired
	private SearchService searchService;
	//搜索
	@RequestMapping(value = "/search")
	public String search(Integer pageNo, String keyword, Model model) throws Exception{
		List<Brand> brands = brandService.selectBrandListFromRedis();
		System.out.println(brands);
		model.addAttribute("brands", brands);
		Pagination pagination = searchService.selectPaginationByQuery(pageNo,keyword);
		System.out.println(pagination.getList());
		model.addAttribute("pagination", pagination);
		return "search";
	}
}
