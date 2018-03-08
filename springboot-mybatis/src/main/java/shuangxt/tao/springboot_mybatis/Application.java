package shuangxt.tao.springboot_mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author peter
 *
 */
@SpringBootApplication
public class Application 
{
    public static void main( String[] args )
    {
    	SpringApplication application = new SpringApplication(Application.class);
    	application.run(args);
        System.out.println( "SpringBoot Startup!" );
    }
}
