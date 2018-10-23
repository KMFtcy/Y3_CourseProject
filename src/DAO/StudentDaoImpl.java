package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DAO.util.JDBCUtil;
import bean.Course;
import bean.Student;

public class StudentDaoImpl{
	/**
	 * �õ�����ѧ��������
	 * @return Student���͵�����ѧ�����ݵĶ�̬����
	 */
	List <Student> findAllStudent() {
		List<Student> sd=new ArrayList<>();
		Student result=null;
		int id=0;
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
		//�������ݿ�
		Connection conn =null;
		Statement st=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			conn.createStatement();
			String sql="select * from student";
			rs=st.executeQuery(sql);
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
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sd;
}
	/**
	 * ����ѧԱ��Ϣ
	 * @param id����ѧ��id
	 * @return
	 */
	@Test
	public static Student findById(int Id) {
		Student result=null;
		int id=0;
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
		//�������ݿ�����
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		//��ѯ
		try {
		conn = JDBCUtil.getConn();
		
		String sql="select * from student where student_id=?";
		st = conn.prepareStatement(sql);
		st.setLong(1, Id);
		rs=st.executeQuery(sql);
		while(rs.next()) {
			id=rs.getInt("student_id");
			name=rs.getString("name");
			grade=rs.getString("grade");
			RegisteTime=rs.getString("time");
			phone=rs.getString("phone");
			Birth=rs.getString("birth");
			sex=rs.getString("sex");
			ad_teacher=rs.getString("ad_teacher");
			email=rs.getString("email");
			cer_type=rs.getString("cer_type");
			cer_num=rs.getString("cer_num");
			address=rs.getString("address");
			note=rs.getString("note");
			picture=rs.getByte("picture");
		}
		result=new Student();
		result.setId(id);
		result.setName(name);
		result.setGrade(grade);
		//result.setpassword(password);
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
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.release(conn, st, rs);
	}
		return result;
}

	List <Student> findByName(String Name){
		List<Student> sd = new ArrayList<>();
		Student result=null;
		int id=0;
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
		//�������ݿ�
		Connection conn =null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="select * from student where name=?";
			st = conn.prepareStatement(sql);
			st.setString(1,Name);
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
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sd;
	}
	/**
	 * �����ѧԱ
	 * @param student����������Ϣ
	 * @return ����true(��ӳɹ�)��false(���ʧ��)
	 */
	@Test
	public static boolean addStudent(Student student) {
		boolean flag = false;
		Connection conn =null;
		Statement st=null;
		try {
			conn = JDBCUtil.getConn();
			st=conn.createStatement();
			String sql="insert into student values("+student.getId()+","+student.getName()+","
			+student.getGrade()+","+student.getRegisteTime()+","+student.getPhone()+","
			+student.getBirth()+","+student.getSex()+","+student.getInChargeTeacher()+","
			+student.getEmail()+","+student.getCerTypr()+","+student.getCerCode()+","+student.getAddress()+","
			+student.getNote()+","+student.getPhoto()+")";
			//photo��û�д�ȡ����
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
	/**
	 * ɾ����������
	 * @param id����ѧ��id
	 * @param ����true(ɾ���ɹ�)��false(ɾ��ʧ��)
	 * @return
	 */
	public static boolean deleteById(int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="delete from student where student_id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸�����
	 * @param name�������֣�id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentName(String name,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set name=? where student_id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸�ѧ���꼶
	 * @param grade�����꼶��id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentGrade(String grade,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set grade=? where student_id=?";//��û��Ӷ�λ���ֶ�
			ps=conn.prepareStatement(sql);
			ps.setString(1, grade);
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
	 * �޸���ѧʱ��
	 * @param time������ѧʱ�䣬id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentTime(Timestamp time,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set time=? where student_id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸��ֻ�����
	 * @param phone�����ֻ��ţ�id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentPhone(String phone,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set phone=? where id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸�����
	 * @param birth�������գ�id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentBirth(String birth,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set birth=? where student_id=?";//��û��Ӷ�λ���ֶ�
			ps=conn.prepareStatement(sql);
			ps.setString(1, birth);
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
	 * �޸��Ա�
	 * @param sex�����Ա�id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentSex(String sex,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set sex=? where student_id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸�������ʦ
	 * @param ad_teacher����������ʦ���֣�id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentAd_teacher(String ad_teacher,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set ad_teacher=? where student_id=?";//��û��Ӷ�λ���ֶ�
			ps=conn.prepareStatement(sql);
			ps.setString(1, ad_teacher);
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
	 * �޸ĵ�������
	 * @param email���������ַ��id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentEmail(String email,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set email=? where student_id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸�֤������
	 * @param cer_type����֤�����ͣ�id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentCer_type(String cer_type,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set cer_type=? where student_id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸�֤������
	 * @param cer_code����֤���ţ�id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentCer_code(String cer_code,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set cer_code=? where student_id=?";//��û��Ӷ�λ���ֶ�
			ps=conn.prepareStatement(sql);
			ps.setString(1, cer_code);
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
	 * �޸�סַ
	 * @param address�����ַ��id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentAddress(String address,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set address=? where student_id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸ı�ע
	 * @param note���뱸ע��id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentNote(String note,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set note=? where student_id=?";//��û��Ӷ�λ���ֶ�
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
	/**
	 * �޸���Ƭ
	 * @param photo����ͼƬ��id����ѧ��id
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateStudentPhoto(String photo,int id) {//��ûʵ��
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set photo=? where student_id=?";//��û��Ӷ�λ���ֶ�
			ps=conn.prepareStatement(sql);
			ps.setString(1, photo);
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
