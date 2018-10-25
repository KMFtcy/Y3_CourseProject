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
	String[] Classes= {"��һ�����̰�","�߶���ѧ������","��һ���Ļ�����"};  //�滻Ϊ�����ݿ��ж����γ��б�
	String[] Students = {"����","����","����","����"}; //ֻ����������  ���ݿγ����ƶ���
	String TeacherName;  // ֻ����������   �����ݿ���������ݿγ�����
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
		//������ڴ��·�Ϊ��������������,�����ұߴ��·�Ϊ���ϡ�������������,���ϲ����н�ʦ������ѧ������
		JPanel LeftArea = new JPanel();
		JPanel RightArea = new JPanel();
		JPanel RightUpArea = new JPanel();
		JPanel RightButtomArea = new JPanel();
		//���ֹ�����
		RightArea.setLayout(new BorderLayout());
		RightUpArea.setLayout(new BorderLayout());
		RightButtomArea.setLayout(new BorderLayout());

		LeftArea.add(ClassList);
		RightUpArea.add(TeacherLabel,BorderLayout.NORTH);
		RightUpArea.add(StudentList,BorderLayout.CENTER);
		RightButtomArea.add(SignOn,BorderLayout.EAST);
		//����������ӵ����������������
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
		// ѧ������ʦ��ӷ��ڼ�������
		StudentList = new JList();
		StudentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		TeacherLabel =new JLabel();
		
		SignOn = new JButton("ǩ��");
		Cancel = new JButton("ȡ��");

		ClassList.addListSelectionListener(e -> {
		    if(!e.getValueIsAdjusting()){
                String CourseName;  //�γ�����
		        CourseName = (String) ClassList.getSelectedValue();  //��ȡѡ�еĿγ�����
		        course = CourseDaoImpl.findByName(CourseName).get(0); //���ݿγ����ƻ�ȡ�γ���Ϣ
                teacher = SignOnDaoImpl.findTeacherByCourse(course); //���ݿγ̻�ȡ��ʦ��Ϣ
                TeacherLabel.setText("��ʦ������"+teacher.getName());// ���ݽ�ʦID��ȡ��ʦ����
                //���ѧ��Jlist
                Vector<String> students = new Vector<>();
                List<Student> studentList = SignOnDaoImpl.findByCourse(course);  //���ݿγ̲���ѧ����Ϣ
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
                    signRecord.setCourse_id(course.getId());  //���ÿγ�id
                    signRecord.setTeacher_id(teacher.getId()); //���ý�ʦid
                    Student student = null;
					try {
						student = (Student) StudentDaoImpl.findByName((String)arrayList.get(i));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    signRecord.setStudent_id(student.getId());  //����ѧ��id
                    //��������
                    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd"); //��ȡʱ��
                    dateFormat.format(new Date()); //����ʱ��
                    String data = String.valueOf(dateFormat); //��ʱ��ת��ΪString
                    signRecord.setSchooltime(data); //����ǩ��ʱ��
                    SignOnDaoImpl.addSignRecord(signRecord); //���ǩ����
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
