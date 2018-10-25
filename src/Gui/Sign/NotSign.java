package Gui.Sign;

import DAO.CourseDaoImpl;
import DAO.SignOnDaoImpl;
import DAO.TeacherDaoImpl;
import bean.Course;
import bean.Student;
import bean.Teacher;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class NotSign extends JPanel {
    public NotSign(){nsGUI();}
    private Vector<String> colHead; //表格列标题
    private Vector rows;            //行
    private JTable table;           //表格
    private JScrollPane jScrollPane;//滚动面板
    List<List<Student>> studentList = new ArrayList<List<Student>>();


    private void nsGUI(){
        setLayout(new BorderLayout());
        table = new JTable();
        colHead = new Vector();
        rows = new Vector();
        fillTable();

    }
    private  void fillTable(){
        colHead.clear();
        //向表格填充首行
        colHead.add("姓名");
        colHead.add("科目");
        colHead.add("老师");
        colHead.add("时间");
        //填充每行
        rows.clear();


        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd"); //获取时间
        dateFormat.format(new Date()); //设置时间
        String data = String.valueOf(dateFormat); //将时间转换为String
        List<Course> courseList = SignOnDaoImpl.getCourseAll(); //获取所有课程

        for(int j = 0;j < courseList.size();j++) {  //遍历所有课程获取该课程当前日期的未签到人员名单
            List<Student> temp ;  //声明学生数组
            temp = CourseDaoImpl.getNotSignIn(data,courseList.get(j));  //获取未签到人员名单
            for(int i = 0; i < temp.size();i++){  //遍历获取的所有学生
                Vector<String> current = new Vector<>();  //创建当前行
                current.add(temp.get(i).getName());  //获取学生姓名
                current.add(courseList.get(j).getName());  //获取课程名称
                int teacherId = courseList.get(j).getTeacherId();  //获取教师id
                Teacher teacher = TeacherDaoImpl.findById(teacherId);//根据教师id获取教师信息
                current.add(teacher.getName());  //获取教师姓名
                current.add(data);  //添加日期
                rows.add(current);  //添加当前行
            }
        }

//        for(int i = 0;i < 10;i++){
//            Vector<String> currentRow = new Vector<>();//创建当前行的数据
//
//            currentRow.add()
//            currentRow.addElement("杨兆铭");
//            currentRow.addElement("语文");
//            currentRow.addElement("唐朝阳");
//            currentRow.addElement("2018-10-10");
//            rows.add(currentRow);//将当前行加入rows
//        }
        table = new JTable(rows,colHead); //创建表格（参数1：记录集；参数2：表头）
        jScrollPane = new JScrollPane(table);
        add(jScrollPane,BorderLayout.CENTER);
        table.setEnabled(false); //设置不可编辑
        table.getTableHeader().setReorderingAllowed(false); //设置标题行不允许被调换
    }
    /*public static void main(String args[]){
        NotSign notSign = new NotSign();
        JFrame frame = new JFrame();
        frame.add(notSign);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400,400,400,400);
    }*/
}
