package com.yeelenh.manageservice.utils.Impl;

import com.yeelenh.manageservice.utils.Interface.AbstractHandleImportFile;
import com.yeelenh.manageservice.utils.JxlReadUtil;
import com.yeelenh.manageservice.pojo.*;
import com.yeelenh.manageservice.service.DeliveryInfoService;
import com.yeelenh.manageservice.service.ProductService;
import com.yeelenh.manageservice.service.PurchaseInfoService;
import com.yeelenh.manageservice.service.SupplierService;
import com.yeelenh.manageservice.utils.SpringContextUtil;
import jxl.Sheet;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/516:20
 */
public class StockInfoImport extends AbstractHandleImportFile {
    // 需要插入的表
    private static final String sproductid     = "序号";
    private static final String ssuppliername  = "品牌";
    private static final String sproductname   = "商品名称";
    private static final String sproductprice     = "人民币价格";

    // 需要插入的表
    private static final String date     = "日期";
    private static final String buysell_flag  = "买卖方向";
    private static final String sproductid1   = "产品序号";
    private static final String sproductname1    = "产品名称";
    private static final String count    = "数量";
    private static final String sorderid ="订单号";

    SupplierService supplierService;
    ProductService productService;
    PurchaseInfoService purchaseInfoService;
    DeliveryInfoService deliveryInfoService;



    @Override
    public String handleImportFile(List<Sheet> sheets) {
         supplierService=(SupplierService) SpringContextUtil.getBean("supplierService");
         purchaseInfoService=(PurchaseInfoService) SpringContextUtil.getBean("purchaseInfoService");
         deliveryInfoService=(DeliveryInfoService) SpringContextUtil.getBean("deliveryInfoService");
         productService=(ProductService) SpringContextUtil.getBean("productService");

        //产品信息与供应商信息
        handleProductAndSupplierInfo(sheets.get(0));
        try {
            handleDeliverPurchaseInfo(sheets.get(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private String handleDeliverPurchaseInfo(Sheet sheet) throws SQLException {

        //获取sheet中有效行数和理财编号集合
        String[] fileds=JxlReadUtil.getInstance().getContentsViaRow(sheet,0);
        Map<String,String>[] map4xls=JxlReadUtil.getInstance().assembleMap4xls(sheet,fileds);

        int purchaseid=0;
        int delivaryid=0;
        List<Purchasedetail> purchasedetailList=new ArrayList<Purchasedetail>();
        List<Deliverydetail> deliverydetailList=new ArrayList<Deliverydetail>();
        for(int i=0,size=map4xls.length;i<size;i++){
            xlsData=map4xls[i];
            String purchaseDate = xlsData.get(date);
            if(StringUtils.isEmpty(purchaseDate)){
                break;
            }
            String buysell = xlsData.get(buysell_flag);
            String productid = xlsData.get(sproductid1);
            String productname = xlsData.get(sproductname1);
            String num  =xlsData.get(count);
            String suppliername=xlsData.get(ssuppliername);
            String curorderid=xlsData.get(sorderid);
            String nextorderid=map4xls[i+1].get(sorderid);
            Supplier supplier=supplierService.getSupplierByName(suppliername);
            productid=supplier.getSupplierid()+"_"+productid;

            if("买入".equals(buysell)){
                Purchasemaster purchasemaster=new Purchasemaster();
                purchasemaster.setPurchasedate(purchaseDate);
                purchasemaster.setPurchaseid(purchaseid+"");
                purchasemaster.setSupplierid(supplier.getSupplierid());

                Purchasedetail purchasedetail=new Purchasedetail();
                purchasedetail.setPurchaseid(purchaseid+"");
                purchasedetail.setProductid(productid);
                purchasedetail.setPurchaseunitprice(new BigDecimal(0));
                purchasedetail.setPurchasequantity(Integer.parseInt(num));
                purchasedetailList.add(purchasedetail);
                PurchaseInfo purchaseInfo=new PurchaseInfo();
                purchaseInfo.setPurchasedetailList(purchasedetailList);
                purchaseInfo.setPurchasemaster(purchasemaster);
                purchaseInfoService.insert(purchaseInfo);
                purchasedetailList.clear();
                purchaseid=purchaseid+1;
            }else {
                Deliverymaster deliverymaster=new Deliverymaster();
                deliverymaster.setDeliverydate(purchaseDate);
                deliverymaster.setDeliveryid(delivaryid+"");
                deliverymaster.setCustomerid(1);
                deliverymaster.setSalesmanid("0002");

                Deliverydetail deliverydetail=new Deliverydetail();
                deliverydetail.setDeliveryid(delivaryid+"");
                deliverydetail.setProductid(productid);
                deliverydetail.setSalesquantity(Integer.parseInt(num));
                deliverydetail.setSalesprice(0.0);
                deliverydetailList.add(deliverydetail);
                if(!StringUtils.isEmpty(nextorderid)&&curorderid.equals(nextorderid)) {
                   continue;
                }else{
                    DeliveryInfo deliveryInfo=new DeliveryInfo();
                    deliveryInfo.setDeliverydetailList(deliverydetailList);
                    deliveryInfo.setDeliverymaster(deliverymaster);
                    deliveryInfoService.addDeliveryMaster(deliveryInfo);
                    deliverydetailList.clear();
                    delivaryid=delivaryid+1;
                }
            }



        }
        return null;
    }
    private String handleProductAndSupplierInfo(Sheet sheet){
//获取sheet中有效行数和理财编号集合
        String[] fileds=JxlReadUtil.getInstance().getContentsViaRow(sheet,0);
        Map<String,String>[] map4xls=JxlReadUtil.getInstance().assembleMap4xls(sheet,fileds);

        for(int i=0,size=map4xls.length;i<size;i++){
            xlsData=map4xls[i];

            String productid = xlsData.get(sproductid);
            String suppliername = xlsData.get(ssuppliername);
            String productname = xlsData.get(sproductname);
            String productprice = xlsData.get(sproductprice);
            Supplier supplier=supplierService.getSupplierByName(suppliername);
            Product product=new Product();
            product.setQuantity(0);
            product.setProductname(productname);
            product.setMinsafestock(3);
            product.setMaxsafestock(100);
            product.setSupplierid(supplier.getSupplierid());
            productid=supplier.getSupplierid()+"_"+productid;
            product.setProductid(productid);
            Product isproduct=productService.getProductById(productid);

            if(!StringUtils.isEmpty(productprice)){
                product.setProductprice(new BigDecimal(Double.parseDouble(productprice)));
            }
            if(isproduct==null){
                productService.AddProiduct(product);
            }
        }
        return null;
    }
}
