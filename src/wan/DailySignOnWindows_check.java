package wan;

import javax.swing.*;
import javax.swing.table.*;

public class DailySignOnWindows_check extends JPanel {
	//������ʾ�õ�����
	String[] ListTitle = { "����", "��Ŀ", "��ʦ", "ʱ��" };
	String[][] Datas = {{"�Ƴ���","��ѧ","�޺�","2018-9-4"}};
	
	private DefaultTableModel model = null;
	private JTable table = null;
	private DefaultTableModel StudentList;

	public DailySignOnWindows_check() {
		
		setComponent();
		setVisible(true);
	}

	public void setComponent() {
		componentInitialize();
		this.add(table);
		this.add(new JScrollPane(table));
	}

	public void componentInitialize() {
		model = new DefaultTableModel(Datas, ListTitle);
		table = new JTable(model);
	}
}
