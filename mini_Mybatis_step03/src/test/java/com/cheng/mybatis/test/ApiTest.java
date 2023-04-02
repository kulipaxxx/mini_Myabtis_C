package com.cheng.mybatis.test;


import com.alibaba.fastjson.JSON;
import com.cheng.mybatis.builder.xml.XMLConfigBuilder;
import com.cheng.mybatis.session.Configuration;
import com.cheng.mybatis.session.defaults.DefaultSqlSession;
import com.cheng.mybatis.test.dao.IUserDao;
import com.cheng.mybatis.io.Resources;
import com.cheng.mybatis.session.SqlSession;
import com.cheng.mybatis.session.SqlSessionFactory;
import com.cheng.mybatis.session.SqlSessionFactoryBuilder;
import com.cheng.mybatis.test.po.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * 单元测试
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    //@Test
    //public void test_SqlSessionFactory() throws IOException {
    //    // 1. 从SqlSessionFactory中获取SqlSession
    //    Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
    //    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    //    SqlSession sqlSession = sqlSessionFactory.openSession();
    //
    //    // 2. 获取映射器对象
    //    IUserDao userDao = sqlSession.getMapper(IUserDao.class);
    //    if(userDao == null)
    //        logger.info("userDao代理失败");
    //    // 3. 测试验证
    //    //String res = userDao.queryUserInfoById(1L);
    //    //logger.info("测试结果：{}", res);
    //}

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }

    @Test
    public void test_selectOne() throws IOException {
        // 解析 XML
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();

        // 获取 DefaultSqlSession
        SqlSession sqlSession = new DefaultSqlSession(configuration);

        // 执行查询：默认是一个集合参数
        Object[] req = {1L};
        Object res = sqlSession.selectOne("cn.bugstack.mybatis.test.dao.IUserDao.queryUserInfoById", req);
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }

}
