package com.platenco.p2pCredit.model;
// default package

import java.sql.Timestamp;


/**
 * LastInstanceRecord entity. @author MyEclipse Persistence Tools
 */

public class LastInstanceRecord  implements java.io.Serializable {


    // Fields    

     private Long lirId;
     private Integer userId;
     private Long recordId;
     private Long loanCreditAuto;
     private Long loanCreditFinal;
     private String lendingRates;
     private String payBackType;
     private String opinionMsg;
     private Integer status;
     private Timestamp createDate;
     private Timestamp updateDate;


    // Constructors

    /** default constructor */
    public LastInstanceRecord() {
    }

    
    /** full constructor */
    public LastInstanceRecord(Integer userId, Long recordId, Long loanCreditAuto, Long loanCreditFinal, String lendingRates, String payBackType, String opinionMsg, Integer status, Timestamp createDate, Timestamp updateDate) {
        this.userId = userId;
        this.recordId = recordId;
        this.loanCreditAuto = loanCreditAuto;
        this.loanCreditFinal = loanCreditFinal;
        this.lendingRates = lendingRates;
        this.payBackType = payBackType;
        this.opinionMsg = opinionMsg;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

   
    // Property accessors

    public Long getLirId() {
        return this.lirId;
    }
    
    public void setLirId(Long lirId) {
        this.lirId = lirId;
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

    public Long getLoanCreditAuto() {
        return this.loanCreditAuto;
    }
    
    public void setLoanCreditAuto(Long loanCreditAuto) {
        this.loanCreditAuto = loanCreditAuto;
    }

    public Long getLoanCreditFinal() {
        return this.loanCreditFinal;
    }
    
    public void setLoanCreditFinal(Long loanCreditFinal) {
        this.loanCreditFinal = loanCreditFinal;
    }

    public String getLendingRates() {
        return this.lendingRates;
    }
    
    public void setLendingRates(String lendingRates) {
        this.lendingRates = lendingRates;
    }

    public String getPayBackType() {
        return this.payBackType;
    }
    
    public void setPayBackType(String payBackType) {
        this.payBackType = payBackType;
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


	@Override
	public String toString() {
		return "LastInstanceRecord [lirId=" + lirId + ", userId=" + userId
				+ ", recordId=" + recordId + ", loanCreditAuto="
				+ loanCreditAuto + ", loanCreditFinal=" + loanCreditFinal
				+ ", lendingRates=" + lendingRates + ", payBackType="
				+ payBackType + ", opinionMsg=" + opinionMsg + ", status="
				+ status + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}
   








}