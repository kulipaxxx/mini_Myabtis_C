package com.cheng.mybatis.session;

import com.cheng.mybatis.builder.xml.XMLConfigBuilder;
import com.cheng.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @Author cheng
 * @Date: 2023/3/27 20:37
 * @Description: 构建sqlsessionfactory的工厂
 * @Version 1.0
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader){
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();
        return build(configuration);
    }

    public SqlSessionFactory build(Configuration configuration){
        return new DefaultSqlSessionFactory(configuration);
    }
}
