package util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	private static SqlSessionFactory sqlSeesionFactory;
	
	static {
		try {
			String resource="resource/mybatis-config.xml";
			InputStream inputStream=Resources.getResourceAsStream(resource);
			//SqlSessionFactoryBuilder 생성
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			//SqlSessionFactory 생성
			sqlSeesionFactory=sqlSessionFactoryBuilder.build(inputStream);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSeesionFactory;
	}
}
