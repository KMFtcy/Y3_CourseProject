package DAO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DAO.util.JDBCUtil;
import bean.Course;
import bean.Student;

public class StudentDaoImpl{
	/**
	 * 得到所有学生的数据
	 * @return Student类型的所有学生数据的动态数组
	 */
	@Test
	public static List <Student> findAllStudent() {
		List<Student> sd=new ArrayList<>();
		Student result=null;
		int id=0;
		String name=null;
		String grade=null;
		//String password=null;
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
		//byte picture=(Byte) null;
		//连接数据库
		Connection conn =null;
		Statement st=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			st=conn.createStatement();
			String sql="select * from student";
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
				//picture=rs.getByte("picture");
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
			//	result.setPhoto(picture);
				sd.add(result);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sd;
}
	/**
	 * 查找学员信息
	 * @param id传入学生id
	 * @return
	 */
	
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
		//创建数据库连接
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		//查询
		try {
		conn = JDBCUtil.getConn();
		
		String sql="select * from student where student_id=?";
		st = conn.prepareStatement(sql);
		st.setLong(1, Id);
		rs=st.executeQuery();
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
		//result.setPhoto(picture);
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.release(conn, st, rs);
	}
		return result;
}


	
	public static List <Student> findByName(String Name)throws FileNotFoundException{
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
		//byte picture=(Byte) null;
		//连接数据库
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
				//picture=rs.getByte("picture");
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
				//result.setPhoto(picture);
				sd.add(result);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sd;
	}
	/**
	 * 添加新学员
	 * @param student传入所有信息
	 * @return 返回true(添加成功)或false(添加失败)
	 */
	public static boolean addStudent(Student student) {
		/*File file=new File("C:\\Users\\陆文翰\\git\\Y3_CourseProject\\src\\Gui\\罗豪.jpg");
		BufferedInputStream imageInput = new BufferedInputStream(new FileInputStream(file));*/
		boolean flag = false;
		Connection conn =null;
		Statement st=null;
		try {
			conn = JDBCUtil.getConn();
			st=conn.createStatement();
			String sql="insert into student values("+student.getId()+",'"+student.getName()+"','"
			+student.getGrade()+"',"+student.getRegisteTime()+",'"+student.getPhone()+"',"
			+student.getBirth()+",'"+student.getSex()+"','"+student.getInChargeTeacher()+"','"
			+student.getEmail()+"','"+student.getCerTypr()+"','"+student.getCerCode()+"','"+student.getAddress()+"','"
			+student.getNote()+"')";//,"+student.getPhoto()+"
			//photo还没有存取方法
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
	 * 删除单条数据
	 * @param id传入学生id
	 * @param 返回true(删除成功)或false(删除失败)
	 * @return
	 */
	public static boolean deleteById(int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="delete from student where student_id=?";//还没添加定位的字段
			ps=conn.prepareStatement(sql);
			ps.setLong(1, id);
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
	 * 修改名字
	 * @param name传入名字，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentName(String name,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set name=? where student_id=?";//还没添加定位的字段
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
	 * 修改学生年级
	 * @param grade传入年级，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentGrade(String grade,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set grade=? where student_id=?";//还没添加定位的字段
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
	 * 修改入学时间
	 * @param time传入入学时间，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentTime(Timestamp time,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set time=? where student_id=?";//还没添加定位的字段
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
	 * @param phone传入手机号，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentPhone(String phone,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set phone=? where id=?";//还没添加定位的字段
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
	 * 修改生日
	 * @param birth传入生日，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentBirth(String birth,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set birth=? where student_id=?";//还没添加定位的字段
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
	 * 修改性别
	 * @param sex传入性别，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentSex(String sex,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set sex=? where student_id=?";//还没添加定位的字段
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
	 * 修改招生老师
	 * @param ad_teacher传入招生老师名字，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentAd_teacher(String ad_teacher,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set ad_teacher=? where student_id=?";//还没添加定位的字段
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
	 * 修改电子邮箱
	 * @param email传入邮箱地址，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentEmail(String email,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set email=? where student_id=?";//还没添加定位的字段
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
	 * @param cer_type传入证件类型，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentCer_type(String cer_type,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set cer_type=? where student_id=?";//还没添加定位的字段
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
	 * @param cer_code传入证件号，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentCer_code(String cer_code,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set cer_code=? where student_id=?";//还没添加定位的字段
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
	 * 修改住址
	 * @param address传入地址，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentAddress(String address,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set address=? where student_id=?";//还没添加定位的字段
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
	 * @param note传入备注，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentNote(String note,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set note=? where student_id=?";//还没添加定位的字段
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
	 * 修改照片
	 * @param photo传入图片，id传入学生id
	 * @return 返回true(正确更新)或false(出错)
	 */
	public static boolean updateStudentPhoto(String photo,int id) {//还没实现
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update student set photo=? where student_id=?";//还没添加定位的字段
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
