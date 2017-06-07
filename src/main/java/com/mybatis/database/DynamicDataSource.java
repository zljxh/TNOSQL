package com.mybatis.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by user on 2017/6/7.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }
}
