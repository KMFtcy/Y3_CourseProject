package Gui.Manage;
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
    public JPanel JPanel() {
        //�������
        /*Vector<JLabel> jlns = new Vector<>();//������ǩ����
        Vector<JLabel> jlnos = new Vector<>();//���
        Vector<JLabel> jlts = new Vector<>();//ѧ������
        Vector<JLabel> jlss = new Vector<>();//��ѧʱ��*/
        JPanel jp = new JPanel();
        ///////��JPanel���JLable    /////////�����ݿ��е���
        jck = new JCheckBox();
        jln = new JLabel("��");//�γ���
        jlno = new JLabel("1234");//��Ŀ����
        jlts = new JLabel("121");//��ʱ��
        jls = new JLabel("2018");//�ο���ʦ
        jp.setLayout(new GridLayout(1,4));
        //���������ӱ�ǩ
        jp.add(jck);
        jp.add(jln);
        jp.add(jlno);
        jp.add(jlts);
        jp.add(jls);
        //���ø�ʽ����Ӽ�����
        jp.setBorder(BorderFactory.createEtchedBorder());
        jp.addMouseListener(new mouseTwice());
        return jp;
    }

    //˫���¼�
    public class mouseTwice extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            int clickTime = e.getClickCount();
            if(clickTime == 2) {
                DetailC inf = new DetailC();
                inf.setVisible(true);
                inf.setLocationRelativeTo(null);
            }
        }
    }
}