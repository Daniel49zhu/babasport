package com.zjc.core.dao.product;

import com.zjc.core.bean.product.Brand;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface BrandDao {
    //List集合
    @Select("<script>select id , name ,description,img_url,sort,is_display\n" +
            "from bbs_brand\n" +
            "<where>\n" +
            "<if test=\"isDisplay != null\">\n" +
            "is_display = #{isDisplay}\n" +
            "</if>\n" +
            "<if test=\"name != null\">\n" +
            "and name like #{name}\n" +
            "</if>\n" +
            "</where>\n" +
            "order by id desc\n" +
            "limit #{startRow},#{pageSize}</script>")
    @Results(
            value = {
                    @Result(column = "img_url", property = "imgUrl", javaType = String.class, jdbcType = JdbcType.VARCHAR),
                    @Result(column = "is_display", property = "isDisplay", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
            }
    )
    List<Brand> getBrandListWithPage(Brand brand);


    //查询总记录数
    @Select("<script>select count(1)\n" +
            "from bbs_brand\n" +
            "<where>\n" +
            "<if test=\"isDisplay != null\">\n" +
            "is_display = #{isDisplay}\n" +
            "</if>\n" +
            "<if test=\"name != null\">\n" +
            "and name like #{name}\n" +
            "</if>\n" +
            "</where></script>")
    int getBrandCount(Brand brand);

    @Insert("<script>insert into bbs_brand\n" +
            "<trim prefix=\"(\" suffix=\")\">\n" +
            "name ,\n" +
            "description,\n" +
            "img_url,\n" +
            "sort,\n" +
            "is_display\n" +
            "</trim>\n" +
            "values\n" +
            "<trim prefix=\"(\" suffix=\")\">\n" +
            "#{name},\n" +
            "#{description},\n" +
            "#{imgUrl},\n" +
            "#{sort},\n" +
            "#{isDisplay}\n" +
            "</trim></script>")
    void addBrand(Brand brand);

    //删除
    @Delete("<script>delete from bbs_brand\n" +
            "<where>\n" +
            "id = #{id}\n" +
            "</where></script>")
    void deleteBrandByKey(Integer id);

    //删除 批量
    @Delete("<script>delete from bbs_brand\n" +
            "<where>\n" +
            "id in \n" +
            "<foreach collection=\"array\" item=\"id\" open=\"(\" close=\")\" separator=\",\" >\n" +
            "#{id}\n" +
            "</foreach>\n" +
            "</where></script>")
    void deleteBrandByKeys(Integer[] ids);//List<Integer>  ids

    //修改
    @Update("<script>update bbs_brand\n" +
            "<set>\n" +
            "<if test=\"name != null\">\n" +
            "name=#{name},\n" +
            "</if>\n" +
            "<if test=\"description != null\">\n" +
            "description=#{description},\n" +
            "</if>\n" +
            "<if test=\"imgUrl != null\">\n" +
            "img_url=#{imgUrl},\n" +
            "</if>\n" +
            "<if test=\"sort != null\">\n" +
            "sort=#{sort},\n" +
            "</if>\n" +
            "<if test=\"isDisplay != null\">\n" +
            "is_display=#{isDisplay}\n" +
            "</if>\n" +
            "</set>\n" +
            "<where>\n" +
            "id=#{id}\n" +
            "</where></script>")
    void updateBrandByKey(Brand brand);

    @Select("<script>select id , name ,description,img_url,sort,is_display\n" +
            "from bbs_brand\n" +
            "<where>\n" +
            "id = #{id}\n" +
            "</where></script>")
    @Results(
            value = {
                    @Result(column = "img_url", property = "imgUrl", javaType = String.class, jdbcType = JdbcType.VARCHAR),
                    @Result(column = "is_display", property = "isDisplay", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
            }
    )
    Brand getBrandByKey(Integer id);
}
