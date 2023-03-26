package com.cheng.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.cheng.mybatis.session.SqlSession;
import com.cheng.mybatis.session.binding.MapperRegister;
import com.cheng.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.cheng.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: ApiTest
 * @Author cheng
 * @Date: 2023/3/26 20:36
 * @Version 1.0
 */
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_mapper_proxy_factory(){
        //1.注册Mapper
        MapperRegister mapperRegister = new MapperRegister();
        mapperRegister.addMappers("com.cheng.mybatis.test.dao");

        //2.从注册工厂获取session
        DefaultSqlSessionFactory sessionFactory = new DefaultSqlSessionFactory(mapperRegister);
        SqlSession sqlSession = sessionFactory.openSession();

        //3.获取映射器对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);

        //4.测试验证
        Object o = mapper.queryUserInfo();

        logger.info("测试结果,{}", o);
    }


}
