package com.zjc.core.service;

import cn.itcast.common.page.Pagination;

public interface SearchService {

    //全文检索
    //全文检索
    Pagination selectPaginationByQuery(Integer pageNo, String keyword) throws Exception;
}
