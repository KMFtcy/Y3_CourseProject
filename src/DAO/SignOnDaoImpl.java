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
import bean.SignRecord;
import bean.Student;
import bean.Teacher;

public class SignOnDaoImpl {
	List<Student> findByCourse(Course course){
		Student result=null;
		List<Student> sd = new ArrayList<>();
		int i=0;
		int id=0;
		int teacer_id=0;
		int student_id=0;
		int course_id=0;
		int studentid[]=new int[10000];
		String schooltime=null;
		String name=null;
		String grade=null;
		String password=null;
		String RegisteTime = null;
		String phone=null;
		String Birth = null;
		String sex=null;
		String ad_teacher=null;
		String email=null;
		String cer_type=null;
		String cer_num=null;
		String address=null;
		String note=null;
		byte picture=(Byte) null;
		//创建数据库连接
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		//查询
		try {
		conn = JDBCUtil.getConn();
		
		String sql="select * from signin where course_id=?";
		st = conn.prepareStatement(sql);
		id=course.getId();
		st.setLong(1, id);
		rs=st.executeQuery();
		while(rs.next()) {
			student_id=rs.getInt("student_id");
			studentid[i]=student_id;
			i++;
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			for(int j=0;j<sd.size();j++) {
			String sql="select * from student where student_id=?";
			st = conn.prepareStatement(sql);
			st.setLong(1, studentid[j]);
			rs=st.executeQuery();
			while(rs.next()) {
				id=rs.getInt("student_id");
				name=rs.getString("name");
				grade=rs.getString("grade");
				String time=rs.getString("time");
				phone=rs.getString("phone");
				String birth=rs.getString("birth");
				sex=rs.getString("sex");
				ad_teacher=rs.getString("ad_teacher");
				email=rs.getString("email");
				cer_type=rs.getString("cer_type");
				cer_num=rs.getString("cer_num");
				address=rs.getString("address");
				note=rs.getString("note");
				picture=rs.getByte("picture");
				result=new Student();
				result.setId(id);
				result.setName(name);
				result.setGrade(grade);
				result.setRegisteTime(RegisteTime);
				result.setPhone(phone);
				result.setBirth(Birth);
				result.setSex(sex);
				result.setInChargeTeacher(ad_teacher);
				result.setEmail(email);
				result.setCerTypr(cer_type);
				result.setCerCode(cer_num);
				result.setAddress(address);
				result.setNote(note);
				result.setPhoto(picture);
				sd.add(result);
			}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			JDBCUtil.release(conn, st, rs);
		}
		return (List<Student>) result;
}
	List<Course> getCourseAll(){
		List<Course> c = new ArrayList<>();
		Course result=null;
		int id=0;
		String name=null;
		int teacher_id=0;
		String course_type=null;
		int course_fee=0;
		String course_memo=null;
		//连接数据库
		Connection conn =null;
		Statement st=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			st=conn.createStatement();
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
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	public static Teacher findTeacherByCourse(Course course) {
		int teacher_id=course.getTeacherId();
		Teacher result=null;
		int id=0;
		String name=null;
		String sex=null;
		String time=null;
		String phone=null;
		String email=null;
		String cer_type=null;
		String cer_num=null;
		String address=null;
		String note=null;
		Connection conn =null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="select * from teacher where teacher_id=?";
			st = conn.prepareStatement(sql);
			st.setLong(1, teacher_id);
			rs=st.executeQuery();
			while(rs.next()) {
				id=rs.getInt("teacher_id");
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
		result.setId(id);
		result.setName(name);
		result.setSex(sex);
		result.setTime(time);
		result.setPhone(phone);
		result.setEmail(email);
		result.setCerType(cer_type);
		result.setCerNum(cer_num);
		result.setAddress(address);
		result.setNote(note);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st);
		}
		return result;
	}
	public static boolean addSignRecord(SignRecord signrecord) {
		boolean flag = false;
		Connection conn =null;
		Statement st=null;
		try {
			conn = JDBCUtil.getConn();
			st=conn.createStatement();
			String sql="insert into signin values("+signrecord.getTeacher_id()+","+signrecord.getStudent_id()+","
			+signrecord.getCourse_id()+","+signrecord.getSchooltime()+")";
			st.executeQuery(sql);
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st);
		}
		return flag;
	
	}
}
