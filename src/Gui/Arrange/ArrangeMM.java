package Gui.Arrange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import DAO.*;
import bean.SignRecord;

public class ArrangeMM extends JPanel {
	// ��ʾ����
//	String[] Course = { "��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����",
//			"��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����",
//			"��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����" };
//	String[] Teacher = { "�Ƴ���", "�޺�", "������", "�����", "½�ĺ�", "�����" };
//	String[] Student = { "С��", "����", "����", "����" };
	Vector<String> Course;
	Vector<String> Teacher;
	Vector<String> Student;
	JList CourseList;
	JList TeacherList;
	JList StudentList;
	JTextField SearchCourse;
	JTextField SearchTeacher;
	JTextField SearchStudent;
	JButton SearchCourseButton;
	JButton SearchTeacherButton;
	JButton SearchStudentButton;
	JButton Comfirm;

	public ArrangeMM() {
		setLayout(new BorderLayout());
		setComponent();
	}

	public void setComponent() {
		// ��ʼ�����
		componentInitialize();
		// ���б���ӹ�����
		JScrollPane CourseListPane = new JScrollPane(CourseList);
		CourseListPane.setBounds(0, 0, 200, 100);
		JScrollPane TeacherListPane = new JScrollPane(TeacherList);
		CourseListPane.setBounds(0, 0, 200, 100);
		JScrollPane StudentListPane = new JScrollPane(StudentList);
		CourseListPane.setBounds(0, 0, 200, 100);
		// ���������
		JPanel LeftArea = new JPanel();
		JPanel LeftUpArea = new JPanel();//������������
		JPanel CenterArea = new JPanel();
		JPanel CenterUpArea = new JPanel();//������������
		JPanel RightArea = new JPanel();
		JPanel RightUpArea = new JPanel();//������������
		LeftArea.setLayout(new BorderLayout());
		LeftUpArea.setLayout(new BorderLayout());
		CenterArea.setLayout(new BorderLayout());
		CenterUpArea.setLayout(new BorderLayout());
		RightArea.setLayout(new BorderLayout());
		RightUpArea.setLayout(new BorderLayout());
		
		LeftUpArea.add(SearchCourse,BorderLayout.CENTER);
		LeftUpArea.add(SearchCourseButton,BorderLayout.EAST);
		LeftArea.add(LeftUpArea,BorderLayout.NORTH);
		LeftArea.add(CourseListPane,BorderLayout.CENTER);
		CenterUpArea.add(SearchTeacher,BorderLayout.CENTER);
		CenterUpArea.add(SearchTeacherButton,BorderLayout.EAST);
		CenterArea.add(CenterUpArea,BorderLayout.NORTH);
		CenterArea.add(TeacherListPane,BorderLayout.CENTER);
		RightUpArea.add(SearchStudent,BorderLayout.CENTER);
		RightUpArea.add(SearchStudentButton,BorderLayout.EAST);
		RightArea.add(RightUpArea,BorderLayout.NORTH);
		RightArea.add(StudentListPane,BorderLayout.CENTER);

		this.add(LeftArea, BorderLayout.WEST);
		this.add(CenterArea, BorderLayout.CENTER);
		this.add(RightArea, BorderLayout.EAST);
		this.add(Comfirm, BorderLayout.SOUTH);
	}

	public void componentInitialize() {
		initializeSearchTextField();
		initializeButton();
		ArrayList<bean.Course> allCourseList= (ArrayList<bean.Course>) DAO.SignOnDaoImpl.getCourseAll();
		Course = new Vector<String>();
		Teacher = new Vector<String>();
		Student = new Vector<String>();
		for(bean.Course temp:allCourseList) {
			System.out.println(temp.getName());
		}
		for(bean.Course i:allCourseList) {
			Course.add(i.getName());
		}
		CourseList = new JList(Course);
		CourseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArrayList<bean.Teacher> allTeacherList= (ArrayList<bean.Teacher>) DAO.TeacherDaoImpl.findAllCourse();
		for(bean.Teacher i:allTeacherList) {
			Teacher.add(i.getName());
		}
		TeacherList = new JList(Teacher);
		TeacherList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArrayList<bean.Student> allStudentList= (ArrayList<bean.Student>) DAO.StudentDaoImpl.findAllStudent();
		for(bean.Student i:allStudentList) {
			Student.add(i.getName());
		}
		StudentList = new JList(Student);
		StudentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	}

	public void initializeSearchTextField() {
		SearchCourse = new JTextField("������γ���");
		SearchCourse.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				SearchCourse.setText("");
			}
		});
		SearchTeacher = new JTextField("�������ʦ��");
		SearchTeacher.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				SearchTeacher.setText("");
			}
		});
		SearchStudent = new JTextField("������ѧ����");
		SearchStudent.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				SearchStudent.setText("");
			}
		});
	}


	public void initializeButton() {
		Comfirm = new JButton("���");
		Comfirm.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList selectedStudentList;
				selectedStudentList = (ArrayList) StudentList.getSelectedValuesList();
				String data = "�γ̣�" + (String)CourseList.getSelectedValue() +
						 "��ʦ��" + (String)TeacherList.getSelectedValue() 
						 + "ѧ����";
				for(Object i: selectedStudentList) {
					data += (String)i+" ";
				}
				System.out.println("��ӿγ�" + data);
				//�γ�������ʦ��ֻ�û�ȡһ��
				String courseName = (String)CourseList.getSelectedValue();
				String teacherName = (String)TeacherList.getSelectedValue();
				bean.Course selectedCourse = CourseDaoImpl.findByName(courseName).get(0);
				bean.Teacher theTeacher = TeacherDaoImpl.findByName(teacherName).get(0);
				//ѧ����Ҫһһ��ȡ��ӽ����ݿ�
				for(Object i:selectedStudentList) {
					bean.Student student = null;
					try {
						student = StudentDaoImpl.findByName((String)i).get(0);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					SignRecord record = new SignRecord();
					record.setTeacher_id(theTeacher.getId());
					record.setCourse_id(selectedCourse.getId());
					record.setStudent_id(student.getId());
					//��ȡ��ǰʱ��
					Calendar c = Calendar.getInstance();
					record.setSchooltime(c.get(Calendar.YEAR) + "-" 
						+ c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH));
				}
			}
		});
		SearchCourseButton = new JButton("����");
		SearchTeacherButton = new JButton("����");
		SearchStudentButton = new JButton("����");
		
		SearchCourseButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				searchCourse(SearchCourse.getText());
			}
		});
		SearchTeacherButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				searchTeacher(SearchTeacher.getText());
			}
		});
		SearchStudentButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				searchStudent(SearchStudent.getText());
			}
		});
	}

	public void searchCourse(String Name) {
//		CourseDaoImpl.
		System.out.println(Name);
	}

	public void searchTeacher(String Name) {
//		TeacherDaoImpl.
		System.out.println(Name);
	}

	public void searchStudent(String Name) {
//		StudentDaoImpl.f
		System.out.println(Name);
	}
}