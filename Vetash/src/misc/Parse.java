package misc;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Parse {
	private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");
	public static java.util.Date convertDate(String data) {
		java.util.Date result = null;
		try {
			result = sFormat.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			result = new java.util.Date(0);
		}
		return result;
	}
	
	public static String dateToString(java.util.Date date){
		return sFormat.format(date);
	}
	
	private static SimpleDateFormat sFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static java.util.Date convertDate2(String data) {
		java.util.Date result = null;
		try {
			result = sFormat2.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			result = new java.util.Date(0);
		}
		return result;
	}
	
	public static String dateToString2(java.util.Date date){
		return sFormat2.format(date);
	}
	
	public static int convertInt(String data) {
		int result = 0;
		try {
			result = Integer.parseInt(data);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}
	
	public static double convertDouble(String data) {
		double result = 0;
		try {
			result = Double.parseDouble(data);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}
	
	public static byte[] encodeMD5(String str) {
		byte[] result = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			result = md5.digest(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String toHexString(byte[] in) {
		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < in.length; i++){
			String hex = Integer.toHexString(0xFF & in[i]);
			if (hex.length() == 1){
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString().toUpperCase();
	}
	
}
