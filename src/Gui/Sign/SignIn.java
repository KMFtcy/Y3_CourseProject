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
	String[] Classes= {"��һ�����̰�","�߶���ѧ������","��һ���Ļ�����"};  //�滻Ϊ�����ݿ��ж����γ��б�
	String[] Students = {"����","����","����","����"}; //ֻ����������  ���ݿγ����ƶ���
	String TeacherName;  // ֻ����������   �����ݿ���������ݿγ�����
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
		RightUpArea.add(Teacher,BorderLayout.NORTH);
		RightUpArea.add(StudentList,BorderLayout.CENTER);
		RightButtomArea.add(SignOn,BorderLayout.EAST);
		//����������ӵ����������������
		RightArea.add(RightUpArea,BorderLayout.CENTER);
		RightArea.add(RightButtomArea,BorderLayout.SOUTH);
		this.add(LeftArea, BorderLayout.WEST);
		this.add(RightArea, BorderLayout.CENTER);


	}
	public void componentInitialize() {
		ClassList = new JList(Classes);
		ClassList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ѧ������ʦ��ӷ��ڼ�������
		StudentList = new JList();
		StudentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		Teacher =new JLabel();
		
		SignOn = new JButton("ǩ��");
		Cancel = new JButton("ȡ��");

		ClassList.addListSelectionListener(e -> {
		    if(!e.getValueIsAdjusting()){
		    TeacherName = (String) ClassList.getSelectedValue();
            Teacher.setText("��ʦ������"+TeacherName);//��Ϊ�����ݿ��л�ȡ�ĸÿγ̵Ľ�ʦ����
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
