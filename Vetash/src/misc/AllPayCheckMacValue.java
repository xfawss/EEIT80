package misc;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AllPayCheckMacValue {

	public static String merchantID = "2000132";//1132880
	public static String paymentType = "aio";
	public static String tradeDesc = "客製化搖桿";//客製化搖桿
	public static String itemName = "客製化搖桿";//客製化搖桿
	public static String returnURL = "http://http://vetash.cloudapp.net:8080/Vetash/OrderReturn";
	public static String choosePayment = "ALL";
	public static String ignorePayment = "Alipay#Tenpay";
	public static String clientBackURL = "http://http://vetash.cloudapp.net:8080/Vetash";
	public static String hashKey = "5294y06JbISpM5x9"; //0wMgoGtlxbsgmrk8
	public static String hashIV = "v77hoKGq4kWxNNIS";//lsHiApLhbobvzew3
	
	public static String checkMacValue(String merchantTradeNo, String merchantTradeDate, String totalAmount){
		String result = "";
		StringBuilder mix = new StringBuilder();
		mix.append("HashKey=" + hashKey + "&");
		mix.append("ChoosePayment=" + choosePayment + "&");
		mix.append("ClientBackURL=" + clientBackURL + "&");
		mix.append("IgnorePayment=" + ignorePayment + "&");
		mix.append("ItemName=" + itemName + "&");
		mix.append("MerchantID=" + merchantID + "&");
		mix.append("MerchantTradeDate=" + merchantTradeDate + "&");
		mix.append("MerchantTradeNo=" + merchantTradeNo + "&");
		mix.append("PaymentType=" + paymentType + "&");
		mix.append("ReturnURL=" + returnURL + "&");
		mix.append("TotalAmount=" + totalAmount + "&");
		mix.append("TradeDesc=" + tradeDesc + "&");
		mix.append("HashIV=" + hashIV);
		try {
			result = URLEncoder.encode(mix.toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		result = result.toLowerCase();
		result = Parse.toHexString(Parse.encodeMD5(result));
		return result;
	}
	
	public static boolean checkMacValueReturn(String merchantTradeNo, String rtnCode,
			String rtnMsg, String tradeNo, String tradeAmt, String paymentDate, String paymentType,
			String paymentTypeChargeFee, String tradeDate, String simulatePaid, String checkMacValue){
		StringBuilder mix = new StringBuilder();
		mix.append("HashKey=" + hashKey + "&");
		mix.append("MerchantID=" + merchantID + "&");
		mix.append("MerchantTradeNo=" + merchantTradeNo + "&");
		mix.append("PaymentDate=" + paymentDate + "&");
		mix.append("PaymentType=" + paymentType + "&");
		mix.append("PaymentTypeChargeFee=" + paymentTypeChargeFee + "&");
		mix.append("RtnCode=" + rtnCode + "&");
		mix.append("RtnMsg=" + rtnMsg + "&");
		mix.append("SimulatePaid=" + simulatePaid + "&");
		mix.append("TradeAmt=" + tradeAmt + "&");
		mix.append("TradeDate=" + tradeDate + "&");
		mix.append("TradeNo=" + tradeNo + "&");
		mix.append("HashIV=" + hashIV);
		String checkValue = "";
		try {
			checkValue = URLEncoder.encode(mix.toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		checkValue = checkValue.toLowerCase();
		checkValue = Parse.toHexString(Parse.encodeMD5(checkValue));
		if(checkValue.equals(checkMacValue)) {
			System.out.println("SUCCESS!!!");
			return true;
		}
		return false;
	}
	
	
	
//	public static void main(String[] args) {
//		
//		String a = AllPayCheckMacValue.checkMacValue("testtest1112", "2015/02/25 01:14:00", "888");
//		System.out.println(a);
//		
//	}
	
}
