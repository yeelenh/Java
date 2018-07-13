package com.yeelenh.manageservice.controller;

import com.yeelenh.manageservice.pojo.Cart;
import com.yeelenh.manageservice.pojo.JSONResponse;
import com.yeelenh.manageservice.pojo.Users;
import com.yeelenh.manageservice.service.CartService;
import com.yeelenh.manageservice.service.UsersService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
public class CartController {
	@Resource
	CartService cartService;


	//新增用户
	@RequestMapping(value="/addCart.do",method= RequestMethod.POST)
	@ResponseBody
	public JSONResponse addCart(String cartJson){
		JSONArray jsonArray=JSONArray.fromObject(cartJson);
		List<Cart> list=JSONArray.toList(jsonArray,new Cart(),new JsonConfig());
		for(Cart cart:list){
			cartService.addCart(cart);
		}
		return JSONResponse.success(list);
	}

	/**
	//登录验证
	@RequestMapping(value="/loginByNameAndPwd.do",method= RequestMethod.POST)
	@ResponseBody
	public JSONResponse LoginByNameAndPwd(String user_json){
		Users users=null;
		JSONObject jo=JSONObject.fromObject(user_json);
		users=usersService.LoginByNameAndPwd(jo.optString("name"), jo.optString("pwd"));
		if (users!=null) {
			return JSONResponse.success(users);
		}else {
			return JSONResponse.error("用户名或密码不正确");
		}
	}
*/
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

	/*
	@RequestMapping(value = "/balanceCart.do",method = RequestMethod.GET)
	public ModelAndView getsChapterDetail(String customerid) throws IOException {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("balanceCart");
		List<Cart> listCart=cartService.getCustomerCart(customerid);
		modelAndView.getModel().put("listCart",listCart);
		return modelAndView;
	}*/
}
