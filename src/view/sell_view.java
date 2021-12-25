package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import com.mysql.cj.exceptions.StatementIsClosedException;

import dao.SellDao;
import dao.StockDao;
import pojo.Sell;
import pojo.Stock;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sell_view extends JPanel {
	private JTextField jt5;
	private JTextField jt2;
	private JTextField jt3;
	private JTextField jt4;
	private StockDao stockDao=new StockDao();
	private SellDao sellDao=new SellDao();
	private JTextField jt1;

	/**
	 * Create the panel.
	 */
	public Sell_view() {
		setBorder(new TitledBorder(null, "\u552E\u8D27\u4E2D\uFF01\uFF01\uFF01", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u6761\u5F62\u7801\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(72, 22, 91, 29);
		add(lblNewLabel);
		
		jt5 = new JTextField();
		jt5.setFont(new Font("宋体", Font.PLAIN, 15));
		jt5.setBounds(166, 25, 203, 21);
		add(jt5);
		jt5.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6570\u91CF\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(111, 103, 91, 29);
		add(lblNewLabel_1);
		
		jt2 = new JTextField();
		jt2.setFont(new Font("宋体", Font.PLAIN, 15));
		jt2.setColumns(10);
		jt2.setBounds(166, 106, 203, 21);
		add(jt2);
		
		JLabel lblNewLabel_2 = new JLabel("\u96F6\u552E\u4EF7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(97, 153, 91, 29);
		add(lblNewLabel_2);
		
		jt3 = new JTextField();
		jt3.setFont(new Font("宋体", Font.PLAIN, 15));
		jt3.setColumns(10);
		jt3.setBounds(166, 156, 203, 21);
		add(jt3);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				清空输入
				clear();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(72, 245, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u4E0B\u5355");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				获取文本框的输入
				String bar_code=jt5.getText();
				String num=jt2.getText();
				String price=jt3.getText();
//				判断库存是否为0
				Stock stock=stockDao.getStock(bar_code);
//				判断库存是否有该商品
				if (stock==null) {
					JOptionPane.showMessageDialog(null, "没有该商品！！","提示",JOptionPane.INFORMATION_MESSAGE);
				}else {
//					判断商品是否有库存，即库存数量不等于零
					if (stock.getStock_num()<Integer.parseInt(num)) {
						JOptionPane.showMessageDialog(null, stock.getName()+"剩余库存："+stock.getStock_num()+",最大购买数量为"+stock.getName(),"提示",JOptionPane.INFORMATION_MESSAGE);
					}
					else {
//						添加购买记录
						Sell sell=new Sell();
						sell.setBar_code(bar_code);
						sell.setNum(Integer.parseInt(num));
						sell.setSell_price(Double.valueOf(jt3.getText()));
						sell.setTotal(Double.valueOf(jt4.getText()));
						int res=sellDao.insertSell(sell);
						if (res==1) {
							JOptionPane.showMessageDialog(null, "下单成功!!","提示",JOptionPane.INFORMATION_MESSAGE);
//							修改库存
							stockDao.updateQualityByBar_code(bar_code, stock.getStock_num()-Integer.parseInt(num));
//							清空输入框
							clear();
						}else {
							JOptionPane.showMessageDialog(null, "下单失败！！","提示",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}

			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(300, 245, 97, 23);
		add(btnNewButton_1);
		
		jt4 = new JTextField();
		jt4.setFont(new Font("宋体", Font.PLAIN, 15));
		jt4.setColumns(10);
		jt4.setBounds(166, 195, 203, 21);
//		零售价根据条形码自动查询数据库自动显示
		Document document=jt5.getDocument();
		document.addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				findPriceByBar_code();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				findPriceByBar_code();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		add(jt4);
		
		Document document4=jt2.getDocument();
		document4.addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				totalMoney();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				totalMoney();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblNewLabel_2_1 = new JLabel("\u603B\u4EF7\uFF1A");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(111, 192, 91, 29);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(97, 64, 91, 29);
		add(lblNewLabel_3);
		
		jt1 = new JTextField();
		jt1.setFont(new Font("宋体", Font.PLAIN, 15));
		jt1.setColumns(10);
		jt1.setBounds(166, 67, 203, 21);
		add(jt1);

	}
//	清空输入框
	public void clear() {
		jt5.setText("");
		jt2.setText("");
		jt3.setText("");
		jt4.setText("");
		jt1.setText("");
	}
//	自动显示当前存在商品的零售价
	public void findPriceByBar_code() {
		String bar_code=jt5.getText();
		Stock stock=stockDao.getStock(bar_code);
		if (stock!=null) {
			jt3.setText(Double.toString(stock.getRetail_price()));
			jt1.setText(stock.getName());
		}
	}
//	获取零售价和数量自动计算总价
	public void totalMoney() {
//		当零售价和购买数量的输入框的值不为空时计算
		if(!jt2.getText().equals("")&&!jt3.getText().equals("")) {
			double total=Integer.parseInt(jt2.getText())*(Double.valueOf(jt3.getText()));
			jt4.setText(Double.toString(total));
		}
		if(jt2.getText().equals("")) {
			jt4.setText("");
		}
	}
}
