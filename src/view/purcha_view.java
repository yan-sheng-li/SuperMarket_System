package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;

import dao.PurchaseDao;
import dao.StockDao;
import pojo.Purchase;
import pojo.Stock;
import utils.TimeTools;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Purcha_view extends JPanel {
	private JTextField jt5;
	private JTextField jt3;
	private JTextField jt1;
	private JTextField jt2;
	private JTextField jt4;
	private JTextField jt6;
	private JTextField jt7;
	private PurchaseDao purchaseDao=new PurchaseDao();
	private StockDao stockDao=new StockDao();

	/**
	 * Create the panel.
	 */
	public Purcha_view() {
		setBorder(new TitledBorder(null, "\u8FDB\u8D27", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(57, 237, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u8FDB\u8D27");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				添加进货记录
				String bar_code=jt1.getText();
				String purchase_price=jt5.getText();
				String num=jt7.getText();
				Purchase purchase=new Purchase();
				purchase.setBar_code(bar_code);
				purchase.setPrice(Double.valueOf(purchase_price));
				purchase.setQuality(Integer.parseInt(num));
				purchaseDao.insertPur(purchase);
//				判断库存中是否有记录
				Stock stock=stockDao.getStock(bar_code);
				Stock stock1=new Stock();
				stock1.setBar_code(bar_code);
				stock1.setName(jt2.getText());
				stock1.setManufac(jt3.getText());
				stock1.setSpecifications(jt4.getText());
				stock1.setRetail_price(Double.valueOf(jt6.getText()));
				if (stock==null) {
//					如果库存没有过记录，就添加
					stock1.setStock_num(Integer.parseInt(num));
					stockDao.insertStock(stock1);
//					提示
					JOptionPane.showMessageDialog(null, "进货成功！！","提示",JOptionPane.INFORMATION_MESSAGE);
					clear();
				}else {
//					如果库存有过记录，就直接在原来的数据数量上增加
//					原有数量
					int quality=stock.getStock_num();
//					根据条形码更改库存数量
					stockDao.updateQualityByBar_code(bar_code, Integer.parseInt(num)+quality);
					JOptionPane.showMessageDialog(null, "进货成功！！","提示",JOptionPane.INFORMATION_MESSAGE);
					clear();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(285, 237, 97, 23);
		add(btnNewButton_1);
		
		jt5 = new JTextField();
		jt5.setFont(new Font("宋体", Font.PLAIN, 15));
		jt5.setColumns(10);
		jt5.setBounds(111, 131, 109, 21);
		add(jt5);
		
		JLabel lblNewLabel_2 = new JLabel("\u8FDB\u4EF7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(70, 128, 178, 29);
		add(lblNewLabel_2);
		
		jt3 = new JTextField();
		jt3.setFont(new Font("宋体", Font.PLAIN, 15));
		jt3.setColumns(10);
		jt3.setBounds(111, 81, 109, 21);
		add(jt3);
		
		JLabel lblNewLabel_1 = new JLabel("\u5382\u5546\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(70, 78, 164, 29);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u6761\u5F62\u7801\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 33, 109, 29);
		add(lblNewLabel);
		
		jt1 = new JTextField();
		jt1.setFont(new Font("宋体", Font.PLAIN, 15));
		jt1.setColumns(10);
		jt1.setBounds(111, 36, 109, 21);
		add(jt1);
		
		jt2 = new JTextField();
		jt2.setFont(new Font("宋体", Font.PLAIN, 15));
		jt2.setColumns(10);
		jt2.setBounds(304, 36, 109, 21);
		add(jt2);
		
		jt4 = new JTextField();
		jt4.setFont(new Font("宋体", Font.PLAIN, 15));
		jt4.setColumns(10);
		jt4.setBounds(304, 81, 109, 21);
		add(jt4);
		
		jt6 = new JTextField();
		jt6.setFont(new Font("宋体", Font.PLAIN, 15));
		jt6.setColumns(10);
		jt6.setBounds(304, 131, 109, 21);
		add(jt6);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u96F6\u552E\u4EF7\uFF1A");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(246, 128, 178, 29);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u89C4\u683C\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(260, 78, 164, 29);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(230, 33, 210, 29);
		add(lblNewLabel_3);
		
		jt7 = new JTextField();
		jt7.setFont(new Font("宋体", Font.PLAIN, 15));
		jt7.setColumns(10);
		jt7.setBounds(111, 182, 109, 21);
		add(jt7);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u6570\u91CF\uFF1A");
		lblNewLabel_2_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(70, 179, 178, 29);
		add(lblNewLabel_2_2);

	}
	
//	清空
	public  void clear() {
		jt1.setText("");
		jt2.setText("");
		jt3.setText("");
		jt4.setText("");
		jt5.setText("");
		jt6.setText("");
		jt7.setText("");
	}
}
