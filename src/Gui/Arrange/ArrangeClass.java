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

    private Vector<String> colHead; //表格列标题
    private Vector<Vector<java.io.Serializable>> rows;            //行
    private JTable table;           //表格
    private JScrollPane jScrollPane;//滚动面板
    //private Vector<JButton> jButtons;     //点击查看名单数组

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
                            (String)table.getValueAt(c,0));//创建一个学生详细信息窗口
                }else return;
            }
        });

    }

    private void fillTable() {
        colHead.clear();
        colHead.add("课程");
        colHead.add("任课老师");
        colHead.add("报名学生");
        //填充每行
        rows.clear();
        for (int i = 0; i < 10; i++) {
            Vector<java.io.Serializable> currentRow = new Vector<>();//创建当前行的数据
            currentRow.add("高一语文");
            currentRow.add("xxxxx");
            currentRow.add("点击查看学生名单");
            rows.add(currentRow);
        }



        table = new JTable(rows, colHead); //创建表格（参数1：记录集；参数2：表头）
        jScrollPane = new JScrollPane(table);
        add(jScrollPane, BorderLayout.CENTER);
        table.getTableHeader().setReorderingAllowed(false); //设置标题行不允许被调换
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