package Gui.Manage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 */
public class ToolS {
    public JCheckBox jck;
    public JLabel jln;//����
    public JLabel jlno;//���
    public JLabel jlc;//��Ŀ
    public JLabel jlt;//����ʱ��
    public JPanel JPanel(String name) {
        JPanel jp = new JPanel();
        jck = new JCheckBox();
        jln = new JLabel("B");
        jlno = new JLabel("23");
        jlc = new JLabel("math");
        jlt = new JLabel("2008");
        jp.setLayout(new GridLayout(1,4));
        jp.add(jck);
        jp.add(jln);
        jp.add(jlno);
        jp.add(jlc);
        jp.add(jlt);
        jp.setBorder(BorderFactory.createEtchedBorder());
        jp.addMouseListener(new mouseTwice());
        return jp;
    }


    //˫���¼�
    public class mouseTwice extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            int clickTime = e.getClickCount();
            if(clickTime == 2) {
                DetailS inf = new DetailS();
                inf.setVisible(true);
                inf.setLocationRelativeTo(null);
            }
        }
    }
}