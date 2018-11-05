package Gui.Manage;

import DAO.CourseDaoImpl;
import DAO.TeacherDaoImpl;
import bean.Course;
import bean.Teacher;

public class DetailC extends AddC {
    public String string;
    public DetailC(String names){
        super();
        string = names;
        CC();
    }
    public void setComponent(){
        super.setComponent();
    }
    public void CC() {
        try {
            //Áô¸øDAO
            Course course = CourseDaoImpl.findByName(string).get(0);
            name.setText(course.getName());
            ID.setText(String.valueOf(course.getId()));
            Teacher teacher = TeacherDaoImpl.findById(course.getTeacherId());
            Teacher.setText(teacher.getName());
            Cost.setText(String.valueOf(course.getCourseFee()));
            Memo.setText(course.getCourseType());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
