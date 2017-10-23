package com.platenco.p2pCredit.model;
// default package

import java.sql.Timestamp;


/**
 * ReqImageData entity. @author MyEclipse Persistence Tools
 */

public class ReqImageData  implements java.io.Serializable {


    // Fields    

     private Long imageId;
     private Long recordId;
     private String imagePath;
     private String imageName;
     private Timestamp createDate;
     private Integer imageType;
     private Timestamp updateDate;


    // Constructors

    /** default constructor */
    public ReqImageData() {
    }

	/** minimal constructor */
    public ReqImageData(Long recordId) {
        this.recordId = recordId;
    }
    
    /** full constructor */
    public ReqImageData(Long recordId, String imagePath, String imageName, Timestamp createDate, Integer imageType, Timestamp updateDate) {
        this.recordId = recordId;
        this.imagePath = imagePath;
        this.imageName = imageName;
        this.createDate = createDate;
        this.imageType = imageType;
        this.updateDate = updateDate;
    }

   
    // Property accessors

    public Long getImageId() {
        return this.imageId;
    }
    
    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getRecordId() {
        return this.recordId;
    }
    
    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getImagePath() {
        return this.imagePath;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return this.imageName;
    }
    
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Integer getImageType() {
        return this.imageType;
    }
    
    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }

    public Timestamp getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

	@Override
	public String toString() {
		return "ReqImageData [imageId=" + imageId + ", recordId=" + recordId
				+ ", imagePath=" + imagePath + ", imageName=" + imageName
				+ ", createDate=" + createDate + ", imageType=" + imageType
				+ ", updateDate=" + updateDate + "]";
	}
   








}