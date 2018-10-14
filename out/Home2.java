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
    //�˵�
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
        // �������˵�
        Jmb = new JMenuBar();

        // ���������á��˵�����˵���
        mnuSet = new JMenu("ϵͳ����[S]");
        mnuSet.setMnemonic(KeyEvent.VK_S);
        mniSetCollegeInfo = new JMenuItem("ѧУ��Ϣ");
        mniSetStatusBar = new JMenuItem("״̬����Ϣ");
        mniChangePassword = new JMenuItem("�޸�����");
        mniExit = new JMenuItem("�˳�ϵͳ");

        // �������������˵�����˵���
        mnuOperate = new JMenu("���ݲ���[O]");
        mnuOperate.setMnemonic(KeyEvent.VK_O);
        mniAddStudent = new JMenuItem("����ѧ�����¼");
        mnuDelStu = new JMenu("ɾ��ѧ�����¼");
        mniEditStudent = new JMenuItem("�༭ѧ�����¼");
        mniBrowseStudent = new JMenuItem("���ѧ�����¼");

        // ������ɾ��ѧ�����¼�����Ӳ˵�
        mniDelStudentById = new JMenuItem("��ѧ��ɾ��");
        mniDelStudentsByClass = new JMenuItem("���༶ɾ��");
        mniDelStudentsByDepartment = new JMenuItem("��ϵ��ɾ��");

        // ��������ѯ���˵�����˵���
        mnuFind = new JMenu("��ѯѧ��[Q]");
        mnuFind.setMnemonic(KeyEvent.VK_Q);
        mniFindStudentById = new JMenuItem("��ѧ�Ų�ѯ");
        mniFindStudentsByName = new JMenuItem("��������ѯ");
        mniFindStudentsByClass = new JMenuItem("���༶��ѯ");
        mniFindStudentsByDepartment = new JMenuItem("��ϵ����ѯ");

        // ������ͳ�ơ��˵�����˵���
        mnuCount = new JMenu("����ͳ��[C]");
        mnuCount.setMnemonic(KeyEvent.VK_C);
        mniCountStudentsBySex = new JMenuItem("���Ա�ͳ��");
        mniCountStudentsByClass = new JMenuItem("���༶ͳ��");
        mniCountStudentsByDepartment = new JMenuItem("��ϵ��ͳ��");

        // �������������˵�����˵���
        mnuHelp = new JMenu("����[H]");
        mnuHelp.setMnemonic(KeyEvent.VK_H);
        mniHelp = new JMenuItem("����");
        mniAbout = new JMenuItem("����");

        // ����ͼ�����
        imgCollege = new ImageIcon("images/college.png");
        imgPassword = new ImageIcon("images/password.png");
        imgQuery = new ImageIcon("images/query.png");
        imgBrowse = new ImageIcon("images/browse.png");
        imgCount = new ImageIcon("images/count.png");
        imgExit = new ImageIcon("images/exit.png");

        // ����������
        toolbar = new JToolBar();
        btnSetCollege = new JButton("����ѧУ", imgCollege);
        btnSetCollege.setToolTipText("����ѧУ��Ϣ");
        btnSetCollege.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnSetCollege.setHorizontalTextPosition(AbstractButton.CENTER);
        btnChangePassword = new JButton("�޸�����", imgPassword);
        btnChangePassword.setToolTipText("�޸��û�����");
        btnChangePassword.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnChangePassword.setHorizontalTextPosition(AbstractButton.CENTER);
        btnBrowseStudent = new JButton("���ѧ��", imgBrowse);
        btnBrowseStudent.setToolTipText("���ѧ����¼");
        btnBrowseStudent.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnBrowseStudent.setHorizontalTextPosition(AbstractButton.CENTER);
        btnFindStudentById = new JButton("��ѯѧ��", imgQuery);
        btnFindStudentById.setToolTipText("��ѧ�Ų�ѯѧ����¼");
        btnFindStudentById.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnFindStudentById.setHorizontalTextPosition(AbstractButton.CENTER);
        btnCoutByDepartment = new JButton("ͳ������", imgCount);
        btnCoutByDepartment.setToolTipText("��ϵ��ͳ��ѧ������");
        btnCoutByDepartment.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnCoutByDepartment.setHorizontalTextPosition(AbstractButton.CENTER);
        btnExit = new JButton("�˳�ϵͳ", imgExit);
        btnExit.setToolTipText("�˳�ϵͳ");
        btnExit.setVerticalTextPosition(AbstractButton.BOTTOM);
        btnExit.setHorizontalTextPosition(AbstractButton.CENTER);
        toolbar.add(btnSetCollege);
        toolbar.add(btnChangePassword);
        toolbar.add(btnBrowseStudent);
        toolbar.add(btnFindStudentById);
        toolbar.add(btnCoutByDepartment);
        toolbar.add(btnExit);

        // �������
        panel = (JPanel) getContentPane();
        pnlMain = new JPanel();
        pnlStatus = new JPanel();
        pnlStatus.setLayout(new GridLayout(1, 5));

        // ��������ͼƬ
        imgBackground = new ImageIcon("images/background.jpg");

        // ����������ǩ
        lblBackground = new JLabel(imgBackground);



        // ���ò˵���
        setJMenuBar(Jmb);
        // ��ӡ����á��˵�
        Jmb.add(mnuSet);
        mnuSet.add(mniSetCollegeInfo);
        mnuSet.add(mniSetStatusBar);
        mnuSet.add(mniChangePassword);
        mnuSet.addSeparator();
        mnuSet.add(mniExit);

        // ��ӡ�ɾ��ѧ�����¼���˵�
        mnuDelStu.add(mniDelStudentById);
        mnuDelStu.add(mniDelStudentsByClass);
        mnuDelStu.add(mniDelStudentsByDepartment);

        // ��ӡ��������˵�
        Jmb.add(mnuOperate);
        mnuOperate.add(mniAddStudent);
        mnuOperate.add(mniEditStudent);
        mnuOperate.add(mnuDelStu);
        mnuOperate.add(mniBrowseStudent);

        // ��ӡ���ѯ���˵�
        Jmb.add(mnuFind);
        mnuFind.add(mniFindStudentById);
        mnuFind.add(mniFindStudentsByName);
        mnuFind.add(mniFindStudentsByClass);
        mnuFind.add(mniFindStudentsByDepartment);

        // ��ӡ�ͳ�ơ��˵�
        Jmb.add(mnuCount);
        mnuCount.add(mniCountStudentsBySex);
        mnuCount.add(mniCountStudentsByClass);
        mnuCount.add(mniCountStudentsByDepartment);

        // ��ӡ��������˵�
        Jmb.add(mnuHelp);
        mnuHelp.add(mniHelp);
        mnuHelp.add(mniAbout);

        // ������
        panel.setLayout(new BorderLayout());
        panel.add(toolbar, "North");
        panel.add(pnlMain, "Center");
        panel.add(pnlStatus, "South");
        pnlMain.add(lblBackground);

        // �ǹ���Ա��������״̬��


        setStatusBar(); // ����״̬����Ϣ

        // ���ô�������
        setSize(800, 640);
        setVisible(true);
        setLocationRelativeTo(null);

        // �رմ��ڵ����¼�
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitSystem();
            }
        });

        // ���ò˵�

        // ���˳�ϵͳ���˵�����¼�
        mniExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });

        // ��ѯ�˵�
        // ����ѧ�Ų�ѯ���˵�����¼�
        mniFindStudentById.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindStudentByIdFrame("��ѧ�Ų�ѯѧ����¼");
            }
        });




    protected void exitSystem() {
        int choice = JOptionPane.showConfirmDialog(null, "���Ƿ�Ҫ�˳�ϵͳ��", "ѧ����Ϣ����ϵͳ", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            // �رյ�ǰ����
            dispose();
            App.home = new Home("ѧ����Ϣ����ϵͳ" );
        }

    }
}
