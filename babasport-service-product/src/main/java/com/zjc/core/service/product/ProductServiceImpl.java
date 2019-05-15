package com.zjc.core.service.product;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Color;
import com.zjc.core.bean.product.ColorQuery;
import com.zjc.core.bean.product.ProductQuery;
import com.zjc.core.dao.product.ColorDao;
import com.zjc.core.dao.product.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    //分页对象
    public Pagination selectPaginationByQuery(Integer pageNo, String name
            , Long brandId, Boolean isShow) {
        ProductQuery productQuery = new ProductQuery();
        productQuery.setPageNo(Pagination.cpn(pageNo));
        //排序
        productQuery.setOrderByClause("id desc");
        //productQuery.s
        ProductQuery.Criteria createCriteria = productQuery.createCriteria();
        StringBuilder params = new StringBuilder();
        if (null != name) {
            createCriteria.andNameLike("%" + name + "%");
            params.append("name=").append(name);
        }
        if (null != brandId) {
            createCriteria.andBrandIdEqualTo(brandId);
            params.append("&brandId=").append(brandId);
        }
        if (null != isShow) {
            createCriteria.andIsShowEqualTo(isShow);
            params.append("&isShow=").append(isShow);
        } else {
            createCriteria.andIsShowEqualTo(false);
            params.append("&isShow=").append(false);
        }

        Pagination pagination = new Pagination(
                productQuery.getPageNo(),
                productQuery.getPageSize(),
                productDao.countByExample(productQuery),
                productDao.selectByExample(productQuery)
        );
        String url = "/product/list.do";

        pagination.pageView(url, params.toString());

        return pagination;
    }

    //加载颜色
    @Autowired
    private ColorDao colorDao;

    //颜色结果集
    public List<Color> selectColorList() {
        ColorQuery colorQuery = new ColorQuery();
        colorQuery.createCriteria().andParentIdNotEqualTo(0L);
        return colorDao.selectByExample(colorQuery);
    }
}
