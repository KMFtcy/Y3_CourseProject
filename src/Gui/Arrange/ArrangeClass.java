package Gui.Arrange;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import DAO.CourseDaoImpl;
import DAO.ScheduleDaoImpl;
import DAO.StudentDaoImpl;
import DAO.TeacherDaoImpl;
import bean.ScheduleRecord;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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

    public void fillTable() {
        colHead.clear();
        colHead.add("�γ�");
        colHead.add("����ѧ��");
        colHead.add("�ο���ʦ");
        //���ÿ��
        rows.clear();
        ArrayList<ScheduleRecord> ScheduleRecordList = (ArrayList) ScheduleDaoImpl.getAll();
        for (ScheduleRecord i:ScheduleRecordList) {
            Vector<java.io.Serializable> currentRow = new Vector<>();//������ǰ�е�����
            currentRow.add(CourseDaoImpl.findById(i.getCourseId()).getName());
            currentRow.add(StudentDaoImpl.findById(i.getStudentId()).getName());
            currentRow.add(TeacherDaoImpl.findById(i.getTeacherId()).getName());
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