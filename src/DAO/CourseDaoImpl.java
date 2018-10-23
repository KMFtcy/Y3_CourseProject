package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.util.JDBCUtil;
import bean.Course;
import bean.Student;
import bean.Teacher;

public class CourseDaoImpl {
	/**
	 * �õ�����course����
	 * @return	
	 */
	/*List <Course> findAllCourse() {
		List<Course> c=new ArrayList<>();
		Course result=null;
		int id=0;
		String name=null;
		int teacher_id=0;
		String course_type=null;
		int course_fee=0;
		String course_memo=null;
		//�������ݿ�
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		//��ѯ
		try {
		conn = JDBCUtil.getConn();
		conn.createStatement();
		String sql="select * from course";
		rs=st.executeQuery(sql);
		while(rs.next()) {
				id=rs.getInt("course_id");
				name=rs.getString("course_name");
				teacher_id=rs.getInt("teacher_id");
				course_type=rs.getString("course_type");
				course_fee=rs.getInt("course_fee");
				course_memo=rs.getString("course_memo");
				result.setId(id);
				result.setName(name);
				result.setTeacherId(teacher_id);
				result.setCourseType(course_type);
				result.setCourseFee(course_fee);
				result.setMemo(course_memo);
				c.add(result);
				}
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.release(conn, st, rs);
	}
	return c;
}*/
	public static Course findById(int Id) {
		Course result=null;
		int id=0;
		String name=null;
		int teacher_id=0;
		String course_type=null;
		int course_fee=0;
		String course_memo=null;
		//�������ݿ�
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		//��ѯ
		try {
		conn = JDBCUtil.getConn();
		String sql="select * from course where course_id=?";
		st = conn.prepareStatement(sql);
		st.setLong(1, Id);
		rs=st.executeQuery();
		while(rs.next()) {
				id=rs.getInt("course_id");
				name=rs.getString("course_name");
				teacher_id=rs.getInt("teacher_id");
				course_type=rs.getString("course_type");
				course_fee=rs.getInt("course_fee");
				course_memo=rs.getString("course_memo");
			}
		result.setId(id);
		result.setName(name);
		result.setTeacherId(teacher_id);
		result.setCourseType(course_type);
		result.setCourseFee(course_fee);
		result.setMemo(course_memo);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st, rs);
		}
		return result;
	}
	public static List <Course> findByName(String Name){
		List<Course> c = new ArrayList<>();
		Course result=null;
		int id=0;
		String name=null;
		int teacher_id=0;
		String course_type=null;
		int course_fee=0;
		String course_memo=null;
		//�������ݿ�
		Connection conn =null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="select * from course where course_name=?";
			st = conn.prepareStatement(sql);
			st.setString(1, Name);
			rs=st.executeQuery();
			while(rs.next()) {
					id=rs.getInt("course_id");
					name=rs.getString("course_name");
					teacher_id=rs.getInt("teacher_id");
					course_type=rs.getString("course_type");
					course_fee=rs.getInt("course_fee");
					course_memo=rs.getString("course_memo");
					result.setId(id);
					result.setName(name);
					result.setTeacherId(teacher_id);
					result.setCourseType(course_type);
					result.setCourseFee(course_fee);
					result.setMemo(course_memo);
					c.add(result);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st, rs);
		}
		return c;
	}
	/**
	 * ��ȡ�������пγ�����
	 * @param Date�ǵ�������
	 * @return course�Ƿ��ص�ʵ���࣬�����Name����������
	 */
	public static List <Course> getSchedule(String Date){
		List<Course> c = new ArrayList<>();
		Course result=null;
		int id=0;
		int teacher_id=0;
		String course_group=null;
		//�������ݿ�
		Connection conn =null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="select * from todaySchedule where datetime=?";
			st = conn.prepareStatement(sql);
			st.setString(1, Date);
			rs=st.executeQuery();
			while(rs.next()) {
					id=rs.getInt("schedule_id");
			}
			sql="select * from todaySchedule_contact where schedule_id=?";
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
			rs=st.executeQuery();
			while(rs.next()) {
				course_group=rs.getString("courses_group");
				result.setName(course_group);
				c.add(result);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st, rs);
		}
		return c;
	}
	
	public static List<Student> getNotSignIn(String Date,Course course){
		List<Student> c = new ArrayList<>();
		int id=0;
		int course_id=0;
		Student result=null;
		Student result1=null;
		Connection conn =null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="select * from coursePurchase where course_Id=?";
			st = conn.prepareStatement(sql);
			st.setLong(1, course_id);
			rs=st.executeQuery();
			while(rs.next()) {
			id=rs.getInt("student_id");
			result1.setId(id);
			c.add(result);
			}
			sql="select * from signin where schooltime=?";
			st = conn.prepareStatement(sql);
			st.setString(1, Date);
			rs=st.executeQuery();
			while(rs.next()) {
			id=rs.getInt("student_id");
			course_id=rs.getInt("course_id");
			for(int j=0;j<c.size();j++) {
				if(c.get(j).getId()==id) {
					c.remove(id);
					}
			}
			}	
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCUtil.release(conn, st,rs);
	}
		return c;
}
	/**
	 * ��ӿγ�
	 * @param ����course��ʵ����
	 * @return true or false
	 */
	public static boolean addCourse(Course course) {
		boolean flag = false;
		Connection conn =null;
		Statement ps=null;
		try {
			conn = JDBCUtil.getConn();
			ps = conn.createStatement();
			String sql="insert into course values("+course.getId()+","+course.getName()+","
			+course.getTeacherId()+","+course.getCourseType()+","+course.getCourseFee()+","
			+course.getMemo()+")";
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
			String sql="delete from course where course_id="+id;//��û��Ӷ�λ���ֶ�
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
