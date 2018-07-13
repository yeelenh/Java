package com.yeelenh.manageservice.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/2/2813:43
 */
public class DeliveryInfo  implements Serializable {
    List<Deliverydetail> deliverydetailList;
    Deliverymaster deliverymaster;

    public List<Deliverydetail> getDeliverydetailList() {
        return deliverydetailList;
    }

    public void setDeliverydetailList(List<Deliverydetail> deliverydetailList) {
        this.deliverydetailList = deliverydetailList;
    }

    public Deliverymaster getDeliverymaster() {
        return deliverymaster;
    }

    public void setDeliverymaster(Deliverymaster deliverymaster) {
        this.deliverymaster = deliverymaster;
    }

    @Override
    public String toString() {
        return "DeliveryInfo{" +
                "deliverydetailList=" + deliverydetailList +
                ", deliverymaster=" + deliverymaster +
                '}';
    }
}
