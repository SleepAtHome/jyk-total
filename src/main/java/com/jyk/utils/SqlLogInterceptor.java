package com.jyk.utils;


import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

/**
 * @author : Jing Yuankui
 * @description : MyBatis打印SQL语句
 * @date : Created in 2024/8/2 0:40
 */
public class SqlLogInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();

        if (args != null && args.length > 1) {
            MappedStatement mappedStatement = (MappedStatement) args[0];
            Object parameter = args[1];
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);

            String sql = boundSql.getSql();
            System.out.println("SQL语句：" + sql);
        }

        return invocation.proceed();
    }
}
