package com.yeelenh.manageservice.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.ProductID
     *
     * @mbggenerated
     */
    private String productid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.ProductName
     *
     * @mbggenerated
     */
    private String productname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.SupplierID
     *
     * @mbggenerated
     */
    private String supplierid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.ProductPrice
     *
     * @mbggenerated
     */
    private BigDecimal productprice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.Quantity
     *
     * @mbggenerated
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.MaxSafeStock
     *
     * @mbggenerated
     */
    private Integer maxsafestock;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.MinSafeStock
     *
     * @mbggenerated
     */
    private Integer minsafestock;

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.ProductID
     *
     * @return the value of product.ProductID
     *
     * @mbggenerated
     */

    private String suppliername;

    public String getProductid() {
        return productid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.ProductID
     *
     * @param productid the value for product.ProductID
     *
     * @mbggenerated
     */
    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.ProductName
     *
     * @return the value of product.ProductName
     *
     * @mbggenerated
     */
    public String getProductname() {
        return productname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.ProductName
     *
     * @param productname the value for product.ProductName
     *
     * @mbggenerated
     */
    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.SupplierID
     *
     * @return the value of product.SupplierID
     *
     * @mbggenerated
     */
    public String getSupplierid() {
        return supplierid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.SupplierID
     *
     * @param supplierid the value for product.SupplierID
     *
     * @mbggenerated
     */
    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid == null ? null : supplierid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.ProductPrice
     *
     * @return the value of product.ProductPrice
     *
     * @mbggenerated
     */
    public BigDecimal getProductprice() {
        return productprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.ProductPrice
     *
     * @param productprice the value for product.ProductPrice
     *
     * @mbggenerated
     */
    public void setProductprice(BigDecimal productprice) {
        this.productprice = productprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.Quantity
     *
     * @return the value of product.Quantity
     *
     * @mbggenerated
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.Quantity
     *
     * @param quantity the value for product.Quantity
     *
     * @mbggenerated
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.MaxSafeStock
     *
     * @return the value of product.MaxSafeStock
     *
     * @mbggenerated
     */
    public Integer getMaxsafestock() {
        return maxsafestock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.MaxSafeStock
     *
     * @param maxsafestock the value for product.MaxSafeStock
     *
     * @mbggenerated
     */
    public void setMaxsafestock(Integer maxsafestock) {
        this.maxsafestock = maxsafestock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.MinSafeStock
     *
     * @return the value of product.MinSafeStock
     *
     * @mbggenerated
     */
    public Integer getMinsafestock() {
        return minsafestock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.MinSafeStock
     *
     * @param minsafestock the value for product.MinSafeStock
     *
     * @mbggenerated
     */
    public void setMinsafestock(Integer minsafestock) {
        this.minsafestock = minsafestock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid='" + productid + '\'' +
                ", productname='" + productname + '\'' +
                ", supplierid='" + supplierid + '\'' +
                ", productprice=" + productprice +
                ", quantity=" + quantity +
                ", maxsafestock=" + maxsafestock +
                ", minsafestock=" + minsafestock +
                '}';
    }
}