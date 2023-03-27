package com.cheng.mybatis.builder;

import com.cheng.mybatis.session.Configuration;

/**
 * @Description: BaseBuilder
 * @Author cheng
 * @Date: 2023/3/27 20:20
 * @Version 1.0
 */
public abstract class BaseBuilder {
    
    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
