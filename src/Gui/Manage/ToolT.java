package Gui.Manage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ToolT {
    public JCheckBox jck;
    public JLabel jln;//����
    public JLabel jlno;//���
    public JLabel jlc;//��Ŀ
    public JLabel jlt;//����ʱ��
    public JPanel JPanel() {
        JPanel jp = new JPanel();
        jck = new JCheckBox();
        jln = new JLabel("��ʮ��");
        jlno = new JLabel("66");
        jlc = new JLabel("����");
        jlt = new JLabel("2016");
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
                DetailT inf = new DetailT();
                inf.setVisible(true);
                inf.setLocationRelativeTo(null);
            }
        }
    }
}