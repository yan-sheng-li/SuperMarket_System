package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import pojo.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField jtf1;
	private JPasswordField jtf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("@CSDN\u7F18\u5206\u951D\u5929\u7A7A(\u674E\u5EF6\u80DC)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("");
				jtf2.setText("");
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 17));
		btnNewButton.setBounds(64, 195, 100, 25);
		contentPane.add(btnNewButton);
		JLabel jL1 = new JLabel("");
		jL1.setForeground(Color.RED);
		jL1.setBounds(126, 170, 185, 15);
		contentPane.add(jL1);
		
		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=jtf1.getText();
				char password[]=jtf2.getPassword();
				UserDao userDao=new UserDao();
				User user=userDao.selectUserByName(username);
				if(user==null) {
					jL1.setText("账号不存在！");
				}else {
					if(!user.getPassword().equals(String.valueOf(password))) {
						jL1.setText("账号或者密码错误！");
					}else {
						System.out.println("登录成功！");
					}
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 17));
		btnNewButton_1.setBounds(257, 195, 100, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("***\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 27));
		lblNewLabel.setBounds(157, 10, 126, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7:");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 18));
		lblNewLabel_1.setBounds(67, 86, 58, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 18));
		lblNewLabel_2.setBounds(67, 141, 58, 21);
		contentPane.add(lblNewLabel_2);
		
		jtf1 = new JTextField();
		jtf1.setFont(new Font("����", Font.BOLD, 17));
		jtf1.setBounds(126, 87, 228, 21);
		contentPane.add(jtf1);
		jtf1.setColumns(10);
		
		jtf2 = new JPasswordField();
		jtf2.setBounds(126, 142, 228, 21);
		contentPane.add(jtf2);
		
		
	}
}
