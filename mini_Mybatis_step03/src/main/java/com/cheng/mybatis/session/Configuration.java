package com.cheng.mybatis.session;

import com.cheng.mybatis.binding.MapperRegister;
import com.cheng.mybatis.datasource.druid.DruidDataSourceFactory;
import com.cheng.mybatis.mapping.Environment;
import com.cheng.mybatis.mapping.MappedStatement;
import com.cheng.mybatis.transaction.jdbc.JdbcTransaction;
import com.cheng.mybatis.transaction.jdbc.JdbcTransactionFactory;
import com.cheng.mybatis.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date: 2023/3/27 20:33
 * @Description: 配置项
 * @Version 1.0
 */
public class Configuration {


    //环境
    protected Environment environment;

    // 映射注册机
    protected MapperRegister mapperRegistry = new MapperRegister(this);

    // 映射的语句，存在Map里
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
