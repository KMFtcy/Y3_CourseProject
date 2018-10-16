package bean;

public class Finance {
	private int Id;
	private String Aim;
	private int TeacherId;
	private String OutTime;
	private String OutNum;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAim() {
		return Aim;
	}

	public void setAim(String aim) {
		Aim = aim;
	}

	public int getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}

	public String getOutTime() {
		return OutTime;
	}

	public void setOutTime(String outTime) {
		OutTime = outTime;
	}

	public String getOutNum() {
		return OutNum;
	}

	public void setOutNum(String outNum) {
		OutNum = outNum;
	}

	@Override
	public String toString() {
		return "Finance [Id=" + Id + ", Aim=" + Aim + ", TeacherId=" + TeacherId + ", OutTime=" + OutTime + ", OutNum="
				+ OutNum + "]";
	}

}
