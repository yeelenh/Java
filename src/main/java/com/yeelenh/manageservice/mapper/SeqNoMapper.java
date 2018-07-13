package com.yeelenh.manageservice.mapper;

import com.yeelenh.manageservice.pojo.Cart;
import com.yeelenh.manageservice.pojo.SeqNo;

import java.util.List;

public interface SeqNoMapper {

    int selectByPrimaryKey(String tablename);
    int updateByPrimaryKey(SeqNo seqNo);
}