# 手撸Mybatis

github：https://github.com/kulipaxxx/mini_Myabtis_C/tree/master

## 基础框架搭建

### 创建简单的映射器代理工厂

![图 2-1 代理类设计](https://bugstack.cn/images/article/spring/mybatis-220327-01.png)

使用MapperProxyFacotry工厂模式，提供对外服务，避免每次都需要new instance()创建代理对象。

MapperProxy实现InvocationHandler接口，重写invoke类，代理时会执行此方法。

目标：

1、了解ORM框架大体执行过程

2、实现简单的映射器代理工厂

Task:

通过jdk动态代理的方式，将生成代理对象。 实现类图：

Action:

1、MapperProxy实现InvocationHandler接口的invoke方法，该方法用于实际调用的包装逻辑。

2、MapperProxyFactory 是MapperProxy 的包装，对外提供实列化操作。

3、SqlSession对象是Map对象存放，接口名称+方法名作为唯一key

Result:

1、通过映射器代理工厂生成代理对象

2、了解泛化orm框架大体执行过程



### 实现映射器的注册和使用

![图 3-1 映射器的注册和使用](https://bugstack.cn/images/article/spring/mybatis-220404-01.png)

1.新建MapperRegistry类，其中包含了一个Mapper集合（一群映射代理器），其中有getMapper方法，addMapper方法，addMappers方法（通过扫描包，添加所有映射代理器），hasMapper方法（判断是否已经注册过）。

2.新建SqlSession接口，定义用来执行SQL，获取映射器，管理事务。

3.新建SqlSessionFactory接口，对外部提供sqlsession服务。

3.对接口进行实现，实现其具体规则定义，Factory返回一个对应映射器的SQLsession。

### Mapper xml的解析和使用

