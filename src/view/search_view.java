package view;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.PurchaseDao;
import dao.SellDao;
import dao.StockDao;
import pojo.Purchase;
import pojo.Sell;
import pojo.Stock;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;
import java.awt.event.ActionEvent;

public class Search_view extends JPanel {
	private JTextField jt;
	private JTable table;
	private JButton jb;
	private PurchaseDao purchaseDao=new PurchaseDao();
	private SellDao sellDao=new SellDao();
	private StockDao stockDao=new StockDao();
	private JTextField jt1;
	private JTable table_1;
	private JTextField textField_1;
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public Search_view() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 430, 278);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("\u8FDB\u8D27\u67E5\u8BE2", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 0, 405, 59);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		jt = new JTextField();
		jt.setToolTipText("\u8F93\u5165\u641C\u7D22");
		jt.setBounds(63, 11, 173, 21);
		panel_3.add(jt);
		jt.setColumns(10);
		
		jb = new JButton("\u641C\u7D22");
		
		jb.setBounds(242, 10, 97, 23);
		panel_3.add(jb);
		
		JRadioButton rb1 = new JRadioButton("\u6761\u5F62\u7801");
		rb1.setBounds(101, 38, 83, 23);
		panel_3.add(rb1);
		
		
		
		JRadioButton rb3 = new JRadioButton("\u65F6\u95F4");
		rb3.setBounds(186, 38, 61, 23);
		panel_3.add(rb3);
		
//		按钮组
		ButtonGroup buttonGroup=new ButtonGroup();
		buttonGroup.add(rb1);
		buttonGroup.add(rb3);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 405, 172);
		panel.add(scrollPane);
		
		String tips[]= {"顺序码","条形码","进价","采购数量","采购日期"};
		String tips1[]= {"条形码","数量","零售价","总计","下单时间"};
		String tips2[]= {"条形码","商品名","库存量","生产厂商","规格","零售价"};
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				查询
//				获取文本框的输入
				String text=jt.getText();
//				获取单选框按钮状态
				if (rb1.isSelected()) {
//					查询结果反馈到表格
					TableModel tableModel=new DefaultTableModel(findResult(text),tips);
					table.setModel(tableModel);
					
				}
				if (rb3.isSelected()) {
					TableModel tableModel=new DefaultTableModel(findResultByTime(text),tips);
					table.setModel(tableModel);
				}
				
			}
		});
		
		
//		给表格添加数据
		Object objects[][]=findResult("");
		
		table = new JTable(objects,tips);
		scrollPane.setViewportView(table);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u9500\u552E\u67E5\u8BE2", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(10, 0, 405, 59);
		panel_1.add(panel_3_1);
		
		jt1 = new JTextField();
		jt1.setToolTipText("\u8F93\u5165\u641C\u7D22");
		jt1.setColumns(10);
		jt1.setBounds(63, 11, 173, 21);
		panel_3_1.add(jt1);
		
		JRadioButton rb1_1 = new JRadioButton("\u6761\u5F62\u7801");
		rb1_1.setBounds(101, 38, 83, 23);
		panel_3_1.add(rb1_1);
		
		JButton jb1 = new JButton("\u641C\u7D22");
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=jt1.getText();
				if (rb1_1.isSelected()) {
//					查询结果反馈到表格
					TableModel tableModel=new DefaultTableModel(findResult1(str),tips);
					table_1.setModel(tableModel);
					
				}
			}
		});
		jb1.setBounds(242, 10, 97, 23);
		panel_3_1.add(jb1);
		
		
		
		JRadioButton rb3_1 = new JRadioButton("\u4E0B\u5355\u65F6\u95F4");
		rb3_1.setBounds(186, 38, 105, 23);
		panel_3_1.add(rb3_1);
		
		ButtonGroup buttonGroup1=new ButtonGroup();
		buttonGroup1.add(rb1_1);
		buttonGroup1.add(rb3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 69, 405, 172);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable(findResult1(""),tips1) ;
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\u5E93\u5B58\u67E5\u8BE2", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBounds(10, 0, 405, 59);
		panel_2.add(panel_3_1_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("\u8F93\u5165\u641C\u7D22");
		textField_1.setColumns(10);
		textField_1.setBounds(63, 11, 173, 21);
		panel_3_1_1.add(textField_1);
		
		JButton jb_1_1 = new JButton("\u641C\u7D22");
		jb_1_1.setBounds(242, 10, 97, 23);
		panel_3_1_1.add(jb_1_1);
		
		JRadioButton rb1_1_1 = new JRadioButton("\u6761\u5F62\u7801");
		rb1_1_1.setBounds(101, 38, 83, 23);
		panel_3_1_1.add(rb1_1_1);
		
		JRadioButton rb3_1_1 = new JRadioButton("\u5546\u54C1\u540D");
		rb3_1_1.setBounds(200, 38, 80, 23);
		panel_3_1_1.add(rb3_1_1);
		
		jb_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str=textField_1.getText();
				if (rb1_1_1.isSelected()) {
					TableModel tableModel=new DefaultTableModel(findResult3(str),tips2);
					table_2.setModel(tableModel);
				}
				if (rb3_1_1.isSelected()) {
					TableModel tableModel=new DefaultTableModel(findResult2(str),tips2);
					table_2.setModel(tableModel);
				}
			}
		});
		
		
		
		ButtonGroup buttonGroup2=new ButtonGroup();
		buttonGroup1.add(rb1_1_1);
		buttonGroup1.add(rb3_1_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 69, 405, 172);
		panel_2.add(scrollPane_1_1);
		
		table_2 = new JTable(findResult2(""),tips2);
		scrollPane_1_1.setViewportView(table_2);

	}
	
//	返回查询结果的并包装成二维数组用于表格展示
	public Object[][] findResult(String text) {
		List<Purchase> ps;
		if("".equals(text)) {
			ps=purchaseDao.selectAll();
		}else {
			ps=purchaseDao.selectByName(text);
		}
		java.lang.reflect.Field[] s=Purchase.class.getDeclaredFields();
		Object[][] arr=new Object[ps.size()][s.length];
		int i=0;
		int j=0;
		for (Purchase purchase : ps) {
			arr[i][j]=purchase.getId();
			arr[i][j+1]=purchase.getBar_code();
			arr[i][j+2]=purchase.getPrice();
			arr[i][j+3]=purchase.getQuality();
			arr[i][j+4]=purchase.getTime();
			i++;
		}
		return arr;
	}
	public Object[][] findResultByTime(String text) {
		List<Purchase> ps;
		if("".equals(text)) {
			ps=purchaseDao.selectAll();
		}else {
			ps=purchaseDao.selectByTime(text);
		}
		java.lang.reflect.Field[] s=Purchase.class.getDeclaredFields();
		Object[][] arr=new Object[ps.size()][s.length];
		int i=0;
		int j=0;
		for (Purchase purchase : ps) {
			arr[i][j]=purchase.getId();
			arr[i][j+1]=purchase.getBar_code();
			arr[i][j+2]=purchase.getPrice();
			arr[i][j+3]=purchase.getQuality();
			arr[i][j+4]=purchase.getTime();
			i++;
		}
		
		return arr;
	}
	
	
	
	public Object[][] findResult1(String text) {
		List<Sell> ps;
		if("".equals(text)) {
			ps=sellDao.selectAll();
		}else {
			ps=sellDao.selectByBarCdoe(text);
		}
		java.lang.reflect.Field[] s=Sell.class.getDeclaredFields();
		Object[][] arr=new Object[ps.size()][s.length-1];
		int i=0;
		int j=0;
		for ( Sell sell : ps) {
			arr[i][j]=sell.getBar_code();
			arr[i][j+1]=sell.getNum();
			arr[i][j+2]=sell.getSell_price();
			arr[i][j+3]=sell.getTotal();
			arr[i][j+4]=sell.getTime();
			i++;
		}
		return arr;
	}
	public Object[][] findResult2(String name) {
		List<Stock> ps;
		if("".equals(name)) {
			ps=stockDao.selectAll();
		}else {
			ps=stockDao.selectByName(name);
		}
		java.lang.reflect.Field[] s=Stock.class.getDeclaredFields();
		Object[][] arr=new Object[ps.size()][s.length];
		int i=0;
		int j=0;
		for ( Stock stock : ps) {
			arr[i][j]=stock.getBar_code();
			arr[i][j+1]=stock.getName();
			arr[i][j+2]=stock.getStock_num();
			arr[i][j+3]=stock.getManufac();
			arr[i][j+4]=stock.getSpecifications();
			arr[i][j+5]=stock.getRetail_price();
			i++;
		}
		return arr;
	}
	public Object[][] findResult3(String bar_code) {
		List<Stock> ps;
		if("".equals(bar_code)) {
			ps=stockDao.selectAll();
		}else {
			ps=stockDao.selectByBarcode(bar_code);
		}
		java.lang.reflect.Field[] s=Stock.class.getDeclaredFields();
		Object[][] arr=new Object[ps.size()][s.length];
		int i=0;
		int j=0;
		for ( Stock stock : ps) {
			arr[i][j]=stock.getBar_code();
			arr[i][j+1]=stock.getName();
			arr[i][j+2]=stock.getStock_num();
			arr[i][j+3]=stock.getManufac();
			arr[i][j+4]=stock.getSpecifications();
			arr[i][j+5]=stock.getRetail_price();
			i++;
		}
		return arr;
	}
}
