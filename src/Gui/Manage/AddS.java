package Gui.Manage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * ���ѧ������
 */
//////////////////////////////////////////////////////////////////////////////////////////////////////��Ϊjfram
public class AddS extends JFrame implements ActionListener{
	
	JTextField ID;//ѧ�����
	JTextField Name;//ѧ������
	JTextField Gender;//ѧ���Ա�
	JTextField StudentType;//ѧ������
	Image Photo;//ѧ����Ƭ
	JTextField RegistTime;//ѧ����ѧʱ��
	JTextField PhoneNumber;//ѧ���绰
	JTextField Birthday;//ѧ������
	JTextField InChargeTeacher;//������ʦ
	JTextField CardType;//֤������
	JTextField CardID;//֤������
	JTextField Address;//��ַ
	JTextField Email;//�����ַ
	JTextArea Memo;//����
	JButton Comfirm;//ȷ�ϰ�ť
	JButton Cancel;//ȡ����ť
	File file;//ѡ�����Ƭ
	ImageIcon photo;//��Ƭ
	
	
	public AddS(){
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		setComponent();
		this.setVisible(true);
	}
	public void setComponent() {
		//��ʼ��������ڵĸ������Ԫ�أ�Ȼ��ʼ��װ
		componentInitialize();
		//������ڵĲ��ִ�ŷ�Ϊ�����������֣������ϴ�ŷ�Ϊ���С��ҡ����ĸ�����
		//�¾��Ƿ�������ť
		JPanel UpArea = new JPanel();
		JPanel UpLeftArea = new JPanel();
		JPanel UpCenterArea = new JPanel();
		JPanel UpRightArea = new JPanel();
		JPanel UpButtomArea = new JPanel();
		JPanel ButtomArea = new JPanel();
		//���������Ĳ���Layout
		UpArea.setLayout(new BorderLayout());
		UpLeftArea.setLayout(new GridLayout(7,2));
		UpCenterArea.setLayout(new GridLayout(5,2));
		UpRightArea.setLayout(new GridLayout(2,1));	
		UpButtomArea.setLayout(new BorderLayout());
		ButtomArea.setLayout(new GridLayout(1,2));
		//���Ԫ�ؽ�����
		UpLeftArea.add(new JLabel("ѧ�����",JLabel.CENTER));
		UpLeftArea.add(ID);
		UpLeftArea.add(new JLabel("ѧ������",JLabel.CENTER));
		UpLeftArea.add(Name);
		UpLeftArea.add(new JLabel("ѧ���Ա�",JLabel.CENTER));
		UpLeftArea.add(Gender);
		UpLeftArea.add(new JLabel("ѧ������",JLabel.CENTER));
		UpLeftArea.add(StudentType);
		UpLeftArea.add(new JLabel("��ѧʱ��",JLabel.CENTER));
		UpLeftArea.add(RegistTime);
		UpLeftArea.add(new JLabel("�ֻ�����",JLabel.CENTER));
		UpLeftArea.add(PhoneNumber);
		UpLeftArea.add(new JLabel("��������",JLabel.CENTER));
		UpLeftArea.add(Birthday);
		UpCenterArea.add(new JLabel("������ʦ",JLabel.CENTER));
		UpCenterArea.add(InChargeTeacher);
		UpCenterArea.add(new JLabel("֤������",JLabel.CENTER));
		UpCenterArea.add(CardType);
		UpCenterArea.add(new JLabel("֤������",JLabel.CENTER));
		UpCenterArea.add(CardID);
		UpCenterArea.add(new JLabel("��ϵ��ַ",JLabel.CENTER));
		UpCenterArea.add(Address);
		UpCenterArea.add(new JLabel("��������",JLabel.CENTER));
		UpCenterArea.add(Email);
	//	UpRightArea.add(new JLabel("��Ƭ",JLabel.CENTER));
	//	UpRightArea.add(new JLabel("���ǵ�ʱ�������Ƭ",JLabel.CENTER));
		JButton JAddImage ;
		UpRightArea.add(JAddImage = new JButton("������Ƭ"));
		JAddImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				fileChooser.showOpenDialog(null);
				file = fileChooser.getSelectedFile();
				try {
					InputStream is = new FileInputStream(file);
					BufferedImage bi = ImageIO.read(is);
					photo = new ImageIcon((Image)bi);
					JLabel jLabel = new JLabel(photo);
					UpRightArea.removeAll();
					UpRightArea.add(jLabel);
					UpRightArea.revalidate();
					UpRightArea.repaint();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		
		UpButtomArea.add(new JLabel("��ע"),BorderLayout.WEST);
		UpButtomArea.add(Memo,BorderLayout.CENTER);
		ButtomArea.add(Comfirm);
		ButtomArea.add(Cancel);
		//����������ӵ���Ӧ���������У����
		UpArea.add(UpLeftArea,BorderLayout.WEST);
		UpArea.add(UpCenterArea,BorderLayout.CENTER);
		UpArea.add(UpRightArea,BorderLayout.EAST);
		UpArea.add(UpButtomArea,BorderLayout.SOUTH);
		this.add(UpArea,BorderLayout.NORTH);
		this.add(ButtomArea,BorderLayout.SOUTH);
		pack();
	}
	public void componentInitialize() {
		ID = new JTextField(20);
		Name = new JTextField(20);
		Gender = new JTextField(20);
		StudentType = new JTextField(20);
		RegistTime = new JTextField(20);
		PhoneNumber = new JTextField(20);
		Birthday = new JTextField(20);
		InChargeTeacher = new JTextField(20);
		CardType = new JTextField(20);
		CardID = new JTextField(20);
		Address = new JTextField(20);
		Email = new JTextField(20);
		Memo = new JTextArea(6,20);
		
		Comfirm = new JButton("ȷ��");
		Cancel = new JButton("ȡ��");
		Cancel.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand()=="ȡ��") {
			this.dispose();
		}
	}

}
