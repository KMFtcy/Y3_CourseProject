package Gui.Manage;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 */
public class Tool {
    public JPanel JPanel(int i) {
        int a = i;
        JPanel jp = new JPanel();
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