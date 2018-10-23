package bean;

import java.util.Arrays;

public class Student {
	private int Id;
	private String Name;
	private String Grade;
	private String RegisteTime;
	private String Phone;
	private String Birth;
	private String Sex;
	private String InChargeTeacher;
	private String Email;
	private String cerTypr;
	private String cerCode;
	private String Address;
	private String Note;
	private byte Photo;

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

	public String getGrade() {
		return Grade;
	}

	public void setGrade(String grade) {
		Grade = grade;
	}

	public String getRegisteTime() {
		return RegisteTime;
	}

	public void setRegisteTime(String registeTime) {
		RegisteTime = registeTime;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getBirth() {
		return Birth;
	}

	public void setBirth(String birth) {
		Birth = birth;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getInChargeTeacher() {
		return InChargeTeacher;
	}

	public void setInChargeTeacher(String inChargeTeacher) {
		InChargeTeacher = inChargeTeacher;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCerTypr() {
		return cerTypr;
	}

	public void setCerTypr(String cerTypr) {
		this.cerTypr = cerTypr;
	}

	public String getCerCode() {
		return cerCode;
	}

	public void setCerCode(String cerCode) {
		this.cerCode = cerCode;
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

	public byte getPhoto() {
		return Photo;
	}

	public void setPhoto(byte picture) {
		Photo = picture;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", Name=" + Name + ", Grade=" + Grade + ", RegisteTime=" + RegisteTime + ", Phone="
				+ Phone + ", Birth=" + Birth + ", Sex=" + Sex + ", InChargeTeacher=" + InChargeTeacher + ", Email="
				+ Email + ", cerTypr=" + cerTypr + ", cerCode=" + cerCode + ", Address=" + Address + ", Note=" + Note
				+ "]";
	}

}
