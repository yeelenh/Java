package com.yeelenh.manageservice.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yeelenh.manageservice.pojo.JSONResponse;
import com.yeelenh.manageservice.pojo.PurchaseInfo;
import com.yeelenh.manageservice.pojo.Purchasemaster;
import com.yeelenh.manageservice.pojo.Purchasedetail;
import com.yeelenh.manageservice.service.PurchaseInfoService;
import com.yeelenh.manageservice.service.SeqNoService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class PurchaseController {
	Logger logger=Logger.getLogger("DeliveryController.class");

	@Resource
	PurchaseInfoService purchaseInfoService;
	@Resource
	SeqNoService seqNoService;


	// 插入购买信息
	@RequestMapping(value="/addPurchaseInfo.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse insert(String pl_json) {
		logger.info("进入addDeliveryMaster处理，参数："+pl_json);

		if(StringUtils.isEmpty(pl_json)){
			return JSONResponse.error("参数为空！");
		}

		PurchaseInfo purchaseInfo=new PurchaseInfo();


		List<Purchasedetail> purchasedetailList = new ArrayList<Purchasedetail>();
		JSONArray ja = JSONArray.fromObject(pl_json);
		String id=String.valueOf(seqNoService.getMaxSeqNoByTableName("deliverymaster"));
		logger.info("id="+id);
		for (int i = 0; i < ja.size(); i++) {
			Purchasemaster purchasemaster=new Purchasemaster();
			purchasemaster.setPurchaseid(id);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			purchasemaster.setPurchasedate(df.format(System.currentTimeMillis()));
			purchasemaster.setSubtotal(new BigDecimal(0));
			Purchasedetail purchasedetail = new Purchasedetail();
			JSONObject ob = JSONObject.fromObject(ja.get(i));
			String suppliernamenext="";
			if(i<ja.size()-1){
				JSONObject obnext = JSONObject.fromObject(ja.get(i+1));
				suppliernamenext=obnext.optString("suppliername");
			}
			String suppliername=ob.optString("suppliername");
			purchasedetail.setPurchaseid(purchasemaster.getPurchaseid());

			String productid=ob.optString("productid");
			String supplierid=productid.split("_")[0];
			purchasemaster.setSupplierid(supplierid);
			purchasedetail.setProductid(ob.optString("productid"));

			purchasedetail.setPurchasequantity(ob.optInt("quantity"));
			purchasedetail.setPurchaseunitprice(new BigDecimal(0));
			purchasedetailList.add(purchasedetail);
			if(!suppliername.equals(suppliernamenext)){
				purchaseInfo.setPurchasemaster(purchasemaster);
				purchaseInfo.setPurchasedetailList(purchasedetailList);
				try {
					purchaseInfoService.insert(purchaseInfo);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return JSONResponse.error("faild");
				}
				purchasedetailList.clear();
				id=String.valueOf(seqNoService.getMaxSeqNoByTableName("deliverymaster"));
				logger.info("id="+id);

			}

		}

		return JSONResponse.success("success");

	}
}
