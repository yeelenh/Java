package com.yeelenh.manageservice.mapper;

import com.yeelenh.manageservice.pojo.DeliveryInfo;
import com.yeelenh.manageservice.pojo.Deliverydetail;
import com.yeelenh.manageservice.pojo.Deliverymaster;
import com.yeelenh.manageservice.pojo.Supplier;
import com.yeelenh.manageservice.service.DeliveryInfoService;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/616:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring/*.xml","classpath:mybatis/*.xml"})
public class SupplierMapperTest {
    @Resource
    SupplierMapper mapper;
    @Resource
    DeliveryInfoService deliveryInfoService;
    @Test
    public void getSupplierByName() throws Exception {
        Supplier supplier=mapper.getSupplierByName("BabyLiss");
        System.out.println(supplier.toString());
    }
    @Test
    public void addDeliveryMaster() throws Exception{
        List<Deliverydetail> deliverydetailList=new ArrayList<>();
        Deliverymaster deliverymaster=new Deliverymaster();
        deliverymaster.setDeliverydate("20170101");
        deliverymaster.setDeliveryid(1+"");
        deliverymaster.setCustomerid(1);
        deliverymaster.setSalesmanid("0002");

        Deliverydetail deliverydetail=new Deliverydetail();
        deliverydetail.setDeliveryid(1+"");
        deliverydetail.setProductid("1_1");
        deliverydetail.setSalesquantity(Integer.parseInt("1"));
        deliverydetail.setSalesprice(0.0);
        deliverydetailList.add(deliverydetail);

        DeliveryInfo deliveryInfo=new DeliveryInfo();
        deliveryInfo.setDeliverydetailList(deliverydetailList);
        deliveryInfo.setDeliverymaster(deliverymaster);
        deliveryInfoService.addDeliveryMaster(deliveryInfo);

    }

}