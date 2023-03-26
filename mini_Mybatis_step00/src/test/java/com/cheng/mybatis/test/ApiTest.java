package com.cheng.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.cheng.mybatis.binding.MapperProxyFactory;
import com.cheng.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
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
        //代理IUserdao对象
        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);

        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.cheng.mybatis.test.dao.IUserDao.queryUserInfo", "模拟执行Mapper.xml中sql语句的操作");

        IUserDao userDao = mapperProxyFactory.newInstance(sqlSession);

        Object userInfo = userDao.queryUserInfo();

        logger.info("执行结果, {}", userInfo);
    }

    @Test
    public void test_proxy_class(){
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class},
                ((proxy, method, args) ->
                        "你被代理了"
                )
        );
        Object userInfo = userDao.queryUserInfo();
        logger.info("测试结果, {}", JSON.toJSONString(userInfo));
    }
}
