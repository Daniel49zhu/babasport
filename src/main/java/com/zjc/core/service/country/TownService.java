package com.zjc.core.service.country;


import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.country.Town;
import com.zjc.core.query.country.TownQuery;

import java.util.List;

interface TownService {
    /**
     * 基本插入
     *
     * @return
     */
    Integer addTown(Town town);

    /**
     * 根据主键查询
     */
    Town getTownByKey(Integer id);

    /**
     * 根据主键批量查询
     */
    List<Town> getTownsByKeys(List<Integer> idList);

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
    Integer updateTownByKey(Town town);

    /**
     * 根据条件查询分页查询
     *
     * @param townQuery 查询条件
     * @return
     */
    Pagination getTownListWithPage(TownQuery townQuery);

    /**
     * 根据条件查询
     *
     * @param townQuery 查询条件
     * @return
     */
    List<Town> getTownList(TownQuery townQuery);
}
