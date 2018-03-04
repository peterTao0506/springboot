package shuangxt.tao.springboot_withoutparent.web;

import java.util.Date;

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
		return "index -- " + new Date();
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello";
	}
}
