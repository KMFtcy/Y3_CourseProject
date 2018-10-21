package Gui.Manage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 浏览信息的jpanel的构建方法
 */

public class ToolC {
    public JCheckBox jck;
    public JLabel jln;
    public JLabel jlno;
    public JLabel jlts;
    public JLabel jls;
    public JPanel JPanel() {
        //添加容器
        /*Vector<JLabel> jlns = new Vector<>();//姓名标签容器
        Vector<JLabel> jlnos = new Vector<>();//编号
        Vector<JLabel> jlts = new Vector<>();//学生类型
        Vector<JLabel> jlss = new Vector<>();//入学时间*/
        JPanel jp = new JPanel();
        ///////向JPanel添加JLable    /////////从数据库中导入
        jck = new JCheckBox();
        jln = new JLabel("张");//课程名
        jlno = new JLabel("1234");//科目类型
        jlts = new JLabel("121");//课时费
        jls = new JLabel("2018");//任课老师
        jp.setLayout(new GridLayout(1,4));
        //向面板中添加标签
        jp.add(jck);
        jp.add(jln);
        jp.add(jlno);
        jp.add(jlts);
        jp.add(jls);
        //设置格式并添加监听器
        jp.setBorder(BorderFactory.createEtchedBorder());
        jp.addMouseListener(new mouseTwice());
        return jp;
    }

    //双击事件
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