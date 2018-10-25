package Gui.Manage;

import bean.Student;

import java.awt.*;

import DAO.StudentDaoImpl;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
