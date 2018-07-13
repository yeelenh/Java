package com.yeelenh.manageservice.service;

import java.util.List;

import com.yeelenh.manageservice.mapper.ProductMapper;
import com.yeelenh.manageservice.pojo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 
 * @author yrr_2012/11/7
 *
 */
@Service
public class StockService {
    @Resource
    ProductMapper mapper;

	public List<Product> getAlarmProduct()
    {
		return mapper.getAlarmProducts();
	}

    public List<Product> getHotProductStockAlarm()
    {
        return mapper.getHotProductStockAlarm();
    }
}
