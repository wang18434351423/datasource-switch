package com.yyf.blbq.config;

import com.yyf.blbq.dynamic.DynamicDataSource;
import com.yyf.blbq.util.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * hikari多数据源配置
 * @author wangchen
 * @create 2020/05/11/15:24
 */
@Configuration
public class DatasourceConfig {

    @Autowired
    private DBProperties properties;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        //按照目标数据源名称和目标数据源对象的映射存放在Map中
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER.name(), properties.getMaster());
        targetDataSources.put(DataSourceType.SLAVE.name(), properties.getSlave());
        //采用是想AbstractRoutingDataSource的对象包装多数据源
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);
        //设置默认的数据源，当拿不到数据源时，使用此配置
        dataSource.setDefaultTargetDataSource(properties.getMaster());
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
