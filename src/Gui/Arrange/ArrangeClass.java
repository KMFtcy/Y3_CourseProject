package Gui.Arrange;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class ArrangeClass extends JPanel {
    public ArrangeClass() {
        nsGUI();
    }

    private Vector<String> colHead; //����б���
    private Vector<Vector<java.io.Serializable>> rows;            //��
    private JTable table;           //���
    private JScrollPane jScrollPane;//�������
    //private Vector<JButton> jButtons;     //����鿴��������

    private void nsGUI() {
        setLayout(new BorderLayout());
        table = new JTable();
        rows = new Vector<>();
        colHead = new Vector<>();
        //jButtons = new Vector();
        fillTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedColumn();
                int c = table.getSelectedRow();
                if(r == 2){
                    JFrame jFrame = new ArrangeClassList(
                            (String)table.getValueAt(c,0));//����һ��ѧ����ϸ��Ϣ����
                }else return;
            }
        });

    }

    private void fillTable() {
        colHead.clear();
        colHead.add("�γ�");
        colHead.add("�ο���ʦ");
        colHead.add("����ѧ��");
        //���ÿ��
        rows.clear();
        for (int i = 0; i < 10; i++) {
            Vector<java.io.Serializable> currentRow = new Vector<>();//������ǰ�е�����
            currentRow.add("��һ����");
            currentRow.add("xxxxx");
            currentRow.add("����鿴ѧ������");
            rows.add(currentRow);
        }



        table = new JTable(rows, colHead); //������񣨲���1����¼��������2����ͷ��
        jScrollPane = new JScrollPane(table);
        add(jScrollPane, BorderLayout.CENTER);
        table.getTableHeader().setReorderingAllowed(false); //���ñ����в���������
    }
    /*public static void main(String args[]){
        ArrangeClass arrangeClass = new ArrangeClass();
        JFrame frame = new JFrame();
        frame.add(arrangeClass);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400,400,400,400);
    }*/
}