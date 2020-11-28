package com.udacity.jwdnd.course1.cloudstorage.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.course1.cloudstorage.models.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USERS WHERE username = #{username}")
	public User getUser(String username);
	
	@Insert("INSERT INTO USERS (username, password, salt, firstname, lastname) VALUES (#{username}, #{password}, #{salt}, #{firstname}, #{lastname})")
	@Options(useGeneratedKeys=true, keyProperty="userid")
	public int insert(User user);

}
