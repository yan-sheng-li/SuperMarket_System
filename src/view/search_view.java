package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class Search_view extends JPanel {

	/**
	 * Create the panel.
	 */
	public Search_view() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 430, 280);
		add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("\u8FDB\u8D27\u67E5\u8BE2", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("\u552E\u8D27\u67E5\u8BE2", null, tabbedPane_2, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("\u96F6\u552E\u67E5\u8BE2", null, tabbedPane_3, null);

	}
}
