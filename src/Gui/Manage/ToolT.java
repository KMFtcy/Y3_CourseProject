package Gui.Manage;
import javax.swing.*;
import java.awt.event.*;


public class ToolT {
    public JPanel JPanel(int i) {
        int a = i;
        JPanel jp = new JPanel();
        jp.setBorder(BorderFactory.createEtchedBorder());
        jp.addMouseListener(new mouseTwice());
        return jp;
    }


    //Ë«»÷ÊÂ¼þ
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