package com.yeelenh.manageservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Purchasedetail implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchasedetail.PurchaseID
     *
     * @mbggenerated
     */
    private String purchaseid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchasedetail.ProductID
     *
     * @mbggenerated
     */
    private String productid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchasedetail.PurchaseQuantity
     *
     * @mbggenerated
     */
    private Integer purchasequantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchasedetail.PurchaseUnitPrice
     *
     * @mbggenerated
     */
    private BigDecimal purchaseunitprice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchasedetail.PurchaseID
     *
     * @return the value of purchasedetail.PurchaseID
     *
     * @mbggenerated
     */
    public String getPurchaseid() {
        return purchaseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchasedetail.PurchaseID
     *
     * @param purchaseid the value for purchasedetail.PurchaseID
     *
     * @mbggenerated
     */
    public void setPurchaseid(String purchaseid) {
        this.purchaseid = purchaseid == null ? null : purchaseid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchasedetail.ProductID
     *
     * @return the value of purchasedetail.ProductID
     *
     * @mbggenerated
     */
    public String getProductid() {
        return productid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchasedetail.ProductID
     *
     * @param productid the value for purchasedetail.ProductID
     *
     * @mbggenerated
     */
    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchasedetail.PurchaseQuantity
     *
     * @return the value of purchasedetail.PurchaseQuantity
     *
     * @mbggenerated
     */
    public Integer getPurchasequantity() {
        return purchasequantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchasedetail.PurchaseQuantity
     *
     * @param purchasequantity the value for purchasedetail.PurchaseQuantity
     *
     * @mbggenerated
     */
    public void setPurchasequantity(Integer purchasequantity) {
        this.purchasequantity = purchasequantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchasedetail.PurchaseUnitPrice
     *
     * @return the value of purchasedetail.PurchaseUnitPrice
     *
     * @mbggenerated
     */
    public BigDecimal getPurchaseunitprice() {
        return purchaseunitprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchasedetail.PurchaseUnitPrice
     *
     * @param purchaseunitprice the value for purchasedetail.PurchaseUnitPrice
     *
     * @mbggenerated
     */
    public void setPurchaseunitprice(BigDecimal purchaseunitprice) {
        this.purchaseunitprice = purchaseunitprice;
    }

    @Override
    public String toString() {
        return "Purchasedetail{" +
                "purchaseid='" + purchaseid + '\'' +
                ", productid='" + productid + '\'' +
                ", purchasequantity=" + purchasequantity +
                ", purchaseunitprice=" + purchaseunitprice +
                '}';
    }
}