package com.yeelenh.manageservice.service;


import java.sql.SQLException;
import java.util.List;

import com.yeelenh.manageservice.mapper.DeliverydetailMapper;
import com.yeelenh.manageservice.mapper.DeliverymasterMapper;
import com.yeelenh.manageservice.pojo.DeliveryInfo;
import com.yeelenh.manageservice.pojo.Deliverydetail;
import com.yeelenh.manageservice.pojo.Deliverymaster;
import com.yeelenh.manageservice.pojo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeliveryInfoService {
	@Resource
	DeliverymasterMapper deliverymasterMapper;
	@Resource
	DeliverydetailMapper deliverydetailMapper;
	@Resource
    ProductService productService;
	//新增配送
	public void addDeliveryMaster(DeliveryInfo deliveryInfo) throws SQLException {
		deliverymasterMapper.insertSelective(deliveryInfo.getDeliverymaster());
	    String id=deliveryInfo.getDeliverymaster().getDeliveryid();
        List<Deliverydetail> deliverydetailList = deliveryInfo.getDeliverydetailList();
        for (Deliverydetail deliverydetail : deliverydetailList) {
				deliverydetail.setDeliveryid(id);
                saveDeliveryDetail(deliverydetail);
				String productID = deliverydetail.getProductid();
				Product pro = productService.getProductById(productID);
				int proNum = pro.getQuantity() - deliverydetail.getSalesquantity();
				pro.setQuantity(proNum);
                productService.UpdateProduct(pro);
        }
	}

	// 根据编号查询
	public Deliverymaster getOneDeliveryById(String id) {
		return deliverymasterMapper.selectByPrimaryKey(id);
	}


	//根据客户号查询订单信息
	public List<Deliverydetail> selectDeliverydetailByCustomerID(String id){

		return deliverydetailMapper.selectDeliverydetailByCustomerID(id);
	}
	public List<Deliverydetail> getAllDeliveryByDeliveryID(String deliveryid) {
		return deliverydetailMapper.getAllDeliveryByDeliveryID(deliveryid);
	}
	public int saveDeliveryDetail(Deliverydetail deliverydetail) {
		return deliverydetailMapper.insert(deliverydetail);
	}
	//根据产品id产品配送信息
	public List<Deliverydetail> getDeliverydetailByProductId(String productId) {
		return deliverydetailMapper.getDeliverydetailByProductId(productId);
	}
}
