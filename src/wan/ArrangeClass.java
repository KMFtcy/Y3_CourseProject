package wan;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ArrangeClass extends JPanel {
    private ArrangeClass (){nsGUI();}
    private Vector<String> colHead; //����б���
    private Vector rows;            //��
    private JTable table;           //���
    private JScrollPane jScrollPane;//�������
    //private Vector<JButton> jButtons;     //����鿴��������

    private void nsGUI(){
        setLayout(new BorderLayout());
        table = new JTable();
        colHead = new Vector();
        rows = new Vector();
        //jButtons = new Vector();
        fillTable();

    }
    private  void fillTable(){
        colHead.clear();
        //�����������
        colHead.add("�γ�");
        colHead.add("�ο���ʦ");
        colHead.add("����ѧ��");
        //���ÿ��
        rows.clear();
        for(int i = 0;i < 10;i++){
            Vector currentRow = new Vector();//������ǰ�е�����
            //jButtons.add(new JButton("����鿴����"));  //��JButtons��������Ӱ�ť
            currentRow.addElement("��һ����");
            currentRow.addElement("xxxxx");
            currentRow.addElement("����鿴����");  ////////����������������¼�����
            rows.add(currentRow);//����ǰ�м���rows
        }
        table = new JTable(rows,colHead); //������񣨲���1����¼��������2����ͷ��
        jScrollPane = new JScrollPane(table);
        add(jScrollPane,BorderLayout.CENTER);
        table.setEnabled(false); //���ò��ɱ༭
        table.getTableHeader().setReorderingAllowed(false); //���ñ����в���������
    }
    public static void main(String args[]){
        ArrangeClass arrangeClass = new ArrangeClass();
        JFrame frame = new JFrame();
        frame.add(arrangeClass);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400,400,400,400);
    }
}
