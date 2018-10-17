package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itheima.util.JDBCUtil;

public class CourseDaoImpl {
	public static Course findById(int Id) {
		Course result=null;
		String id=null;
		String name=null;
		String teacher_id=null;
		String course_type=null;
		String course_fee=null;
		String course_memo=null;
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		//查询
		try {
		conn = JDBCUtil.getConn();
		String sql="select * from course"+" where course_id=?";
		st = conn.prepareStatement(sql);
		st.setLong(1, Id);
		rs=st.executeQuery(sql);
		while(rs.next()) {
				id=rs.getString("course_id");
				name=rs.getString("course_name");
				teacher_id=rs.getString("teacher_id");
				course_type=rs.getString("course_type");
				course_fee=rs.getString("course_fee");
				course_memo=rs.getString("course_memo");
			}
		result.setcourse_id("id");
		result.setcourse_name("name");
		result.setteacher_id("teacher_id");
		result.setcourse_type("course_type");
		result.setcourse_fee("course_fee");
		result.setcourse_memo("course_memo");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st, rs);
		}
	}
	public static boolean addCourse(Course course) {
		boolean flag = false;
		Connection conn =null;
		Statement ps=null;
		try {
			conn = JDBCUtil.getConn();
			ps = conn.createStatement();
			String sql="insert into course values("+course.getId()+","+course.getName()+","
			+course.getTeacher_id()+","+course.getcourse_type()+","+course.getcourse_fee()+","
			+course.getcourse_memo+")";
			ps.executeUpdate(sql);
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
		return flag;
	}
	public static boolean deleteById(int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="delete from course where course_id="+id;//还没添加定位的字段
			ps=conn.prepareStatement(sql);
			ps.setLong(1, id);
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
		return flag;
	}
}
