package Gui.Manage;
import Gui.App;
import Gui.Home;
import javafx.beans.binding.ObjectBinding;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;
import javax.swing.*;

/**
 * 学生信息浏览功能         tool 工具的jpanel的构建需要有参数，参数为在学生类中读取的学生的姓名
 */
public class SInformation extends JPanel {

    private JButton jbs;        //搜索按钮
    private JButton jba;        //添加按钮
    private JButton jbd;        //删除按钮
    private JButton jbBack;     //返回按钮
    private JTextField jtfs;    //搜索文本框
    private JPanel jpm;         //主要显示区域
    private JLabel jln;         //姓名标签
    private JLabel jlno;        //编号标签
    private JLabel jlt;         //学生类型
    private JLabel jls;         //入学时间
    private JCheckBox jcka;     //全选复选框
    private JPanel jpn;         //上方搜索pane
    private JPanel jpso;         //下方按钮
    public SInformation(){
        intGUI();
    }


    private void intGUI(){
        setLayout(new BorderLayout());
        ToolS tool  = new ToolS();
        jbs = new JButton("搜索");
        jbd = new JButton("删除");
        jba = new JButton("添加");
        jbBack = new JButton("返回");
        jtfs = new JTextField(20);
        jpm = new JPanel();
        jln = new JLabel("姓名");
        jlno = new JLabel("编号");
        jlt = new JLabel("学生类型");
        jls = new JLabel("入学时间");
        jcka = new JCheckBox("全选");
        Vector<JPanel> jPanelVector;
        jPanelVector = new Vector<>();
        //重要的jpanel设置  //此处i应被替换为数据库中读取的学生的列表的长度
        for(int i = 0;i < 40;i++){
            String name = "sdsfdsfsa";   //此处name应为学生类中读取的学生姓名
            jPanelVector.add(tool.JPanel("sdsfdsaf"));
        }
        //上方pane
        jpn = new JPanel();
        jpn.add(jtfs);
        jpn.add(jbs);
        jpn.add(jbBack);
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
       for(int i = 0; i < jPanelVector.size(); i++){   //此处的i应小于studentlist的长度
           jpmm.add(jPanelVector.get(i));
        }
        //总体布局
        add(jpn,BorderLayout.NORTH);
        add(jpso,BorderLayout.SOUTH);
        add(jpm,BorderLayout.CENTER);


        //为添加按钮添加事件监听
        jba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddS DS = new AddS();
                DS.setVisible(true);
                DS.setLocationRelativeTo(null);
                //实现添加窗口的确认功能
                DS.Comfirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        //DAO预留位置
                        ToolS ts = new ToolS();
                        //设置标签信息
                        jPanelVector.add(ts.JPanel("sssss"));
                        ts.jln.setText(DS.Name.getText());
                        ts.jlno.setText(DS.ID.getText());
                        ts.jlc.setText(DS.StudentType.getText());
                        ts.jlt.setText(DS.RegistTime.getText());

                        jpmm.add(jPanelVector.get(jPanelVector.size()-1));
                        jpmm.revalidate();
                        DS.dispose();
                    }
                });
            }
        });

        //实现全选按钮功能
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

        //为搜索添加事件监听
        jbs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jtfs.getText().trim();
                if(!name.equals("")){
                    Vector <Integer>temp = new Vector();
                    for(int i = jPanelVector.size()-1; i >=0; i--){
                        Object object = jPanelVector.get(1).getComponent(1);  //获取姓名与搜索文本进行对比
                        if(name.equals(((JLabel) object).getText())){   //保存符合要求的jpanel序号
                            temp.add(i);
                        }
                    }
                    jpmm.removeAll();
                    for(int i = 0;i <temp.size();i++){
                        jpmm.add(jPanelVector.get(temp.get(i)));
                    }
                    jpmm.validate();
                    jpmm.repaint();
                }else {
                    JOptionPane.showMessageDialog(App.home,"请输入学生姓名！","警告",JOptionPane.WARNING_MESSAGE);
                    jtfs.requestFocus();
                }
            }
        });
        //为返回添加事件监听
        jbBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < jPanelVector.size(); i++){   //此处的i应小于studentlist的长度
                    jpmm.add(jPanelVector.get(i));
                }
                jpmm.validate();
                jpmm.repaint();
            }
        });
    }
}
