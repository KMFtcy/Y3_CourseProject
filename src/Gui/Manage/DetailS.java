package Gui.Manage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//////////////////////////////////////////////////////////////////////////////////////////////////////改为jfram
public class DetailS extends JFrame implements ActionListener{
	
	JTextField ID;//学生编号
	JTextField Name;//学生姓名
	JTextField Gender;//学生性别
	JTextField StudentType;//学生类型
	Image Photo;//学生照片
	JTextField RegistTime;//学生入学时间
	JTextField PhoneNumber;//学生电话
	JTextField Birthday;//学生生日
	JTextField InChargeTeacher;//负责老师
	JTextField CardType;//证件类型
	JTextField CardID;//证件号码
	JTextField Address;//地址
	JTextField Email;//邮箱地址
	JTextArea Memo;//备忘
	JButton Comfirm;//确认按钮
	JButton Cancel;//取消按钮
	
	
	public DetailS(){
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		setComponent();
		this.setVisible(true);
	}
	public void setComponent() {
		//初始化这个窗口的各个组件元素，然后开始组装
		componentInitialize();
		//这个窗口的布局大概分为上下两个部分，其中上大概分为左、中、右、下四个部分
		//下就是放两个按钮
		JPanel UpArea = new JPanel();
		JPanel UpLeftArea = new JPanel();
		JPanel UpCenterArea = new JPanel();
		JPanel UpRightArea = new JPanel();
		JPanel UpButtomArea = new JPanel();
		JPanel ButtomArea = new JPanel();
		//设置容器的布局Layout
		UpArea.setLayout(new BorderLayout());
		UpLeftArea.setLayout(new GridLayout(7,2));
		UpCenterArea.setLayout(new GridLayout(5,2));
		UpRightArea.setLayout(new GridLayout(2,1));	
		UpButtomArea.setLayout(new BorderLayout());
		ButtomArea.setLayout(new GridLayout(1,2));
		//添加元素进容器
		UpLeftArea.add(new JLabel("学生编号",JLabel.CENTER));
		UpLeftArea.add(ID);
		UpLeftArea.add(new JLabel("学生姓名",JLabel.CENTER));
		UpLeftArea.add(Name);
		UpLeftArea.add(new JLabel("学生性别",JLabel.CENTER));
		UpLeftArea.add(Gender);
		UpLeftArea.add(new JLabel("学生类型",JLabel.CENTER));
		UpLeftArea.add(StudentType);
		UpLeftArea.add(new JLabel("入学时间",JLabel.CENTER));
		UpLeftArea.add(RegistTime);
		UpLeftArea.add(new JLabel("手机号码",JLabel.CENTER));
		UpLeftArea.add(PhoneNumber);
		UpLeftArea.add(new JLabel("出生日期",JLabel.CENTER));
		UpLeftArea.add(Birthday);
		UpCenterArea.add(new JLabel("招生老师",JLabel.CENTER));
		UpCenterArea.add(InChargeTeacher);
		UpCenterArea.add(new JLabel("证件类型",JLabel.CENTER));
		UpCenterArea.add(CardType);
		UpCenterArea.add(new JLabel("证件号码",JLabel.CENTER));
		UpCenterArea.add(CardID);
		UpCenterArea.add(new JLabel("联系地址",JLabel.CENTER));
		UpCenterArea.add(Address);
		UpCenterArea.add(new JLabel("电子邮箱",JLabel.CENTER));
		UpCenterArea.add(Email);
		UpRightArea.add(new JLabel("照片",JLabel.CENTER));
		UpRightArea.add(new JLabel("这是到时插入的照片",JLabel.CENTER));
		UpButtomArea.add(new JLabel("备注"),BorderLayout.WEST);
		UpButtomArea.add(Memo,BorderLayout.CENTER);
		ButtomArea.add(Comfirm);
		ButtomArea.add(Cancel);
		//将子容器添加到相应父容器当中，组合
		UpArea.add(UpLeftArea,BorderLayout.WEST);
		UpArea.add(UpCenterArea,BorderLayout.CENTER);
		UpArea.add(UpRightArea,BorderLayout.EAST);
		UpArea.add(UpButtomArea,BorderLayout.SOUTH);
		this.add(UpArea,BorderLayout.NORTH);
		this.add(ButtomArea,BorderLayout.SOUTH);
		pack();
	}
	public void componentInitialize() {
		ID = new JTextField(20);
		Name = new JTextField(20);
		Gender = new JTextField(20);
		StudentType = new JTextField(20);
		RegistTime = new JTextField(20);
		PhoneNumber = new JTextField(20);
		Birthday = new JTextField(20);
		InChargeTeacher = new JTextField(20);
		CardType = new JTextField(20);
		CardID = new JTextField(20);
		Address = new JTextField(20);
		Email = new JTextField(20);
		Memo = new JTextArea(6,20);
		
		Comfirm = new JButton("确认");
		Cancel = new JButton("取消");
		Comfirm.addActionListener(this);
		Cancel.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand()=="确认") {
			System.out.println("确认命令");
		}
		if(e.getActionCommand()=="取消") {
			this.dispose();
		}
	}

}
