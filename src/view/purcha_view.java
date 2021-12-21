package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

public class Purcha_view extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Purcha_view() {
		setBorder(new TitledBorder(null, "\u8FDB\u8D27", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(56, 217, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u4E0B\u5355");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(284, 217, 97, 23);
		add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(157, 152, 203, 21);
		add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("\u96F6\u552E\u4EF7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(88, 149, 91, 29);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(157, 102, 203, 21);
		add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u6570\u91CF\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(102, 99, 91, 29);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u6761\u5F62\u7801\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(56, 54, 91, 29);
		add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(157, 57, 203, 21);
		add(textField_2);

	}
}
