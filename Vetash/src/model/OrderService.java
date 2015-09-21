package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import misc.Parse;

@Component(value="OrderService")
public class OrderService {
	@Autowired
	private OrderDAO dao;
	
	private List<Map<String, Object>> jfomat(List<OrderBean> beans){
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		for(OrderBean bean : beans) {
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("OrderNo", bean.getOrderNo());
			map.put("CustomerTel", bean.getCustomerTel());
			map.put("ReceiveType", bean.getReceiveType());
			map.put("CustomerAddr", bean.getCustomerAddr());
			map.put("ReceiveNotes", bean.getReceiveNotes());
			map.put("OrderDate", Parse.dateToString2(bean.getOrderDate()));
			map.put("OrderNotes", bean.getOrderNotes());
			map.put("Coupon", bean.getCoupon());
			map.put("Price", bean.getPrice());
			map.put("BossNotes", bean.getBossNotes());
			map.put("OrderState", bean.getOrderState());
			map.put("Housing", bean.getHousing());
			map.put("Rocker", bean.getRocker());
			map.put("L1", bean.getL1());
			map.put("L2", bean.getL2());
			map.put("R1", bean.getR1());
			map.put("R2", bean.getR2());
			map.put("O", bean.getO());
			map.put("X", bean.getX());
			map.put("Square", bean.getSquare());
			map.put("Triangle", bean.getTriangle());
			map.put("Start", bean.getStart());
			map.put("Selecter", bean.getSelecter());
			map.put("Touch", bean.getTouch());
			map.put("CoverImg", bean.getCoverImg());
			map.put("Board", bean.getBoard());
			result.add(map);
		}
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

	public List<Map<String, Object>> selectByDate(java.util.Date orderDate) {
		return this.jfomat(dao.selectByDate(orderDate));
	}

	public List<Map<String, Object>> selectByTel(String customerTel) {
		return this.jfomat(dao.selectByTel(customerTel));
	}

	public List<Map<String, Object>> selectByNote(String bossNotes) {
		return this.jfomat(dao.selectByNote(bossNotes));
	}
	
}
