package shuangxt.tao.springboot_helloworld.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author peter
 *
 */
@RestController
@RequestMapping("/")
public class HelloWorldController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello";
	}
}
