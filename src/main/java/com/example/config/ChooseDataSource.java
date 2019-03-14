package com.example.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
@Primary
public class ChooseDataSource extends AbstractRoutingDataSource{
	
	public static Map<String, List<String>> METHOD_TYPE_MAP = new HashMap<String, List<String>>();
	
	@Autowired
	@Qualifier("writeDatasource")
	private DataSource writeDatasource;
	
	
	@Autowired
	@Qualifier("readDatasource")
	private DataSource readDatasource;

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHandler.getDataSource();
	}
	
	@Override
	public void afterPropertiesSet() {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("writeDatasource", writeDatasource);
		targetDataSources.put("readDatasource", readDatasource);
		Object defaultTargetDataSource = writeDatasource;
		
		setDefaultTargetDataSource(defaultTargetDataSource);
		setTargetDataSources(targetDataSources);
		
		super.afterPropertiesSet();
	}
	
	public void setMethodType(Map<String, String> map) {
        for (String key : map.keySet()) {
            List<String> v = new ArrayList<String>();
            String[] types = map.get(key).split(",");
            for (String type : types) {
                if (!StringUtils.isEmpty(type)) {
                    v.add(type);
                }
            }
            METHOD_TYPE_MAP.put(key, v);
        }
    }
	
	
}
