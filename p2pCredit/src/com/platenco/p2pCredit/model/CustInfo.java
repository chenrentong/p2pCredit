package com.platenco.p2pCredit.model;

// default package

import java.sql.Timestamp;

/**
 * CustInfo entity. @author MyEclipse Persistence Tools
 */

public class CustInfo implements java.io.Serializable {

	// Fields

	private Integer custId;
	private String userId;
	private String custName;
	private String phoneNo;
	private String idCardNo;
	private Timestamp createDate;
	private Timestamp updateDate;

// Constructors

	/** default constructor */
	public CustInfo() {
	}

	/** full constructor */
	public CustInfo(Integer custId, String userId, String custName,
			String phoneNo, String idCardNo, Timestamp createDate,
			Timestamp updateDate) {
		super();
		this.custId = custId;
		this.userId = userId;
		this.custName = custName;
		this.phoneNo = phoneNo;
		this.idCardNo = idCardNo;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	// Property accessors

	public Integer getCustId() {
		return this.custId;
	}

	

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getIdCardNo() {
		return this.idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "CustInfo [custId=" + custId + ", userId=" + userId
				+ ", custName=" + custName + ", phoneNo=" + phoneNo
				+ ", idCardNo=" + idCardNo + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

	

}