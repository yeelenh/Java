package com.yeelenh.manageservice.controller;

import java.util.List;

import javax.annotation.Resource;

import com.yeelenh.manageservice.pojo.JSONResponse;

import com.yeelenh.manageservice.pojo.Customer;
import com.yeelenh.manageservice.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
	@Resource
	CustomerService customerService;
	@RequestMapping(value="/sayHello.do",method = RequestMethod.GET)
	@ResponseBody
	public JSONResponse sayHello(){
		return JSONResponse.success("hello");
	}




    @RequestMapping(value="/selectAllCustomer.do",method = RequestMethod.GET)
	@ResponseBody
	public JSONResponse SelectAllCustomer() {
		List<Customer> customer = customerService.selectAllCustomer();
		return JSONResponse.success(customer);
	}

	// 更新客户信息
/**
	@RequestMapping(value="/upateCustomer.do",method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse upateCustomer(String updatecus_json) {
		JSONObject jb = JSONObject.fromObject(updatecus_json);
		Customer cus = new Customer();
		cus.setCustomername(jb.optString("customername"));
		cus.setCustomerid(jb.optInt("customerid"));
		cus.setTelephone(jb.optString("telephone"));
		cus.setCutomeraddress(jb.optString("customeraddress"));
		int i = customerService.updateCustomer(cus);
		if (i > 0) {
			return JSONResponse.success(i);
		}
		return JSONResponse.error("更新失败！");
	}
*/
	// 删除客户信息
	// 更新客户信息

	@RequestMapping(value="/deleteCustomer.do",method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse deleteCustomer(String cusid) {

			int i = customerService.deleteCustomer(cusid);
			if (i > 0) {
				return JSONResponse.success(i);
			} else {
				return JSONResponse.error("删除失败！");
			}
	}

	// 新增客户
/**
	@RequestMapping(value="/addCustomer.do",method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse AddCustomer(String addcus_json) {
		JSONObject jb = JSONObject.fromObject(addcus_json);
		Customer cus = new Customer();
		cus.setCustomername(jb.optString("customername"));
		cus.setTelephone(jb.optString("telephone"));
		cus.setCutomeraddress(jb.optString("customeraddress"));
		cus.setCustomerid(jb.optInt("customerid"));
		return JSONResponse.success(customerService.AddCustomer(cus));
	}
*/
	//根据id或name查询客户信息
	@RequestMapping(value="/getCustomerByNameOrId.do",method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse getCustomerByNameOrId(String nameorid) {
		Customer cus = customerService.getCustomerByNameOrId(nameorid);
		if (cus != null) {
			return JSONResponse.success(cus);
		} else {
			return JSONResponse.error("查询客户信息失败！");
		}
	}
}
