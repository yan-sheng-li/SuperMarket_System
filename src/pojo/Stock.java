package pojo;


public class Stock {
	private String bar_code;
	private String name;
	private int stock_num;
	private String manufac;
	private String specifications;
	private double retail_price;
	
	public Stock() {
		
	}
	
	

	public Stock(String bar_code, String name, int stock_num, String manufac, String specifications,
			double retail_price) {
		super();
		this.bar_code = bar_code;
		this.name = name;
		this.stock_num = stock_num;
		this.manufac = manufac;
		this.specifications = specifications;
		this.retail_price = retail_price;
	}



	public String getBar_code() {
		return bar_code;
	}

	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock_num() {
		return stock_num;
	}

	public void setStock_num(int stock_num) {
		this.stock_num = stock_num;
	}

	public String getManufac() {
		return manufac;
	}

	public void setManufac(String manufac) {
		this.manufac = manufac;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public double getRetail_price() {
		return retail_price;
	}

	public void setRetail_price(double retail_price) {
		this.retail_price = retail_price;
	}

	@Override
	public String toString() {
		return "Stock [bar_code=" + bar_code + ", name=" + name + ", stock_num=" + stock_num + ", manufac=" + manufac
				+ ", specifications=" + specifications + ", retail_price=" + retail_price + "]";
	}
	
	
	
}
