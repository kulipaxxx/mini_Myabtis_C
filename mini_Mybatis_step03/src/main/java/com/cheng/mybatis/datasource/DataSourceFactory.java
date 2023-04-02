package com.cheng.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author cheng
 * @Date: 2023/4/2 21:22
 * @Description: 数据源工厂
 * @Version 1.0
 */
public interface DataSourceFactory {
    
    void setProperties(Properties props);
    
    DataSource getDataSource();
}
