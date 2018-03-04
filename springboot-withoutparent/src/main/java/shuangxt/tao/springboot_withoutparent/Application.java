package shuangxt.tao.springboot_withoutparent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * @author peter
 * Hello world without parent
 * @description:
 *  1. 没有使用parent，而是使用dependencyManager方式，这种方式比较适合项目中有自己的parent模块)!
 *  2. 添加spring-boot-actuator依赖：可以对应用的健康指标进行监控
 *  3. 添加spring-boot-maven-plugin插件，可以使用spring-boot:run方式实现热加载
 *
 */
@SpringBootApplication
public class Application 
{
    public static void main( String[] args )
    {
    	//方式 1：直接调用表态方法启动
    	ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    	
    	//方式2：创建SpringApplication，可以调用setXXX方法设置不同参数实现灵活控制，然后调用run方法启动
    	/*SpringApplication app = new SpringApplication(Application.class);
    	app.setBannerMode(Mode.OFF);
    	app.run(args);*/
    	
        System.out.println( "Hello World--- SpringBoot server is running!" );
    }
}
