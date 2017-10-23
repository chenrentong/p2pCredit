package com.platenco.p2pCredit.model;
// default package

import java.sql.Timestamp;


/**
 * SDRole entity. @author MyEclipse Persistence Tools
 */

public class SDRole  implements java.io.Serializable {


    // Fields    

     private Integer roleId;
     private String roleName;
     private Integer roleLevel;
     private Integer status;
     private Timestamp createDate;


    // Constructors

    /** default constructor */
    public SDRole() {
    }

    
    /** full constructor */
    public SDRole(String roleName, Integer roleLevel, Integer status, Timestamp createDate) {
        this.roleName = roleName;
        this.roleLevel = roleLevel;
        this.status = status;
        this.createDate = createDate;
    }

   
    // Property accessors

    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleLevel() {
        return this.roleLevel;
    }
    
    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
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


	@Override
	public String toString() {
		return "SDRole [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleLevel=" + roleLevel + ", status=" + status
				+ ", createDate=" + createDate + "]";
	}
   
    

}