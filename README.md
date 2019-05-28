整合spring + Mybatis

整合Dubbo

   Dubbo相当于是中介，服务消费方连接Dubbo，Dubbo官方推荐注册中心使用zookeeper,通过Dubbo远程调用的实体类需要序列化
   
   本地测试时会设置为直连，也不检查服务

- Solr服务

Solr是基于Lucene的分布式搜索方案，通过在bin文件下执行 `Solr.cmd start`来启动服务，默认
在8983端口`http://localhost:8983/solr/#/`,通过`Solr.cmd stop -all`停止服务。

添加集合需要在server/solr文件夹下手动创建目录，然后将configsets中的conf文件夹复制到创建的目录下，在网页端
点击Add Core来初始化集合。

添加分词需要将ik-analyzer.jar放置到`\server\solr-webapp\webapp\WEB-INF\lib`目录中，修改需要添加分词功能的
集合的配置文件，在managed-schema文件中添加如下配置
```
  </fieldType>
  <fieldType name="text_ik" class="solr.TextField">
  <analyzer type="index">
      <tokenizer class="org.wltea.analyzer.lucene.IKTokenizerFactory" useSmart="false" conf="babasport.conf"/>
      <filter class="solr.LowerCaseFilterFactory"/>
  </analyzer>
  <analyzer type="query">
      <tokenizer class="org.wltea.analyzer.lucene.IKTokenizerFactory" useSmart="true" conf="babasport.conf"/>
      <filter class="solr.LowerCaseFilterFactory"/>
  </analyzer>
</fieldType>
...
  <field name="name_ik" type="text_ik" indexed="true" stored="true" />
```
其中conf属性是集合名，然后将需要分词的字段属性进行修改，即可。
   