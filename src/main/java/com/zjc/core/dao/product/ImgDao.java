package com.zjc.core.dao.product;

import com.zjc.core.bean.product.Img;
import com.zjc.core.query.product.ImgQuery;

import java.util.List;


public interface ImgDao {

    /**
     * 添加
     *
     * @param img
     */
    Integer addImg(Img img);

    /**
     * 根据主键查找
     */
    Img getImgByKey(Integer id);

    /**
     * 根据主键批量查找
     */
    List<Img> getImgsByKeys(List<Integer> idList);

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
    Integer updateImgByKey(Img img);

    /**
     * 分页查询
     *
     * @param imgQuery
     */
    List<Img> getImgListWithPage(ImgQuery imgQuery);

    /**
     * 集合查询
     *
     * @param imgQuery
     */
    List<Img> getImgList(ImgQuery imgQuery);

    /**
     * 总条数
     *
     * @param imgQuery
     */
    int getImgListCount(ImgQuery imgQuery);
}
