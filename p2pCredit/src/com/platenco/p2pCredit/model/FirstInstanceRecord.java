package com.platenco.p2pCredit.model;
// default package

import java.sql.Timestamp;


/**
 * FirstInstanceRecord entity. @author MyEclipse Persistence Tools
 */

public class FirstInstanceRecord  implements java.io.Serializable {


    // Fields    

     private Long firId;
     private Integer userId;
     private Long recordId;
     private String remarkMsg;
     private String opinionMsg;
     private Integer status;
     private Timestamp createDate;
     private Timestamp updateDate;


    // Constructors

    /** default constructor */
    public FirstInstanceRecord() {
    }

    
    /** full constructor */
    public FirstInstanceRecord(Integer userId, Long recordId, String remarkMsg, String opinionMsg, Integer status, Timestamp createDate, Timestamp updateDate) {
        this.userId = userId;
        this.recordId = recordId;
        this.remarkMsg = remarkMsg;
        this.opinionMsg = opinionMsg;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

   
    // Property accessors

    public Long getFirId() {
        return this.firId;
    }
    
    public void setFirId(Long firId) {
        this.firId = firId;
    }

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getRecordId() {
        return this.recordId;
    }
    
    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getRemarkMsg() {
        return this.remarkMsg;
    }
    
    public void setRemarkMsg(String remarkMsg) {
        this.remarkMsg = remarkMsg;
    }

    public String getOpinionMsg() {
        return this.opinionMsg;
    }
    
    public void setOpinionMsg(String opinionMsg) {
        this.opinionMsg = opinionMsg;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
   








}