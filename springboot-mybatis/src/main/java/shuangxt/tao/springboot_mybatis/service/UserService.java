package shuangxt.tao.springboot_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import shuangxt.tao.springboot_mybatis.dao.UserMapper;
import shuangxt.tao.springboot_mybatis.model.User;

/**
 * 
 * @author peter
 *
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUserByUserName(String userName) {
		return userMapper.getUserByUserName(userName);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addUser(User user) {
		userMapper.addUser(user);
		userMapper.addUser(user);
		return true;
	}
}
