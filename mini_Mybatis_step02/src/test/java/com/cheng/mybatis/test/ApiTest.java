package com.cheng.mybatis.test;


import com.cheng.mybatis.test.dao.IUserDao;
import com.cheng.mybatis.io.Resources;
import com.cheng.mybatis.session.SqlSession;
import com.cheng.mybatis.session.SqlSessionFactory;
import com.cheng.mybatis.session.SqlSessionFactoryBuilder;
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

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        if(userDao == null)
            logger.info("userDao代理失败");
        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);
    }

}
