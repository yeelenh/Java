package com.yeelenh.manageservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yeelenh.manageservice.mapper.UsersMapper;
import com.yeelenh.manageservice.pojo.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersService {

	@Resource
	UsersMapper mapper;
	//根据用户名、密码查询客户
	public Users LoginByNameAndPwd(String name,String pwd){
		Users users=new Users();
		users.setUsername(name);
		users.setPasswordcode(pwd);
		return mapper.loginByNameAndPwd(users);
	}
	//查询所有销售人员
	public List<Users> getAllSalesMan(){
		return mapper.getAllSalesMan("1");
	}
	//查询所有用户
	public List<Users> getAllUsers(){
		return mapper.getAllUsers();
	}
	//根据用户name或id查询用户
	public List<Users> getUsersByNameOrId(String nameorid){
		return mapper.getUsersByNameOrId(nameorid);
	}
	//新增用户
	public int addUsers(Users users){
		return mapper.insert(users);
	}
	//根据用户id删除用户
	public int deleteUser(String userId){
		return mapper.deleteByPrimaryKey(userId);
	}
	//更新密码
	public int updatePassword(String userId,String password){
		Users users=new Users();
		users.setPasswordcode(password);
		users.setUserid(userId);
		return mapper.updateByPrimaryKeySelective(users);
	}
	//重置密码
	public int resetPassword(String userId){
		Users users=new Users();
		users.setPasswordcode("111111");
		users.setUserid(userId);
		return mapper.updateByPrimaryKeySelective(users);
	}
	public int updateUserInfo(int role,String userId){
		Users users=new Users();
		users.setUserid(userId);
		users.setUserauthority(role);
		return mapper.updateByPrimaryKeySelective(users);
	}
}
