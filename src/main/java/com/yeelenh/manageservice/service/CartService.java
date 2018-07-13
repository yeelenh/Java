package com.yeelenh.manageservice.service;

import com.yeelenh.manageservice.mapper.CartMapper;
import com.yeelenh.manageservice.mapper.UsersMapper;
import com.yeelenh.manageservice.pojo.Cart;
import com.yeelenh.manageservice.pojo.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

	@Resource
	CartMapper mapper;
	//根据用户名、密码查询客户
	public int addCart(Cart cart){
		return mapper.insertSelective(cart);
	}
	//根据用户id删除用户
	public int deleteCart(String cartId){
		return mapper.deleteByPrimaryKey(cartId);
	}

	public int updateCartInfo(Cart cart){
		return mapper.updateByPrimaryKeySelective(cart);
	}

	public List<Cart> getCustomerCart(String customerid){
		return mapper.getCustomerCart(customerid);
	}
}
