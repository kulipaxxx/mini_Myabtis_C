package com.cheng.mybatis.transaction.jdbc;

import com.cheng.mybatis.session.TransactionIsolationLevel;
import com.cheng.mybatis.transaction.Transaction;
import com.cheng.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Author cheng
 * @Date: 2023/4/2 21:00
 * @Description: JdbcTransaction 工厂
 * @Version 1.0
 */
public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
