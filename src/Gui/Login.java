package Gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Login extends JFrame   {

    static {
        try {
            javax.swing.UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //�û���
    private String username;
    //����
    private String password;
    //�û�����ǩ
    private JLabel lblUsername;
    //�����ǩ
    private JLabel lblPassword;
    //�û����ı���
    private   JTextField txtUsername;
    //�����ı���
    private JPasswordField txtPassword;
    //��½��ť
    private JButton btnOK;
    //ȡ����ť
    private JButton btnCancel;
    //�����
    private JPanel panel;
    //��һ�����
    private JPanel panel1;
    //�ڶ������
    private JPanel panel2;
    //���������
    private JPanel panel3;
    //////////////////////////////////
    public static String userss;
    //���췽��
    private Login(String title) {
        super(title);
        // ���ó�ʼ�����淽��
        initGUI();
    }

    /**
     * ��ʼ������
     */
    private void initGUI() {



        // ʵ�����ؼ�
        lblUsername = new JLabel("�û�����");
        lblPassword = new JLabel("��  �룺");
        txtUsername = new JTextField("", 15);
        txtPassword = new JPasswordField("", 15);
        btnOK = new JButton("��½");
        btnCancel = new JButton("ȡ��");
        panel = (JPanel) getContentPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        /////////////////

        // ���������Ϊ���񲼾�
        panel.setLayout(new GridLayout(3, 1));
        // �����������ӵ������
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        // ���ؼ��ֱ���ӵ��������
        panel1.add(lblUsername);
        panel1.add(txtUsername);
        panel2.add(lblPassword);
        panel2.add(txtPassword);
        panel3.add(btnOK);
        panel3.add(btnCancel);

        // ���ô�����ؼ�����
        setSize(new Dimension(300,150)); // ���ô��ڴ�С
        setLocationRelativeTo(null);// �ô��ھ���
        setResizable(false); // ���ڲ��ɵ�����С
       // ʹ����ǡ���������
        setVisible(true); // �ô��ڿɼ�
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /*
         * ע�����������д�¼�������� ���������ڲ��෽ʽ��ʵ��
         */
        // ȷ����ť�����¼�
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        // ȡ����ť�����¼�
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        // �û����ı��򰴼��¼�
        txtUsername.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    txtPassword.requestFocus();
                }
            }
        });

        // �����ı��򰴼��¼�
        txtPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    login();
                }
            }
        });
    }

    /**
     * ��¼����
     */
    private void login() {
        //�̶��û���������
        String cuname = "123";
        String cpassword = "123";
        // ��ȡ�û���
        username = txtUsername.getText().trim();
        userss = txtUsername.getText();
        // ��ȡ����
        password = new String(txtPassword.getPassword());

        // �ж��Ƿ��¼�ɹ�
        //if (username.equals(cuname)  && password.equals(cpassword)) {
        if(true){
            // ���ص�¼����
            App.login.setVisible(false);
            // ��ʾ�û���¼�ɹ�
            JOptionPane.showMessageDialog(null, "��½�ɹ���",
                    "ѧУ����ϵͳ", JOptionPane.INFORMATION_MESSAGE);
            // ��ʾϵͳ������
            App.home = new Home("ѧ����Ϣ����ϵͳ" );
            // �ͷŵ�¼����
            App.login.dispose();
        } else {
            // ���ص�¼����
            App.login.setVisible(false);
            // ��ʾ�û���¼ʧ��
            JOptionPane.showMessageDialog(null, "�û���������������������룡", "ѧ����Ϣ����ϵͳ", JOptionPane.ERROR_MESSAGE);
            // ��ʾ��¼����
            App.login.setVisible(true);
            //��ʼ���û���������
            txtUsername.selectAll();
            txtPassword.selectAll();
            // �û����ı����ȡ����
            txtUsername.requestFocus();
        }
    }

    public static void main(String[] args) {
        // ����Ӧ�ó����¼����
        App.login = new Login("��¼");
        App.status = new Status();
        Font font = new Font("����",Font.PLAIN,15);

    }
}

