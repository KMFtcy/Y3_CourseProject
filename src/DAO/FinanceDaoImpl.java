package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.util.JDBCUtil;
import bean.Course;
import bean.Finance;

public class FinanceDaoImpl {
	public static List <Finance> findAllFinance() {
		List<Finance> f=new ArrayList<>();
		Finance result=null;
		int theId = 0;
		String theAim = null;
		int theTeacherId = 0;
		String theOutTime = null;
		String theOutNum = null;
		// �������ݿ������
		Connection conn = null;
		Statement stmt = null;
		ResultSet searchResult = null;
		try {
			conn = JDBCUtil.getConn();
			conn.createStatement();
			String sql = "select * from Finance";
			searchResult = stmt.executeQuery(sql);
			while (searchResult.next()) {
				// TODO : ��Ҫ�ɺ�̨�滻������
				theId = searchResult.getInt("put_id");
				theAim = searchResult.getString("put_aim");
				theTeacherId = searchResult.getInt("teacher_id");
				theOutTime = searchResult.getString("out_time");
				theOutNum = searchResult.getString("out_num");
				result = new Finance();
				result.setId(theId);
				result.setAim(theAim);
				result.setTeacherId(theTeacherId);
				result.setOutTime(theOutTime);
				result.setOutNum(theOutNum);
				f.add(result);
			}
		}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.release(conn, stmt, searchResult);
			}
		return f;
	}
	/** ����ID�����ݿ��ѯ�����¼�����������¼����ΪFinance���󷵻�
	 * 
	 * @param Id ��Ҫ��ѯ��ID
	 * @return result �����ݿ��в�ѯ������Finance��¼����
	 */
	public static Finance findById(int Id) {
		// ���������Finance����
		Finance result = null;
		int theId = 0;
		String theAim = null;
		int theTeacherId = 0;
		String theOutTime = null;
		String theOutNum = null;
		// �������ݿ������
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet searchResult = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select * from Finance" + " where id = " + Id;
			stmt = conn.prepareStatement(sql);
			searchResult = stmt.executeQuery(sql);
			while (searchResult.next()) {
				// TODO : ��Ҫ�ɺ�̨�滻������
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
			// �ر�����
			searchResult.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ����µĲ����¼�����ݿ���
	 * @param finance �µĲ����¼
	 * @return flag �Ƿ���ӳɹ�
	 */
	public static boolean insertFinance(Finance finance) {
		// �����Ƿ����ɹ�
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		try {
			// TODO : ��Ҫ�滻���ݿ������û�������
			conn = JDBCUtil.getConn();
			stmt = conn.createStatement();
			// TODO : ��Ҫ�滻���ݿ�ı���
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
