package com.example.project.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //后台监控
    //spring-boot 内置了 servlet容器，没有web.xml 替代：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean StatViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要有人登录，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername", "admin");//key固定参数 loginUsername loginPassword
        initParameters.put("loginPassword", "123456");
        //允许谁能访问
        initParameters.put("allow", "");
        //禁止谁能访问
        initParameters.put("", "ip");
        bean.setInitParameters(initParameters);//设置初始化参数
        return bean;

    }

    //filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        HashMap<String, String> initParameters = new HashMap<>();
        //不统计
        initParameters.put("exclusion","*.js");

        bean.setInitParameters(initParameters);
        return bean;
    }

}
