package com.yeelenh.manageservice.service;

import java.util.List;

import com.yeelenh.manageservice.mapper.CustomerMapper;
import com.yeelenh.manageservice.pojo.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerService {

	@Resource
	CustomerMapper mapper;


	public List<Customer> selectAllCustomer(){
		return mapper.selectAllCustomer();
	}
	//添加新客户
	public String AddCustomer(Customer cus) {
		String flag = "";
		int i = mapper.insert(cus);
		if (i > 0) {
			flag = "success";
		} else {
			flag = "faild";
		}
		return flag;
	}

	//根据客户id删除客户
	public int deleteCustomer(String id){
		return mapper.deleteByPrimaryKey(Integer.parseInt(id));
	}
	//根据客户id更新客户信息
	public int updateCustomer(Customer cus){
		return mapper.updateByPrimaryKeySelective(cus);
	}
	//根据客户id或者名称查询用户
	public Customer getCustomerByNameOrId(String nameorid){

		return mapper.getCustomerByNameOrId(nameorid);
	}
}
