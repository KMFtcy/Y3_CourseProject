package Gui.Finace;

import javax.swing.*;
import java.awt.*;

public class FinanceAdd extends JPanel {
    private JTextField outId; //支出记录ID
    private JTextField outTime;//支出时间
    private JTextField outMount;//支出金额
    private JTextArea outPP;//支出目的
    private JTextField TID;//老师ID

    //相应JLabel
    private JLabel LoutId;
    private JLabel LoutTime;
    private JLabel LoutMount;
    private JLabel LoutPP;
    private JLabel LTID;
    //确定按钮
    private JButton confirm;

    public FinanceAdd(){GUI();}
    private void GUI(){
        setLayout(null);
        outId = new JTextField(20);
        outTime = new JTextField(20);
        outMount = new JTextField(20);
        outPP = new JTextArea(6,20);
        TID = new JTextField(20);
        LoutId = new JLabel ("支出记录ID");
        LoutTime = new JLabel("支出时间");
        LoutMount = new JLabel("支出金额");
        LoutPP = new JLabel("支出目的");
        LTID =new JLabel("支出教师ID");
        confirm = new JButton("确认");
        confirm.setBounds(800,600,150,75);
        //添加详细信息
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
        //添加支出目的
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
