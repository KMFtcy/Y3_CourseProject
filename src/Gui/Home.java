package Gui;
import Gui.Arrange.ArrangeClass;
import Gui.Arrange.ArrangeMM;
import Gui.Finace.FinanceAdd;
import Gui.Finace.FinanceWindows;
import Gui.Manage.CInformation;
import Gui.Manage.SInformation;
import Gui.Manage.TInformation;
import Gui.Sign.SignIn;
import Gui.Sign.NotSign;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Home extends JFrame{
    //主界面
    JPanel JPMain;
    //状态栏
    private JMenuBar JMB;
    //管理菜单
    private JMenu JManage;
    private JMenuItem JMStudent;//学生管理
    private JMenuItem JMTeacher;//教师管理
    private JMenuItem JMCourse;//课程管理
    //签到
    private JMenu JSign;
    private JMenuItem JMSign;//签到
    private JMenuItem JMUsign;//未签到
    //财务
    private JMenu JFinace;
    private JMenuItem Check;//查看
    private JMenuItem JMAdd;//添加
    //排课
    private JMenu JFArr;
    private JMenuItem JMArr;//排课
    private JMenuItem JMCheck;//查看排课

    //构造方法
    public Home(String title){
        super(title);
        initGui();
    }

    //用户界面
    private void initGui(){
        JPMain = new JPanel();
        JMB = new JMenuBar();
        //管理
        JManage = new JMenu("管理");
        JMStudent = new JMenuItem("管理学生");
        JMTeacher = new JMenuItem("管理教师");
        JMCourse = new JMenuItem("管理课程");
        //签到
        JSign = new JMenu("签到");
        JMSign = new JMenuItem("签到管理");
        JMUsign = new JMenuItem("未签到人员名单");
        //财务
        JFinace = new JMenu("财务");
        Check = new JMenuItem("查看");
        JMAdd = new JMenuItem("添加");
        //排课
        JFArr = new JMenu("排课");
        JMArr = new JMenuItem("排课管理");
        JMCheck = new JMenuItem("查看");

        setJMenuBar(JMB);

        JMB.add(JManage);
        JManage.add(JMStudent);
        JManage.add(JMTeacher);
        JManage.add(JMCourse);

        JMB.add(JSign);
        JSign.add(JMSign);
        JSign.add(JMUsign);

        JMB.add(JFinace);
        JFinace.add(Check);
        JFinace.add(JMAdd);

        JMB.add(JFArr);
        JFArr.add(JMArr);
        JFArr.add(JMCheck);

        JPanel jPanel = new JPanel();
        CardLayout card = new CardLayout();
        jPanel.setLayout(card);
        setSize(1024,768);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        add(jPanel);
        //添加所有界面
        JPanel jjjj = new JPanel();//////////////以后可以用图片代替
        jPanel.add(jjjj);
        jPanel.add(new SInformation(),"1");
        jPanel.add(new ArrangeClass(),"2");
        jPanel.add(new FinanceAdd(),"3");
        jPanel.add(new NotSign(),"4");
        jPanel.add(new TInformation(),"6");
        jPanel.add(new CInformation(),"5");
        jPanel.add(new SignIn(),"7");
        jPanel.add(new FinanceWindows(),"9");
        jPanel.add(new ArrangeMM(),"10");
        //关闭窗口事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitSystem();
            }
        });
        //添加使用功能事件监听
        JMCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPanel,"2");
            }
        });
        JMStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPanel,"1");
            }
        });
        JMAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPanel,"3");
            }
        });
        JMUsign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPanel,"4");
            }
        });
        JMTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPanel,"6");
            }
        });
        JMCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPanel,"5");
            }
        });
        JMSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPanel,"7");
            }
        });

        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPanel,"9");
            }
        });
        JMArr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(jPanel,"10");
            }
        });
    }
    void exitSystem(){
        int ask = JOptionPane.showConfirmDialog(null,"确定退出系统","退出",JOptionPane.YES_NO_OPTION);
        if(ask == JOptionPane.YES_OPTION){
            System.exit(0);
        }else {
            dispose();
            App.home = new Home("学校管理系统");
        }
    }
}
