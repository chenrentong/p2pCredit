package com.platenco.p2pCredit.model;
// default package

import java.sql.Timestamp;


/**
 * ReqBaseData entity. @author MyEclipse Persistence Tools
 */

public class ReqBaseData  implements java.io.Serializable {


    // Fields    

     private Integer recordId;
     private Integer custId;
     private String idCardPhotoPath;
     private String idCardFrontName;
     private String idCardBackName;
     private Integer storeId;
     private String companyName;
     private String companyAdress;
     private String corporateName;
     private String actualControlPerson;
     private String contactInformation;
     private Long monthlyRent;
     private Long monthlyUtilities;
     private Integer employeeNum;
     private Integer wages;
     private Long purchaseFee;
     private Long reqLoanAmount;
     private String loanTerm;
     private String fundsUse;
     private String useDate;
     private Integer status;
     private Timestamp createDate;
     private Timestamp updateDate;
     private Long reqSerialNumber;
     private String brandName;
     private String storeName;
     private String openDate;
     private Integer rooms;
     private String storeAddress;


    // Constructors

    /** default constructor */
    public ReqBaseData() {
    }

	/** minimal constructor */
    public ReqBaseData(Long reqSerialNumber) {
        this.reqSerialNumber = reqSerialNumber;
    }
    
    /** full constructor */
    public ReqBaseData(Integer custId, String idCardPhotoPath, String idCardFrontName, String idCardBackName, Integer storeId, String companyName, String companyAdress, String corporateName, String actualControlPerson, String contactInformation, Long monthlyRent, Long monthlyUtilities, Integer employeeNum, Integer wages, Long purchaseFee, Long reqLoanAmount, String loanTerm, String fundsUse, String useDate, Integer status, Timestamp createDate, Timestamp updateDate, Long reqSerialNumber, String brandName, String storeName, String openDate, Integer rooms, String storeAddress) {
        this.custId = custId;
        this.idCardPhotoPath = idCardPhotoPath;
        this.idCardFrontName = idCardFrontName;
        this.idCardBackName = idCardBackName;
        this.storeId = storeId;
        this.companyName = companyName;
        this.companyAdress = companyAdress;
        this.corporateName = corporateName;
        this.actualControlPerson = actualControlPerson;
        this.contactInformation = contactInformation;
        this.monthlyRent = monthlyRent;
        this.monthlyUtilities = monthlyUtilities;
        this.employeeNum = employeeNum;
        this.wages = wages;
        this.purchaseFee = purchaseFee;
        this.reqLoanAmount = reqLoanAmount;
        this.loanTerm = loanTerm;
        this.fundsUse = fundsUse;
        this.useDate = useDate;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.reqSerialNumber = reqSerialNumber;
        this.brandName = brandName;
        this.storeName = storeName;
        this.openDate = openDate;
        this.rooms = rooms;
        this.storeAddress = storeAddress;
    }

   
    // Property accessors

    public Integer getRecordId() {
        return this.recordId;
    }
    
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getCustId() {
        return this.custId;
    }
    
    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getIdCardPhotoPath() {
        return this.idCardPhotoPath;
    }
    
    public void setIdCardPhotoPath(String idCardPhotoPath) {
        this.idCardPhotoPath = idCardPhotoPath;
    }

    public String getIdCardFrontName() {
        return this.idCardFrontName;
    }
    
    public void setIdCardFrontName(String idCardFrontName) {
        this.idCardFrontName = idCardFrontName;
    }

    public String getIdCardBackName() {
        return this.idCardBackName;
    }
    
    public void setIdCardBackName(String idCardBackName) {
        this.idCardBackName = idCardBackName;
    }

    public Integer getStoreId() {
        return this.storeId;
    }
    
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getCompanyName() {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAdress() {
        return this.companyAdress;
    }
    
    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress;
    }

    public String getCorporateName() {
        return this.corporateName;
    }
    
    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getActualControlPerson() {
        return this.actualControlPerson;
    }
    
    public void setActualControlPerson(String actualControlPerson) {
        this.actualControlPerson = actualControlPerson;
    }

    public String getContactInformation() {
        return this.contactInformation;
    }
    
    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Long getMonthlyRent() {
        return this.monthlyRent;
    }
    
    public void setMonthlyRent(Long monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Long getMonthlyUtilities() {
        return this.monthlyUtilities;
    }
    
    public void setMonthlyUtilities(Long monthlyUtilities) {
        this.monthlyUtilities = monthlyUtilities;
    }

    public Integer getEmployeeNum() {
        return this.employeeNum;
    }
    
    public void setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
    }

    public Integer getWages() {
        return this.wages;
    }
    
    public void setWages(Integer wages) {
        this.wages = wages;
    }

    public Long getPurchaseFee() {
        return this.purchaseFee;
    }
    
    public void setPurchaseFee(Long purchaseFee) {
        this.purchaseFee = purchaseFee;
    }

    public Long getReqLoanAmount() {
        return this.reqLoanAmount;
    }
    
    public void setReqLoanAmount(Long reqLoanAmount) {
        this.reqLoanAmount = reqLoanAmount;
    }

    public String getLoanTerm() {
        return this.loanTerm;
    }
    
    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getFundsUse() {
        return this.fundsUse;
    }
    
    public void setFundsUse(String fundsUse) {
        this.fundsUse = fundsUse;
    }

    public String getUseDate() {
        return this.useDate;
    }
    
    public void setUseDate(String useDate) {
        this.useDate = useDate;
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

    public Long getReqSerialNumber() {
        return this.reqSerialNumber;
    }
    
    public void setReqSerialNumber(Long reqSerialNumber) {
        this.reqSerialNumber = reqSerialNumber;
    }

    public String getBrandName() {
        return this.brandName;
    }
    
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getStoreName() {
        return this.storeName;
    }
    
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOpenDate() {
        return this.openDate;
    }
    
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public Integer getRooms() {
        return this.rooms;
    }
    
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getStoreAddress() {
        return this.storeAddress;
    }
    
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

	@Override
	public String toString() {
		return "ReqBaseData [recordId=" + recordId + ", custId=" + custId
				+ ", idCardPhotoPath=" + idCardPhotoPath + ", idCardFrontName="
				+ idCardFrontName + ", idCardBackName=" + idCardBackName
				+ ", storeId=" + storeId + ", companyName=" + companyName
				+ ", companyAdress=" + companyAdress + ", corporateName="
				+ corporateName + ", actualControlPerson="
				+ actualControlPerson + ", contactInformation="
				+ contactInformation + ", monthlyRent=" + monthlyRent
				+ ", monthlyUtilities=" + monthlyUtilities + ", employeeNum="
				+ employeeNum + ", wages=" + wages + ", purchaseFee="
				+ purchaseFee + ", reqLoanAmount=" + reqLoanAmount
				+ ", loanTerm=" + loanTerm + ", fundsUse=" + fundsUse
				+ ", useDate=" + useDate + ", status=" + status
				+ ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", reqSerialNumber=" + reqSerialNumber + ", brandName="
				+ brandName + ", storeName=" + storeName + ", openDate="
				+ openDate + ", rooms=" + rooms + ", storeAddress="
				+ storeAddress + "]";
	}
   








}