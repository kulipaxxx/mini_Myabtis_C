package com.cheng.mybatis.mapping;

/**
 * @Author cheng
 * @Date: 2023/3/27 20:41
 * @Description: SQL 指令类型枚举
 * @Version 1.0
 */
public enum SqlCommandType {

    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;
}
