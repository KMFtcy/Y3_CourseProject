package Gui.Manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CInformation extends JPanel {
    private JButton jbs;        //������ť
    private JButton jba;        //��Ӱ�ť
    private JButton jbd;        //ɾ����ť
    private JTextField jtfs;    //�����ı���
    private JPanel jpm;         //��Ҫ��ʾ����
    private JLabel jln;         //������ǩ
    private JLabel[] jlns;      //������ǩ����
    private JLabel jlno;        //��ű�ǩ
    private JLabel[] jlnos;       //��ű�ǩ����
    private JLabel jlt;         //ѧ������
    private JLabel[] jlts;        //ѧ����������
    private JLabel jls;         //��ѧʱ��
    private JLabel[] jlss;        //��ѧʱ������
    private JCheckBox jcka;     //ȫѡ��ѡ��
    private Vector<JCheckBox> boxVector;
    private JCheckBox[] boxes;  //��ѡ������
    private JPanel[] jPanels;   //ѧ����ǩ
    private JPanel jpn;         //�Ϸ�����pane
    private JPanel jpso;         //�·���ť
    public CInformation(){
        intGUI();
    }



    private void intGUI(){
        setLayout(new BorderLayout());
        jbs = new JButton("����");
        jbd = new JButton("ɾ��");
        jba = new JButton("���");
        jtfs = new JTextField(20);
        jpm = new JPanel();
        jln = new JLabel("�γ���");
        jlns = new JLabel[20];
        //Ϊ��Ӱ�ťʵ�ֹ���
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
        jlno = new JLabel("��Ŀ����");
        jlnos = new JLabel[20];
        for(int i = 0; i < 20; i++) {
            jlnos[i] = new JLabel("aaaa");
        }
        jlt = new JLabel("�ο���ʦ");
        jlts = new JLabel[20];
        for(int i = 0; i < 20; i++) {
            jlts[i] = new JLabel("bbbb");
        }
        jls = new JLabel("��ʱ�ѣ��Σ�");
        jlss = new JLabel[20];
        for(int i = 0; i < 20; i++) {
            jlss[i] = new JLabel("cccc");
        }



        jcka = new JCheckBox("ȫѡ");
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
        //�Ϸ�pane
        jpn = new JPanel();
        jpn.add(jtfs);
        jpn.add(jbs);
        //�·�pane
        jpso = new JPanel();
        jpso.setLayout(new BorderLayout());
        jpso.add(jba,BorderLayout.EAST);
        jpso.add(jbd,BorderLayout.WEST);
        //��Ҫ����
        jpm.setLayout(new BorderLayout());//��Ҫ����߽�ʹ��Border����
        //�ڲ���ʾ��Ϣ����
        JPanel jpmm = new JPanel();
        jpmm.setLayout(new BoxLayout(jpmm,BoxLayout.Y_AXIS));   //���򲼾�
        JScrollPane jScrollPane = new JScrollPane(jpmm);        //��ӹ���������
        jpm.add(jScrollPane);
        //�Ϸ�����   ��������ŵ�
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(1,5));
        menu.add(jcka);
        menu.add(jln);
        menu.add(jlno);
        menu.add(jls);
        menu.add(jlt);
        jpm.add(menu,BorderLayout.NORTH);
        //��Ϣ
        for(int i = 0; i < 20; i++){
            jPanels[i].add(boxes[i]);
            jPanels[i].add(jlns[i]);
            jPanels[i].add(jlnos[i]);
            jPanels[i].add(jlts[i]);
            jPanels[i].add(jlss[i]);
            jPanels[i].setLayout(new GridLayout(1,5));
            jpmm.add(jPanels[i]);
        }
        //���岼��
        add(jpn,BorderLayout.NORTH);
        add(jpso,BorderLayout.SOUTH);
        add(jpm,BorderLayout.CENTER);
    }


}