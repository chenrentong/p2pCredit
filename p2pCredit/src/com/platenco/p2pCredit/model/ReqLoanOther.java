package com.platenco.p2pCredit.model;
// default package

import java.sql.Timestamp;


/**
 * ReqLoanOther entity. @author MyEclipse Persistence Tools
 */

public class ReqLoanOther  implements java.io.Serializable {


    // Fields    

     private Long otherRecordId;
     private Long recordId;
     private String institutionName;
     private Long inLoanAmount;
     private Long inNoFurtherAmount;
     private String inBorrowingRates;
     private Timestamp inExpiryDate;
     private Timestamp createDate;
     private Timestamp updateDate;


    // Constructors

    /** default constructor */
    public ReqLoanOther() {
    }

    
    /** full constructor */
    public ReqLoanOther(Long recordId, String institutionName, Long inLoanAmount, Long inNoFurtherAmount, String inBorrowingRates, Timestamp inExpiryDate, Timestamp createDate, Timestamp updateDate) {
        this.recordId = recordId;
        this.institutionName = institutionName;
        this.inLoanAmount = inLoanAmount;
        this.inNoFurtherAmount = inNoFurtherAmount;
        this.inBorrowingRates = inBorrowingRates;
        this.inExpiryDate = inExpiryDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

   
    // Property accessors

    public Long getOtherRecordId() {
        return this.otherRecordId;
    }
    
    public void setOtherRecordId(Long otherRecordId) {
        this.otherRecordId = otherRecordId;
    }

    public Long getRecordId() {
        return this.recordId;
    }
    
    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getInstitutionName() {
        return this.institutionName;
    }
    
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public Long getInLoanAmount() {
        return this.inLoanAmount;
    }
    
    public void setInLoanAmount(Long inLoanAmount) {
        this.inLoanAmount = inLoanAmount;
    }

    public Long getInNoFurtherAmount() {
        return this.inNoFurtherAmount;
    }
    
    public void setInNoFurtherAmount(Long inNoFurtherAmount) {
        this.inNoFurtherAmount = inNoFurtherAmount;
    }

    public String getInBorrowingRates() {
        return this.inBorrowingRates;
    }
    
    public void setInBorrowingRates(String inBorrowingRates) {
        this.inBorrowingRates = inBorrowingRates;
    }

    public Timestamp getInExpiryDate() {
        return this.inExpiryDate;
    }
    
    public void setInExpiryDate(Timestamp inExpiryDate) {
        this.inExpiryDate = inExpiryDate;
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
		return "ReqLoanOther [otherRecordId=" + otherRecordId + ", recordId="
				+ recordId + ", institutionName=" + institutionName
				+ ", inLoanAmount=" + inLoanAmount + ", inNoFurtherAmount="
				+ inNoFurtherAmount + ", inBorrowingRates=" + inBorrowingRates
				+ ", inExpiryDate=" + inExpiryDate + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}
   

}