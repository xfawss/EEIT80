package misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SupplierParse {
	private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
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
}
