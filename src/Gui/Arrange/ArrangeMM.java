package Gui.Arrange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ArrangeMM extends JPanel {
	// ��ʾ����
	String[] Course = { "��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����",
			"��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����",
			"��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����", "��һ����", "��һ��ѧ", "��������", "�߶�����" };
	String[] Teacher = { "�Ƴ���", "�޺�", "������", "�����", "½�ĺ�", "�����" };
	String[] Student = { "С��", "����", "����", "����" };

	JList CourseList;
	JList TeacherList;
	JList StudentList;
	JTextField SearchCourse;
	JTextField SearchTeacher;
	JTextField SearchStudent;
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
		JPanel CenterArea = new JPanel();
		JPanel RightArea = new JPanel();
		LeftArea.setLayout(new GridLayout(2, 1));
		CenterArea.setLayout(new GridLayout(2, 1));
		RightArea.setLayout(new GridLayout(2, 1));

		LeftArea.add(SearchCourse);
		LeftArea.add(CourseListPane);
		CenterArea.add(SearchTeacher);
		CenterArea.add(TeacherListPane);
		RightArea.add(SearchStudent);
		RightArea.add(StudentListPane);

		this.add(LeftArea, BorderLayout.WEST);
		this.add(CenterArea, BorderLayout.CENTER);
		this.add(RightArea, BorderLayout.EAST);
		this.add(Comfirm, BorderLayout.SOUTH);
	}

	public void componentInitialize() {
		initializeSearchTextField();
		initializeButton();
		CourseList = new JList(Course);
		CourseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TeacherList = new JList(Teacher);
		TeacherList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
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
				// TODO Auto-generated method stub
				String data = "�γ̣�" + (String)CourseList.getSelectedValue() +
						 "��ʦ��" + (String)TeacherList.getSelectedValue() +
						 "ѧ����" + (String)StudentList.getSelectedValue();
				System.out.println("��ӿγ�" + data);
			}
		});
	}

}