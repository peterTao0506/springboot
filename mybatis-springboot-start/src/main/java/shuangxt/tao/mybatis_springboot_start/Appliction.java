package shuangxt.tao.mybatis_springboot_start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author peter
 * 
 * 使用Mybatis-Springboot-Start依赖来集成mybatis到spring boot
 * 官方文档：http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
 * 启用*Mapper bean有三种方式：1.Mapper接口加@Mapper注解(本例使用这种方式)
 *                           2.使用MapperScan注解，配置扫描接口包
 *                           3.使用MapperFactoryBean 
 * 加载mapper.xml文件有两种方式： 1. application.properties中配置mybatis.config-location
 *                             2. application.properties中配置mybatis.mapper-locations(本例使用这种方式)
 * 
 */
@SpringBootApplication
public class Appliction 
{
    public static void main( String[] args )
    {
    	SpringApplication application = new SpringApplication(Appliction.class);
    	application.run(args);
        System.out.println( "Mybatis SpringBoot Starter Server Startup!" );
    }
}
