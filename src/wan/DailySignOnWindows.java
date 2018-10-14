package wan;
import javax.swing.*;
import java.awt.*;

public class DailySignOnWindows extends JPanel {
	String[] Classes= {"��һ�����̰�","�߶���ѧ������","��һ���Ļ�����"};
	String[] Students = {"����","����","����","����"};
	String TeacherName = "����ʦ";
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
		//������ڴ��·�Ϊ��������������,�����ұߴ��·�Ϊ���ϡ�������������,���ϲ����н�ʦ������ѧ������
		JPanel LeftArea = new JPanel();
		JPanel RightArea = new JPanel();
		JPanel RightUpArea = new JPanel();
		JPanel RightButtomArea = new JPanel();
		RightUpArea.setLayout(new GridLayout(2,1));
		LeftArea.add(ClassList);
		RightUpArea.add(Teacher);
		RightUpArea.add(StudentList);
		RightButtomArea.add(SignOn,BorderLayout.WEST);
		
		
		//����������ӵ����������������
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
		
		Teacher =new JLabel( "��ʦ������" + TeacherName);
		
		SignOn = new JButton("ǩ��");
		Cancel = new JButton("ȡ��");
	}


}
