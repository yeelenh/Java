package com.yeelenh.manageservice.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/111:10
 */
public class PurchaseInfo implements Serializable {
    private List<Purchasedetail> purchasedetailList;
    private Purchasemaster purchasemaster;

    public List<Purchasedetail> getPurchasedetailList() {
        return purchasedetailList;
    }

    public void setPurchasedetailList(List<Purchasedetail> purchasedetailList) {
        this.purchasedetailList = purchasedetailList;
    }

    public Purchasemaster getPurchasemaster() {
        return purchasemaster;
    }

    @Override
    public String toString() {
        return "PurchaseInfo{" +
                "purchasedetailList=" + purchasedetailList +
                ", purchasemaster=" + purchasemaster +
                '}';
    }

    public void setPurchasemaster(Purchasemaster purchasemaster) {
        this.purchasemaster = purchasemaster;
    }


}
