package com.yeelenh.manageservice.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeelenh.manageservice.pojo.*;
import com.yeelenh.manageservice.service.DeliveryInfoService;
import com.yeelenh.manageservice.service.ProductService;
import com.yeelenh.manageservice.service.PurchaseInfoService;

import com.yeelenh.manageservice.service.ProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

	@Resource
	ProductService service;
	@Resource
	PurchaseInfoService purchaseInfoService;
	@Resource
	DeliveryInfoService deliveryInfoService;

	// 查询所有产品
	@RequestMapping(value="/selectAllProduct.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse SelectAllProduct(String keyword) {
		List<Product> productlist=null;
		if(StringUtils.isEmpty(keyword)){
			productlist = service.getAllProduct();
		}else{
			keyword='%'+keyword+'%';
			productlist=service.getProductByNameOrId(keyword);
		}
		if (productlist.size() > 0) {
			return JSONResponse.success(productlist);
		} else {
			return JSONResponse.error("查询失败！");
		}
	}
	// 根据name或id查询产品
	@RequestMapping(value="/getProductByNameorID.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse getProductByNameorID(String nameid) {
		List<Product> product = service.getProductByNameOrId(nameid);
		if (product.size()>0) {
			return JSONResponse.success(product);
		} else {
			return JSONResponse.error("faild");
		}
	}

	// 新增产品

	/**
	@RequestMapping(value="/addProiduct.do",method= RequestMethod.GET)
	@ResponseBody
	public String AddProiduct(String addpro_json) {
		JSONObject jb = JSONObject.fromObject(addpro_json);
		Product pro = new Product();
		pro.setProductid(jb.optString("ProductID"));
		pro.setProductname(jb.optString("ProductName"));
		pro.setSupplierid(jb.optString("SupplierID"));
		pro.setMaxsafestock(jb.optInt("MaxSafeStock"));
		pro.setMinsafestock(jb.optInt("MinSafeStock"));

		return service.AddProiduct(pro);
	}
*/
	// 更新产品
	/**
	@RequestMapping(value="/updateProduct.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse UpdateProduct(String UpdatePro_json) {
		JSONObject jb = JSONObject.fromObject(UpdatePro_json);
		Product pro = new Product();
		pro.setProductname(jb.optString("ProductName"));
		pro.setSupplierid(jb.optString("SupplierID"));
		pro.setMaxsafestock(jb.optInt("MaxSafeStock"));
		pro.setMinsafestock(jb.optInt("MinSafeStock"));
		pro.setProductid(jb.optString("ProductID"));
		int i = service.UpdateProduct(pro);
		if (i > 0) {
			return JSONResponse.success("success");
		}
		return JSONResponse.error("faild");
	}
*/
	// 删除产品
	@RequestMapping(value="/deleteProduct.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse DeleteProduct(String productId) {
		List<Purchasedetail> puList = purchaseInfoService.getsPurchasedetailByPurchaseId(productId);
		List<Deliverydetail> delList = deliveryInfoService.getDeliverydetailByProductId(productId);
		if (puList.size() > 0 || delList.size() > 0) {
			return JSONResponse.error("存在交易记录，不允许删除！");
		} else {
			int i = service.DeleteProduct(productId);
			if (i > 0) {
				return JSONResponse.success("success");
			} else {
				return JSONResponse.error("faild");
			}
		}

	}

	// 根据id查询产品名称
	@RequestMapping(value="/getOneProductById.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse getOneProductById(String id) {
		Product product = service.getProductById(id);
		if (id != "") {
			return JSONResponse.success(product.getProductname());
		} else {
			return JSONResponse.error("faild");
		}
	}

   //根据名称查询产品信息
   @RequestMapping(value="/getOneProductByName.do",method= RequestMethod.GET)
   @ResponseBody
	public JSONResponse getProductByName(String name) {
		Product pro = service.getProductByName(name);
		if (pro != null) {
			return JSONResponse.success(pro);
		} else {
			return JSONResponse.error("faild");
		}
	}

}
