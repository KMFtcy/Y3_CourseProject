package Gui.Manage;

public class DetailT extends AddT {
    public DetailT(){
        super();
    }
    public void setComponent(){
        super.setComponent();
    }
    public void componentInitialize(){
        super.componentInitialize();
        ID.setText("123456");
        Name.setText("luo");
        Gender.setText("G");
        RegistTime.setText("1990.11.20");
        PhoneNumber.setText("12345678999");
        CardType.setText("身份证");
        CardID.setText("370911111155486654");
        Address.setText("北京市朝阳区");
        Email.setText("1254887799@qq.com");

    }
}
