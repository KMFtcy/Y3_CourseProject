package Gui.Finace;

import javax.swing.*;
import java.awt.*;

public class FinanceAdd extends JPanel {
    private JTextField outId; //֧����¼ID
    private JTextField outTime;//֧��ʱ��
    private JTextField outMount;//֧�����
    private JTextArea outPP;//֧��Ŀ��
    private JTextField TID;//��ʦID

    //��ӦJLabel
    private JLabel LoutId;
    private JLabel LoutTime;
    private JLabel LoutMount;
    private JLabel LoutPP;
    private JLabel LTID;
    //ȷ����ť
    private JButton confirm;

    public FinanceAdd(){GUI();}
    private void GUI(){
        setLayout(null);
        outId = new JTextField(20);
        outTime = new JTextField(20);
        outMount = new JTextField(20);
        outPP = new JTextArea(6,20);
        TID = new JTextField(20);
        LoutId = new JLabel ("֧����¼ID");
        LoutTime = new JLabel("֧��ʱ��");
        LoutMount = new JLabel("֧�����");
        LoutPP = new JLabel("֧��Ŀ��");
        LTID =new JLabel("֧����ʦID");
        confirm = new JButton("ȷ��");
        confirm.setBounds(800,600,150,75);
        //�����ϸ��Ϣ
        add(LoutId);
        LoutId.setBounds(70,50,100,50);
        add(outId);
        outId.setBounds(200,50,200,50);
        add(LoutTime);
        LoutTime.setBounds(600,50,100,50);
        add(outTime);
        outTime.setBounds(730,50,200,50);
        add(LoutMount);
        LoutMount.setBounds(70,150,100,50);
        add(outMount);
        outMount.setBounds(200,150,200,50);
        add(LTID);
        LTID.setBounds(600,150,100,50);
        add(TID);
        TID.setBounds(730,150,200,50);
        //���֧��Ŀ��
        add(LoutPP);
        LoutPP.setBounds(70,250,100,50);
        add(outPP);
        outPP.setBounds(200,250,450,200);
        add(confirm);

    }
   /* public static void main(String args[]){
        FinanceAdd financeAdd = new FinanceAdd();
        JFrame frame = new JFrame();
        frame.add(financeAdd);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400,400,400,400);
    }*/
}
