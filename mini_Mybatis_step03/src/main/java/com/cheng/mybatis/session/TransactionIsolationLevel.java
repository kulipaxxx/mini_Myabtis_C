package com.cheng.mybatis.session;

import java.sql.Connection;

/**
 * @Author cheng
 * @Date: 2023/4/2 20:53
 * @Description: 事务的隔离级别
 * @Version 1.0
 */
public enum TransactionIsolationLevel {
    
    //Jdbc支持的5个事务级别
    NONE(Connection.TRANSACTION_NONE),
    READ_COMMIT(Connection.TRANSACTION_READ_COMMITTED),
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);
    
    
    private final int level;
    
    TransactionIsolationLevel(int level){
        this.level = level;
    }
    
    public int getLevel(){
        return this.level;
    }
}
