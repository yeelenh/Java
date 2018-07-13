package com.yeelenh.manageservice.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeelenh.manageservice.pojo.*;
import com.yeelenh.manageservice.service.ProductService;
import com.yeelenh.manageservice.service.PurchaseInfoService;

import com.yeelenh.manageservice.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SupplierController {

	@Resource
	SupplierService service;
	@Resource
	ProductService productService;

	// 查询所有供应商
	@RequestMapping(value="/selectAllSupplier.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse selectAllSupplier() {
		List<Supplier> supplier = service.getAllSupplier();
		if (supplier.size() > 0) {
			return JSONResponse.success(supplier);
		} else {
			return JSONResponse.error("failed");
		}

	}
/**
	// 新增供应商
	@RequestMapping(value="/addSupplier.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse AddSupplier(String addsup_json) {
		int i = 0;
		String flag = "";
		JSONObject jb = JSONObject.fromObject(addsup_json);
		Supplier supplier = new Supplier();
		supplier.setSupplierid(jb.optString("SupplierID"));
		supplier.setSuppliername(jb.optString("SupplierName"));
		supplier.setTelephone(jb.optString("Telephone"));
		supplier.setCompanyaddress(jb.optString("Companyaddress"));
		
		Supplier sup_check = service.getSupplierByName(supplier.getSuppliername());
		if (null != sup_check) {
			return  JSONResponse.error("已经存在");

		} else {
			 i = service.insertSupplier(supplier);
			if (i > 0) {
				return JSONResponse.success("success");

			} else {

				return JSONResponse.error("faild");
			}
		}


	}
*/
	//根据name查询供应商信息
	@RequestMapping(value="/getSupplierByName.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse getSupplierByName(String name) {
		Supplier supplier = service.getSupplierByName(name);
		if (supplier != null) {
			return JSONResponse.success(supplier);

		} else {
			return JSONResponse.error("faild");
		}

	}
/**
	// 更新供应商信息
	@RequestMapping(value="/updateSupplier.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse updateSupplier(String updatesup_json) {
		int i = 0;
		JSONObject jb = JSONObject.fromObject(updatesup_json);
		Supplier sup = new Supplier();
		sup.setSupplierid(jb.optString("SupplierID"));
		sup.setSuppliername(jb.optString("SupplierName"));
		sup.setTelephone(jb.optString("Telephone"));
		sup.setCompanyaddress(jb.optString("Companyaddress"));

		i = service.updateSupplier(sup);

		if (i > 0) {
			return JSONResponse.success("SUCCESS");
		}
		return JSONResponse.error("faild");
	}
*/
	// 删除供应商
	@RequestMapping(value="/deleteSupplier.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse deleteSupplier(String supplierid) {
		List<Product> product = productService.getProductBySupplierNameorID(supplierid);
		

		if (product.size() > 0 ) {
			return JSONResponse.error("已存在产品，不允许删除！");
		} else{ 
				int i = service.deleteSupplier(supplierid);
				if (i>0){
					return JSONResponse.success("SUCCESS");
			}else {
				return JSONResponse.error("faild");
			}
		}
	}
}
