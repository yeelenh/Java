package com.yeelenh.manageservice.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import com.yeelenh.manageservice.pojo.DeliveryInfo;
import com.yeelenh.manageservice.pojo.Deliverydetail;
import com.yeelenh.manageservice.pojo.Deliverymaster;
import com.yeelenh.manageservice.pojo.JSONResponse;
import com.yeelenh.manageservice.service.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.util.calendar.BaseCalendar;

@Controller
public class DeliveryController {
	Logger  logger=Logger.getLogger("DeliveryController.class");
	@Resource
    DeliveryInfoService deliveryInfoService;
	@Resource
	ProductService productService;
	@Resource
	UsersService usersService;
	@Resource
	CustomerService customerService;
	@Resource
	SeqNoService seqNoService;

	@RequestMapping(value="/getAllDeliveryByDeliveryID.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse getAllDeliveryByDeliveryID(String deliveryid) {
		List<Deliverydetail> list = deliveryInfoService.getAllDeliveryByDeliveryID(deliveryid);
		if (list.size() > 0) {
			return JSONResponse.success(list);
		} else {
			return JSONResponse.error("查询失败！");
		}
	}

	@RequestMapping(value="/getOneDeliveryMaster.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse getOneDeliveryMaster(String deliveryid) {
		Deliverymaster deliverymaster = deliveryInfoService.getOneDeliveryById(deliveryid);
		return JSONResponse.success(deliverymaster);
	}
	@RequestMapping(value="/addDeliveryMaster.do",method= RequestMethod.GET)
	@ResponseBody
	public JSONResponse addDeliveryMaster(String dm_json) {
		logger.info("进入addDeliveryMaster处理，参数："+dm_json);

		if(StringUtils.isEmpty(dm_json)){
			return JSONResponse.error("参数为空！");
		}
		DeliveryInfo deliveryInfo=new DeliveryInfo();
		Deliverymaster deliverymaster=new Deliverymaster();
		deliverymaster.setDeliveryid(String.valueOf(seqNoService.getMaxSeqNoByTableName("deliverymaster")));
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		deliverymaster.setDeliverydate(df.format(System.currentTimeMillis()));
		deliverymaster.setSalesmanid("0002");
		deliverymaster.setCustomerid(1);
		deliverymaster.setSubtotal(new BigDecimal(0));
		List<Deliverydetail> deliverydetailList = new ArrayList<Deliverydetail>();
		JSONArray ja=JSONArray.fromObject(dm_json);
		for (int i = 0; i < ja.size(); i++) {
			Deliverydetail deliverydetail = new Deliverydetail();
			JSONObject job = JSONObject.fromObject(ja.get(i));

			String proid = job.optString("productid");
			logger.info("产品编号："+proid);
			deliverydetail.setProductid(proid);
			deliverydetail.setSalesquantity(job.optInt("quantity"));
			logger.info("数量："+job.optInt("quantity"));
			deliverydetail.setSalesprice(0.0);
			deliverydetailList.add(deliverydetail);
		}

		deliveryInfo.setDeliverydetailList(deliverydetailList);
		deliveryInfo.setDeliverymaster(deliverymaster);
		try {
			 deliveryInfoService.addDeliveryMaster(deliveryInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JSONResponse.error("添加失败！");
		}
		return JSONResponse.success("添加成功！");

	}
}

