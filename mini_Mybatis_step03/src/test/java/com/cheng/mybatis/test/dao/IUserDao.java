package com.cheng.mybatis.test.dao;

import com.cheng.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
