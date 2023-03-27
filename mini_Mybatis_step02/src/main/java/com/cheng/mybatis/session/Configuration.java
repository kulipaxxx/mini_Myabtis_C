package com.cheng.mybatis.session;

import com.cheng.mybatis.binding.MapperRegister;
import com.cheng.mybatis.mapping.MappedStatement;
import com.cheng.mybatis.binding.MapperRegister;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date: 2023/3/27 20:33
 * @Description: 配置项
 * @Version 1.0
 */
public class Configuration {

    /**
     * 映射注册器
     */
    private MapperRegister mapperRegister = new MapperRegister(this);

    /**
     * 映射的语句，存在Map里
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();


    public void addMappers(String packageName) {
        mapperRegister.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegister.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegister.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegister.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

}
