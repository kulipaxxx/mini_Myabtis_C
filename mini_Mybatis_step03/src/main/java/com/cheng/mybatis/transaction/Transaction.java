package com.cheng.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author cheng
 * @Date: 2023/4/2 20:46
 * @Description: 事务接口
 * @Version 1.0
 */
public interface Transaction {

    /**
     * 获取连接
     */
    Connection getConnect() throws SQLException;

    /**
     * 提交事务
     */
    void commit() throws SQLException;

    /**
     * 回滚事务
     */
    void rollback() throws SQLException;

    /**
     * 关闭事务
     */
    void close() throws SQLException;
}
