package com.yeelenh.manageservice.mapper;

import com.yeelenh.manageservice.pojo.Purchasemaster;

public interface PurchasemasterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchasemaster
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String purchaseid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchasemaster
     *
     * @mbggenerated
     */
    int insert(Purchasemaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchasemaster
     *
     * @mbggenerated
     */
    int insertSelective(Purchasemaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchasemaster
     *
     * @mbggenerated
     */
    Purchasemaster selectByPrimaryKey(String purchaseid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchasemaster
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Purchasemaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchasemaster
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Purchasemaster record);
}