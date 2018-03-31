package shuangxt.tao.mybatis_springboot_start.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shuangxt.tao.mybatis_springboot_start.model.ResponseResult;
import shuangxt.tao.mybatis_springboot_start.model.User;
import shuangxt.tao.mybatis_springboot_start.service.UserService;


/**
 * 
 * @author peter
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, path="/getUserByName")
	public ResponseResult getUserByName(HttpServletRequest request ) {
		String userName = request.getParameter("name");
		try {
			User user = userService.getUserByUserName(userName);
			return ResponseResult.succeed("200", "success", user);
		}catch(Exception ex) {
			logger.error(ex.getMessage());
			return ResponseResult.failed("500", "服务器出错");
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/addUser")
	public ResponseResult addUser() {
		try {
			User user = new User();
			user.setUserId("testUserId001");
			user.setUserName("张三");
			user.setAge(20);
			user.setSex("男");
			user.setEmail("zhangshan@126.com");
			user.setPassWord("root@123");
			user.setDescs("");
			userService.addUser(user);
			return ResponseResult.succeed("200", "success", null);
		}catch(Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return ResponseResult.failed("500", "服务器出错");
		}
	}
}
