package com.zjc.core.dao.product;

import java.util.List;

import com.zjc.core.bean.product.Feature;
import com.zjc.core.query.product.FeatureQuery;

public interface FeatureDao {

    /**
     * 添加
     *
     * @param feature
     */
    Integer addFeature(Feature feature);

    /**
     * 根据主键查找
     */
    Feature getFeatureByKey(Integer id);

    /**
     * 根据主键批量查找
     */
    List<Feature> getFeaturesByKeys(List<Integer> idList);

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
    Integer updateFeatureByKey(Feature feature);

    /**
     * 分页查询
     *
     * @param featureQuery
     */
    List<Feature> getFeatureListWithPage(FeatureQuery featureQuery);

    /**
     * 集合查询
     *
     * @param featureQuery
     */
    List<Feature> getFeatureList(FeatureQuery featureQuery);

    /**
     * 总条数
     *
     * @param featureQuery
     */
    int getFeatureListCount(FeatureQuery featureQuery);
}
