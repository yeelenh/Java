package com.yeelenh.manageservice.service;

import com.yeelenh.manageservice.mapper.CartMapper;
import com.yeelenh.manageservice.mapper.SeqNoMapper;
import com.yeelenh.manageservice.pojo.Cart;
import com.yeelenh.manageservice.pojo.SeqNo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SeqNoService {

	@Resource
	SeqNoMapper mapper;
	//根据表名查询最大序号
	public int getMaxSeqNoByTableName(String  tablename){
		int result=mapper.selectByPrimaryKey(tablename);
		SeqNo seqNo=new SeqNo();
		seqNo.setTablename(tablename);
		seqNo.setSeqno(result+1);
		if(result>0){
			mapper.updateByPrimaryKey(seqNo);
		}
		return result;
	}
}
