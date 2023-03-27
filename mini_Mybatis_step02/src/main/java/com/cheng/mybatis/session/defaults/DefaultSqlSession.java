package com.cheng.mybatis.session.defaults;

import com.cheng.mybatis.mapping.MappedStatement;
import com.cheng.mybatis.session.Configuration;
import com.cheng.mybatis.session.SqlSession;

/**
 * @Description: DefaultSqlSession 默认sqlSession实现类
 * @Author cheng
 * @Date: 2023/3/26 21:51
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 配置项
     */
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
