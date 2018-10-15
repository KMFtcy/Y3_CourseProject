package wan;
import javax.swing.*;
import java.awt.*;

public class DailySignOnWindows extends JPanel {
	String[] Classes= {"高一生物冲刺班","高二数学竞赛班","高一语文基础班"};
	String[] Students = {"张三","李四","王五","宋六"};
	String TeacherName = "孙老师";
	JLabel Teacher;
	JList ClassList;
	JList StudentList;
	JButton SignOn;
	JButton Cancel;
	
	public DailySignOnWindows(){
		super();
		this.setSize(1000,1000);
		this.setLayout(new BorderLayout());
		setComponent();
		this.setVisible(true);
	}
	public void setComponent() {
		componentInitialize();
		//这个窗口大致分为左、右两个个部分,其中右边大致分为右上、右下两个部分,右上部分有教师姓名和学生名单
		JPanel LeftArea = new JPanel();
		JPanel RightArea = new JPanel();
		JPanel RightUpArea = new JPanel();
		JPanel RightButtomArea = new JPanel();
		RightUpArea.setLayout(new GridLayout(2,1));
		LeftArea.add(ClassList);
		RightUpArea.add(Teacher);
		RightUpArea.add(StudentList);
		RightButtomArea.add(SignOn,BorderLayout.WEST);
		
		
		//将子容器添加到父容器，进行组合
		RightArea.add(RightUpArea,BorderLayout.NORTH);
		RightArea.add(RightButtomArea,BorderLayout.SOUTH);
		this.add(LeftArea, BorderLayout.WEST);
		this.add(RightArea, BorderLayout.EAST);
	}
	public void componentInitialize() {
		ClassList = new JList(Classes);
		ClassList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		StudentList = new JList(Students);
		StudentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		Teacher =new JLabel( "老师姓名：" + TeacherName);
		
		SignOn = new JButton("签到");
		Cancel = new JButton("取消");
	}


}
