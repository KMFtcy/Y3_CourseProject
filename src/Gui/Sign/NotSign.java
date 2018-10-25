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
    private Vector<String> colHead; //����б���
    private Vector rows;            //��
    private JTable table;           //���
    private JScrollPane jScrollPane;//�������
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
        //�����������
        colHead.add("����");
        colHead.add("��Ŀ");
        colHead.add("��ʦ");
        colHead.add("ʱ��");
        //���ÿ��
        rows.clear();


        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd"); //��ȡʱ��
        dateFormat.format(new Date()); //����ʱ��
        String data = String.valueOf(dateFormat); //��ʱ��ת��ΪString
        List<Course> courseList = SignOnDaoImpl.getCourseAll(); //��ȡ���пγ�

        for(int j = 0;j < courseList.size();j++) {  //�������пγ̻�ȡ�ÿγ̵�ǰ���ڵ�δǩ����Ա����
            List<Student> temp ;  //����ѧ������
            temp = CourseDaoImpl.getNotSignIn(data,courseList.get(j));  //��ȡδǩ����Ա����
            for(int i = 0; i < temp.size();i++){  //������ȡ������ѧ��
                Vector<String> current = new Vector<>();  //������ǰ��
                current.add(temp.get(i).getName());  //��ȡѧ������
                current.add(courseList.get(j).getName());  //��ȡ�γ�����
                int teacherId = courseList.get(j).getTeacherId();  //��ȡ��ʦid
                Teacher teacher = TeacherDaoImpl.findById(teacherId);//���ݽ�ʦid��ȡ��ʦ��Ϣ
                current.add(teacher.getName());  //��ȡ��ʦ����
                current.add(data);  //�������
                rows.add(current);  //��ӵ�ǰ��
            }
        }

//        for(int i = 0;i < 10;i++){
//            Vector<String> currentRow = new Vector<>();//������ǰ�е�����
//
//            currentRow.add()
//            currentRow.addElement("������");
//            currentRow.addElement("����");
//            currentRow.addElement("�Ƴ���");
//            currentRow.addElement("2018-10-10");
//            rows.add(currentRow);//����ǰ�м���rows
//        }
        table = new JTable(rows,colHead); //������񣨲���1����¼��������2����ͷ��
        jScrollPane = new JScrollPane(table);
        add(jScrollPane,BorderLayout.CENTER);
        table.setEnabled(false); //���ò��ɱ༭
        table.getTableHeader().setReorderingAllowed(false); //���ñ����в���������
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
