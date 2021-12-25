package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	CardLayout cardLayout=new CardLayout();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("超市信息管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "\u4E3B\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u64CD\u4F5C\u9875", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(117, 10, 483, 334);
		contentPane.add(panel);
		panel.setLayout(cardLayout);
		
//		添加面板
		Purcha_view purcha_view=new Purcha_view();
		panel.add(purcha_view,"purchase_view");
		
		Search_view search_view=new Search_view();
		panel.add(search_view,"search_view");
		
		Sell_view sell_view=new Sell_view();
		panel.add(sell_view,"sell_view");
		
		About_view about_view=new About_view();
		panel.add(about_view,"about_view");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u83DC\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 34, 100, 217);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FDB\u8D27");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel, "purchase_view");
			}
		});
		btnNewButton.setBounds(0, 26, 97, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u552E\u8D27");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel, "sell_view");
			}
		});
		btnNewButton_1.setBounds(0, 59, 97, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel, "search_view");
			}
		});
		btnNewButton_2.setBounds(0, 92, 97, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("\u5173\u4E8E");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel, "about_view");
			}
		});
		btnNewButton_2_1.setBounds(0, 127, 97, 23);
		panel_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("\u9000\u51FA");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login=new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1_1.setBounds(0, 161, 97, 23);
		panel_1.add(btnNewButton_2_1_1);
	}
}
