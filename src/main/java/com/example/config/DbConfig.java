package com.example.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DbConfig {

	@Bean(name = "writeDatasource")
	@ConfigurationProperties(prefix = "spring.wd")
	public DataSource writeDatasource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "readDatasource")
	@ConfigurationProperties(prefix = "spring.rd")
	public DataSource readDatasource() {
		return DataSourceBuilder.create().build();
	}
}
