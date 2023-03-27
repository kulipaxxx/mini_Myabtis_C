package mybatis.session;

/**
 * @Description: SqlSessionFactory
 * @Author cheng sqlSession工厂类，对外提供服务
 * @Date: 2023/3/26 21:50
 * @Version 1.0
 */
public interface SqlSessionFactory {

    /**
     * 打开session
     *
     * @return SqlSession
     */
    SqlSession openSession();
}
