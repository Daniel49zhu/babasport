package com.zjc.core.dao.product;

import com.zjc.core.bean.product.Brand;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface BrandDao {
    //List集合
    @Select("select id,name,description,img_url,sort,is_display from bbs_brand where is_display=1 order by id desc")
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
    @Select("<script>\tselect count(1)\n" +
            "\t\tfrom bbs_brand\n" +
            "\t\t<where>\n" +
            "\t\t\t<if test=\"isDisplay != null\">\n" +
            "\t\t\t\tis_display = #{isDisplay}\n" +
            "\t\t\t</if>\n" +
            "\t\t\t<if test=\"name != null\">\n" +
            "\t\t\t\tand name = #{name}\n" +
            "\t\t\t</if>\n" +
            "\t\t</where></script>")
    int getBrandCount(Brand brand);
}
