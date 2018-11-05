package Gui.Manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 添加课程信息窗口
 */
public class AddC extends JFrame implements ActionListener{

    JTextField name;//课程编号
    JTextField ID;//课程名称
    JTextField Teacher;//上课方式
    JTextField Cost;//任课教师
    JTextArea Memo;//备忘
    JButton Comfirm;//确认按钮
    JButton Cancel;//取消按钮


    public AddC(){
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        setComponent();
        this.setVisible(true);
    }
    public void setComponent() {
        //初始化这个窗口的各个组件元素，然后开始组装
        componentInitialize();
        //这个窗口的布局大概分为上下两个部分，其中上大概分为左、中、右、下四个部分
        //下就是放两个按钮
        JPanel Up = new JPanel();
        JPanel Down = new JPanel();
        JPanel UpArea = new JPanel();
        JPanel UpDown = new JPanel();
        //设置容器的布局Layout
        Up.setLayout(new BorderLayout());
        UpArea.setLayout(new GridLayout(2,4));
        UpDown.setLayout(new BorderLayout());
        Down.setLayout(new BorderLayout());
        //添加元素进容器
        UpArea.add(new JLabel("课程名称",JLabel.CENTER));
        UpArea.add(name);
        UpArea.add(new JLabel("课程编号",JLabel.CENTER));
        UpArea.add(ID);
        UpArea.add(new JLabel("任课老师",JLabel.CENTER));
        UpArea.add(Teacher);
        UpArea.add(new JLabel("课时费（次）",JLabel.CENTER));
        UpArea.add(Cost);
        UpDown.add(new JLabel("上课方式"),BorderLayout.WEST);
        UpDown.add(Memo,BorderLayout.CENTER);
        Down.add(Comfirm,BorderLayout.EAST);
        Down.add(Cancel,BorderLayout.WEST);
        //将子容器添加到相应父容器当中，组合
        add(Up,BorderLayout.CENTER);
        Up.add(UpArea,BorderLayout.SOUTH);
        add(Down,BorderLayout.SOUTH);
        Down.add(UpDown,BorderLayout.NORTH);
        pack();
    }
    public void componentInitialize() {
        name = new JTextField(20);
        ID = new JTextField(20);
        Teacher = new JTextField(20);
        Cost = new JTextField(20);
        Memo = new JTextArea(6,10);
        Memo.setLineWrap(true);
        Comfirm = new JButton("确认");
        Cancel = new JButton("取消");
        Cancel.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("取消")) {
            this.dispose();
        }
    }

}
