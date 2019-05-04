package com.zjc.core.service.country;


import cn.itcast.common.page.Pagination;
import com.zjc.core.bean.country.Province;
import com.zjc.core.dao.country.ProvinceDao;
import com.zjc.core.query.country.ProvinceQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceDao provinceDao;

    /**
     * 插入数据库
     *
     * @return
     */
    public Integer addProvince(Province province) {
        return provinceDao.addProvince(province);
    }

    /**
     * 根据主键查找
     */
    @Transactional(readOnly = true)
    public Province getProvinceByKey(Integer id) {
        return provinceDao.getProvinceByKey(id);
    }

    @Transactional(readOnly = true)
    public List<Province> getProvincesByKeys(List<Integer> idList) {
        return provinceDao.getProvincesByKeys(idList);
    }

    /**
     * 根据主键删除
     *
     * @return
     */
    public Integer deleteByKey(Integer id) {
        return provinceDao.deleteByKey(id);
    }

    public Integer deleteByKeys(List<Integer> idList) {
        return provinceDao.deleteByKeys(idList);
    }

    /**
     * 根据主键更新
     *
     * @return
     */
    public Integer updateProvinceByKey(Province province) {
        return provinceDao.updateProvinceByKey(province);
    }

    @Transactional(readOnly = true)
    public Pagination getProvinceListWithPage(ProvinceQuery provinceQuery) {
        Pagination p = new Pagination(provinceQuery.getPageNo(), provinceQuery.getPageSize(), provinceDao.getProvinceListCount(provinceQuery));
        p.setList(provinceDao.getProvinceListWithPage(provinceQuery));
        return p;
    }

    @Transactional(readOnly = true)
    public List<Province> getProvinceList(ProvinceQuery provinceQuery) {
        return provinceDao.getProvinceList(provinceQuery);
    }
}
