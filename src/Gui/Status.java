package Gui;

import javax.swing.*;
import java.awt.*;

import static Gui.Login.userss;

public class Status extends JPanel{
    private JLabel user ;
    private JLabel School;
    private JLabel Version;
    public Status(){
        gui();
    }
    public void gui(){
        user = new JLabel("�û�:     "+userss);
        School = new JLabel("ѧУ:"+"       ���ִ�ѧ");
        Version = new JLabel("�汾:"+"        1.0");
        this.setLayout(new GridLayout(1,3));
        add(user);
        add(School);
        add(Version);





    }
}
