package mybatis.binding;

import com.cheng.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: MapperProxy映射器代理类
 * @Author cheng
 * @Date: 2023/3/26 20:44
 * @Version 1.0
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final Long SerialVersionUID = 1L;

    SqlSession sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //排除调Object的方法
        if(Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this, args);
        }else {
            return sqlSession.selectOne(method.getName(), args);
        }
    }
}
