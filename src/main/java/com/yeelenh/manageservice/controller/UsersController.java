package com.yeelenh.manageservice.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeelenh.manageservice.pojo.JSONResponse;

import com.yeelenh.manageservice.pojo.Users;
import com.yeelenh.manageservice.service.UsersService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {
	Logger logger=Logger.getLogger("DeliveryController.class");

	@Resource
	UsersService usersService;


	//登录验证
	@RequestMapping(value="/loginByNameAndPwd.do",method= RequestMethod.POST)
	@ResponseBody
	public JSONResponse LoginByNameAndPwd(String user_json){
		logger.info("user_json:"+user_json);
		Users users=null;
		JSONObject jo=JSONObject.fromObject(user_json);
		logger.info("name:"+jo.optString("name")+"pwd:"+jo.optString("pwd"));
		users=usersService.LoginByNameAndPwd(jo.optString("name"), jo.optString("pwd"));
		if (users!=null) {
			return JSONResponse.success(users);
		}else {
			return JSONResponse.error("用户名或密码不正确");
		}
	}
	/**
	//新增用户
    @RequestMapping(value="/addUsers.do",method= RequestMethod.POST)
    @ResponseBody
	public JSONResponse addUsers(String userJson){
		JSONObject jo=JSONObject.fromObject(userJson);
        List<Users>  usersList=usersService.getUsersByNameOrId(jo.optString("userName"));
		if (usersList==null) {
            Users users=new Users();
			users.setUserid(jo.optString("userId"));
			users.setUsername(jo.optString("userName"));
			users.setPasswordcode(jo.optString("password"));
			users.setUserauthority(jo.optInt("roles"));
			if (usersService.addUsers(users)!=0) {
				return JSONResponse.success("success");
			}else {
				return JSONResponse.error("fail");
			}
		}else{
			return JSONResponse.error("用户名已存在");
		}
	}
*/
	/**
	//修改密码
    @RequestMapping(value="/updatePassword.do",method= RequestMethod.POST)
    @ResponseBody
	public JSONResponse updatePassword(String jsonString){
		JSONObject jo=JSONObject.fromObject(jsonString);
		if (usersService.updatePassword(jo.optString("userId"), jo.optString("pwd"))>0) {
			return JSONResponse.success("success");
		}else {
			return JSONResponse.error("fail");
		}
	}
	*/
	//重置密码
    @RequestMapping(value="/resetPassword.do",method= RequestMethod.POST)
    @ResponseBody
	public JSONResponse resetPassword(String userId){
		if (usersService.resetPassword(userId)>0) {
			return JSONResponse.success("success");
		}else {
			return JSONResponse.error("fail");
		}
	}
	/**
	//更新用户信息
    @RequestMapping(value="/updateUserInfo.do",method= RequestMethod.POST)
    @ResponseBody
	public JSONResponse updateUserInfo(String jsonString){
		JSONObject jo=JSONObject.fromObject(jsonString);
		if (usersService.updateUserInfo(jo.optInt("roles"), jo.optString("userId"))>0) {
			return JSONResponse.success("success");
		}else {
			return JSONResponse.error("fail");
		}
	}
	*/
}
