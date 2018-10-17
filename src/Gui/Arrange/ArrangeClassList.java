package Gui.Arrange;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ArrangeClassList extends JFrame {
    ArrangeClassList(){
        nsGUI();
        setVisible(true);
        setBounds(400,400,400,400);
    }
    private Vector<String> colHead; //表格列标题
    private Vector rows;            //行
    private JTable table;           //表格
    private JScrollPane jScrollPane;//滚动面板
    //private Vector<JButton> jButtons;     //点击查看名单数组

    private void nsGUI(){
        setLayout(new BorderLayout());
        table = new JTable();
        colHead = new Vector();
        rows = new Vector();
        //jButtons = new Vector();
        fillTable();

    }
    private  void fillTable() {
        colHead.clear();
        //向表格填充首行
        colHead.add("学生姓名");
        colHead.add("学生id");
        colHead.add("性别");
        //填充每行
        rows.clear();
        for (int i = 0; i < 10; i++) {
            Vector currentRow = new Vector();//创建当前行的数据
            //jButtons.add(new JButton("点击查看名单"));  //向JButtons数组中添加按钮
            currentRow.addElement("朱子乐");
            currentRow.addElement("0000000");
            currentRow.addElement("男");  ////////点击名单添加鼠标点击事件监听
            rows.add(currentRow);//将当前行加入rows
        }
        table = new JTable(rows, colHead); //创建表格（参数1：记录集；参数2：表头）
        jScrollPane = new JScrollPane(table);
        add(jScrollPane, BorderLayout.CENTER);
        table.setEnabled(false); //设置不可编辑
        table.getTableHeader().setReorderingAllowed(false); //设置标题行不允许被调换
    }
}
