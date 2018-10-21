package Gui.Manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * �γ���Ϣ�������
 *
 */
public class CInformation extends JPanel {

    private JButton jbs;        //������ť
    private JButton jba;        //��Ӱ�ť
    private JButton jbd;        //ɾ����ť
    private JTextField jtfs;    //�����ı���
    private JPanel jpm;         //��Ҫ��ʾ����
    private JLabel CourseName;         //�γ�����ǩ
    //private JLabel[] jlns;      //������ǩ����
    private JLabel CourseID;        //�γ̱�ű�ǩ
   // private JLabel[] jlnos;       //��ű�ǩ����
    private JLabel CourseTeacher;         //�ον�ʦ��ǩ
    //private JLabel[] jlts;        //ѧ����������
    private JLabel CourseCost;         //��ʱ�ѱ�ǩ
   // private JLabel[] jlss;        //��ѧʱ������
    private JCheckBox jcka;     //ȫѡ��ѡ��
    //private Vector<JCheckBox> boxVector;
    //private JCheckBox[] boxes;  //��ѡ������
    //private JPanel[] jPanels;   //ѧ����ǩ
    private JPanel jpn;         //�Ϸ�����pane
    private JPanel jpso;         //�·���ť
    public CInformation(){
        intGUI();
    }



    private void intGUI(){
        setLayout(new BorderLayout());
        ToolC tool = new ToolC();//����һ����������������jpanel
        //���ñ�ǩ
        jbs = new JButton("����");
        jbd = new JButton("ɾ��");
        jba = new JButton("���");
        jtfs = new JTextField(20);
        jpm = new JPanel();
        CourseName = new JLabel("�γ�����");
        CourseID = new JLabel("�γ̱��");
        CourseTeacher = new JLabel("�ο���ʦ");
        CourseCost = new JLabel("��ʱ�ѣ��Σ�");
        jcka = new JCheckBox("ȫѡ");
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
        //ÿ����Ϣ�Ĺ���������tool����
        Vector<JPanel> jPanelVector;
        jPanelVector = new Vector<>();
        for(int i = 0;i < 40;i++){
            jPanelVector.add(tool.JPanel());
        }
        //��֯ҳ�沼��
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
        menu.add(CourseName);
        menu.add(CourseID);
        menu.add(CourseTeacher);
        menu.add(CourseCost);
        jpm.add(menu,BorderLayout.NORTH);
        //��Ϣ
        for(int i = 0; i < jPanelVector.size(); i++){
            /*jPanels[i].add(boxVector.get(i));
            jPanels[i].add(jlns[i]);
            jPanels[i].add(jlnos[i]);
            jPanels[i].add(jlts[i]);
            jPanels[i].add(jlss[i]);
            jPanels[i].setLayout(new GridLayout(1,5));*/
            jpmm.add(jPanelVector.get(i));
        }
        //���岼��
        add(jpn,BorderLayout.NORTH);
        add(jpso,BorderLayout.SOUTH);
        add(jpm,BorderLayout.CENTER);


        //Ϊ��Ӱ�ťʵ�ֹ���
        jba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddC DC = new AddC();
                DC.setVisible(true);
                DC.setLocationRelativeTo(null);
                //ʵ����Ӵ��ڵ�ȷ�Ϲ���
                DC.Comfirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        //DAOԤ��λ��
                        ToolC tc = new ToolC();
                        //���ñ�ǩ��Ϣ
                        jPanelVector.add(tc.JPanel());
                        tc.jln.setText(DC.ID.getText());
                        tc.jlno.setText(DC.name.getText());
                        tc.jlts.setText(DC.Teacher.getText());
                        tc.jls.setText(DC.Cost.getText());


                        jpmm.add(jPanelVector.get(jPanelVector.size()-1));
                        jpmm.revalidate();
                        DC.dispose();
                    }
                });
            }
        });
        //Ϊȫѡ����¼�����
        jcka.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               for (int i = 0; i < jPanelVector.size(); i++) {
                   if (jcka.isSelected()) {
                       Object obj = jPanelVector.get(i).getComponent(0);
                       ((JCheckBox) obj).setSelected(true);
                   }else {
                           Object obj = jPanelVector.get(i).getComponent(0);
                           ((JCheckBox) obj).setSelected(false);
                   }
               }
           }
        });
        //Ϊɾ������¼�����
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