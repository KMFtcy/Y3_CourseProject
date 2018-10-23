package Gui.Finace;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
//杩欐槸jfre鍥捐〃鐨勫寘
import org.jfree.chart.*;
//杩欐槸jfree璁剧疆鐢ㄦ潵璁剧疆鍥捐〃鐨�
import org.jfree.data.category.*;
//杩欐槸jfree鐢ㄦ潵璁剧疆鏁版嵁瀵硅薄鐨�
import org.jfree.data.general.*;
import org.jfree.chart.plot.*;

public class FinanceWindows extends JFrame {
	// 杩欐槸婕旂ず鐢ㄧ殑鏁版嵁
	String[] ListTitle = { "支出记录ID", "支出时间", "支出金额", "支出目的","老师ID" };
	String[][] Datas = {
			{ "123456789", "2018.11.26", "100,000.00", "鏇存崲妗屾" ,"520520"},
			{ "123475725", "2018.9.13", "10,000.00", "鏇存崲鑰佸笀" ,"520520"}
			};
	String[] rowKeys = { "A平台" };
	String[] colKeys = { "1st", "2nd", "3th", "4th", "5th", "6th", "7th", "8th", "9th", "10th",
			"11th", "12th"};
	double[][] data = {
			{ 4, 3, 1, 1, 1, 1, 2, 2, 2, 1, 8, 2, }
	};
	//杩欐槸绐楀彛鐨勪竴浜涘睘鎬�
	ChartPanel FinanceChart;
	JTable RecordTable;

	public FinanceWindows() {
		setLayout(new BorderLayout());
		setComponent();
	}

	public void setComponent() {
		//鍒濆鍖栫粍浠�
		JPanel UpArea = new JPanel();
		JPanel UpLeftArea = new JPanel();
		JPanel UpRightArea = new JPanel();
		JPanel ButtomArea = new JPanel();
		UpArea.setLayout(new BorderLayout());
		UpRightArea.setLayout(new GridLayout(2,1));
		componentInitialize();
		
		//娣诲姞缁勪欢杩涚獥鍙�
		UpLeftArea.setPreferredSize(new Dimension(500,450));
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
		// 姝ラ1锛氬垱寤篊ategoryDataset瀵硅薄锛堝噯澶囨暟鎹級
		CategoryDataset dataset = createDataset();
		// 姝ラ2锛氭牴鎹瓺ataset 鐢熸垚JFreeChart瀵硅薄锛屼互鍙婂仛鐩稿簲鐨勮缃�
		FinanceChart = new ChartPanel(createChart(dataset));
	}

	public CategoryDataset createDataset() {
		return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
	}

	public JFreeChart createChart(CategoryDataset categoryDataset) {
		JFreeChart jfreechart = ChartFactory.createLineChart("月份收入", // 鏍囬
				"（十万）元", // categoryAxisLabel 锛坈ategory杞达紝妯酱锛孹杞存爣绛撅級
				"月份", // valueAxisLabel锛坴alue杞达紝绾佃酱锛孻杞寸殑鏍囩锛�
				categoryDataset, // Datatest
				PlotOrientation.VERTICAL, true, // legend
				false, // tooltips
				false); // URLs
		
		//璁剧疆鍥句緥绫诲埆瀛椾綋,瑙ｅ喅姹夊瓧鐨勬樉绀洪棶棰�
		CategoryPlot plot = jfreechart.getCategoryPlot();
		plot.getRangeAxis().setLabelFont(new  Font("宋体", Font.PLAIN, 12));//绾靛潗鏍囨眽瀛�
		plot.getDomainAxis().setLabelFont(new  Font("宋体", Font.PLAIN, 12));//妯潗鏍囨眽瀛�
		jfreechart.getTitle().setFont(new Font("",Font.BOLD, 15));//璁剧疆鏍囬

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
