package wan;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class NotSign extends JPanel {
    private NotSign (){nsGUI();}
    private Vector<String> colHead; //����б���
    private Vector rows;            //��
    private JTable table;           //���
    private JScrollPane jScrollPane;//�������


    private void nsGUI(){
        setLayout(new BorderLayout());
        table = new JTable();
        colHead = new Vector();
        rows = new Vector();
        fillTable();

    }
    private  void fillTable(){
        colHead.clear();
        //�����������
        colHead.add("����");
        colHead.add("��Ŀ");
        colHead.add("��ʦ");
        colHead.add("ʱ��");
        //���ÿ��
        rows.clear();
        for(int i = 0;i < 10;i++){
            Vector<String> currentRow = new Vector<String>();//������ǰ�е�����
            currentRow.addElement("������");
            currentRow.addElement("����");
            currentRow.addElement("�Ƴ���");
            currentRow.addElement("2018-10-10");
            rows.add(currentRow);//����ǰ�м���rows
        }
        table = new JTable(rows,colHead); //������񣨲���1����¼��������2����ͷ��
        jScrollPane = new JScrollPane(table);
        add(jScrollPane,BorderLayout.CENTER);
        table.setEnabled(false); //���ò��ɱ༭
        table.getTableHeader().setReorderingAllowed(false); //���ñ����в���������
    }
    public static void main(String args[]){
        NotSign notSign = new NotSign();
        JFrame frame = new JFrame();
        frame.add(notSign);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400,400,400,400);
    }
}
