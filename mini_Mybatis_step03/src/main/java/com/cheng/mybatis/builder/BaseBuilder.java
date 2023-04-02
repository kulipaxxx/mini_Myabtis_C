package com.cheng.mybatis.builder;

import com.cheng.mybatis.session.Configuration;
import com.cheng.mybatis.type.TypeAliasRegistry;

/**
 * @Description: 构造器的基类，建造者模式
 * @Author cheng
 * @Date: 2023/3/27 20:20
 * @Version 1.0
 */
public abstract class BaseBuilder {
    
    protected final Configuration configuration;
    
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
