package com.yeelenh.manageservice.pojo;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/1217:17
 */
public class SeqNo implements Serializable {
    private  String  tablename;
    private Integer seqno;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public Integer getSeqno() {
        return seqno;
    }

    public void setSeqno(Integer seqno) {
        this.seqno = seqno;
    }
}
