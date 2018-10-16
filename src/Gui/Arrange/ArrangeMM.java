package Gui.Arrange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ArrangeMM extends JPanel {
	// 演示数据
	String[] Course = { "高一语文", "高一数学", "高三语文", "高二语文", "高一语文", "高一数学", "高三语文", "高二语文", "高一语文", "高一数学", "高三语文", "高二语文",
			"高一语文", "高一数学", "高三语文", "高二语文", "高一语文", "高一数学", "高三语文", "高二语文", "高一语文", "高一数学", "高三语文", "高二语文", "高一语文",
			"高一数学", "高三语文", "高二语文", "高一语文", "高一数学", "高三语文", "高二语文", "高一语文", "高一数学", "高三语文", "高二语文" };
	String[] Teacher = { "唐朝阳", "罗豪", "杨兆铭", "万旭光", "陆文翰", "张翔彬" };
	String[] Student = { "小明", "张三", "李四", "王五" };

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
		// 初始化组件
		componentInitialize();
		// 给列表添加滚动条
		JScrollPane CourseListPane = new JScrollPane(CourseList);
		CourseListPane.setBounds(0, 0, 200, 100);
		JScrollPane TeacherListPane = new JScrollPane(TeacherList);
		CourseListPane.setBounds(0, 0, 200, 100);
		JScrollPane StudentListPane = new JScrollPane(StudentList);
		CourseListPane.setBounds(0, 0, 200, 100);
		// 将容器组合
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
		SearchCourse = new JTextField("请输入课程名");
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
		SearchTeacher = new JTextField("请输入教师名");
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
		SearchStudent = new JTextField("请输入学生名");
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
		Comfirm = new JButton("添加");
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
				String data = "课程：" + (String)CourseList.getSelectedValue() +
						 "教师：" + (String)TeacherList.getSelectedValue() +
						 "学生：" + (String)StudentList.getSelectedValue();
				System.out.println("添加课程" + data);
			}
		});
	}

}