package com.yeelenh.manageservice.controller;

import java.util.List;

import javax.annotation.Resource;

import com.yeelenh.manageservice.pojo.JSONResponse;

import com.yeelenh.manageservice.pojo.Product;
import com.yeelenh.manageservice.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StockController {
	@Resource
	StockService stockService;

	@RequestMapping(value="/getAlarmProduct.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse getAlarmProduct(){
		List<Product> list=stockService.getAlarmProduct();
		return JSONResponse.success(list);
	}

	@RequestMapping(value="/getHotProductStockAlarm.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse getHotProductStockAlarm(){
		List<Product> list=stockService.getHotProductStockAlarm();
		return JSONResponse.success(list);
	}

}
