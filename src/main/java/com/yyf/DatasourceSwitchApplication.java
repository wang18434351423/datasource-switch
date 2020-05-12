package com.yyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DatasourceSwitchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasourceSwitchApplication.class, args);
    }

}
