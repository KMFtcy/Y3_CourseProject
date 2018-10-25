package Gui.Manage;
import bean.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *   创建一个信息条目
 */
public class ToolS {
	//public Student students = new Student();
    public JCheckBox jck;
    public JLabel jln;//姓名
    public JLabel jlno;//编号
    public JLabel jlc;//科目
    public JLabel jlt;//加入时间
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
        jp.add(jlc);
        jp.add(jlt);
        jp.setBorder(BorderFactory.createEtchedBorder());
//        jp.addMouseListener(new mouseTwice());
        return jp;
    }


    //双击事件
    public class mouseTwice extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            int clickTime = e.getClickCount();
            if(clickTime == 2) {
                DetailS inf = new DetailS(jln.getText());
                inf.setVisible(true);
                inf.setLocationRelativeTo(null);
            }
        }
    }
}