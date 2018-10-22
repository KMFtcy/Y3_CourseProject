package Gui.Finace;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
//����jfreͼ��İ�
import org.jfree.chart.*;
//����jfree������������ͼ���
import org.jfree.data.category.*;
//����jfree�����������ݶ����
import org.jfree.data.general.*;
import org.jfree.chart.plot.*;

public class FinanceWindows extends JPanel {
	// ������ʾ�õ�����
	String[] ListTitle = { "֧����¼ID", "֧��ʱ��", "֧�����", "֧��Ŀ��","��ʦID" };
	String[][] Datas = { 
			{ "123456789", "2018.11.26", "100,000.00", "��������" ,"520520"},
			{ "123475725", "2018.9.13", "10,000.00", "������ʦ" ,"520520"}
			};
	String[] rowKeys = { "Aƽ̨" };
	String[] colKeys = { "1��", "2��", "3��", "4��", "5��", "6��", "7��", "8��", "9��", "10��",
			"11��", "12��"};
	double[][] data = {
			{ 4, 3, 1, 1, 1, 1, 2, 2, 2, 1, 8, 2, }
	};
	//���Ǵ��ڵ�һЩ����
	ChartPanel FinanceChart;
	JTable RecordTable;

	public FinanceWindows() {
		setLayout(new BorderLayout());
		setComponent();
	}

	public void setComponent() {
		//��ʼ�����
		JPanel UpArea = new JPanel();
		JPanel UpLeftArea = new JPanel();
		JPanel UpRightArea = new JPanel();
		JPanel ButtomArea = new JPanel();
		UpArea.setLayout(new BorderLayout());
		UpRightArea.setLayout(new BorderLayout());
		componentInitialize();
		
		//������������
		UpLeftArea.add(FinanceChart);
		UpRightArea.add(new JLabel("�����룺305,000"),BorderLayout.NORTH);
		UpRightArea.add(new JLabel("��֧����237,000"),BorderLayout.SOUTH);
		UpArea.add(UpLeftArea, BorderLayout.WEST);
		UpArea.add(UpRightArea, BorderLayout.EAST);
		ButtomArea.add(new JScrollPane(RecordTable) );
		this.add(UpArea, BorderLayout.NORTH);
		this.add(ButtomArea, BorderLayout.SOUTH);
	}

	public void componentInitialize() {
		initializeChart();
		initializeTable();
	}

	public void initializeChart() {
		// ����1������CategoryDataset����׼�����ݣ�
		CategoryDataset dataset = createDataset();
		// ����2������Dataset ����JFreeChart�����Լ�����Ӧ������
		FinanceChart = new ChartPanel(createChart(dataset));
	}

	public CategoryDataset createDataset() {
		return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
	}

	public JFreeChart createChart(CategoryDataset categoryDataset) {
		JFreeChart jfreechart = ChartFactory.createLineChart("����ͳ��ͼ", // ����
				"���", // categoryAxisLabel ��category�ᣬ���ᣬX���ǩ��
				"����", // valueAxisLabel��value�ᣬ���ᣬY��ı�ǩ��
				categoryDataset, // Datatest
				PlotOrientation.VERTICAL, true, // legend
				false, // tooltips
				false); // URLs
		jfreechart.getTitle().setFont(new Font("",Font.BOLD, 15));//���ñ���
		//����ͼ���������           
		jfreechart.getLegend().setItemFont(new Font("" ,Font.BOLD, 15));
		return jfreechart;
	}
	/*
	 * @��ʼ�����
	 * @return:void
	 * 
	 * */
	public void initializeTable() {
		DefaultTableModel model = new DefaultTableModel(Datas, ListTitle);
		RecordTable = new JTable(Datas, ListTitle);
		
		JFrame frame = new JFrame();
		
		frame.add(new JScrollPane(RecordTable));
		frame.pack();
		frame.setVisible(true);
	}


}
