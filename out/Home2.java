/*
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Home2 extends JFrame {
    //菜单
    private JMenuBar Jmb;

    private JMenu mnuSet;
    private JMenuItem mniSetCollegeInfo;
    private JMenuItem mniSetStatusBar;
    private JMenuItem mniChangePassword;
    private JMenuItem mniExit;

    private JMenu mnuOperate;
    private JMenuItem mniAddStudent;
    private JMenuItem mniBrowseStudent;
    private JMenuItem mniEditStudent;

    private JMenu mnuDelStu;
    private JMenuItem mniDelStudentById;
    private JMenuItem mniDelStudentsByClass;
    private JMenuItem mniDelStudentsByDepartment;

    private JMenu mnuFind;
    private JMenuItem mniFindStudentById;
    private JMenuItem mniFindStudentsByName;
    private JMenuItem mniFindStudentsByClass;
    private JMenuItem mniFindStudentsByDepartment;

    private JMenu mnuCount;
    private JMenuItem mniCountStudentsBySex;
    private JMenuItem mniCountStudentsByClass;
    private JMenuItem mniCountStudentsByDepartment;

    private JMenu mnuHelp;
    private JMenuItem mniHelp;
    private JMenuItem mniAbout;


    private JPanel panel;
    private JPanel pnlMain;
    private JPanel pnlStatus;




    private JLabel lblBackground;


    private ImageIcon imgCollege;
    private ImageIcon imgExit;
    private ImageIcon imgPassword;
    private ImageIcon imgQuery;
    private ImageIcon imgBrowse;
    private ImageIcon imgCount;
    private ImageIcon imgBackground;


    private JToolBar toolbar;


    private JButton btnSetCollege;
    private JButton btnChangePassword;
    private JButton btnFindStudentById;
    private JButton btnExit;
    private JButton btnBrowseStudent;
    private JButton btnCoutByDepartment;


    public Home(String title) {
        super(title);
        initGUI();
    }

    private void initGUI() {
        // 创建主菜单
        Jmb = new JMenuBar();

        // 创建【设置】菜单及其菜单项
        mnuSet = new JMenu("系统设置[S]");
        mnuSet.setMnemonic(KeyEvent.VK_S);
        mniSetCollegeInfo = new JMenuItem("学校信息");
        mniSetStatusBar = new JMenuItem("状态栏信息");
        mniChangePassword = new JMenuItem("修改密码");
        mniExit = new JMenuItem("退出系统");

        // 创建【操作】菜单及其菜单项
        mnuOperate = new JMenu("数据操作[O]");
        mnuOperate.setMnemonic(KeyEvent.VK_O);
        mniAddStudent = new JMenuItem("增加学生表记录");
        mnuDelStu = new JMenu("删除学生表记录");
        mniEditStudent = new JMenuItem("编辑学生表记录");
        mniBrowseStudent = new JMenuItem("浏览学生表记录");

        // 创建【删除学生表记录】的子菜单
        mniDelStudentById = new JMenuItem("按学号删除");
        mniDelStudentsByClass = new JMenuItem("按班级删除");
        mniDelStudentsByDepartment = new JMenuItem("按系部删除");

        // 创建【查询】菜单及其菜单项
        mnuFind = new JMenu("查询学生[Q]");
        mnuFind.setMnemonic(KeyEvent.VK_Q);
        mniFindStudentById = new JMenuItem("按学号查询");
        mniFindStudentsByName = new JMenuItem("按姓名查询");
        mniFindStudentsByClass = new JMenuItem("按班级查询");
        mniFindStudentsByDepartment = new JMenuItem("按系部查询");

        // 创建【统计】菜单及其菜单项
        mnuCount = new JMenu("人数统计[C]");
        mnuCount.setMnemonic(KeyEvent.VK_C);
        mniCountStudentsBySex = new JMenuItem("按性别统计");
        mniCountStudentsByClass = new JMenuItem("按班级统计");
        mniCountStudentsByDepartment = new JMenuItem("按系部统计");

        // 创建【帮助】菜单及其菜单项
        mnuHelp = new JMenu("帮助[H]");
        mnuHelp.setMnemonic(KeyEvent.VK_H);
        mniHelp = new JMenuItem("帮助");
        mniAbout = new JMenuItem("关于");

        // 创建图标对象
        imgCollege = new ImageIcon("images/college.png");
        imgPassword = new ImageIcon("images/password.png");
        imgQuery = new ImageIcon("images/query.png");
        imgBrowse = new ImageIcon("images/browse.png");
        imgCount = new ImageIcon("images/count.png");
        imgExit = new ImageIcon("images/exit.png");

        // 创建工具栏
        toolbar = new JToolBar();
        btnSetCollege = new JButton("设置学校", imgCollege);
        btnSetCollege.setToolTipText("设置学校信息");
        btnSetCollege.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnSetCollege.setHorizontalTextPosition(AbstractButton.CENTER);
        btnChangePassword = new JButton("修改密码", imgPassword);
        btnChangePassword.setToolTipText("修改用户密码");
        btnChangePassword.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnChangePassword.setHorizontalTextPosition(AbstractButton.CENTER);
        btnBrowseStudent = new JButton("浏览学生", imgBrowse);
        btnBrowseStudent.setToolTipText("浏览学生记录");
        btnBrowseStudent.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnBrowseStudent.setHorizontalTextPosition(AbstractButton.CENTER);
        btnFindStudentById = new JButton("查询学生", imgQuery);
        btnFindStudentById.setToolTipText("按学号查询学生记录");
        btnFindStudentById.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnFindStudentById.setHorizontalTextPosition(AbstractButton.CENTER);
        btnCoutByDepartment = new JButton("统计人数", imgCount);
        btnCoutByDepartment.setToolTipText("按系部统计学生人数");
        btnCoutByDepartment.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnCoutByDepartment.setHorizontalTextPosition(AbstractButton.CENTER);
        btnExit = new JButton("退出系统", imgExit);
        btnExit.setToolTipText("退出系统");
        btnExit.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnExit.setHorizontalTextPosition(AbstractButton.CENTER);
        toolbar.add(btnSetCollege);
        toolbar.add(btnChangePassword);
        toolbar.add(btnBrowseStudent);
        toolbar.add(btnFindStudentById);
        toolbar.add(btnCoutByDepartment);
        toolbar.add(btnExit);

        // 创建面板
        panel = (JPanel) getContentPane();
        pnlMain = new JPanel();
        pnlStatus = new JPanel();
        pnlStatus.setLayout(new GridLayout(1, 5));

        // 创建背景图片
        imgBackground = new ImageIcon("images/background.jpg");

        // 创建背景标签
        lblBackground = new JLabel(imgBackground);



        // 设置菜单栏
        setJMenuBar(Jmb);
        // 添加【设置】菜单
        Jmb.add(mnuSet);
        mnuSet.add(mniSetCollegeInfo);
        mnuSet.add(mniSetStatusBar);
        mnuSet.add(mniChangePassword);
        mnuSet.addSeparator();
        mnuSet.add(mniExit);

        // 添加【删除学生表记录】菜单
        mnuDelStu.add(mniDelStudentById);
        mnuDelStu.add(mniDelStudentsByClass);
        mnuDelStu.add(mniDelStudentsByDepartment);

        // 添加【操作】菜单
        Jmb.add(mnuOperate);
        mnuOperate.add(mniAddStudent);
        mnuOperate.add(mniEditStudent);
        mnuOperate.add(mnuDelStu);
        mnuOperate.add(mniBrowseStudent);

        // 添加【查询】菜单
        Jmb.add(mnuFind);
        mnuFind.add(mniFindStudentById);
        mnuFind.add(mniFindStudentsByName);
        mnuFind.add(mniFindStudentsByClass);
        mnuFind.add(mniFindStudentsByDepartment);

        // 添加【统计】菜单
        Jmb.add(mnuCount);
        mnuCount.add(mniCountStudentsBySex);
        mnuCount.add(mniCountStudentsByClass);
        mnuCount.add(mniCountStudentsByDepartment);

        // 添加【帮助】菜单
        Jmb.add(mnuHelp);
        mnuHelp.add(mniHelp);
        mnuHelp.add(mniAbout);

        // 添加面板
        panel.setLayout(new BorderLayout());
        panel.add(toolbar, "North");
        panel.add(pnlMain, "Center");
        panel.add(pnlStatus, "South");
        pnlMain.add(lblBackground);

        // 非管理员不能设置状态栏


        setStatusBar(); // 设置状态栏信息

        // 设置窗口属性
        setSize(800, 640);
        setVisible(true);
        setLocationRelativeTo(null);

        // 关闭窗口单击事件
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitSystem();
            }
        });

        // 设置菜单

        // 【退出系统】菜单项单击事件
        mniExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });

        // 查询菜单
        // 【按学号查询】菜单项单击事件
        mniFindStudentById.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindStudentByIdFrame("按学号查询学生记录");
            }
        });




    protected void exitSystem() {
        int choice = JOptionPane.showConfirmDialog(null, "你是否要退出系统？", "学生信息管理系统", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            // 关闭当前窗口
            dispose();
            App.home = new Home("学生信息管理系统" );
        }

    }
}
