package com.s126.demo.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.s126.demo.bean.VipUsers;
import com.s126.demo.dao.VipUsersDao;

public class VipUsersAction extends ActionSupport {
	
	private VipUsers vipUsers = new VipUsers();
	private List<VipUsers> vipUsersList = new ArrayList<VipUsers>();
	private VipUsersDao vipUsersDao = new VipUsersDao();
	private String message;
	private Integer status;
	
	/**
	 * 显示商品列表
	 */
	public String listAll() {
		return "listAll";
	}
	
	/**
	 * 返回添加页面
	 */
	public String add() {
		return "add";
	}
	
	/**
	 * 获取上架 或者下架 的列表
	 */
	public String getUpOrDnAll() {
		if (status == null)
			status = 0;
		vipUsersList = vipUsersDao.getUpOrDnAll(status);
		return listAll();
	}
	
	
	/**
	 * 录入商品信息
	 */
	public String insert() {
		boolean bl = vipUsersDao.insertVipUsers(vipUsers);
		if(bl)
			message = "添加成功";
		else
			message = "添加失败";
		return "add";
	}

	/**
	 *  更新上下架 的状态
	 */
	public String update(){
		status = vipUsers.getStatus();
		
		if (vipUsers.getStatus() == 0)
			vipUsers.setStatus(1);
		else
			vipUsers.setStatus(0);
		
		vipUsersDao.updateVipUsers(vipUsers);
		
		return getUpOrDnAll();
	}
	
	
	
	
	public VipUsers getVipUsers() {
		return vipUsers;
	}

	public void setVipUsers(VipUsers vipUsers) {
		this.vipUsers = vipUsers;
	}

	public List<VipUsers> getVipUsersList() {
		return vipUsersList;
	}

	public void setVipUsersList(List<VipUsers> vipUsersList) {
		this.vipUsersList = vipUsersList;
	}

	public VipUsersDao getVipUsersDao() {
		return vipUsersDao;
	}

	public void setVipUsersDao(VipUsersDao vipUsersDao) {
		this.vipUsersDao = vipUsersDao;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
}
