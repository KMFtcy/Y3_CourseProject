package Gui.Manage;
import bean.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ToolT {
    public JCheckBox jck;
    public JLabel jln;//����
    public JLabel jlno;//���
    public JLabel jlc;//��Ŀ
    public JLabel jlt;//����ʱ��
    public JPanel JPanel(Teacher teacher) {
        JPanel jp = new JPanel();
        jck = new JCheckBox();
        jln = new JLabel(teacher.getName());
        jlno = new JLabel(String.valueOf(teacher.getId()));
        jlc = new JLabel(teacher.getSex());
        jlt = new JLabel(teacher.getTime());
        jp.setLayout(new GridLayout(1,4));
        jp.add(jck);
        jp.add(jln);
        jp.add(jlno);
        jp.add(jlt);
        jp.add(jlc);
        jp.setBorder(BorderFactory.createEtchedBorder());
        //jp.addMouseListener(new mouseTwice());
        return jp;
    }

    //˫���¼�
//    public class mouseTwice extends MouseAdapter {
//
//        public void mouseClicked(MouseEvent e) {
//            int clickTime = e.getClickCount();
//            if(clickTime == 2) {
//                DetailT inf = new DetailT();
//                inf.setVisible(true);
//                inf.setLocationRelativeTo(null);
//            }
//        }
//    }
}