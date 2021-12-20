package pojo;

import java.util.Date;

public class Sell {
	private int id;
	private String bar_code;
	private int num;
	private double sell_price;
	private Date time;
	
	public Sell() {
		
	}
	
	
	
	public Sell(int id, String bar_code, int num, double sell_price, Date time) {
		super();
		this.id = id;
		this.bar_code = bar_code;
		this.num = num;
		this.sell_price = sell_price;
		this.time = time;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getBar_code() {
		return bar_code;
	}
	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getSell_price() {
		return sell_price;
	}
	public void setSell_price(double sell_price) {
		this.sell_price = sell_price;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "Sell [id=" + id + ", bar_code=" + bar_code + ", num=" + num + ", sell_price=" + sell_price + ", time="
				+ time + "]";
	}
	

	
	

}
