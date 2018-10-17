package Gui.Manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class TInformation extends JPanel {
    private JButton jbs;        //搜索按钮
    private JButton jba;        //添加按钮
    private JButton jbd;        //删除按钮
    private JTextField jtfs;    //搜索文本框
    private JPanel jpm;         //主要显示区域
    private JLabel jln;         //姓名标签
    private JLabel[] jlns;      //姓名标签数组
    private JLabel jlno;        //编号标签
    private JLabel[] jlnos;       //编号标签数组
    private JLabel jlt;         //学生类型
    private JLabel[] jlts;        //学生类型数组
    private JLabel jls;         //入学时间
    private JLabel[] jlss;        //入学时间数组
    private JCheckBox jcka;     //全选复选框
    private Vector<JCheckBox> boxVector;
    private JPanel[] jPanels;   //学生标签
    private JPanel jpn;         //上方搜索pane
    private JPanel jpso;         //下方按钮
    public TInformation(){
        intGUI();
    }



    private void intGUI(){
        setLayout(new BorderLayout());
        jbs = new JButton("搜索");
        jbd = new JButton("删除");
        jba = new JButton("添加");
        jtfs = new JTextField(20);
        jpm = new JPanel();
        jln = new JLabel("姓名");
        jlns = new JLabel[20];


        //实现添加按钮功能
        jba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetailT inf = new DetailT();
                inf.setVisible(true);
                inf.setLocationRelativeTo(null);
            }
        });
        for(int i = 0; i < 20; i++) {
            jlns[i] = new JLabel("ssss");
        }
        jlno = new JLabel("编号");
        jlnos = new JLabel[20];
        for(int i = 0; i < 20; i++) {
            jlnos[i] = new JLabel("aaaa");
        }
        jlt = new JLabel("教学科目");
        jlts = new JLabel[20];
        for(int i = 0; i < 20; i++) {
            jlts[i] = new JLabel("bbbb");
        }
        jls = new JLabel("加入时间");
        jlss = new JLabel[20];
        for(int i = 0; i < 20; i++) {
            jlss[i] = new JLabel("cccc");
        }
        jcka = new JCheckBox("全选");
        boxVector = new Vector<>();
        for(int i = 0; i < 20; i++){
            boxVector.add(new JCheckBox());
        }
        jPanels = new JPanel[20];
        ToolT tool = new ToolT();
        for(int i = 0;i < 20;i++){
            jPanels[i] = tool.JPanel(i);
        }
        //上方pane
        jpn = new JPanel();
        jpn.add(jtfs);
        jpn.add(jbs);
        //下方pane
        jpso = new JPanel();
        jpso.setLayout(new BorderLayout());
        jpso.add(jba,BorderLayout.EAST);
        jpso.add(jbd,BorderLayout.WEST);
        //主要区域
        jpm.setLayout(new BorderLayout());//主要区域边界使用Border布局
        //内部显示信息区域
        JPanel jpmm = new JPanel();
        jpmm.setLayout(new BoxLayout(jpmm,BoxLayout.Y_AXIS));   //纵向布局
        JScrollPane jScrollPane = new JScrollPane(jpmm);        //添加滚动条功能
        jpm.add(jScrollPane);
        //上方标题   姓名，编号等
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(1,5));
        menu.add(jcka);
        menu.add(jln);
        menu.add(jlno);
        menu.add(jls);
        menu.add(jlt);
        jpm.add(menu,BorderLayout.NORTH);
        //信息
        for(int i = 0; i < 20; i++){
            jPanels[i].add(boxVector.get(i));
            jPanels[i].add(jlns[i]);
            jPanels[i].add(jlnos[i]);
            jPanels[i].add(jlts[i]);
            jPanels[i].add(jlss[i]);
            jPanels[i].setLayout(new GridLayout(1,5));
            jpmm.add(jPanels[i]);
        }
        //总体布局
        add(jpn,BorderLayout.NORTH);
        add(jpso,BorderLayout.SOUTH);
        add(jpm,BorderLayout.CENTER);
        //为全选添加事件监听
        jcka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 20; i++){
                    if(jcka.isSelected() == true) {
                        boxVector.get(i).setSelected(true);
                    }else{
                        boxVector.get(i).setSelected(false);
                    }
                }
            }
        });
        //为删除添加事件监听
        jbd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 20; i++) {
                    if (boxVector.get(i).isSelected()) {
                        jpmm.remove(jPanels[i]);

                        jpmm.repaint();
                        jpmm.revalidate();
                        jcka.setSelected(false);

                    }
                }
            }
        });
    }
}