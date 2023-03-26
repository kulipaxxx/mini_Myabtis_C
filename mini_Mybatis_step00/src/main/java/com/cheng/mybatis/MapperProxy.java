package com.cheng.mybatis;

import org.apache.ibatis.javassist.SerialVersionUID;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: MapperProxy映射器代理类
 * @Author cheng
 * @Date: 2023/3/26 20:44
 * @Version 1.0
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final Long SerialVersionUID = 1L;

    Map<String, String> sqlSession = new HashMap<>();

    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //排除调Object的方法
        if(Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this, args);
        }else {
            return "你被代理了" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }
}
