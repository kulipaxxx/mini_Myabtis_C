package com.cheng.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Description: MapperProxyFactory
 * @Author cheng
 * @Date: 2023/3/26 20:44
 * @Version 1.0
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, String> sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        //代理对象
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface},
                mapperProxy);
    }
}
