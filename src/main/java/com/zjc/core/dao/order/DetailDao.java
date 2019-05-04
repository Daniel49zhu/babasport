package com.zjc.core.dao.order;

import com.zjc.core.bean.order.Detail;
import com.zjc.core.query.order.DetailQuery;

import java.util.List;


public interface DetailDao {

    /**
     * 添加
     *
     * @param detail
     */
    Integer addDetail(Detail detail);

    /**
     * 根据主键查找
     */
    Detail getDetailByKey(Integer id);

    /**
     * 根据主键批量查找
     */
    List<Detail> getDetailsByKeys(List<Integer> idList);

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
    Integer updateDetailByKey(Detail detail);

    /**
     * 分页查询
     *
     * @param detailQuery
     */
    List<Detail> getDetailListWithPage(DetailQuery detailQuery);

    /**
     * 集合查询
     *
     * @param detailQuery
     */
    List<Detail> getDetailList(DetailQuery detailQuery);

    /**
     * 总条数
     *
     * @param detailQuery
     */
    int getDetailListCount(DetailQuery detailQuery);
}
