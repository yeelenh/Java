package com.yeelenh.manageservice.pojo;

import java.io.Serializable;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/1217:17
 */
public class Cart implements Serializable {
    private  Integer  cartid;
    private String customerid;
    private String productid;
    private Integer quantity;

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartid='" + cartid + '\'' +
                ", customerid='" + customerid + '\'' +
                ", productid='" + productid + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
