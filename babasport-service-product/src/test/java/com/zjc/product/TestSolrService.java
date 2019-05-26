package com.zjc.product;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestSolrService {
    // solr url
    private final static String BASE_URL = "http://localhost:8983/solr";

    /**
     * 获取SolrClient
     * solrj 6.5及以后版本获取方式
     * @return
     */
    public static HttpSolrClient getSolrClient(){
        /*
         * 设置超时时间
         * .withConnectionTimeout(10000)
         * .withSocketTimeout(60000)
         */
        return new HttpSolrClient.Builder(BASE_URL)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
    }

    @Test
    public void testQuery() throws IOException, SolrServerException {
        HttpSolrClient solrClient = getSolrClient();
        // 定义查询条件
        Map<String, String> params = new HashMap<>();
        params.put("q", "*:*");
        SolrParams mapSolrParams = new MapSolrParams(params);
        //执行查询 第一个参数是collection，就是我们在solr中创建的core
        QueryResponse response = solrClient.query("babasport", mapSolrParams);
        // 获取结果集
        SolrDocumentList results = response.getResults();
        for (SolrDocument result : results) {
            // SolrDocument 数据结构为Map
            System.out.println(result);
        }
    }

    @Test
    public void testAdd() throws IOException, SolrServerException {
        HttpSolrClient solrClient = getSolrClient();
        // 定义数据 solr输入文档 数据结构为Map
        SolrInputDocument inputDocument = new SolrInputDocument();
        inputDocument.addField("id","123");
        inputDocument.addField("name", "金城武");
        // 执行添加 ps：如果id相同，则执行更新操作
        // 要指定操作的collection 就是solr-home下定义的core
        UpdateResponse add = solrClient.add("babasport", inputDocument);
        //提交添加/更新
        solrClient.commit("babasport");
    }

    @Test
    public void testDelete() throws IOException, SolrServerException {
        HttpSolrClient solrClient = getSolrClient();
        // 通过id删除 执行要删除的collection（core）
        solrClient.deleteById("babasport", "123");
        // 还可以通过查询条件删除
        // solrClient.deleteByQuery("babasport", "查询条件");
        // 提交删除
        solrClient.commit("babasport");
    }
}
