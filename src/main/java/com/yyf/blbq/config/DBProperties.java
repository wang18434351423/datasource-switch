package com.yyf.blbq.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangchen
 * @create 2020/05/11/17:27
 */
@Data
@Component
@ConfigurationProperties(prefix = "hikari")
public class DBProperties {

    private HikariDataSource master;
    private HikariDataSource slave;

}
