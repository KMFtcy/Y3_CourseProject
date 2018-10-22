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
 * ѧ����Ϣ�������         tool ���ߵ�jpanel�Ĺ�����Ҫ�в���������Ϊ��ѧ�����ж�ȡ��ѧ�������������滻ΪID��
 */
public class SInformation extends JPanel {

    private JButton jbs;        //������ť
    private JButton jba;        //��Ӱ�ť
    private JButton jbd;        //ɾ����ť
    private JButton jbBack;     //���ذ�ť
    private JTextField jtfs;    //�����ı���
    private JPanel jpm;         //��Ҫ��ʾ����
    private JLabel jln;         //������ǩ
    private JLabel jlno;        //��ű�ǩ
    private JLabel jlt;         //ѧ������
    private JLabel jls;         //��ѧʱ��
    private JCheckBox jcka;     //ȫѡ��ѡ��
    private JPanel jpn;         //�Ϸ�����pane
    private JPanel jpso;         //�·���ť
    public SInformation(){
        intGUI();
    }


    private void intGUI(){
        setLayout(new BorderLayout());
        ToolS tool  = new ToolS();
        jbs = new JButton("����");
        jbd = new JButton("ɾ��");
        jba = new JButton("���");
        jbBack = new JButton("����");
        jtfs = new JTextField(20);
        jpm = new JPanel();
        jln = new JLabel("����");
        jlno = new JLabel("���");
        jlt = new JLabel("ѧ������");
        jls = new JLabel("��ѧʱ��");
        jcka = new JCheckBox("ȫѡ");
        Vector<JPanel> jPanelVector;
        jPanelVector = new Vector<>();
        //��Ҫ��jpanel����  //�˴�iӦ���滻Ϊ���ݿ��ж�ȡ��ѧ�����б�ĳ���
        for(int i = 0;i < 40;i++){
            String name = "sdsfdsfsa";   //�˴�nameӦΪѧ�����ж�ȡ��ѧ������
            jPanelVector.add(tool.JPanel("sdsfdsaf"));
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
       for(int i = 0; i < jPanelVector.size(); i++){   //�˴���iӦС��studentlist�ĳ���
           jpmm.add(jPanelVector.get(i));
        }
        //���岼��
        add(jpn,BorderLayout.NORTH);
        add(jpso,BorderLayout.SOUTH);
        add(jpm,BorderLayout.CENTER);


        //Ϊ��Ӱ�ť����¼�����
        jba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddS DS = new AddS();
                DS.setVisible(true);
                DS.setLocationRelativeTo(null);
                //ʵ����Ӵ��ڵ�ȷ�Ϲ���
                DS.Comfirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        //DAOԤ��λ��
                        ToolS ts = new ToolS();
                        //���ñ�ǩ��Ϣ
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

        //ʵ��ȫѡ��ť����
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
                            Object obj = jPanelVector.get(i).getComponent(0);  //��ȡÿ����ѡ��
                            if (obj instanceof JCheckBox) {
                                flag = ((JCheckBox) obj).isSelected();  //�鿴��ѡ���Ƿ�ѡ��
                            }
                        }
                        if (flag) {  //����ѡ����ɾ��
                            jpmm.remove(jPanelVector.get(i));
                            jPanelVector.remove(i);  //�Ƴ���Ӧ��jpanel
                            count--;                 //��Ҫ���ɾ�����ݿ�����
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
