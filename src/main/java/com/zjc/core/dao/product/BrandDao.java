package com.zjc.core.dao.product;

import com.zjc.core.bean.product.Brand;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
                    @Result(column = "id", property = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
                    @Result(column = "name", property = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
                    @Result(column = "description", property = "description", javaType = String.class, jdbcType = JdbcType.VARCHAR),
                    @Result(column = "img_url", property = "imgUrl", javaType = String.class, jdbcType = JdbcType.VARCHAR),
                    @Result(column = "sort", property = "sort", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
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
}
