package com.zjc.core.dao.product;

import com.zjc.core.bean.product.Type;
import com.zjc.core.query.product.TypeQuery;

import java.util.List;

public interface TypeDao {

    /**
     * 添加
     *
     * @param type
     */
    Integer addType(Type type);

    /**
     * 根据主键查找
     */
    Type getTypeByKey(Integer id);

    /**
     * 根据主键批量查找
     */
    List<Type> getTypesByKeys(List<Integer> idList);

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
    Integer updateTypeByKey(Type type);

    /**
     * 分页查询
     *
     * @param typeQuery
     */
    List<Type> getTypeListWithPage(TypeQuery typeQuery);

    /**
     * 集合查询
     *
     * @param typeQuery
     */
    List<Type> getTypeList(TypeQuery typeQuery);

    /**
     * 总条数
     *
     * @param typeQuery
     */
    int getTypeListCount(TypeQuery typeQuery);
}
