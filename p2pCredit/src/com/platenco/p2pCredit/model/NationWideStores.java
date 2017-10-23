package com.platenco.p2pCredit.model;
// default package

import java.sql.Timestamp;


/**
 * NationWideStores entity. @author MyEclipse Persistence Tools
 */

public class NationWideStores  implements java.io.Serializable {


    // Fields    

     private Integer storeId;
     private String storeName;
     private String storeCode;
     private String openDate;
     private String city;
     private Timestamp createDate;


    // Constructors

    /** default constructor */
    public NationWideStores() {
    }

    
    /** full constructor */
    public NationWideStores(String storeName, String storeCode, String openDate, String city, Timestamp createDate) {
        this.storeName = storeName;
        this.storeCode = storeCode;
        this.openDate = openDate;
        this.city = city;
        this.createDate = createDate;
    }

   
    // Property accessors

    public Integer getStoreId() {
        return this.storeId;
    }
    
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return this.storeName;
    }
    
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCode() {
        return this.storeCode;
    }
    
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getOpenDate() {
        return this.openDate;
    }
    
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }


	@Override
	public String toString() {
		return "NationWideStores [storeId=" + storeId + ", storeName="
				+ storeName + ", storeCode=" + storeCode + ", openDate="
				+ openDate + ", city=" + city + ", createDate=" + createDate
				+ "]";
	}
   








}