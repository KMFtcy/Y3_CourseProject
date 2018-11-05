package Gui.Finace;

import javax.swing.*;

import DAO.FinanceDaoImpl;
import bean.Finance;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        confirm.setBounds(850,500,100,55);
        //�����ϸ��Ϣ
        add(LoutId);
        LoutId.setBounds(70,50,100,40);
        add(outId);
        outId.setBounds(200,50,230,40);
        add(LoutTime);
        LoutTime.setBounds(600,50,100,40);
        add(outTime);
        outTime.setBounds(730,50,230,40);
        add(LoutMount);
        LoutMount.setBounds(70,110,100,40);
        add(outMount);
        outMount.setBounds(200,110,230,40);
        add(LTID);
        LTID.setBounds(600,110,100,40);
        add(TID);
        TID.setBounds(730,110,230,40);
        //���֧��Ŀ��
        add(LoutPP);
        LoutPP.setBounds(70,220,100,40);
        add(outPP);
        outPP.setBounds(200,220,450,200);
        add(confirm);

        initializeButton();
    }
    
    public void initializeButton() {
    	confirm.addMouseListener(new MouseAdapter() {
    		public void mouseClicked(MouseEvent e) {
    			addFinance();
    		}
		});
    }
    
    /**
     * ��֧����¼��ӵ����ݿ�
     */
    public void addFinance() {
    	//��ȡ���ݣ�����Finance����
    	Finance financeRecord = new Finance();
    	financeRecord.setId(Integer.parseInt(outId.getText()));
    	financeRecord.setOutTime(outTime.getText());
    	financeRecord.setOutNum(outMount.getText());
    	financeRecord.setTeacherId(Integer.parseInt(TID.getText()));
    	financeRecord.setAim(outPP.getText());
    	//��ӽ����ݿ�
    	FinanceDaoImpl.insertFinance(financeRecord);
    	JOptionPane.showMessageDialog(null, "��ӳɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
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
