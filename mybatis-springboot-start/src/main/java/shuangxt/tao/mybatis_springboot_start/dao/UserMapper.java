package shuangxt.tao.mybatis_springboot_start.dao;

import org.apache.ibatis.annotations.Mapper;

import shuangxt.tao.mybatis_springboot_start.model.User;

/**
 * 
 * @author peter
 *
 */
@Mapper
public interface UserMapper {

	User getUserByUserName(String userName);
	
	boolean addUser(User user);
}
