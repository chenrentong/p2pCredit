package com.platenco.p2pCredit.model;
// default package

import java.sql.Timestamp;


/**
 * LastInstanceChangeHistory entity. @author MyEclipse Persistence Tools
 */

public class LastInstanceChangeHistory  implements java.io.Serializable {


    // Fields    

     private Long lichId;
     private Long lirId;
     private Integer userId;
     private Long recordId;
     private Integer eventId;
     private String changeContent;
     private Timestamp createDate;


    // Constructors

    /** default constructor */
    public LastInstanceChangeHistory() {
    }

    
    /** full constructor */
    public LastInstanceChangeHistory(Long lirId, Integer userId, Long recordId, Integer eventId, String changeContent, Timestamp createDate) {
        this.lirId = lirId;
        this.userId = userId;
        this.recordId = recordId;
        this.eventId = eventId;
        this.changeContent = changeContent;
        this.createDate = createDate;
    }

   
    // Property accessors

    public Long getLichId() {
        return this.lichId;
    }
    
    public void setLichId(Long lichId) {
        this.lichId = lichId;
    }

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

    public Integer getEventId() {
        return this.eventId;
    }
    
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getChangeContent() {
        return this.changeContent;
    }
    
    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }


	@Override
	public String toString() {
		return "LastInstanceChangeHistory [lichId=" + lichId + ", lirId="
				+ lirId + ", userId=" + userId + ", recordId=" + recordId
				+ ", eventId=" + eventId + ", changeContent=" + changeContent
				+ ", createDate=" + createDate + "]";
	}
   








}