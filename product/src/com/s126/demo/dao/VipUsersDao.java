package com.s126.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.s126.demo.bean.VipUsers;
import com.s126.demo.util.DBUtil;

public class VipUsersDao {

	/**
	 * 插入数据，插入成功返回 true ，失败 就返回 false
	 * 
	 */
	public boolean insertVipUsers(VipUsers vipUsers) {
		String sql = "insert into Vip_users values(seq_pro.nextval,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBUtil.getCon();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			ps.setString(1, vipUsers.getItem_name());
			ps.setInt(2, vipUsers.getItem_price());
			ps.setDate(3, new java.sql.Date(vipUsers.getCreate_time().getTime()));
			ps.setInt(4, vipUsers.getStatus());
			
			int row = ps.executeUpdate();
			if (row > 0) {
				con.commit();
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(null, ps, con);
		}
		return false;
	}

	/**
	 * 根据 vipUsers对象  更新 状态（status）
	 */
	public void updateVipUsers(VipUsers vipUsers) {
		String sql = "update Vip_users set status = ? where Item_id = ?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBUtil.getCon();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, vipUsers.getStatus());
			ps.setInt(2, vipUsers.getItem_id());
			
			ps.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(null, ps, con);
		}
		
	}

	
	/**
	 * 根据 状态获取上架或者下架的集合
	 */
	public List<VipUsers> getUpOrDnAll(Integer status) {
		List<VipUsers> list = new ArrayList<VipUsers>();
		String sql = "select Item_id, Item_name, Item_price, create_time, status from Vip_users where status = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, status);
			rs = ps.executeQuery();
			while(rs.next()){
				VipUsers vu = new VipUsers();
				vu.setCreate_time(rs.getDate("create_time"));
				vu.setItem_id(rs.getInt("item_id"));
				vu.setItem_name(rs.getString("item_name"));
				vu.setItem_price(rs.getInt("item_price"));
				vu.setStatus(rs.getInt("status"));
				list.add(vu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, con);
		}
		
		return list;
	}


	
}
