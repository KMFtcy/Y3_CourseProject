package Gui.Finace;

import javax.swing.*;
import java.awt.*;

public class FinanceAdd extends JPanel {
    private JTextField outId; //֧����¼ID
    private JTextField outTime;//֧��ʱ��
    private JTextField outMount;//֧�����
    private JTextField outPP;//֧��Ŀ��
    private JTextField TID;//��ʦID
    private JPanel MJP; //��Ҫ���
    private JPanel[] jPanels; //ϸ�����
    private JPanel jpS; //�·����
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
        MJP = new JPanel();
        //������ϸ��Ϣjpanel
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
        LoutId = new JLabel ("֧����¼ID");
        LoutTime = new JLabel("  ֧��ʱ��");
        LoutMount = new JLabel("  ֧�����");
        LoutPP = new JLabel("  ֧��Ŀ��");
        LTID =new JLabel("    ��ʦID");
        confirm = new JButton("ȷ��");
        setLayout(new BorderLayout());
        add(MJP,BorderLayout.CENTER);
        add(jpS,BorderLayout.SOUTH);
        //����Ҫ������
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
        //���·�������
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
