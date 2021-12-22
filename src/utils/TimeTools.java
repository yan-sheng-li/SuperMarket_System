package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTools {
	public static String  getTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return dateFormat.format(date);
	}
	
	
	public static void main(String[] args) {
		System.out.println(TimeTools.getTime());
	}
}
