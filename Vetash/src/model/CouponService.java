package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import misc.Parse;




@Component(value="CouponService")
public class CouponService {

	@Autowired
	private CouponDAO couponDAO;
	
	public List<Map<String, Object>> selectAll(){
		List<Map<String, Object>> result = new LinkedList<Map<String,Object>>();
		List<CouponBean> beans = couponDAO.selectAll();
		for(int i=0; i<beans.size(); i++){
			CouponBean bean = beans.get(i);
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			String coupon = bean.getCoupon();
			if(bean.getDeadline() == null){
				map1.put("Deadline", "");
			} else {
				if(bean.getDeadline().before(new java.util.Date())){
					this.delete(coupon);
					continue;
				} else {
					map1.put("Deadline", Parse.dateToString(bean.getDeadline()));
				}
			}
			if(bean.getTimes() == null){
				map1.put("Times", "");
			} else {
				if(bean.getTimes() == 0){
					this.delete(coupon);
					continue;
				}else {
					map1.put("Times", bean.getTimes());
				}
			}
			map1.put("Coupon", coupon);
			map1.put("discount", bean.getDiscount());
			if(bean.getNotes() == null){
				map1.put("Notes", "");
			} else {
				map1.put("Notes", bean.getNotes());
			}
			result.add(map1);
		}
		return result;
	}
	
	public CouponBean createOrUpdate(String coupon, int discount, java.util.Date deadline, Integer times, String notes){
		return couponDAO.createOrUpdate(coupon, discount, deadline, times, notes);
	}

	public boolean delete(String coupon){
		return couponDAO.delete(coupon);
	}
	
	public int select(String coupon){
		int result = 0;
		CouponBean bean = couponDAO.select(coupon);
		if(bean != null){
			java.util.Date today = new java.util.Date();
			Integer times = bean.getTimes();
			java.util.Date deadline = bean.getDeadline();
			if(times==null || times>0){
				if(deadline==null || today.before(deadline)){
					result = bean.getDiscount();
				}
			}
		}
		return result;
	}
	
	public int updateUse(String coupon) {
		return couponDAO.updateUse(coupon);
	}

}
