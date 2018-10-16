package com.itheima.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class JDBCUtil {
	static String driverCLass=null;
	static String url=null;
	static String name=null;
	static String password=null;
	
	static {
		try {
		Properties properties=new Properties();
		//InputStream is=JDBCUtil.class.getClassLoader().getSystemResourceAsStream("jdbc.properties");
		InputStream is=new FileInputStream("jdbc.properties");
		/**
		 * ��jdbc.properties�Ÿ�����Ŀ¼�¿����ã�
		 * InputStream is=new FileInputStream("jdbc.properties");
		 */
		//����������
		properties.load(is);
		//��ȡ����
		
		driverCLass=properties.getProperty("driverClass");
		url=properties.getProperty("url");
		name=properties.getProperty("name");
		password=properties.getProperty("password");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ���Ӷ���
	 * @return
	 */
	@Test
	public static Connection getConn() {
		Connection conn=null;
		//ע������
		try {
			Class.forName(driverCLass);
			conn=DriverManager.getConnection(url,name,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �ͷ���Դ
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn,Statement st,ResultSet rs) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	public static void release(Connection conn,Statement st) {
		closeSt(st);
		closeConn(conn);
	}
		private static void closeRs(ResultSet rs) {
				try {
					if(rs!=null)
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					rs=null;
				}
		}
		private static void closeSt(Statement st) {
			try {
				if(st!=null)
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				st=null;
			}
		}
		private static void closeConn(Connection conn) {
			try {
				if(conn!=null)
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
}
