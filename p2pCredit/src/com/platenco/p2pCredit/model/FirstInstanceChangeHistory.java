package com.platenco.p2pCredit.model;
// default package

import java.sql.Timestamp;


/**
 * FirstInstanceChangeHistory entity. @author MyEclipse Persistence Tools
 */

public class FirstInstanceChangeHistory  implements java.io.Serializable {


    // Fields    

     private Long fichId;
     private Long firId;
     private Integer userId;
     private Long recordId;
     private Integer eventId;
     private String changeContent;
     private Timestamp createDate;


    // Constructors

    /** default constructor */
    public FirstInstanceChangeHistory() {
    }

    
    /** full constructor */
    public FirstInstanceChangeHistory(Long firId, Integer userId, Long recordId, Integer eventId, String changeContent, Timestamp createDate) {
        this.firId = firId;
        this.userId = userId;
        this.recordId = recordId;
        this.eventId = eventId;
        this.changeContent = changeContent;
        this.createDate = createDate;
    }

   
    // Property accessors

    public Long getFichId() {
        return this.fichId;
    }
    
    public void setFichId(Long fichId) {
        this.fichId = fichId;
    }

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
   








}