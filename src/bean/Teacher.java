package bean;

public class Teacher {
	private int Id;
	private String Name;
	private String Sex;
	private String Time;// 教师加入机构时间
	private String Phone;
	private String Email;
	private String cerType;
	private String cerNum;
	private String Address;
	private String Note;

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

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCerType() {
		return cerType;
	}

	public void setCerType(String cerType) {
		this.cerType = cerType;
	}

	public String getCerNum() {
		return cerNum;
	}

	public void setCerNum(String cerNum) {
		this.cerNum = cerNum;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	@Override
	public String toString() {
		return "Teacher [Id=" + Id + ", Name=" + Name + ", Sex=" + Sex + ", Time=" + Time + ", Phone=" + Phone
				+ ", Email=" + Email + ", cerType=" + cerType + ", cerNum=" + cerNum + ", Address=" + Address
				+ ", Note=" + Note + "]";
	}

}
