package Gui.Manage;
import bean.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *   ����һ����Ϣ��Ŀ
 */
public class ToolS {
	//public Student students = new Student();
    public JCheckBox jck;
    public JLabel jln;//����
    public JLabel jlno;//���
    public JLabel jlc;//��Ŀ
    public JLabel jlt;//����ʱ��
    public JPanel JPanel(Student student) {
    	//students = student ;
        JPanel jp = new JPanel();
        jck = new JCheckBox();
        jln = new JLabel(student.getName());
        jlno = new JLabel(String.valueOf(student.getId()));
        jlc = new JLabel(student.getGrade());
        jlt = new JLabel(student.getRegisteTime());
        jp.setLayout(new GridLayout(1,4));
        jp.add(jck);
        jp.add(jln);
        jp.add(jlno);
        jp.add(jlt);
        jp.add(jlc);
        jp.setBorder(BorderFactory.createEtchedBorder());
//        jp.addMouseListener(new mouseTwice());
        return jp;
    }


    //˫���¼�
//    public class mouseTwice extends MouseAdapter {
//
//        public void mouseClicked(MouseEvent e) {
//            int clickTime = e.getClickCount();
//            if(clickTime == 2) {
//                DetailS inf = new DetailS(jln.getText());
//                inf.setVisible(true);
//                inf.setLocationRelativeTo(null);
//            }
//        }
//    }
}