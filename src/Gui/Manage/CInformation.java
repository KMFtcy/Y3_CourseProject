package Gui.Manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CInformation extends JPanel {
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
    private JCheckBox[] boxes;  //复选框数组
    private JPanel[] jPanels;   //学生标签
    private JPanel jpn;         //上方搜索pane
    private JPanel jpso;         //下方按钮
    public CInformation(){
        intGUI();
    }



    private void intGUI(){
        setLayout(new BorderLayout());
        jbs = new JButton("搜索");
        jbd = new JButton("删除");
        jba = new JButton("添加");
        jtfs = new JTextField(20);
        jpm = new JPanel();
        jln = new JLabel("课程名");
        jlns = new JLabel[20];
        //为添加按钮实现功能
        jba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetailC DC = new DetailC();
                DC.setVisible(true);
                DC.setLocationRelativeTo(null);
            }
        });


        for(int i = 0; i < 20; i++) {
            jlns[i] = new JLabel("ssss");
        }
        jlno = new JLabel("科目类型");
        jlnos = new JLabel[20];
        for(int i = 0; i < 20; i++) {
            jlnos[i] = new JLabel("aaaa");
        }
        jlt = new JLabel("任课老师");
        jlts = new JLabel[20];
        for(int i = 0; i < 20; i++) {
            jlts[i] = new JLabel("bbbb");
        }
        jls = new JLabel("课时费（次）");
        jlss = new JLabel[20];
        for(int i = 0; i < 20; i++) {
            jlss[i] = new JLabel("cccc");
        }



        jcka = new JCheckBox("全选");
        boxes = new JCheckBox[20];
        for(int i = 0; i < 20; i++) {
            boxes[i] = new JCheckBox();
        }
        //boxVector = new Vector<>();
        jPanels = new JPanel[20];
        Tool tool = new Tool();
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
            jPanels[i].add(boxes[i]);
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
    }


}