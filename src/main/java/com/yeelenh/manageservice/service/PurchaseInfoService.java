package com.yeelenh.manageservice.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.yeelenh.manageservice.mapper.PurchasedetailMapper;
import com.yeelenh.manageservice.mapper.PurchasemasterMapper;
import com.yeelenh.manageservice.pojo.Product;
import com.yeelenh.manageservice.pojo.PurchaseInfo;
import com.yeelenh.manageservice.pojo.Purchasedetail;
import com.yeelenh.manageservice.pojo.Purchasemaster;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PurchaseInfoService {
	@Resource
	PurchasedetailMapper purchasedetailMapper;
	@Resource
	PurchasemasterMapper purchasemasterMapper;
	@Resource
	ProductService productService;

	//添加购入信息
	public void insert(PurchaseInfo purchaseInfo) throws SQLException {

		Purchasemaster purchasemaster=purchaseInfo.getPurchasemaster();
		purchasemasterMapper.insertSelective(purchasemaster);
		List<Purchasedetail> purchasedetailList=purchaseInfo.getPurchasedetailList();

		for(Purchasedetail purchasedetail:purchasedetailList){
			purchasedetailMapper.insertSelective(purchasedetail);
			String productId=purchasedetail.getProductid();
			Product product=productService.getProductById(productId);
			int quantity=product.getQuantity()+purchasedetail.getPurchasequantity();
			product.setQuantity(quantity);
			productService.UpdateProduct(product);
		}
	}

	public void addPurchaseDetail(Purchasedetail purchasedetail){
		purchasedetailMapper.insert(purchasedetail);
	}

	public List<Purchasedetail> getsPurchasedetailByPurchaseId(String purchaseId){
		return purchasedetailMapper.selectAllByPurchaseId(purchaseId);
	}
}
