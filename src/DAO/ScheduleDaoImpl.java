package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.util.JDBCUtil;
import bean.Finance;
import bean.ScheduleRecord;

public class ScheduleDaoImpl {
	public static List<ScheduleRecord> getAll(){
		ArrayList<ScheduleRecord> ScheduleRecordList = new ArrayList();
		ScheduleRecord result=null;
		int ScheduleId = 0;
		int Teacher_id = 0;
		String Date = null;
		int Student_Id = 0;
		int Course_Id = 0;
		// 创建数据库的连接
		Connection conn = null;
		Statement stmt = null;
		ResultSet searchResult = null;
		try {
			conn = JDBCUtil.getConn();
			stmt=conn.createStatement();
			String sql = "select * from todayschedule";
			searchResult = stmt.executeQuery(sql);
			while (searchResult.next()) {
				ScheduleId = searchResult.getInt("SCHEDULE_ID");
				Teacher_id = searchResult.getInt("Teacher_Id");
				Date = searchResult.getString("DATETIME");
				Student_Id = searchResult.getInt("Student_Id");
				Course_Id = searchResult.getInt("Course_Id");
				result = new ScheduleRecord();
				result.setId(ScheduleId);
				result.setTeacherId(Teacher_id);
				result.setSchoolTime(Date);
				result.setStudentId(Student_Id);
				result.setCourseId(Course_Id);
				ScheduleRecordList.add(result);
			}
		}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.release(conn, stmt, searchResult);
			}
		return ScheduleRecordList;
	}
	public static void addSchedule(ScheduleRecord record) {
		Connection conn =null;
		Statement st=null;
		try {
			conn = JDBCUtil.getConn();
			st=conn.createStatement();
			String sql="insert into todayschedule values("+record.getId()+","+record.getTeacherId()+",'"
			+record.getSchoolTime()+"',"+record.getStudentId()+","+ record.getCourseId()+")";
			st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st);
		}
	}
}
