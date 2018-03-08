package shuangxt.tao.springboot_mybatis.dao;


import shuangxt.tao.springboot_mybatis.model.User;

/**
 * 
 * @author peter
 *
 */
public interface UserMapper {

	User getUserByUserName(String userName);
	
	boolean addUser(User user);
}
