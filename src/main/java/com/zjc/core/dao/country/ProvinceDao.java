package com.zjc.core.dao.country;

import com.zjc.core.bean.country.Province;
import com.zjc.core.query.country.ProvinceQuery;

import java.util.List;

 public interface ProvinceDao {

    /**
     * 添加
     *
     * @param province
     */
     Integer addProvince(Province province);

    /**
     * 根据主键查找
     */
     Province getProvinceByKey(Integer id);

    /**
     * 根据主键批量查找
     */
     List<Province> getProvincesByKeys(List<Integer> idList);

    /**
     * 根据主键删除
     */
     Integer deleteByKey(Integer id);

    /**
     * 根据主键批量删除
     */
     Integer deleteByKeys(List<Integer> idList);

    /**
     * 根据主键更新
     */
     Integer updateProvinceByKey(Province province);

    /**
     * 分页查询
     *
     * @param provinceQuery
     */
     List<Province> getProvinceListWithPage(ProvinceQuery provinceQuery);

    /**
     * 集合查询
     *
     * @param provinceQuery
     */
     List<Province> getProvinceList(ProvinceQuery provinceQuery);

    /**
     * 总条数
     *
     * @param provinceQuery
     */
     int getProvinceListCount(ProvinceQuery provinceQuery);
}
