package com.yeelenh.manageservice.mapper;

import com.yeelenh.manageservice.pojo.Cart;
import com.yeelenh.manageservice.pojo.Users;

import java.util.List;
import java.util.Map;

public interface CartMapper {

    int deleteByPrimaryKey(String cartid);
    int insert(Cart record);
    int insertSelective(Cart record);
    Cart selectByPrimaryKey(String cartid);
    int updateByPrimaryKeySelective(Cart record);
    int updateByPrimaryKey(Cart record);
    List<Cart> getCustomerCart(String customerid);
}