package Gui.Manage;
import bean.Student;
import java.awt.*;
import DAO.StudentDaoImpl;
import javax.swing.*;

public class DetailS extends AddS {
	public String names;
    public DetailS(String name){
    	super();
    	names = name;
    	CC();
    }

    @Override
    public void setComponent() {
        super.setComponent();
    }

    public void CC(){
        try {
            Image Dimage;
            ImageIcon DPhoto;
        	Student students = StudentDaoImpl.findByName(names).get(0);
            ID.setText(String.valueOf(students.getId()));
            Name.setText(students.getName());
            Gender.setText(students.getSex());
            StudentType.setText(students.getGrade());
            RegistTime.setText(students.getRegisteTime());
            PhoneNumber.setText(students.getPhone());
            Birthday.setText(students.getBirth());
            InChargeTeacher.setText(students.getInChargeTeacher());
            CardType.setText(students.getCerTypr());
            CardID.setText(students.getCerCode());
            Address.setText(students.getAddress());
            Email.setText(students.getEmail());
            Dimage = students.getPhoto();  //获取学生照片信息
            DPhoto = new ImageIcon(Dimage); //转换为ImageIcon类型
            JLabel Djlabel = new JLabel(DPhoto); //添加进Jlabel
            UpRightArea.removeAll();  //清空右上JPanel
            UpRightArea.add(Djlabel); //添加标签
            UpRightArea.revalidate(); //获取全部组件
            UpRightArea.repaint();    //重绘
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
