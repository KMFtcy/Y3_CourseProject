package Gui.Finace;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
//这是jfre图表的包
import org.jfree.chart.*;
//这是jfree设置用来设置图表的
import org.jfree.data.category.*;
//这是jfree用来设置数据对象的
import org.jfree.data.general.*;
import org.jfree.chart.plot.*;

public class FinanceWindows extends JPanel {
	// 这是演示用的数据
	String[] ListTitle = { "支出记录ID", "支出时间", "支出金额", "支出目的","老师ID" };
	String[][] Datas = { 
			{ "123456789", "2018.11.26", "100,000.00", "更换桌椅" ,"520520"},
			{ "123475725", "2018.9.13", "10,000.00", "更换老师" ,"520520"}
			};
	String[] rowKeys = { "A平台" };
	String[] colKeys = { "1st", "2nd", "3th", "4th", "5th", "6th", "7th", "8th", "9th", "10th",
			"11th", "12th"};
	double[][] data = {
			{ 4, 3, 1, 1, 1, 1, 2, 2, 2, 1, 8, 2, }
	};
	//这是窗口的一些属性
	ChartPanel FinanceChart;
	JTable RecordTable;

	public FinanceWindows() {
		setLayout(new BorderLayout());
		setComponent();
	}

	public void setComponent() {
		//初始化组件
		JPanel UpArea = new JPanel();
		JPanel UpLeftArea = new JPanel();
		JPanel UpRightArea = new JPanel();
		JPanel ButtomArea = new JPanel();
		UpArea.setLayout(new BorderLayout());
		UpRightArea.setLayout(new BorderLayout());
		componentInitialize();
		
		//添加组件进窗口
		UpLeftArea.setPreferredSize(new Dimension(700,450));
		UpLeftArea.add(FinanceChart);
		UpRightArea.add(new JLabel("总收入：305,000"),BorderLayout.NORTH);
		UpRightArea.add(new JLabel("总支出：237,000"),BorderLayout.SOUTH);
		UpArea.add(UpLeftArea, BorderLayout.WEST);
		UpArea.add(UpRightArea, BorderLayout.EAST);
		ButtomArea.add(new JScrollPane(RecordTable) );
		this.add(UpArea, BorderLayout.NORTH);
		this.add(new JScrollPane(RecordTable), BorderLayout.SOUTH);
	}

	public void componentInitialize() {
		initializeChart();
		initializeTable();
	}

	public void initializeChart() {
		// 步骤1：创建CategoryDataset对象（准备数据）
		CategoryDataset dataset = createDataset();
		// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
		FinanceChart = new ChartPanel(createChart(dataset));
	}

	public CategoryDataset createDataset() {
		return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
	}

	public JFreeChart createChart(CategoryDataset categoryDataset) {
		JFreeChart jfreechart = ChartFactory.createLineChart("收入统计图", // 标题
				"年分", // categoryAxisLabel （category轴，横轴，X轴标签）
				"数量", // valueAxisLabel（value轴，纵轴，Y轴的标签）
				categoryDataset, // Datatest
				PlotOrientation.VERTICAL, true, // legend
				false, // tooltips
				false); // URLs
		
		//设置图例类别字体,解决汉字的显示问题
		CategoryPlot plot = jfreechart.getCategoryPlot();
		plot.getRangeAxis().setLabelFont(new  Font("宋体", Font.PLAIN, 12));//纵坐标汉字
		plot.getDomainAxis().setLabelFont(new  Font("宋体", Font.PLAIN, 12));//横坐标汉字
		jfreechart.getTitle().setFont(new Font("",Font.BOLD, 15));//设置标题
		jfreechart.getLegend().setItemFont(new Font("" ,Font.BOLD, 15));
		return jfreechart;
	}
	/*
	 * @初始化表格
	 * 
	 * */
	public void initializeTable() {
		DefaultTableModel model = new DefaultTableModel(Datas, ListTitle);
		RecordTable = new JTable(Datas, ListTitle);
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		
//		frame.add(new FinanceWindows());
//		frame.pack();
//		frame.setVisible(true);
//	}
}
