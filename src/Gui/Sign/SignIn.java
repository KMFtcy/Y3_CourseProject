package Gui.Sign;
import javax.swing.*;
import java.awt.*;

public class SignIn extends JPanel {
	String[] Classes= {"高一生物冲刺班","高二数学竞赛班","高一语文基础班"};
	String[] Students = {"张三","李四","王五","宋六"};
	String TeacherName = "孙老师";
	JLabel Teacher;
	JList ClassList;
	JList StudentList;
	JButton SignOn;
	JButton Cancel;
	
	public SignIn(){
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
		//布局管理器
		RightArea.setLayout(new BorderLayout());
		RightUpArea.setLayout(new BorderLayout());
		RightButtomArea.setLayout(new BorderLayout());

		LeftArea.add(ClassList);
		RightUpArea.add(Teacher,BorderLayout.NORTH);
		RightUpArea.add(StudentList,BorderLayout.CENTER);
		RightButtomArea.add(SignOn,BorderLayout.EAST);
		//将子容器添加到父容器，进行组合
		RightArea.add(RightUpArea,BorderLayout.CENTER);
		RightArea.add(RightButtomArea,BorderLayout.SOUTH);
		this.add(LeftArea, BorderLayout.WEST);
		this.add(RightArea, BorderLayout.CENTER);


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
