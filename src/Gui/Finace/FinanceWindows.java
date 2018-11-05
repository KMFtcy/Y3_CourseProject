package Gui.Finace;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;
//闁哄鏅滈悷锕�危缁旀槷re闂佹悶鍎插畷姗�濡撮崘顔藉剭闁告洦鍋勯惁锟�
import org.jfree.chart.*;
//闁哄鏅滈悷锕�危缁旀槷ree闁荤姳绀佹晶浠嬫偪閸℃稒鍋ㄩ柕濠忛檮闂勫秹鎮规担绋库挃闁汇倕妫濆畷鍫曞箲閹扳晪鎷烽崘顔藉剭闁跨噦鎷�
import org.jfree.data.category.*;
//闁哄鏅滈悷锕�危缁旀槷ree闂佺儵鍋撻崝宥咁焽閻㈠灚濯奸柛鎾楀懏鐎梺杞拌兌婢ф鐣垫担鐚存嫹閻㈡鏀伴柦鏍у閹啴鏁撻敓锟�
import org.jfree.data.general.*;

import DAO.FinanceDaoImpl;
import bean.Finance;

import org.jfree.chart.plot.*;

public class FinanceWindows extends JFrame {
	// 闁哄鏅滈悷锕�危缁嬫鐓堕柡鍐ㄥ�舵禒娑㈡煟閳ь剙濡挎繛鍫熷灴瀵偊鎮ч崼婵堛偊
	String[][] Datas = {
			{ "123456789", "2018.11.26", "100,000.00", "发工资" ,"520520"},
			{ "123475725", "2018.9.13", "10,000.00", "购买教务系统" ,"520520"}
			};
		//闁哄鏅滈悷锕�危閸濄儳鐜绘俊銈忔嫹鐟滅増鐩幆鍐礋椤忓棭浼囨繛瀛樼矋缁嬫垿鎯堝锟介獮锟介柨鐕傛嫹
	ChartPanel FinanceChart = null;//缁熻鍥捐〃
	JTable RecordTable = null;//璐㈠姟琛ㄦ牸
	JLabel incomeSum = null;
	JLabel outcomeSum = null;
	static java.util.List<Finance> allFinanceList = null;//璐㈠姟鏁版嵁

	public FinanceWindows() {
		setLayout(new BorderLayout());
		initializeData();
		setComponent();
	}

	/**
	 * 鑾峰彇鎵�鏈夎储鍔℃暟鎹�
	 */
	private void initializeData() {
		allFinanceList = FinanceDaoImpl.findAllFinance();
		for(Finance i:allFinanceList) {
			System.out.println(i.getAim());
		}
		System.out.println("done");
	}
	/**
	 * 缁勫悎鎵�鏈夐潰鏉垮拰缁勪欢
	 */
	public void setComponent() {
		//鍒濆鍖栭潰鏉�
		JPanel UpArea = new JPanel();
		JPanel UpLeftArea = new JPanel();
		JPanel UpRightArea = new JPanel();
		JPanel ButtomArea = new JPanel();
		UpArea.setLayout(new BorderLayout());
		UpRightArea.setLayout(new GridLayout(2,1));
		//鍒濆鍖栫粍浠�
		componentInitialize();
		
		//缁勫悎鎵�鏈夐潰鏉�
		UpLeftArea.setPreferredSize(new Dimension(500,450));
		UpLeftArea.add(FinanceChart);
		UpRightArea.add(incomeSum,BorderLayout.NORTH);
		UpRightArea.add(outcomeSum,BorderLayout.SOUTH);
		UpArea.add(UpLeftArea, BorderLayout.WEST);
		UpArea.add(UpRightArea, BorderLayout.EAST);
		ButtomArea.add(new JScrollPane(RecordTable) );
		this.add(UpArea, BorderLayout.NORTH);
		this.add(new JScrollPane(RecordTable), BorderLayout.SOUTH);
	}

	/**
	 * 鍒濆鍖栨墍鏈夌粍浠�
	 */
	public void componentInitialize() {
		initializeChart();
		initializeTable();
		incomeSum = new JLabel();
		int income = 0;
		for(Finance i:allFinanceList) {
			income += Integer.parseInt(i.getOutNum());
		}
		outcomeSum = new JLabel();
		outcomeSum.setText("总收入" + "500000" + "元");
		int outcome = 0;
		for(Finance i:allFinanceList) {
			outcome += Integer.parseInt(i.getOutNum());
		}
		outcomeSum.setText("总支出" + String.valueOf(outcome) + "元");
	}

	/**
	 * 鍒濆鍖栬〃鏍�
	 */
	public void initializeChart() {
		String[] rowKeys = { "A平台" };
		String[] colKeys = { "1st", "2nd", "3th", "4th", "5th", "6th", "7th", "8th", "9th", "10th",
				"11th", "12th"};
		double[][] data = {
				{ 4, 3, 1, 1, 1, 1, 2, 2, 2, 1, 8, 2, }
		};
		
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
		FinanceChart = new ChartPanel(createChart(dataset));
	}

	public JFreeChart createChart(CategoryDataset categoryDataset) {
		JFreeChart jfreechart = ChartFactory.createLineChart("月收入统计图", // 闂佸搫绉村ú顓€�傞敓锟�
				"月份", // categoryAxisLabel 闂佹寧绋戝寤皌egory闁哄鍋犻幓顏嗘濠靛柈鐔碱敂閸ヮ剙褰欓梺鎸庣☉椤掓煡寮堕悙鑼憼闁绘牭绲跨划鐢稿箻閸涱垳顦�
				"閿涘牆宕勬稉鍥风礆閸忥拷", // valueAxisLabel闂佹寧绋戝濂眑ue闁哄鍋犻幓顏嗘濠靛牏妫ù锝呭暣閸欙繝鏌ㄥ☉姗嗗姤闁哄鍋涢顓炩枔閹达箑鍐�闁搞儮鏅╅崝顕�鏌ㄥ☉铏
				categoryDataset, // Datatest
				PlotOrientation.VERTICAL, true, // legend
				false, // tooltips
				false); // URLs
		
		//闁荤姳绀佹晶浠嬫偪閸℃稑鐐婇柛娆嶅劤娴兼劗绱掗銉殭闁糕晛妫涢敓鑺ョ♁閵囩偟绱為敓锟�,闁荤喐鐟辩徊浠嬪窗閸涱厜褎寰勬繝鍕喕闂佹眹鍔岀�氼厼螣婢跺瞼鐭嗘繛宸簼閿涙牕螞鐢喗瀚�
		CategoryPlot plot = jfreechart.getCategoryPlot();
		plot.getRangeAxis().setLabelFont(new  Font("宋体", Font.PLAIN, 12));//缂備線绠栧褍顭囧Δ鍛唨闁搞儯鍔庡┃鍕倵濞戣櫕瀚�
		plot.getDomainAxis().setLabelFont(new  Font("宋体", Font.PLAIN, 12));//濠碘槅鍨兼禍婊冾焽濡ゅ懎鍐�闁搞儯鍔庡┃鍕倵濞戣櫕瀚�
		jfreechart.getTitle().setFont(new Font("",Font.BOLD, 15));//闁荤姳绀佹晶浠嬫偪閸℃稑鍐�闁搞儺鍓﹂弳锟�

		jfreechart.getLegend().setItemFont(new Font("" ,Font.BOLD, 15));
		return jfreechart;
	}

	public void initializeTable() {
		Vector<String> ListTitle = new Vector<>();
		ListTitle.add("支出记录ID");
		ListTitle.add("支出金额");
		ListTitle.add("支出目的");
		ListTitle.add("教师ID");
		Vector<Vector<String>> FinanceRecordsList = new Vector<Vector<String>>();
		for(int i = 0;i<allFinanceList.size();i++) {
			Vector<String> FinanceRecord = new Vector<>();//鏂板缓涓�涓储鍔¤褰曞璞�
			FinanceRecord.add(String.valueOf(allFinanceList.get(i).getId()));
			FinanceRecord.add(allFinanceList.get(i).getOutNum());
			FinanceRecord.add(allFinanceList.get(i).getAim());
			FinanceRecord.add(String.valueOf(allFinanceList.get(i).getTeacherId()));
			FinanceRecordsList.add(FinanceRecord);
		}
		RecordTable = new JTable(FinanceRecordsList, ListTitle);
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		
//		frame.add(new FinanceWindows());
//		frame.pack();
//		frame.setVisible(true);
//	}
}
