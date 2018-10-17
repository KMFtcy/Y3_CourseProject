package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.itheima.util.JDBCUtil;

public class TeacherDaoImpl{
	/**
	 * 查看老师信息
	 * @param Id传入学生id
	 */
	public static Teacher findById(int Id) {
		Teacher result=null;
		String id=null;
		String name=null;
		String sex=null;
		String time=null;
		String phone=null;
		String email=null;
		String cer_type=null;
		String cer_num=null;
		String address=null;
		String note=null;
		//连接数据库
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		//查询
		try {
		conn = JDBCUtil.getConn();
		String sql="select * from teacher where teacher_id=?";
		st = conn.prepareStatement(sql);
		st.setLong(1, Id);
		rs=st.executeQuery(sql);
		while(rs.next()) {
				id=rs.getString("teacher_id");
				name=rs.getString("teacher_name");
				sex=rs.getString("sex");
				time=rs.getString("time");
				phone=rs.getString("phone");
				email=rs.getString("email");
				cer_type=rs.getString("cer_type");
				cer_num=rs.getString("cer_num");
				address=rs.getString("address");
				note=rs.getString("note");
			}
		result.setteacer_id("id");
		result.setteacher_name("name");
		result.setsex("sex");
		result.settime("time");
		result.setphone("phone");
		result.setemail("email");
		result.setcer_type("cer_type");
		result.setcer_num("cer_num");
		result.setaddress("address");
		result.setnote("note");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st, rs);
		}
	}
	/**
	 * 添加新教师
	 * @param teacher传入所有个人信息
	 * @return 返回true(添加成功)或者false(添加失败)
	 */
	public static boolean addTeacher(Teacher teacher) {
		boolean flag = false;
		Connection conn =null;
		Statement ps=null;
		try {
			conn = JDBCUtil.getConn();
			ps = conn.createStatement();
			String sql="insert into teacher values("+teacher.getId()+","+teacher.getName()+","
			+teacher.getSex()+","+teacher.getTime()+","+teacher.getPhone()+","
			+teacher.getEmail+","+teacher.getcerType+","+teacher.getcerNum+","
			+teacher.getAddress+","+teacher.getNote+")";
			
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
	/**
	 * 删除教师
	 * @param id传入教师id
	 * @return 返回true(删除成功)或者false(删除失败)
	 */
	public static boolean deleteById(int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="delete from teacher where teacher_id="+id;//还没添加定位的字段
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
	/**
	 * 修改名字
	 * @param name传入名字，id传入老师id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateTeacherName(String name,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set teacher_name=? where teacher_id=?";//还没添加定位的字段
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setLong(2, id);
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
		return flag;
	}
	/**
	 * 修改教师性别
	 * @param sex传入性别，id传入教师id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateTeacherSex(String sex,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set sex=? where teacher_id=?";//还没添加定位的字段
			ps=conn.prepareStatement(sql);
			ps.setString(1, sex);
			ps.setLong(2, id);
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
		return flag;
	}
	/**
	 * 修改入教时间
	 * @param time传入入教时间，id传入教师id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateTeacherTime(Timestamp time,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set time=? where teacher_id=?";//还没添加定位的字段
			ps=conn.prepareStatement(sql);
			ps.setTimestamp(1, time);
			ps.setLong(2, id);
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
		return flag;
	}
	/**
	 * 修改手机号码
	 * @param phone传入手机号，id传入教师id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateTeacherPhone(String phone,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set phone=? where teacher_id=?";//还没添加定位的字段
			ps=conn.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setLong(2, id);
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
		return flag;
	}
	/**
	 * 修改电子邮箱
	 * @param birth传入邮箱，id传入教师id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateTeacherEmail(String email,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set email=? where teacher_id=?";//还没添加定位的字段
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setLong(2, id);
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
		return flag;
	}
	/**
	 * 修改证件类型
	 * @param cer_type传入证件类型，id传入教师id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateTeacherCer_type(String cer_type,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set cer_type=? where teacher_id=?";//还没添加定位的字段
			ps=conn.prepareStatement(sql);
			ps.setString(1, cer_type);
			ps.setLong(2, id);
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
		return flag;
	}
	/**
	 * 修改证件号码
	 * @param cer_num传入老师证件号码，id传入老师id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateTeacherCer_num(String cer_num,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set cer_num=? where teacher_id=?";//还没添加定位的字段
			ps=conn.prepareStatement(sql);
			ps.setString(1, cer_num);
			ps.setLong(2, id);
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
		return flag;
	}
	/**
	 * 修改住址
	 * @param address传入住址，id传入教师id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateTeacherAddress(String address,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set address=? where teacher_id=?";//还没添加定位的字段
			ps=conn.prepareStatement(sql);
			ps.setString(1, address);
			ps.setLong(2, id);
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
		return flag;
	}
	/**
	 * 修改备注
	 * @param note传入备注，id传入教师id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateTeacherNote(String note,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set note=? where teacher_id=?";//还没添加定位的字段
			ps=conn.prepareStatement(sql);
			ps.setString(1, note);
			ps.setLong(2, id);
			ps.executeUpdate();
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
