package com.cheng.mybatis.session.defaults;

import com.cheng.mybatis.binding.MapperRegister;
import com.cheng.mybatis.session.Configuration;
import com.cheng.mybatis.session.SqlSession;
import com.cheng.mybatis.session.SqlSessionFactory;

/**
 * @Description: DefaultSqlSessionFactory 默认sqlSessionFactory工厂实现类
 * @Author cheng
 * @Date: 2023/3/26 21:53
 * @Version 1.0
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    /**
     * 映射器注册器
     */
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
