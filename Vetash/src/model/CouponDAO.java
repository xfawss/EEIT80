package model;

import java.util.List;

public interface CouponDAO {
	
	public abstract CouponBean createOrUpdate(String coupon, int discount, java.util.Date deadline, Integer times, String notes);
	
	public abstract List<CouponBean> selectAll();
	
	public abstract CouponBean select(String coupon);
	
	public abstract boolean delete(String coupon);
	
	public abstract int updateUse(String coupon);
	
}
