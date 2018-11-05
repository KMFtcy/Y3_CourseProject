package Gui.Manage;
import DAO.TeacherDaoImpl;
import bean.Course;
import bean.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * �����Ϣ��jpanel�Ĺ�������
 */

public class ToolC {
    public JCheckBox jck;
    public JLabel jln;
    public JLabel jlno;
    public JLabel jlts;
    public JLabel jls;
    public JPanel JPanel(Course course) {
        //�������
        /*Vector<JLabel> jlns = new Vector<>();//������ǩ����
        Vector<JLabel> jlnos = new Vector<>();//���
        Vector<JLabel> jlts = new Vector<>();//ѧ������
        Vector<JLabel> jlss = new Vector<>();//��ѧʱ��*/
        JPanel jp = new JPanel();
        ///////��JPanel���JLable    /////////�����ݿ��е���
        jck = new JCheckBox();
        jln = new JLabel(course.getName());//�γ���
        jlno = new JLabel(String.valueOf(course.getId()));//�γ̱��
        jlts = new JLabel(String.valueOf(course.getCourseFee()));//��ʱ��
        Teacher teacher = TeacherDaoImpl.findById(course.getTeacherId());
        jls = new JLabel(teacher.getName());//�ο���ʦ
        jp.setLayout(new GridLayout(1,4));
        //���������ӱ�ǩ
        jp.add(jck);
        jp.add(jln);
        jp.add(jlno);
        jp.add(jls);
        jp.add(jlts);
        //���ø�ʽ����Ӽ�����
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
//                DetailC inf = new DetailC();
//                inf.setVisible(true);
//                inf.setLocationRelativeTo(null);
//            }
//        }
//    }
}