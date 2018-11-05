package Gui.Manage;

import DAO.TeacherDaoImpl;
import bean.Teacher;

public class DetailT extends AddT {
    public String names;
    public DetailT(String name)
    {
        super();
        names = name;
        CC();
    }
    public void setComponent(){
        super.setComponent();
    }
    public void CC(){
        try{
            Teacher teacher = TeacherDaoImpl.findByName(names).get(0);
            ID.setText(String.valueOf(teacher.getId()));
            Name.setText(teacher.getName());
            Gender.setText(teacher.getSex());
            RegistTime.setText(teacher.getTime());
            PhoneNumber.setText(teacher.getPhone());
            CardType.setText(teacher.getCerType());
            CardID.setText(teacher.getCerNum());
            Address.setText(teacher.getAddress());
            Email.setText(teacher.getEmail());
            Memo.setText(teacher.getNote());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
