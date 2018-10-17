package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itheima.util.JDBCUtil;

public class FinanceDaoImpl {

	/** 根据ID从数据库查询财务记录，并将财务记录保存为Finance对象返回
	 * 
	 * @param Id 需要查询的ID
	 * @return result 从数据库中查询出来的Finance记录对象
	 */
	public static Finance findById(int Id) {
		// 搜索结果的Finance对象
		Finance result = null;
		int theId = 0;
		String theAim = null;
		int theTeacherId = 0;
		String theOutTime = null;
		String theOutNum = null;
		// 创建数据库的连接
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet searchResult = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select * from Finance" + " where id = " + Id;
			stmt = conn.prepareStatement(sql);
			searchResult = stmt.executeQuery(sql);
			while (searchResult.next()) {
				// TODO : 需要由后台替换属性名
				theId = searchResult.getInt("put_id");
				theAim = searchResult.getString("put_aim");
				theTeacherId = searchResult.getInt("teacher_id");
				theOutTime = searchResult.getString("out_time");
				theOutNum = searchResult.getString("out_num");
			}
			result = new Finance();
			result.setId(theId);
			result.setAim(theAim);
			result.setTeacherId(theTeacherId);
			result.setOutTime(theOutTime);
			result.setOutNum(theOutNum);
			// 关闭连接
			searchResult.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 添加新的财务记录到数据库中
	 * @param finance 新的财务记录
	 * @return flag 是否添加成功
	 */
	public static boolean insertFinance(Finance finance) {
		// 代表是否插入成功
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			// TODO : 需要替换数据库名、用户和密码
			conn = JDBCUtil.getConn();
			stmt = conn.createStatement();
			// TODO : 需要替换数据库的表名
			String sql = "INSERT INTO FINANCE VALUES ( " + finance.getId() + "," + finance.getAim() + ","
					+ finance.getTeacherId() + "," + finance.getOutTime() + "," + finance.getOutNum() + ")";
			stmt.executeQuery(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
