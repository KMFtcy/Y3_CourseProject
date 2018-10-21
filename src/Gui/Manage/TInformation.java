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
    private JLabel jlno;        //编号标签
    private JLabel jlt;         //教师类型
    private JLabel jls;         //入学时间
    private JCheckBox jcka;     //全选复选框
    //private JPanel[] jPanels;   //学生标签
    private JPanel jpn;         //上方搜索pane
    private JPanel jpso;         //下方按钮
    public TInformation(){
        intGUI();
    }



    private void intGUI(){
        setLayout(new BorderLayout());
        ToolT tool = new ToolT();
        jbs = new JButton("搜索");
        jbd = new JButton("删除");
        jba = new JButton("添加");
        jtfs = new JTextField(20);
        jpm = new JPanel();
        jln = new JLabel("姓名");
        jlno = new JLabel("编号");
        jlt = new JLabel("教学科目");
        jls = new JLabel("加入时间");
        jcka = new JCheckBox("全选");
        Vector<JPanel> jPanelVector;
        jPanelVector = new Vector<>();
        for(int i = 0;i < 40;i++){
            jPanelVector.add(tool.JPanel());
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
        for(int i = 0; i < jPanelVector.size(); i++){
            jpmm.add(jPanelVector.get(i));
        }
        //总体布局
        add(jpn,BorderLayout.NORTH);
        add(jpso,BorderLayout.SOUTH);
        add(jpm,BorderLayout.CENTER);


        //实现添加按钮功能
        jba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddT DT = new AddT();
                DT.setVisible(true);
                DT.setLocationRelativeTo(null);
                //实现添加窗口的确认功能
                DT.Comfirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        //DAO预留位置
                        ToolT tt = new ToolT();
                        //设置标签信息
                        jPanelVector.add(tt.JPanel());
                        tt.jln.setText(DT.Name.getText());
                        tt.jlno.setText(DT.ID.getText());
                        tt.jlc.setText(DT.CourseType.getText());
                        tt.jlt.setText(DT.RegistTime.getText());

                        jpmm.add(jPanelVector.get(jPanelVector.size()-1));
                        jpmm.revalidate();
                        DT.dispose();
                    }
                });
            }
        });
        //为全选添加事件监听
        jcka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < jPanelVector.size(); i++) {
                    if (jcka.isSelected()) {
                        Object obj = jPanelVector.get(i).getComponent(0);
                        ((JCheckBox) obj).setSelected(true);

                    } else {

                        Object obj = jPanelVector.get(i).getComponent(0);
                        ((JCheckBox) obj).setSelected(false);
                    }
                }
            }
        });
        //为删除添加事件监听
        jbd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;
                int count = jPanelVector.size();
                for (int i = count-1; i >=0; i--) {{
                    Object obj = jPanelVector.get(i).getComponent(0);
                    if (obj instanceof JCheckBox) {
                        flag = ((JCheckBox) obj).isSelected();
                    }
                }
                    if (flag) {
                        jpmm.remove(jPanelVector.get(i));
                        jPanelVector.remove(i);
                        count--;
                        jcka.setSelected(false);
                    }
                }
                jpmm.repaint();
                jpmm.revalidate();
            }
        });
    }
}