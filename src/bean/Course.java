package bean;

public class Course {
	private int Id;
	private String Name;
	private int TeacherId;
	private String CourseType;
	private String CourseFee;
	private String Memo;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}

	public String getCourseType() {
		return CourseType;
	}

	public void setCourseType(String courseType) {
		CourseType = courseType;
	}

	public String getCourseFee() {
		return CourseFee;
	}

	public void setCourseFee(String courseFee) {
		CourseFee = courseFee;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	@Override
	public String toString() {
		return "Course [Id=" + Id + ", Name=" + Name + ", TeacherId=" + TeacherId + ", CourseType=" + CourseType
				+ ", CourseFee=" + CourseFee + ", Memo=" + Memo + "]";
	}

}
