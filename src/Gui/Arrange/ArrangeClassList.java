package Gui.Arrange;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ArrangeClassList extends JFrame {
    ArrangeClassList(String string){
        super(string);
        nsGUI();
        setVisible(true);
        setBounds(400,400,400,400);
        pack();
    }
    static String string;
    private Vector<String> colHead; //����б���
    private Vector<Vector<String>> rows;            //��
    private JTable table;           //���
    private JScrollPane jScrollPane;//�������

    //private Vector<JButton> jButtons;     //����鿴��������

    private void nsGUI(){

        setLayout(new BorderLayout());
        table = new JTable();
        colHead = new Vector<>();
        rows = new Vector<>();
        //jButtons = new Vector();
        fillTable();

    }
    private  void fillTable() {
        colHead.clear();
        //�����������
        colHead.add("ѧ������");
        colHead.add("ѧ��id");
        colHead.add("�Ա�");
        //���ÿ��
        rows.clear();
        for (int i = 0; i < 10; i++) {
            Vector<String> currentRow = new Vector<>();//������ǰ�е�����
            //jButtons.add(new JButton("����鿴����"));  //��JButtons��������Ӱ�ť
            currentRow.addElement("zzz");
            currentRow.addElement("0000000");
            currentRow.addElement("��");  ////////����������������¼�����
            rows.add(currentRow);//����ǰ�м���rows
        }
        table = new JTable(rows, colHead); //������񣨲���1����¼��������2����ͷ��
        jScrollPane = new JScrollPane(table);
        add(jScrollPane, BorderLayout.CENTER);
        table.setEnabled(false); //���ò��ɱ༭
        table.getTableHeader().setReorderingAllowed(false); //���ñ����в���������
    }
}
