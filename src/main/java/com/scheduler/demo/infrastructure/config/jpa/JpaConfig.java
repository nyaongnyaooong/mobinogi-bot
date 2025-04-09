package com.scheduler.demo.infrastructure.config.jpa;

import java.io.File;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JpaConfig {

    @Bean
    public DataSource dataSource() {
        File dbDir = new File("/app/docker/db");
        if (!dbDir.exists()) {
            dbDir.mkdirs();
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:/app/docker/db/scheduler.db");
        return dataSource;
    }
}
