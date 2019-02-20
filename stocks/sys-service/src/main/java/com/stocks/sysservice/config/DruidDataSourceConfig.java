package com.stocks.sysservice.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


/**
 * @Author: ChenYu
 * @Date: 2019/2/19 12:19
 * @Description: 实例化Druid Datasource
 */
@SpringBootConfiguration
public class DruidDataSourceConfig {
    @ConfigurationProperties(prefix = "spring.druid")
    @Bean
    public DruidDataSource dataSource(Filter statFilter){
        DruidDataSource dataSource = new DruidDataSource();
        // 添加慢日志功能Lists.newArrayList添加guava工具集
        dataSource.setProxyFilters(Lists.newArrayList(statFilter));
        return dataSource;
    }

    @Bean
    public Filter statFilter(){
        StatFilter filter = new StatFilter();
        //设置慢sql时间
        filter.setSlowSqlMillis(3000);
        filter.setLogSlowSql(true);
        filter.setMergeSql(true);
        return filter;
    }

    /**
     * 注册StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }
}
