package shuangxt.tao.springboot_mybatis.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author peter
 *
 */
@Configuration
//开启事务管理器
@EnableTransactionManagement
public class MybatisConfig {
	//please refer to http://www.mybatis.org/spring/zh/
	
	@Bean
	public DataSource dataSource(@Value("${jdbc.driver}") String jdbcDriver,
			@Value("${jdbc.url}") String jdbcUrl,
			@Value("${jdbc.username}") String jdbcUsername,
			@Value("${jdbc.password}") String jdbcPassword) throws Exception {
		Properties properties = new Properties();
		properties.put("driverClassName", jdbcDriver);
		properties.put("url", jdbcUrl);
		properties.put("username", jdbcUsername);
		properties.put("password", jdbcPassword);
		//连接池其他参数配置
		properties.put("maxActive", 20);
		properties.put("maxIdle", 5);
		properties.put("testOnBorrow", "true");
		properties.put("testWhileIdle", "true");
		properties.put("testOnReturn", "true");
		properties.put("timeBetweenEvictionRunsMillis", 6000);
		properties.put("validationQuery", "select now()");
		DataSourceFactory dsFactory = new DataSourceFactory();
		DataSource ds = dsFactory.createDataSource(properties);
		return ds;
	}
	
	//配置事务管理器，在service方法上配置@Transactional注解，开启事务，可以指定事务管理器
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}

	@Bean
	public FactoryBean<SqlSessionFactory> sqlSessionFactory(DataSource source) {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(source);
		/**http://www.mybatis.org/spring/zh/mappers.html
		 * 1. 如果 UserMapper 有一个对应的 MyBatis 的 XML 映射器文件, 
		 * 如果 XML 文件在类路径的 位置和映射器类相同时, 
		 * 它会被 MapperFactoryBean 自动解析。 
		 * 2. 没有必要在 MyBatis 配置文 件 中 去 指 定 映 射 器 , 
		 * 除 非 映 射 器 的 XML 文 件 在 不 同 的 类 路 径 下 。 
		 * 可 以 参 考 SqlSessionFactoryBean 的 configLocation 属性(第三章)来获取更多信息。
		 */
		sqlSessionFactory.setConfigLocation(new ClassPathResource("config/mybatis.xml"));
		return sqlSessionFactory;
	}
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("shuangxt.tao.springboot_mybatis.dao");
		return mapperScannerConfigurer;
	}
}
