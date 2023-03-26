package com.cheng.mybatis.session.defaults;

import com.cheng.mybatis.session.SqlSession;
import com.cheng.mybatis.session.binding.MapperRegister;

/**
 * @Description: DefaultSqlSession 默认sqlSession实现类
 * @Author cheng
 * @Date: 2023/3/26 21:51
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 映射器注射器
     */
    private MapperRegister mapperRegister;

    public DefaultSqlSession(MapperRegister mapperRegister) {
        this.mapperRegister = mapperRegister;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了:" + "方法:" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了：" + "方法:" + statement + "入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegister.getMapper(type, this);
    }
}
