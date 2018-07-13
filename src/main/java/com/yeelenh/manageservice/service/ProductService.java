package com.yeelenh.manageservice.service;

import java.util.List;

import com.yeelenh.manageservice.mapper.ProductMapper;
import com.yeelenh.manageservice.pojo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductService {

	@Resource
	ProductMapper mapper;

	//查询所有产品
	public List<Product> getAllProduct() {
		return mapper.selectAllPorduct();
	}

	public String AddProiduct(Product pro) {
		String flag = "";
		List<Product> pro_check = mapper.getProductByNameOrId(pro.getProductname());
		if (null != pro_check&&pro_check.size()>0) {
			flag = "doublename";
		} else {
			int i = mapper.insertSelective(pro);
			if (i > 0) {
				flag = "success";
			} else {
				flag = "faild";
			}
		}
		return flag;
	}

	// 修改产品信息
	public int UpdateProduct(Product pro) {
		return mapper.updateByPrimaryKeySelective(pro);
	}

	//删除产品
	public int DeleteProduct(String proid) {

		return mapper.deleteByPrimaryKey(proid);
	}

	// 根据品牌名称或id查询产品
	public List<Product> getProductBySupplierNameorID(String nameid) {
		return mapper.selectAllPorductBySupplierIdOrName(nameid);
	}

	//根据产品名称或id查询产品
	public List<Product> getProductByNameOrId(String proname) {
		return mapper.getProductByNameOrId(proname);
	}
	//根据产id查询产品
	public Product getProductById(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	//根据产name查询产品
	public Product getProductByName(String name) {
		return mapper.getProductByName(name);
	}
}
