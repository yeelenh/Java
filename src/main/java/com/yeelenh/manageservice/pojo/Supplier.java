package com.yeelenh.manageservice.pojo;

import java.io.Serializable;

public class Supplier  implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supplier.SupplierID
     *
     * @mbggenerated
     */
    private String supplierid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supplier.SupplierName
     *
     * @mbggenerated
     */
    private String suppliername;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supplier.Telephone
     *
     * @mbggenerated
     */
    private String telephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supplier.CompanyAddress
     *
     * @mbggenerated
     */
    private String companyaddress;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column supplier.SupplierID
     *
     * @return the value of supplier.SupplierID
     *
     * @mbggenerated
     */
    public String getSupplierid() {
        return supplierid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column supplier.SupplierID
     *
     * @param supplierid the value for supplier.SupplierID
     *
     * @mbggenerated
     */
    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid == null ? null : supplierid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column supplier.SupplierName
     *
     * @return the value of supplier.SupplierName
     *
     * @mbggenerated
     */
    public String getSuppliername() {
        return suppliername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column supplier.SupplierName
     *
     * @param suppliername the value for supplier.SupplierName
     *
     * @mbggenerated
     */
    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername == null ? null : suppliername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column supplier.Telephone
     *
     * @return the value of supplier.Telephone
     *
     * @mbggenerated
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column supplier.Telephone
     *
     * @param telephone the value for supplier.Telephone
     *
     * @mbggenerated
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column supplier.CompanyAddress
     *
     * @return the value of supplier.CompanyAddress
     *
     * @mbggenerated
     */
    public String getCompanyaddress() {
        return companyaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column supplier.CompanyAddress
     *
     * @param companyaddress the value for supplier.CompanyAddress
     *
     * @mbggenerated
     */
    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress == null ? null : companyaddress.trim();
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierid='" + supplierid + '\'' +
                ", suppliername='" + suppliername + '\'' +
                ", telephone='" + telephone + '\'' +
                ", companyaddress='" + companyaddress + '\'' +
                '}';
    }
}