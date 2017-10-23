package com.platenco.p2pCredit.dao;



import com.platenco.p2pCredit.model.SDRole;

public interface SDRoleDao {
	
	void save(SDRole role);
	
	SDRole get(int roleId);
	
	void update(SDRole role);

}
