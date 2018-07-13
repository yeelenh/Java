package com.yeelenh.manageservice.service;

import java.util.List;

import com.yeelenh.manageservice.mapper.SupplierMapper;
import com.yeelenh.manageservice.pojo.Product;
import com.yeelenh.manageservice.pojo.Supplier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SupplierService {
	@Resource
	SupplierMapper mapper;
	@Resource
	ProductService productService;


	// 查询所有供应商
	public List<Supplier> getAllSupplier() {
		return mapper.getAllSupplier();
	}

	//更新供应商信息
	public int updateSupplier(Supplier sup) {
		return mapper.updateByPrimaryKeySelective(sup);
	}

    //新增供应商信息
    public int insertSupplier(Supplier sup) {
        return mapper.insert(sup);
    }

	// 删除供应商信息
	public int deleteSupplier(String supid) {
		List<Product> productList=productService.getProductBySupplierNameorID(supid);
		if(productList!=null&&productList.size()>0){
			return -1;
		}
		return mapper.deleteByPrimaryKey(supid);
	}

	//根据供应商名字查询供应商信息
	public Supplier getSupplierByName(String supname) {
		return mapper.getSupplierByName(supname);
	}


}
