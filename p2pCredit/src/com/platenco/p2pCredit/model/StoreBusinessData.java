package com.platenco.p2pCredit.model;
// default package

import java.sql.Timestamp;

import com.platenco.p2pCredit.util.Logg;


/**
 * StoreBusinessData entity. @author MyEclipse Persistence Tools
 */

public class StoreBusinessData  implements java.io.Serializable {


    // Fields    

     private Long dataId;
     private Integer storeId;
     private String dataCycle;
     private Long ttv;
     private Long operatingIncome;
     private String openRoomRate;
     private Integer openRooms;
     private Integer rooms;
     private Timestamp createDate;


    // Constructors

    /** default constructor */
    public StoreBusinessData() {
    }

    
    /** full constructor */
    public StoreBusinessData(Integer storeId, String dataCycle, Long ttv, Long operatingIncome, String openRoomRate, Integer openRooms, Integer rooms, Timestamp createDate) {
        this.storeId = storeId;
        this.dataCycle = dataCycle;
        this.ttv = ttv;
        this.operatingIncome = operatingIncome;
        this.openRoomRate = openRoomRate;
        this.openRooms = openRooms;
        this.rooms = rooms;
        this.createDate = createDate;
    }

   
    // Property accessors

    public Long getDataId() {
        return this.dataId;
    }
    
    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Integer getStoreId() {
        return this.storeId;
    }
    
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getDataCycle() {
        return this.dataCycle;
    }
    
    public void setDataCycle(String dataCycle) {
        this.dataCycle = dataCycle;
    }

    public Long getTtv() {
        return this.ttv;
    }
    
    public void setTtv(Long ttv) {
        this.ttv = ttv;
    }

    public Long getOperatingIncome() {
        return this.operatingIncome;
    }
    
    public void setOperatingIncome(Long operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public String getOpenRoomRate() {
        return this.openRoomRate;
    }
    
    public void setOpenRoomRate(String openRoomRate) {
        this.openRoomRate = openRoomRate;
    }

    public Integer getOpenRooms() {
        return this.openRooms;
    }
    
    public void setOpenRooms(Integer openRooms) {
        this.openRooms = openRooms;
    }

    public Integer getRooms() {
        return this.rooms;
    }
    
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }


	@Override
	public String toString() {
		return "StoreBusinessData [dataId=" + dataId + ", storeId=" + storeId
				+ ", dataCycle=" + dataCycle + ", ttv=" + ttv
				+ ", operatingIncome=" + operatingIncome + ", openRoomRate="
				+ openRoomRate + ", openRooms=" + openRooms + ", rooms="
				+ rooms + ", createDate=" + createDate + "]";
	}
   

	public Boolean compare(StoreBusinessData storeBusinessData){
		if(this.ttv.longValue() != storeBusinessData.ttv.longValue()){
			Logg.writeDebugLog("ttv不等:"+this.ttv+"!="+storeBusinessData.ttv);
			return false;
		}
		if(this.operatingIncome.longValue() != storeBusinessData.operatingIncome.longValue()){
			Logg.writeDebugLog("operatingIncome不等");
			return false;
		}
		if(!this.openRoomRate.equals(storeBusinessData.openRoomRate)){
			Logg.writeDebugLog("openRoomRate不等");
			return false;
		}
		if(this.openRooms.intValue() != storeBusinessData.openRooms.intValue()){
			Logg.writeDebugLog("openRooms不等");
			return false;
		}
		if(this.rooms.intValue() != storeBusinessData.rooms.intValue()){
			Logg.writeDebugLog("rooms不等");
			return false;
		}
		
		return true;
	}






}