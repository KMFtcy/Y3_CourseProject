package Gui.Manage;

import Gui.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class TInformation extends JPanel {
    private JButton jbs;        //������ť
    private JButton jba;        //��Ӱ�ť
    private JButton jbd;        //ɾ����ť
    private JButton jbBack;
    private JTextField jtfs;    //�����ı���
    private JPanel jpm;         //��Ҫ��ʾ����
    private JLabel jln;         //������ǩ
    private JLabel jlno;        //��ű�ǩ
    private JLabel jlt;         //��ʦ����
    private JLabel jls;         //��ѧʱ��
    private JCheckBox jcka;     //ȫѡ��ѡ��
    //private JPanel[] jPanels;   //ѧ����ǩ
    private JPanel jpn;         //�Ϸ�����pane
    private JPanel jpso;         //�·���ť
    public TInformation(){
        intGUI();
    }



    private void intGUI(){
        setLayout(new BorderLayout());
        ToolT tool = new ToolT();
        jbs = new JButton("����");
        jbd = new JButton("ɾ��");
        jba = new JButton("���");
        jbBack = new JButton("����");
        jtfs = new JTextField(20);
        jpm = new JPanel();
        jln = new JLabel("����");
        jlno = new JLabel("���");
        jlt = new JLabel("��ѧ��Ŀ");
        jls = new JLabel("����ʱ��");
        jcka = new JCheckBox("ȫѡ");
        Vector<JPanel> jPanelVector;
        jPanelVector = new Vector<>();
        for(int i = 0;i < 40;i++){
            jPanelVector.add(tool.JPanel());
        }
        //�Ϸ�pane
        jpn = new JPanel();
        jpn.add(jtfs);
        jpn.add(jbs);
        jpn.add(jbBack);
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
        for(int i = 0; i < jPanelVector.size(); i++){
            jpmm.add(jPanelVector.get(i));
        }
        //���岼��
        add(jpn,BorderLayout.NORTH);
        add(jpso,BorderLayout.SOUTH);
        add(jpm,BorderLayout.CENTER);


        //ʵ����Ӱ�ť����
        jba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddT DT = new AddT();
                DT.setVisible(true);
                DT.setLocationRelativeTo(null);
                //ʵ����Ӵ��ڵ�ȷ�Ϲ���
                DT.Comfirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        //DAOԤ��λ��
                        ToolT tt = new ToolT();
                        //���ñ�ǩ��Ϣ
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
        //Ϊȫѡ����¼�����
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
        //Ϊɾ������¼�����
        jbd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(App.home, "ȷ��ɾ����", "ɾ��", JOptionPane.OK_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    boolean flag = false;
                    int count = jPanelVector.size();
                    for (int i = count - 1; i >= 0; i--) {
                        {
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
                }else {
                    jpmm.repaint();
                    jpmm.revalidate();
                }
            }
        });


        //Ϊ��������¼�����
        jbs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jtfs.getText().trim();
                if(!name.equals("")){
                    Vector <Integer>temp = new Vector();
                    for(int i = jPanelVector.size()-1; i >=0; i--){
                        Object object = jPanelVector.get(1).getComponent(1);  //��ȡ�����������ı����жԱ�
                        if(name.equals(((JLabel) object).getText())){   //�������Ҫ���jpanel���
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
                    JOptionPane.showMessageDialog(App.home,"������ѧ��������","����",JOptionPane.WARNING_MESSAGE);
                    jtfs.requestFocus();
                }
            }
        });

        //Ϊ��������¼�����
        jbBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < jPanelVector.size(); i++){   //�˴���iӦС��studentlist�ĳ���
                    jpmm.add(jPanelVector.get(i));
                }
                jpmm.validate();
                jpmm.repaint();
            }
        });
    }
}