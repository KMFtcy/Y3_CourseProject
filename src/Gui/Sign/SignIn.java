package Gui.Sign;
import DAO.CourseDaoImpl;
import DAO.SignOnDaoImpl;
import DAO.StudentDaoImpl;
import bean.Course;
import bean.SignRecord;
import bean.Student;
import bean.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class SignIn extends JPanel {
	String[] Classes= {"高一生物冲刺班","高二数学竞赛班","高一语文基础班"};  //替换为从数据库中读出课程列表
	String[] Students = {"张三","李四","王五","宋六"}; //只声明不定义  根据课程名称读出
	String TeacherName;  // 只声明不定义   从数据库读出，根据课程名称
	JLabel TeacherLabel;
	JList ClassList;
	JList StudentList;
	JButton SignOn;
	JButton Cancel;
	Course course;
	Teacher teacher;
	
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
		RightUpArea.add(TeacherLabel,BorderLayout.NORTH);
		RightUpArea.add(StudentList,BorderLayout.CENTER);
		RightButtomArea.add(SignOn,BorderLayout.EAST);
		//将子容器添加到父容器，进行组合
		RightArea.add(RightUpArea,BorderLayout.CENTER);
		RightArea.add(RightButtomArea,BorderLayout.SOUTH);
		this.add(LeftArea, BorderLayout.WEST);
		this.add(RightArea, BorderLayout.CENTER);


	}
	public void componentInitialize() {
		List<Course> classes = SignOnDaoImpl.getCourseAll();
		Vector <String> Classes = new Vector<>();
		for(int i = 0; i<classes.size(); i++){
		    Classes.add(classes.get(i).getName());
        }
		ClassList = new JList(Classes);
		ClassList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 学生跟老师添加放在监听器中
		StudentList = new JList();
		StudentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		TeacherLabel =new JLabel();
		
		SignOn = new JButton("签到");
		Cancel = new JButton("取消");

		ClassList.addListSelectionListener(e -> {
		    if(!e.getValueIsAdjusting()){
                String CourseName;  //课程名称
		        CourseName = (String) ClassList.getSelectedValue();  //获取选中的课程名称
		        course = CourseDaoImpl.findByName(CourseName).get(0); //根据课程名称获取课程信息
                teacher = SignOnDaoImpl.findTeacherByCourse(course); //根据课程获取教师信息
                TeacherLabel.setText("老师姓名："+teacher.getName());// 根据教师ID获取教师姓名
                //添加学生Jlist
                Vector<String> students = new Vector<>();
                List<Student> studentList = SignOnDaoImpl.findByCourse(course);  //根据课程查找学生信息
                for(int i = 0; i < studentList.size();i++){
                    students.add(studentList.get(i).getName());
                }
                StudentList.setListData(students);



//                Students[1] = Students[1]+TeacherName;
//                StudentList.setListData(Students);
		    }
        });

		SignOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // Vector<String> SignOn = new Vector<>();
                ArrayList arrayList;
                arrayList = (ArrayList) StudentList.getSelectedValuesList();
                for(int i = 0;i < arrayList.size();i++){
                    SignRecord signRecord = new SignRecord();
                    signRecord.setCourse_id(course.getId());  //设置课程id
                    signRecord.setTeacher_id(teacher.getId()); //设置教师id
                    Student student = null;
					try {
						student = (Student) StudentDaoImpl.findByName((String)arrayList.get(i));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    signRecord.setStudent_id(student.getId());  //设置学生id
                    //日期设置
                    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd"); //获取时间
                    dateFormat.format(new Date()); //设置时间
                    String data = String.valueOf(dateFormat); //将时间转换为String
                    signRecord.setSchooltime(data); //设置签到时间
                    SignOnDaoImpl.addSignRecord(signRecord); //添加签到表
                }
//                SignRecord signRecord = new SignRecord();
//                signRecord.setCourse_id(course.getId());
//                signRecord.setTeacher_id(teacher.getId());
                //SignOn.add( ClassList.getSelectedValue().toString());
//                for(int i = 0;i <)
//                signRecord.setStudent_id(arrayList);
//                SignOnDaoImpl.addSignRecord(signRecord);
                //     for(int i = 0; i<arrayList.size(); i++){
//                   //SignOn.add((String) arrayList.get(i));
//                }
                //SignOn.add(TeacherLabel.getText());
                //System.out.println(SignOn);
            }
        });

	}


}
