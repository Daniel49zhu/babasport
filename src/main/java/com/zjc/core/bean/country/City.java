package com.zjc.core.bean.country;

import java.io.Serializable;

public class City implements Serializable {

    private static final long serialVersionUID = -8161815726984591480L;
    private Integer id;
    private String code;
    private String name;
    private String province;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String toString() {
        return "City [id=" + id + ",code=" + code + ",name=" + name + ",province=" + province + "]";
    }
}
