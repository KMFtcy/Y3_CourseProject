package Gui.Manage;
import Gui.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//////////////////////////////////////////////////////////////////////////////////////////////////////��Ϊjfram
public class DetailC extends JFrame implements ActionListener{

    JTextField ID;//�γ̱��
    JTextField Name;//�γ�����
    JTextField Gender;//ѧ���Ա�
    JTextField CourseType;//�Ͽη�ʽ
    JTextField InChargeTeacher;//�ον�ʦ
    JTextArea Memo;//����
    JButton Comfirm;//ȷ�ϰ�ť
    JButton Cancel;//ȡ����ť


    public DetailC(){
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        setComponent();
        this.setVisible(true);
    }
    public void setComponent() {
        //��ʼ��������ڵĸ������Ԫ�أ�Ȼ��ʼ��װ
        componentInitialize();
        //������ڵĲ��ִ�ŷ�Ϊ�����������֣������ϴ�ŷ�Ϊ���С��ҡ����ĸ�����
        //�¾��Ƿ�������ť
        JPanel Up = new JPanel();
        JPanel Down = new JPanel();
        JPanel UpArea = new JPanel();
        JPanel UpDown = new JPanel();
        //���������Ĳ���Layout
        Up.setLayout(new BorderLayout());
        UpArea.setLayout(new GridLayout(2,4));
        UpDown.setLayout(new BorderLayout());
        Down.setLayout(new BorderLayout());
        //���Ԫ�ؽ�����
        UpArea.add(new JLabel("�γ̱��",JLabel.CENTER));
        UpArea.add(ID);
        UpArea.add(new JLabel("�γ�����",JLabel.CENTER));
        UpArea.add(Name);
        UpArea.add(new JLabel("�Ͽη�ʽ",JLabel.CENTER));
        UpArea.add(CourseType);
        UpArea.add(new JLabel("�ον�ʦ",JLabel.CENTER));
        UpArea.add(InChargeTeacher);
        UpDown.add(new JLabel("��ע"),BorderLayout.WEST);
        UpDown.add(Memo,BorderLayout.CENTER);
        Down.add(Comfirm,BorderLayout.EAST);
        Down.add(Cancel,BorderLayout.WEST);
        //����������ӵ���Ӧ���������У����
        add(Up,BorderLayout.CENTER);
        Up.add(UpArea,BorderLayout.SOUTH);
        add(Down,BorderLayout.SOUTH);
        Down.add(UpDown,BorderLayout.NORTH);
        pack();
    }
    public void componentInitialize() {
        ID = new JTextField(20);
        Name = new JTextField(20);
        Gender = new JTextField(20);
        CourseType = new JTextField(20);
        InChargeTeacher = new JTextField(20);
        Memo = new JTextArea(6,10);
        Memo.setLineWrap(true);
        Comfirm = new JButton("ȷ��");
        Cancel = new JButton("ȡ��");
        Comfirm.addActionListener(this);
        Cancel.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand()=="ȷ��") {
            System.out.println("ȷ������");
        }
        if(e.getActionCommand()=="ȡ��") {
            this.dispose();
        }
    }

}
