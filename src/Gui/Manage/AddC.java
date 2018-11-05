package Gui.Manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * ��ӿγ���Ϣ����
 */
public class AddC extends JFrame implements ActionListener{

    JTextField name;//�γ̱��
    JTextField ID;//�γ�����
    JTextField Teacher;//�Ͽη�ʽ
    JTextField Cost;//�ον�ʦ
    JTextArea Memo;//����
    JButton Comfirm;//ȷ�ϰ�ť
    JButton Cancel;//ȡ����ť


    public AddC(){
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
        UpArea.add(new JLabel("�γ�����",JLabel.CENTER));
        UpArea.add(name);
        UpArea.add(new JLabel("�γ̱��",JLabel.CENTER));
        UpArea.add(ID);
        UpArea.add(new JLabel("�ο���ʦ",JLabel.CENTER));
        UpArea.add(Teacher);
        UpArea.add(new JLabel("��ʱ�ѣ��Σ�",JLabel.CENTER));
        UpArea.add(Cost);
        UpDown.add(new JLabel("�Ͽη�ʽ"),BorderLayout.WEST);
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
        name = new JTextField(20);
        ID = new JTextField(20);
        Teacher = new JTextField(20);
        Cost = new JTextField(20);
        Memo = new JTextArea(6,10);
        Memo.setLineWrap(true);
        Comfirm = new JButton("ȷ��");
        Cancel = new JButton("ȡ��");
        Cancel.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("ȡ��")) {
            this.dispose();
        }
    }

}
