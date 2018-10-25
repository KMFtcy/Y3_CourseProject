package Gui.Finace;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
//鏉╂瑦妲竕fre閸ユ崘銆冮惃鍕瘶
import org.jfree.chart.*;
//鏉╂瑦妲竕free鐠佸墽鐤嗛悽銊︽降鐠佸墽鐤嗛崶鎹愩�冮惃锟�
import org.jfree.data.category.*;
//鏉╂瑦妲竕free閻€劍娼电拋鍓х枂閺佺増宓佺�电钖勯惃锟�
import org.jfree.data.general.*;
import org.jfree.chart.plot.*;

public class FinanceWindows extends JFrame {
	// 鏉╂瑦妲稿鏃傘仛閻€劎娈戦弫鐗堝祦
	String[] ListTitle = { "支出記錄ID", "支出时间", "支出金额","支出目的","老师ID" };
	String[][] Datas = {
			{ "123456789", "2018.11.26", "100,000.00", "购买学校教材" ,"520520"},
			{ "123475725", "2018.9.13", "10,000.00", "购买教务系统" ,"520520"}
			};
	String[] rowKeys = { "A平台" };
	String[] colKeys = { "1st", "2nd", "3th", "4th", "5th", "6th", "7th", "8th", "9th", "10th",
			"11th", "12th"};
	double[][] data = {
			{ 4, 3, 1, 1, 1, 1, 2, 2, 2, 1, 8, 2, }
	};
	//鏉╂瑦妲哥粣妤�褰涢惃鍕娴滄稑鐫橀幀锟�
	ChartPanel FinanceChart;
	JTable RecordTable;

	public FinanceWindows() {
		setLayout(new BorderLayout());
		setComponent();
	}

	public void setComponent() {
		//閸掓繂顫愰崠鏍矋娴狅拷
		JPanel UpArea = new JPanel();
		JPanel UpLeftArea = new JPanel();
		JPanel UpRightArea = new JPanel();
		JPanel ButtomArea = new JPanel();
		UpArea.setLayout(new BorderLayout());
		UpRightArea.setLayout(new GridLayout(2,1));
		componentInitialize();
		
		//濞ｈ濮炵紒鍕鏉╂稓鐛ラ崣锟�
		UpLeftArea.setPreferredSize(new Dimension(500,450));
		UpLeftArea.add(FinanceChart);
		UpRightArea.add(new JLabel("总收入305,000"),BorderLayout.NORTH);
		UpRightArea.add(new JLabel("总支出237,000"),BorderLayout.SOUTH);
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
		// 濮濄儵顎�1閿涙艾鍨卞绡奱tegoryDataset鐎电钖勯敍鍫濆櫙婢跺洦鏆熼幑顕嗙礆
		CategoryDataset dataset = createDataset();
		// 濮濄儵顎�2閿涙碍鐗撮幑鐡篴taset 閻㈢喐鍨欽FreeChart鐎电钖勯敍灞间簰閸欏﹤浠涢惄绋跨安閻ㄥ嫯顔曠純锟�
		FinanceChart = new ChartPanel(createChart(dataset));
	}

	public CategoryDataset createDataset() {
		return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
	}

	public JFreeChart createChart(CategoryDataset categoryDataset) {
		JFreeChart jfreechart = ChartFactory.createLineChart("月收入统计图", // 閺嶅洭顣�
				"月份", // categoryAxisLabel 閿涘潏ategory鏉炶揪绱濆Ο顏囬叡閿涘鏉炲瓨鐖ｇ粵鎾呯礆
				"（十万）元", // valueAxisLabel閿涘澊alue鏉炶揪绱濈痪浣冮叡閿涘鏉炲娈戦弽鍥╊劮閿涳拷
				categoryDataset, // Datatest
				PlotOrientation.VERTICAL, true, // legend
				false, // tooltips
				false); // URLs
		
		//鐠佸墽鐤嗛崶鍙ョ伐缁鍩嗙�涙ぞ缍�,鐟欙絽鍠呭Ч澶婄摟閻ㄥ嫭妯夌粈娲６妫帮拷
		CategoryPlot plot = jfreechart.getCategoryPlot();
		plot.getRangeAxis().setLabelFont(new  Font("宋体", Font.PLAIN, 12));//缁鹃潧娼楅弽鍥ㄧ溄鐎涳拷
		plot.getDomainAxis().setLabelFont(new  Font("宋体", Font.PLAIN, 12));//濡亜娼楅弽鍥ㄧ溄鐎涳拷
		jfreechart.getTitle().setFont(new Font("",Font.BOLD, 15));//鐠佸墽鐤嗛弽鍥暯

		jfreechart.getLegend().setItemFont(new Font("" ,Font.BOLD, 15));
		return jfreechart;
	}

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
