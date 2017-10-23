package com.platenco.p2pCredit.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.RoleTest;

import com.platenco.p2pCredit.dao.SDRoleDao;
import com.platenco.p2pCredit.model.SDRole;
import com.platenco.p2pCredit.util.Logg;

/**
 * 角色管理,暂时没用
   * @author tsh
   * 2016年9月29日 下午5:32:11
 */

@Controller
public class ControlRole {
	
	@Resource(name="roleDao")  
	private SDRoleDao roleDao;
	

	@RequestMapping(value="/role",method=RequestMethod.GET)
	public @ResponseBody SDRole insertRole(String role_name, int role_level, int status){
		SDRole role = new SDRole(role_name, role_level, status, new Timestamp(new Date().getTime()));
		roleDao.save(role);
		return role;
	}
	
	@RequestMapping(value="/json",method=RequestMethod.POST)
	public @ResponseBody SDRole printRole(@RequestBody SDRole role){
		System.out.println(role.toString());
		return role;
	}
	
	@RequestMapping(value="/getRole",method=RequestMethod.GET)
	public @ResponseBody SDRole getRole(){
		SDRole role = roleDao.get(12);
		Logg.writeTraceLog(role.toString());
		Logg.writeDebugLog(role.toString());
		Logg.writeInfoLog(role.toString());
		Logg.writeWarnLog(role.toString());
		Logg.writeErrorLog(role.toString());
		return role;
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void testLog(){
		Logger Log = LoggerFactory.getLogger(RoleTest.class);
		Log.debug("Test the MessageFormat for {} to {} endTo {}", "1","2");
	    Log.info("Test the MessageFormat for {} to {} endTo {}");
	    Log.error("Test the MessageFormat for {} to {} endTo {}");
	}
	
	@RequestMapping(value="/updateRole", method=RequestMethod.GET)
	public void updateRole(){
		SDRole role = roleDao.get(13);
		roleDao.update(role);
		Logg.writeTraceLog(role.toString());
	}
}
