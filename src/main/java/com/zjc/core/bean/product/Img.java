package com.zjc.core.bean.product;

import java.io.Serializable;


public class Img implements Serializable {

    private static final long serialVersionUID = 6175558682526026675L;
    private Integer id;
    private Integer productId;
    private String url;
    private Integer isDef;

    //获取全Url
    public String getAllUrl() {
        return url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsDef() {
        return isDef;
    }

    public void setIsDef(Integer isDef) {
        this.isDef = isDef;
    }

    public String toString() {
        return "Img [id=" + id + ",productId=" + productId + ",url=" + url + ",isDef=" + isDef + "]";
    }
}
