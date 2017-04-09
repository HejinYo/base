package com.hejinyo.core.common.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;

/**
 * 
 * @author Administrator 访问数据库类
 */
@Component
public class DBAccess {

	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库来连接信息
		Reader reader = Resources.getResourceAsReader("properties/database.properties");
		//通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//通过SqlSessionFactory打开一个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
