package com.zjc.core.service.product;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.*;
import com.zjc.core.dao.product.ColorDao;
import com.zjc.core.dao.product.ProductDao;
import com.zjc.core.dao.product.SkuDao;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
    @Autowired
    private SkuDao skuDao;
    @Autowired
    private Jedis jedis;

    //颜色结果集
    public List<Color> selectColorList() {
        ColorQuery colorQuery = new ColorQuery();
        colorQuery.createCriteria().andParentIdNotEqualTo(0L);
        return colorDao.selectByExample(colorQuery);
    }


    @Override
    public void insertProduct(Product product) {
        //保存商品
        Long id = jedis.incr("pno");
        product.setId(id);
//		下架状态 后台程序写的
        product.setIsShow(false);
//		删除  后台程序写的不删除
        product.setIsDel(true);
        productDao.insertSelective(product);
        //返回ID
        //保存SKU
        String[] colors = product.getColors().split(",");
        String[] sizes = product.getSizes().split(",");
        //颜色
        for (String color : colors) {
            for (String size : sizes) {
                //保存SKU
                Sku sku = new Sku();
                //商品ＩＤ
                sku.setProductId(product.getId());
                //颜色
                sku.setColorId(Long.parseLong(color));
                //尺码
                sku.setSize(size);
                //市场价
                sku.setMarketPrice(999f);
                //售价
                sku.setPrice(666f);
                //运费
                sku.setDeliveFee(8f);
                //库存
                sku.setStock(0);
                //限制
                sku.setUpperLimit(200);
                //时间
                sku.setCreateTime(new Date());

                skuDao.insertSelective(sku);

            }
        }
    }

    @Autowired
    private HttpSolrClient httpSolrClient;


    @Override
    public void isShow(Long[] ids) {
        Product product = new Product();
        //上架
        product.setIsShow(true);
        for (Long id : ids) {
            product.setId(id);
            //商品状态的变更
            productDao.updateByPrimaryKeySelective(product);

            //TODO 保存商品信息到Solr服务器
            SolrInputDocument doc = new SolrInputDocument();
            //商品ID
            doc.setField("id", id);
            //商品名称  ik
            Product p = productDao.selectByPrimaryKey(id);
            doc.setField("name_ik", p.getName());
            //图片
            doc.setField("url", p.getImages()[0]);
            //价格 售价   select price from bbs_sku where product_id =442 order by price asc limit 0,1
            SkuQuery skuQuery = new SkuQuery();
            skuQuery.createCriteria().andProductIdEqualTo(id);
            skuQuery.setOrderByClause("price asc");
            skuQuery.setPageNo(1);
            skuQuery.setPageSize(1);
            skuQuery.setFields("price");
            List<Sku> skus = skuDao.selectByExample(skuQuery);
            doc.setField("price", skus.get(0).getPrice());
            //品牌ID Long
            doc.setField("brandId", p.getBrandId());
            //时间  可选
            try {
                httpSolrClient.add("babasport",doc);
                httpSolrClient.commit("babasport");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //TODO 静态化
        }
    }
}
