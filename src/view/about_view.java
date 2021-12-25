package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class About_view extends JPanel {

	/**
	 * Create the panel.
	 */
	public About_view() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4F5C\u8005\u5FAE\u4FE1\uFF1A17641244340");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 14));
		lblNewLabel.setBounds(138, 10, 228, 15);
		add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 30, 430, 260);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u89C9\u5F97\u4E0D\u9519\uFF0C\u5956\u52B1\u4E00\u4E0B\u4F5C\u8005\uFF01\u54C8\u54C8\u54C8");
		lblNewLabel_1_1.setBounds(112, 10, 194, 15);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(10, 35, 410, 215);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(About_view.class.getResource("/img/pay.jpg")));
		lblNewLabel_1.setBounds(119, 0, 227, 215);
		panel_2_1.add(lblNewLabel_1);
		
	}
}
