package com.cheng.mybatis.mapping;

import com.cheng.mybatis.session.Configuration;

import java.util.Map;

/**
 * @Author cheng
 * @Date: 2023/3/27 20:40
 * @Description: 映射语句类
 * @Version 1.0
 */
public class MappedStatement {

    private Configuration configuration;

    private String id;

    private SqlCommandType sqlCommandType;

    //入参
    private String parameterType;

    //结果类型
    private String resultType;

    private String sql;

    private Map<Integer, String> parameter;

    public MappedStatement(){
        //TODO 往后完善
    }

    /**
     * 建造者
     */
    public static class Builder{
        private MappedStatement mappedStatement = new MappedStatement();
        
        public Builder(Configuration configuration, String id, SqlCommandType sqlCommandType,
                       String parameterType, String resultType, String sql,
                       Map<Integer, String> parameter){
            mappedStatement.configuration = configuration;
            mappedStatement.id = id;
            mappedStatement.sqlCommandType = sqlCommandType;
            mappedStatement.parameterType = parameterType;
            mappedStatement.resultType = resultType;
            mappedStatement.sql = sql;
            mappedStatement.parameter = parameter;
        }
        
        public MappedStatement build(){
            assert mappedStatement.configuration != null;
            assert mappedStatement.id != null;
            return mappedStatement;
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    public void setSqlCommandType(SqlCommandType sqlCommandType) {
        this.sqlCommandType = sqlCommandType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Map<Integer, String> getParameter() {
        return parameter;
    }

    public void setParameter(Map<Integer, String> parameter) {
        this.parameter = parameter;
    }
}
