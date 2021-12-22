package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class Search_view extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Search_view() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 430, 280);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("\u8FDB\u8D27\u67E5\u8BE2", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 10, 405, 49);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 69, 405, 182);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
//		给表格添加数据
		String tips[]= {"顺序码","条形码","进价","采购数量","采购日期"};
		Object objects[][]= {{},{}};
		
		table = new JTable(objects,tips);//表格
		table.setBounds(406, 180, -404, -178);
		panel_4.add(table);
		

		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u9500\u552E\u67E5\u8BE2", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\u5E93\u5B58\u67E5\u8BE2", null, panel_2, null);

	}
}
