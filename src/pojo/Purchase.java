package pojo;

import java.util.Date;

public class Purchase {
	private int id;
	private String bar_code;
	private double price;
	private int quality;
	private Date time;
	
	public  Purchase() {
		
	}
	
	

	public Purchase(String bar_code, double price, int quality, Date time) {
		this.bar_code = bar_code;
		this.price = price;
		this.quality = quality;
		this.time = time;
	}



	public String getBar_code() {
		return bar_code;
	}

	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", bar_code=" + bar_code + ", price=" + price + ", quality=" + quality + ", time="
				+ time + "]";
	}

	

	
	
}
