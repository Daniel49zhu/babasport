package com.zjc.core.dao.product;

import com.zjc.core.bean.product.Color;
import com.zjc.core.query.product.ColorQuery;

import java.util.List;


public interface ColorDao {

    /**
     * 添加
     *
     * @param color
     */
    Integer addColor(Color color);

    /**
     * 根据主键查找
     */
    Color getColorByKey(Integer id);

    /**
     * 根据主键批量查找
     */
    List<Color> getColorsByKeys(List<Integer> idList);

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
    Integer updateColorByKey(Color color);

    /**
     * 分页查询
     *
     * @param colorQuery
     */
    List<Color> getColorListWithPage(ColorQuery colorQuery);

    /**
     * 集合查询
     *
     * @param colorQuery
     */
    List<Color> getColorList(ColorQuery colorQuery);

    /**
     * 总条数
     *
     * @param colorQuery
     */
    int getColorListCount(ColorQuery colorQuery);
}
