package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class Sell_view extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Sell_view() {
		setBorder(new TitledBorder(null, "\u552E\u8D27\u4E2D\uFF01\uFF01\uFF01", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u6761\u5F62\u7801\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(65, 58, 91, 29);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 15));
		textField.setBounds(166, 61, 203, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6570\u91CF\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(111, 103, 91, 29);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(166, 106, 203, 21);
		add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u96F6\u552E\u4EF7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(97, 153, 91, 29);
		add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(166, 156, 203, 21);
		add(textField_2);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(65, 221, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u4E0B\u5355");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(293, 221, 97, 23);
		add(btnNewButton_1);

	}

}
