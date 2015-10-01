package model;

import java.util.List;

public interface OrderDAO {

	public abstract OrderBean insert(OrderBean bean);
	
	public abstract OrderBean update(OrderBean bean);
	
	public abstract boolean delete(String orderNo);
	
	public abstract List<OrderBean> selectAll();
	
	public abstract List<OrderBean> selectByDate(String orderDate);
	
	public abstract List<OrderBean> selectByTel(String customerTel);
	
	public abstract List<OrderBean> selectByNote(String bossNotes);
	
	public abstract OrderBean selectByOrderNo(String orderNo);
	
}
