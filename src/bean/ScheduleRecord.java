package bean;

public class ScheduleRecord {
	private int id;
	private int teacherId;
	private int courseId;
	private int studentId;
	private String schoolTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getSchoolTime() {
		return schoolTime;
	}

	public void setSchoolTime(String schoolTime) {
		this.schoolTime = schoolTime;
	}

	@Override
	public String toString() {
		return "ScheduleRecord [id=" + id + ", teacherId=" + teacherId + ", courseId=" + courseId + ", studentId="
				+ studentId + ", schoolTime=" + schoolTime + "]";
	}

}
