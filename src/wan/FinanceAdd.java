package wan;

import javax.swing.*;
import java.awt.*;

public class FinanceAdd extends JPanel {
    private JTextField outId; //支出记录ID
    private JTextField outTime;//支出时间
    private JTextField outMount;//支出金额
    private JTextField outPP;//支出目的
    private JTextField TID;//老师ID
    private JPanel MJP; //主要面板
    private JPanel[] jPanels; //细节面板
    private JPanel jpS; //下方面板
    //相应JLabel
    private JLabel LoutId;
    private JLabel LoutTime;
    private JLabel LoutMount;
    private JLabel LoutPP;
    private JLabel LTID;
    //确定按钮
    private JButton confirm;

    FinanceAdd(){GUI();}
    private void GUI(){
        MJP = new JPanel();
        //创建详细信息jpanel
        jPanels = new JPanel[5];

        for(int i = 0;i < 5;i++){
            jPanels[i] = new JPanel();
            jPanels[i].setLayout(new FlowLayout());
            MJP.add(jPanels[i]);
        }

        jpS = new JPanel();
        outId = new JTextField(20);
        outTime = new JTextField(20);
        outMount = new JTextField(20);
        outPP = new JTextField(20);
        TID = new JTextField(20);
        LoutId = new JLabel ("支出记录ID");
        LoutTime = new JLabel("  支出时间");
        LoutMount = new JLabel("  支出金额");
        LoutPP = new JLabel("  支出目的");
        LTID =new JLabel("    老师ID");
        confirm = new JButton("确认");
        setLayout(new BorderLayout());
        add(MJP,BorderLayout.CENTER);
        add(jpS,BorderLayout.SOUTH);
        //向主要面板添加
        jPanels[0].add(LoutId);
        jPanels[0].add(outId);
        jPanels[1].add(LoutTime);
        jPanels[1].add(outTime);
        jPanels[2].add(LoutMount);
        jPanels[2].add(outMount);
        jPanels[3].add(LoutPP);
        jPanels[3].add(outPP);
        jPanels[4].add(LTID);
        jPanels[4].add(TID);
        MJP.setLayout(new BoxLayout(MJP,BoxLayout.Y_AXIS));
        //向下方面板添加
        jpS.setLayout(new BorderLayout());
        jpS.add(confirm,BorderLayout.EAST);

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
