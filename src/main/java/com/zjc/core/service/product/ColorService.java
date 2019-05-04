package com.zjc.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.product.Color;
import com.zjc.core.query.product.ColorQuery;

public interface ColorService {
    /**
     * 基本插入
     *
     * @return
     */
    Integer addColor(Color color);

    /**
     * 根据主键查询
     */
    Color getColorByKey(Integer id);

    /**
     * 根据主键批量查询
     */
    List<Color> getColorsByKeys(List<Integer> idList);

    /**
     * 根据主键删除
     *
     * @return
     */
    Integer deleteByKey(Integer id);

    /**
     * 根据主键批量删除
     *
     * @return
     */
    Integer deleteByKeys(List<Integer> idList);

    /**
     * 根据主键更新
     *
     * @return
     */
    Integer updateColorByKey(Color color);

    /**
     * 根据条件查询分页查询
     *
     * @param colorQuery 查询条件
     * @return
     */
    Pagination getColorListWithPage(ColorQuery colorQuery);

    /**
     * 根据条件查询
     *
     * @param colorQuery 查询条件
     * @return
     */
    List<Color> getColorList(ColorQuery colorQuery);
}
