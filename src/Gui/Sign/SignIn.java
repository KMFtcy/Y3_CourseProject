package Gui.Sign;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class SignIn extends JPanel {
	String[] Classes= {"高一生物冲刺班","高二数学竞赛班","高一语文基础班"};  //替换为从数据库中读出课程列表
	String[] Students = {"张三","李四","王五","宋六"}; //只声明不定义  根据课程名称读出
	String TeacherName;  // 只声明不定义   从数据库读出，根据课程名称
	JLabel Teacher;
	JList ClassList;
	JList StudentList;
	JButton SignOn;
	JButton Cancel;
	
	public SignIn(){
		super();
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
		// 学生跟老师添加放在监听器中
		StudentList = new JList();
		StudentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		Teacher =new JLabel();
		
		SignOn = new JButton("签到");
		Cancel = new JButton("取消");

		ClassList.addListSelectionListener(e -> {
		    if(!e.getValueIsAdjusting()){
		    TeacherName = (String) ClassList.getSelectedValue();
            Teacher.setText("老师姓名："+TeacherName);//改为从数据库中获取的该课程的教师姓名
            Students[1] = Students[1]+TeacherName;
            StudentList.setListData(Students);}
        });

		SignOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> SignOn = new Vector<>();

                SignOn.add( ClassList.getSelectedValue().toString());
                ArrayList arrayList;
                arrayList = (ArrayList) StudentList.getSelectedValuesList();
                for(int i = 0; i<arrayList.size(); i++){
                    SignOn.add((String) arrayList.get(i));
                }
                SignOn.add(Teacher.getText());
                System.out.println(SignOn);
            }
        });

	}


}
