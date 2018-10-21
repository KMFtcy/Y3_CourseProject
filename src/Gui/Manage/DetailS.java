package Gui.Manage;

import java.awt.*;

public class DetailS extends AddS {
    public DetailS(){
        super();
    }

    @Override
    public void setComponent() {
        super.setComponent();
    }

    public void componentInitialize(){
        super.componentInitialize();
        ID.setText("aa");
        Name.setText("tang");
        Gender.setText("b");
        StudentType.setText("121");
        RegistTime.setText("1999.11.11");
        PhoneNumber.setText("123456789");
        Birthday.setText("1971.11.11");
        InChargeTeacher.setText("zhang");
        CardID.setText("身份证");
        CardID.setText("370911199911110258");
        Address.setText("吉林省长春市朝阳区");
        Email.setText("1111111@qq.com");
    }
}
