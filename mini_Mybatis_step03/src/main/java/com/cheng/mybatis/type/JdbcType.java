package com.cheng.mybatis.type;

import java.sql.Types;
import java.util.HashMap;

/**
 * @Author cheng
 * @Date: 2023/4/2 21:03
 * @Description: Jdbc的类型枚举
 * @Version 1.0
 */
public enum JdbcType {
    INTEGER(Types.INTEGER),
    FLOAT(Types.FLOAT),
    DOUBLE(Types.DOUBLE),
    DECIMAL(Types.DECIMAL),
    VARCHAR(Types.VARCHAR),
    TIMESTAMP(Types.TIMESTAMP);


    private final int TYPE_CODE;

    private static HashMap<Integer, JdbcType> codeMap = new HashMap<>();
    // 就将数字对应的枚举型放入 HashMap
    static {
        for (JdbcType type : JdbcType.values()) {
            codeMap.put(type.TYPE_CODE, type);
        }
    }
    JdbcType(int TYPE_CODE) {
        this.TYPE_CODE = TYPE_CODE;
    }
    
    public static JdbcType forCode(int code){
        return codeMap.get(code);
    }
}
