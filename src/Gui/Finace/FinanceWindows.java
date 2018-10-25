package Gui.Finace;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
//閺夆晜鐟﹀Σ绔昮re闁搞儲宕橀妴鍐儍閸曨偄鐦�
import org.jfree.chart.*;
//閺夆晜鐟﹀Σ绔昮ree閻犱礁澧介悿鍡涙偨閵婏附闄嶉悹浣稿⒔閻ゅ棝宕堕幑鎰╋拷鍐儍閿燂拷
import org.jfree.data.category.*;
//閺夆晜鐟﹀Σ绔昮ree闁烩偓鍔嶅鐢垫媼閸撗呮瀭闁轰胶澧楀畵浣猴拷鐢殿攰閽栧嫰鎯冮敓锟�
import org.jfree.data.general.*;
import org.jfree.chart.plot.*;

public class FinanceWindows extends JFrame {
	// 閺夆晜鐟﹀Σ绋款煶閺冨倶浠涢柣鈧妿濞堟垿寮悧鍫濈ウ
	String[] ListTitle = { "支出记录ID", "鏀嚭鏃堕棿", "鏀嚭閲戦","鏀嚭鐩殑","鑰佸笀ID" };
	String[][] Datas = {
			{ "123456789", "2018.11.26", "100,000.00", "璐拱瀛︽牎鏁欐潗" ,"520520"},
			{ "123475725", "2018.9.13", "10,000.00", "璐拱鏁欏姟绯荤粺" ,"520520"}
			};
	String[] rowKeys = { "A骞冲彴" };
	String[] colKeys = { "1st", "2nd", "3th", "4th", "5th", "6th", "7th", "8th", "9th", "10th",
			"11th", "12th"};
	double[][] data = {
			{ 4, 3, 1, 1, 1, 1, 2, 2, 2, 1, 8, 2, }
	};
	//閺夆晜鐟﹀Σ鍝ョ玻濡わ拷瑜版盯鎯冮崟顏嗩伇濞存粍绋戦惈姗�骞�閿燂拷
	ChartPanel FinanceChart;
	JTable RecordTable;

	public FinanceWindows() {
		setLayout(new BorderLayout());
		setComponent();
	}

	public void setComponent() {
		//闁告帗绻傞～鎰板礌閺嶎偆鐭嬪ù鐙呮嫹
		JPanel UpArea = new JPanel();
		JPanel UpLeftArea = new JPanel();
		JPanel UpRightArea = new JPanel();
		JPanel ButtomArea = new JPanel();
		UpArea.setLayout(new BorderLayout());
		UpRightArea.setLayout(new GridLayout(2,1));
		componentInitialize();
		
		//婵烇綀顕ф慨鐐电磼閸曨亝顐介弶鈺傜〒閻涖儵宕ｉ敓锟�
		UpLeftArea.setPreferredSize(new Dimension(500,450));
		UpLeftArea.add(FinanceChart);
		UpRightArea.add(new JLabel("鎬绘敹鍏�305,000"),BorderLayout.NORTH);
		UpRightArea.add(new JLabel("鎬绘敮鍑�237,000"),BorderLayout.SOUTH);
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
		// 婵縿鍎甸锟�1闁挎稒鑹鹃崹鍗烆嚈缁″ケtegoryDataset閻庣數顢婇挅鍕晬閸繂娅欏璺烘处閺嗙喖骞戦鍡欑
		CategoryDataset dataset = createDataset();
		// 婵縿鍎甸锟�2闁挎稒纰嶉悧鎾箲閻＄taset 闁汇垻鍠愰崹娆紽reeChart閻庣數顢婇挅鍕晬鐏為棿绨伴柛娆忥工娴犳盯鎯勭粙璺ㄥ畨闁汇劌瀚鏇犵磾閿燂拷
		FinanceChart = new ChartPanel(createChart(dataset));
	}

	public CategoryDataset createDataset() {
		return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
	}

	public JFreeChart createChart(CategoryDataset categoryDataset) {
		JFreeChart jfreechart = ChartFactory.createLineChart("鏈堟敹鍏ョ粺璁″浘", // 闁哄秴娲。锟�
				"鏈堜唤", // categoryAxisLabel 闁挎稑娼廰tegory閺夌偠鎻槐婵單熼鍥彙闁挎稑顒查弶鐐茬摠閻栵絿绮甸幘鍛
				"锛堝崄涓囷級鍏�", // valueAxisLabel闁挎稑婢奱lue閺夌偠鎻槐婵堢棯娴ｅ啴鍙￠柨娑橆劥閺夌偛顕▓鎴﹀冀閸モ晩鍔柨娑虫嫹
				categoryDataset, // Datatest
				PlotOrientation.VERTICAL, true, // legend
				false, // tooltips
				false); // URLs
		
		//閻犱礁澧介悿鍡涘炊閸欍儳浼愮紒顐ヮ嚙閸╁棛锟芥稒銇炵紞锟�,閻熸瑱绲介崰鍛ф径濠勬憻闁汇劌瀚Ο澶岀矆濞差亝锛栧Λ甯嫹
		CategoryPlot plot = jfreechart.getCategoryPlot();
		plot.getRangeAxis().setLabelFont(new  Font("瀹嬩綋", Font.PLAIN, 12));//缂侀箖娼у妤呭冀閸ャ劎婧勯悗娑虫嫹
		plot.getDomainAxis().setLabelFont(new  Font("瀹嬩綋", Font.PLAIN, 12));//婵☆垼浜滃妤呭冀閸ャ劎婧勯悗娑虫嫹
		jfreechart.getTitle().setFont(new Font("",Font.BOLD, 15));//閻犱礁澧介悿鍡涘冀閸ヮ剦鏆�

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
