package com.zjc.core.bean.country;

import java.io.Serializable;

public class Province implements Serializable {


    private static final long serialVersionUID = -8358395981739859499L;
    private Integer id;
    private String code;
    private String name;

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

    public String toString() {
        return "Province [id=" + id + ",code=" + code + ",name=" + name + "]";
    }
}
