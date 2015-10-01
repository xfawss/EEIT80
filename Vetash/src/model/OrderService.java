package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import misc.AllPayCheckMacValue;
import misc.Parse;

@Component(value="OrderService")
public class OrderService {
	@Autowired
	private OrderDAO dao;
	
	private List<Map<String, Object>> jfomat(List<OrderBean> beans){
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		for(OrderBean bean : beans) {
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("orderNo", bean.getOrderNo());
			map.put("customerTel", bean.getCustomerTel());
			map.put("receiveType", bean.getReceiveType());
			map.put("customerAddr", bean.getCustomerAddr());
			map.put("receiveNotes", bean.getReceiveNotes());
			map.put("orderDate", Parse.dateToString2(bean.getOrderDate()));
			map.put("orderNotes", bean.getOrderNotes());
			map.put("coupon", bean.getCoupon());
			map.put("price", bean.getPrice());
			map.put("bossNotes", bean.getBossNotes());
			map.put("orderState", bean.getOrderState());
			map.put("housing", bean.getHousing());
			map.put("rocker", bean.getRocker());
			map.put("l1", bean.getL1());
			map.put("l2", bean.getL2());
			map.put("r1", bean.getR1());
			map.put("r2", bean.getR2());
			map.put("o", bean.getO());
			map.put("x", bean.getX());
			map.put("square", bean.getSquare());
			map.put("triangle", bean.getTriangle());
			map.put("start", bean.getStart());
			map.put("selecter", bean.getSelecter());
			map.put("touch", bean.getTouch());
			map.put("coverImg", bean.getCoverImg());
			map.put("board", bean.getBoard());
			if(bean.getDeliveryDate()!=null){
				map.put("deliveryDate;", Parse.dateToString(bean.getDeliveryDate()));
			} else {
				map.put("deliveryDate;", "");
			}
			map.put("paymentType", bean.getPaymentType());
			map.put("paymentTypeChargeFee", bean.getPaymentTypeChargeFee());
			map.put("allPayTradeNo", bean.getAllPayTradeNo());
			result.add(map);
		}
		return result;
	}
	
	private List<Map<String, Object>> jfomat2(OrderBean bean){
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String orderNo = bean.getOrderNo();
		String orderDate = Parse.dateToString2(bean.getOrderDate());
		String price = Integer.toString(bean.getPrice());;
		map.put("orderNo", orderNo);
		map.put("customerTel", bean.getCustomerTel());
		map.put("orderDate", orderDate);
		map.put("price", price);
		map.put("orderState", bean.getOrderState());
		map.put("housing", bean.getHousing());
		map.put("rocker", bean.getRocker());
		map.put("l1", bean.getL1());
		map.put("l2", bean.getL2());
		map.put("r1", bean.getR1());
		map.put("r2", bean.getR2());
		map.put("o", bean.getO());
		map.put("x", bean.getX());
		map.put("square", bean.getSquare());
		map.put("triangle", bean.getTriangle());
		map.put("start", bean.getStart());
		map.put("selecter", bean.getSelecter());
		map.put("touch", bean.getTouch());
		map.put("coverImg", bean.getCoverImg());
		map.put("board", bean.getBoard());
		if(bean.getDeliveryDate()!=null){
			map.put("deliveryDate;", Parse.dateToString(bean.getDeliveryDate()));
		} else {
			map.put("deliveryDate;", "");
		}
		map.put("MerchantID", AllPayCheckMacValue.merchantID);
		map.put("PaymentType", AllPayCheckMacValue.paymentType);
		map.put("TradeDesc", AllPayCheckMacValue.tradeDesc);
		map.put("ItemName", AllPayCheckMacValue.itemName);
		map.put("ReturnURL", AllPayCheckMacValue.returnURL);
		map.put("ChoosePayment", AllPayCheckMacValue.choosePayment);
		map.put("IgnorePayment", AllPayCheckMacValue.ignorePayment);
		map.put("ClientBackURL", AllPayCheckMacValue.clientBackURL);
		map.put("CheckMacValue", AllPayCheckMacValue.checkMacValue(orderNo, orderDate, price));
		result.add(map);
		return result;
	}
	
	public OrderBean insert(OrderBean bean) {
		return (OrderBean) dao.insert(bean);
	}

	public OrderBean update(OrderBean bean) {
		return (OrderBean) dao.update(bean);
	}

	public boolean delete(String orderNo) {
		return dao.delete(orderNo);
	}

	public List<Map<String, Object>> selectAll() {
		return this.jfomat(dao.selectAll());
	}

	public List<Map<String, Object>> selectByDate(String orderDate) {
		return this.jfomat(dao.selectByDate(orderDate));
	}

	public List<Map<String, Object>> selectByTel(String customerTel) {
		return this.jfomat(dao.selectByTel(customerTel));
	}

	public List<Map<String, Object>> selectByNote(String bossNotes) {
		return this.jfomat(dao.selectByNote(bossNotes));
	}
	
	public OrderBean selectByOrderNo(String orderNo) {
		return (OrderBean)dao.selectByOrderNo(orderNo);
	}
	
	public List<Map<String, Object>> selectByOrderNo2(String orderNo) {
		return this.jfomat2(dao.selectByOrderNo(orderNo));
	}
	
}
