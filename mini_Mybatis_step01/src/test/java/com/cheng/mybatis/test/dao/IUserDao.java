package com.cheng.mybatis.test.dao;

import java.util.List;

/**
 * @Description: IUserDao
 * @Author cheng
 * @Date: 2023/3/26 20:36
 * @Version 1.0
 */
public interface IUserDao {

    Object queryUserInfo();

    List<Object> queryUserInfoList();
}
