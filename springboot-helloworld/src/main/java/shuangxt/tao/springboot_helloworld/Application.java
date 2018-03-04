package shuangxt.tao.springboot_helloworld;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world SpringBoot!
 * @author peter
 */
@SpringBootApplication
public class Application 
{
    public static void main( String[] args )
    {
    	//方式 1：直接调用表态方法启动
    	//ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    	
    	//方式2：创建SpringApplication，可以调用setXXX方法设置不同参数实现灵活控制，然后调用run方法启动
    	SpringApplication app = new SpringApplication(Application.class);
    	app.setBannerMode(Mode.OFF);
    	app.run(args);
    	
        System.out.println( "Hello World--- SpringBoot server is running!" );
    }
}
