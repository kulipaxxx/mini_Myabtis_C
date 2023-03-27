package com.cheng.mybatis.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @Description: 通过类加载器获得resource的辅助类 IO读取文件
 * @Author cheng
 * @Date: 2023/3/27 20:21
 * @Version 1.0
 */
public class Resources {

    //获取配置类转回Reader
    public static Reader getResourceAsReader(String resource) throws IOException {
        return new InputStreamReader(getResourceStream(resource));
    }

    //通过不同的加载去获得配置内容
    private static InputStream getResourceStream(String resource) throws IOException {
        ClassLoader[] classLoaders = getClassLoaders();
        for (ClassLoader classLoader : classLoaders) {
            InputStream inputStream = classLoader.getResourceAsStream(resource);
            if (null != inputStream) {
                return inputStream;
            }
        }
        throw new IOException("Cloud not find resource:" + resource);
    }

    //返回加载器
    private static ClassLoader[] getClassLoaders() {
        return new ClassLoader[]{
                ClassLoader.getSystemClassLoader(),
                Thread.currentThread().getContextClassLoader()
        };
    }

    /*
     * Loads a class
     *
     * @param className - the class to fetch
     * @return The loaded class
     * @throws ClassNotFoundException If the class cannot be found (duh!)
     */
    public static Class<?> classForName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }
}
