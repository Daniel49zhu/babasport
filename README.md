商品列表页优化
1. Lucence+Solr
2. 对页面进行缓存(OSCached)
3. 分布式缓存
4. 高并发

商品详情页
1. 静态化Freemarker

配置两个spring mvc
- springmvc-front.xml
*.shtml(用户)
- springmvc-back.xml
*.do（商家）

web.xml中配置字符集处理乱码

配置日期格式转换
- 局部 在controller中添加
```
@InitBinder
public void initBinder(WebDataBinder binder, WebRequest request) {
    //转换日期格式
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
}
```
- 全局 在springmvc的配置文件中
```
<bean class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
    <property name="webBindingInitializer">
        <bean class="com.zjc.core.web.CustomDateEdtor"/>
    </property>
</bean>
```
定义的转换器和局部一样

上传图片
在[springmvc-back.xml](src/main/resources/springmvc-back.xml)中配置多文件解析器

搭建一个Jersy服务器
