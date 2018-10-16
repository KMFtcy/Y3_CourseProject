package Gui.Sign;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class NotSign extends JPanel {
    public NotSign(){nsGUI();}
    private Vector<String> colHead; //表格列标题
    private Vector rows;            //行
    private JTable table;           //表格
    private JScrollPane jScrollPane;//滚动面板


    private void nsGUI(){
        setLayout(new BorderLayout());
        table = new JTable();
        colHead = new Vector();
        rows = new Vector();
        fillTable();

    }
    private  void fillTable(){
        colHead.clear();
        //向表格填充首行
        colHead.add("姓名");
        colHead.add("科目");
        colHead.add("老师");
        colHead.add("时间");
        //填充每行
        rows.clear();
        for(int i = 0;i < 10;i++){
            Vector<String> currentRow = new Vector<String>();//创建当前行的数据
            currentRow.addElement("杨兆铭");
            currentRow.addElement("语文");
            currentRow.addElement("唐朝阳");
            currentRow.addElement("2018-10-10");
            rows.add(currentRow);//将当前行加入rows
        }
        table = new JTable(rows,colHead); //创建表格（参数1：记录集；参数2：表头）
        jScrollPane = new JScrollPane(table);
        add(jScrollPane,BorderLayout.CENTER);
        table.setEnabled(false); //设置不可编辑
        table.getTableHeader().setReorderingAllowed(false); //设置标题行不允许被调换
    }
    /*public static void main(String args[]){
        NotSign notSign = new NotSign();
        JFrame frame = new JFrame();
        frame.add(notSign);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400,400,400,400);
    }*/
}
