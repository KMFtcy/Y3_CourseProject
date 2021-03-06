package Gui.Manage;

import DAO.CourseDaoImpl;
import DAO.SignOnDaoImpl;
import Gui.App;
import bean.Course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

/**
 * 课程信息浏览功能
 *
 */
public class CInformation extends JPanel {

    private JButton jbs;        //搜索按钮
    private JButton jba;        //添加按钮
    private JButton jbBack;     //返回按钮
    private JButton jbd;        //删除按钮
    private JTextField jtfs;    //搜索文本框
    private JPanel jpm;         //主要显示区域
    private JLabel CourseName;         //课程名标签
    //private JLabel[] jlns;      //姓名标签数组
    private JLabel CourseID;        //课程编号标签
   // private JLabel[] jlnos;       //编号标签数组
    private JLabel CourseTeacher;         //任课教师标签
    //private JLabel[] jlts;        //学生类型数组
    private JLabel CourseCost;         //课时费标签
   // private JLabel[] jlss;        //入学时间数组
    private JCheckBox jcka;     //全选复选框
    //private Vector<JCheckBox> boxVector;
    //private JCheckBox[] boxes;  //复选框数组
    //private JPanel[] jPanels;   //学生标签
    private JPanel jpn;         //上方搜索pane
    private JPanel jpso;         //下方按钮

    private List<Course> courseList;

    public CInformation(){
        intGUI();
    }

    private void intGUI(){
        setLayout(new BorderLayout());
        ToolC tool = new ToolC();//创建一个工具类用来创建jpanel
        //设置标签
        jbs = new JButton("搜索");
        jbd = new JButton("删除");
        jbBack = new JButton("返回");
        jba = new JButton("添加");
        jtfs = new JTextField(20);
        jpm = new JPanel();
        CourseName = new JLabel("课程名称");
        CourseID = new JLabel("课程编号");
        CourseTeacher = new JLabel("任课老师");
        CourseCost = new JLabel("课时费（次）");
        jcka = new JCheckBox("全选");

        courseList = SignOnDaoImpl.getCourseAll();
        /*jlns = new JLabel[40];
        for(int i = 0; i < 40; i++) {
            jlns[i] = new JLabel("ssss");
        }
        jlnos = new JLabel[40];
        for(int i = 0; i < 40; i++) {
            jlnos[i] = new JLabel("aaaa");
        }
        jlts = new JLabel[40];
        for(int i = 0; i < 40; i++) {
            jlts[i] = new JLabel("bbbb");
        }
        jlss = new JLabel[40];
        for(int i = 0; i < 40; i++) {
            jlss[i] = new JLabel("cccc");
        }
        boxVector = new Vector<>();
        for(int i = 0; i < 40; i++) {
            boxVector.add(new JCheckBox());
        }
        boxes = new JCheckBox[20];
        for(int i = 0; i < 20; i++) {
            boxes[i] = new JCheckBox();
        }*/
        //每条信息的构建，调用tool方法
        Vector<JPanel> jPanelVector;
        jPanelVector = new Vector<>();
        for(int i = 0;i < courseList.size();i++){
            Course course = courseList.get(i);
            JPanel jPanel = tool.JPanel(course);
            jPanel.addMouseListener(new MouseListener() {

                @Override
                public void mouseReleased(MouseEvent arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mousePressed(MouseEvent arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mouseExited(MouseEvent arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mouseEntered(MouseEvent arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    int clickTime = e.getClickCount();
                    if(clickTime == 2) {
                        DetailC inf = new DetailC(course.getName());
                        inf.setVisible(true);
                        inf.setLocationRelativeTo(null);
                    }

                }
            });
            jPanelVector.add(jPanel);
        }
        //组织页面布局
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
        menu.add(CourseName);
        menu.add(CourseID);
        menu.add(CourseTeacher);
        menu.add(CourseCost);
        jpm.add(menu,BorderLayout.NORTH);
        //信息
        for(int i = 0; i < jPanelVector.size(); i++){
            /*jPanels[i].add(boxVector.get(i));
            jPanels[i].add(jlns[i]);
            jPanels[i].add(jlnos[i]);
            jPanels[i].add(jlts[i]);
            jPanels[i].add(jlss[i]);
            jPanels[i].setLayout(new GridLayout(1,5));*/
            jpmm.add(jPanelVector.get(i));
        }
        //总体布局
        add(jpn,BorderLayout.NORTH);
        add(jpso,BorderLayout.SOUTH);
        add(jpm,BorderLayout.CENTER);


        //为添加按钮实现功能
        jba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddC DC = new AddC();
                DC.setVisible(true);
                DC.setLocationRelativeTo(null);
                //实现添加窗口的确认功能
                DC.Comfirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        //DAO预留位置
                        ToolC tc = new ToolC();
                        //设置标签信息
                        Course course = new Course();
                        course.setName(DC.name.getText());
                        course.setCourseFee(Integer.parseInt(DC.Cost.getText()));
                        course.setCourseType(DC.Memo.getText());
                        course.setId(Integer.parseInt(DC.ID.getText()));
                        course.setTeacherId(Integer.parseInt(DC.Teacher.getText()));

                        CourseDaoImpl.addCourse(course);

                        JPanel jPanel = tc.JPanel(course);
                        jPanel.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                int clickTime = e.getClickCount();
                                if(clickTime == 2) {
                                    DetailC inf = new DetailC(course.getName());
                                    inf.setVisible(true);
                                    inf.setLocationRelativeTo(null);
                                }
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {

                            }

                            @Override
                            public void mouseExited(MouseEvent e) {

                            }
                        });
                        jPanelVector.add(jPanel);
                        jpmm.add(jPanel);
                        jpmm.revalidate();
                        jpmm.repaint();
                        jScrollPane.revalidate();
                        jScrollPane.repaint();
//                        jPanelVector.add(tc.JPanel());
//                        tc.jln.setText(DC.ID.getText());
//                        tc.jlno.setText(DC.name.getText());
//                        tc.jlts.setText(DC.Teacher.getText());
//                        tc.jls.setText(DC.Cost.getText());


//                        jpmm.add(jPanelVector.get(jPanelVector.size()-1));
//                        jpmm.revalidate();
                        DC.dispose();
                    }
                });
            }
        });
        //为全选添加事件监听
        jcka.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               for (int i = 0; i < jpmm.getComponentCount(); i++) {
                   if (jcka.isSelected()) {
                       Object object = jpmm.getComponent(i);
                       Object obj = ((JPanel) object).getComponent(0);
                       ((JCheckBox) obj).setSelected(true);
                   }else {
                       Object object = jpmm.getComponent(i);
                       Object obj = ((JPanel) object).getComponent(0);
                       ((JCheckBox) obj).setSelected(false);
                   }
               }
           }
        });
        //为删除添加事件监听
        jbd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(App.home, "确定删除？", "删除", JOptionPane.OK_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                boolean flag = false;
                int count = jPanelVector.size();
                for (int i = count-1; i >=0; i--) {{
                    Object obj = jPanelVector.get(i).getComponent(0);
                    if (obj instanceof JCheckBox) {
                        flag = ((JCheckBox) obj).isSelected();
                    }
                }
                    if (flag) {
                        Object object = jPanelVector.get(i).getComponent(2);
                        String temp = ((JLabel) object).getText();
                        int n = Integer.parseInt(temp);
                        CourseDaoImpl .deleteById(n);
                        System.out.print(n);
                        jpmm.remove(jPanelVector.get(i));
                        jPanelVector.remove(i);
                        count--;
                        jcka.setSelected(false);
                    }
                }
                jpmm.repaint();
                jpmm.revalidate();
                jScrollPane.validate();
                jScrollPane.repaint();
                } else {
                    jpmm.repaint();
                    jpmm.revalidate();
                    jScrollPane.validate();
                    jScrollPane.repaint();
                }
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
                        Object object = jPanelVector.get(i).getComponent(1);  //获取姓名与搜索文本进行对比
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
                    jScrollPane.validate();
                    jScrollPane.repaint();
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
                jScrollPane.validate();
                jScrollPane.repaint();
            }
        });


    }
}