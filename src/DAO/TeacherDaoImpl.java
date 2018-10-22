package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import DAO.util.JDBCUtil;
import bean.Teacher;

public class TeacherDaoImpl{
	/**
	 * �鿴��ʦ��Ϣ
	 * @param Id����ѧ��id
	 */
	public static Teacher findById(int Id) {
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
		//�������ݿ�
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		//��ѯ
		try {
		conn = JDBCUtil.getConn();
		String sql="select * from teacher where teacher_id=?";
		st = conn.prepareStatement(sql);
		st.setLong(1, Id);
		rs=st.executeQuery(sql);
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
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st, rs);
		}
		return result;
	}
	/**
	 * ����½�ʦ
	 * @param teacher�������и�����Ϣ
	 * @return ����true(��ӳɹ�)����false(���ʧ��)
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
			+teacher.getEmail()+","+teacher.getCerType()+","+teacher.getCerNum()+","
			+teacher.getAddress()+","+teacher.getNote()+")";
			
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
	 * ɾ����ʦ
	 * @param id�����ʦid
	 * @return ����true(ɾ���ɹ�)����false(ɾ��ʧ��)
	 */
	public static boolean deleteById(int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="delete from teacher where teacher_id="+id;//��û��Ӷ�λ���ֶ�
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
	 * @param name�������֣�id������ʦid
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateTeacherName(String name,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set teacher_name=? where teacher_id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸Ľ�ʦ�Ա�
	 * @param sex�����Ա�id�����ʦid
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateTeacherSex(String sex,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set sex=? where teacher_id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸����ʱ��
	 * @param time�������ʱ�䣬id�����ʦid
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateTeacherTime(Timestamp time,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set time=? where teacher_id=?";//��û��Ӷ�λ���ֶ�
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
	 * @param phone�����ֻ��ţ�id�����ʦid
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateTeacherPhone(String phone,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set phone=? where teacher_id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸ĵ�������
	 * @param birth�������䣬id�����ʦid
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateTeacherEmail(String email,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set email=? where teacher_id=?";//��û��Ӷ�λ���ֶ�
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
	 * @param cer_type����֤�����ͣ�id�����ʦid
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateTeacherCer_type(String cer_type,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set cer_type=? where teacher_id=?";//��û��Ӷ�λ���ֶ�
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
	 * @param cer_num������ʦ֤�����룬id������ʦid
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateTeacherCer_num(String cer_num,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set cer_num=? where teacher_id=?";//��û��Ӷ�λ���ֶ�
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
	 * �޸�סַ
	 * @param address����סַ��id�����ʦid
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateTeacherAddress(String address,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set address=? where teacher_id=?";//��û��Ӷ�λ���ֶ�
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
	 * @param note���뱸ע��id�����ʦid
	 * @return ����true(��ȷ����)��false(����)
	 */
	public static boolean updateTeacherNote(String note,int id) {
		boolean flag=false;
		Connection conn =null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update teacher set note=? where teacher_id=?";//��û��Ӷ�λ���ֶ�
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
