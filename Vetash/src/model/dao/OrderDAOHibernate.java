package model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import misc.Parse;
import model.CouponBean;
import model.CustomerBean;
import model.OrderBean;
import model.OrderDAO;

@Component(value="OrderDAO")
public class OrderDAOHibernate implements OrderDAO {
	@Autowired
	private SessionFactory sessionFactory = null;
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public OrderBean insert(OrderBean bean) {
		OrderBean result = (OrderBean)this.getSession().get(OrderBean.class, bean.getOrderNo());
		if(result == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public OrderBean update(OrderBean bean) {
		OrderBean result = (OrderBean)this.getSession().get(OrderBean.class, bean.getOrderNo());
		if(result != null) {
			result.setHousing(bean.getHousing());
			result.setRocker(bean.getRocker());
			result.setL1(bean.getL1());
			result.setL2(bean.getL2());
			result.setR1(bean.getR1());
			result.setR2(bean.getR2());
			result.setO(bean.getO());
			result.setX(bean.getX());
			result.setSquare(bean.getSquare());
			result.setTriangle(bean.getTriangle());
			result.setStart(bean.getStart());
			result.setSelecter(bean.getSelecter());
			result.setTouch(bean.getTouch());
			result.setCoverImg(bean.getCoverImg());
			result.setBoard(bean.getBoard());
			result.setBossNotes(bean.getBossNotes());
			result.setOrderState(bean.getOrderState());
			result.setPrice(bean.getPrice());
			result.setDeliveryDate(bean.getDeliveryDate());
			return bean;
		}
		return null;
	}

	@Override
	public boolean delete(String orderNo) {
		OrderBean result = (OrderBean)this.getSession().get(OrderBean.class, orderNo);
		if(result != null) {
			this.getSession().delete(result);
			return true;
		}
		return false;
	}

	@Override
	public List<OrderBean> selectAll() {
		//SELECT * FROM Orderlist left outer join Customer on (Orderlist.CustomerTel = Customer.CustomerTel) order by OrderDate DESC
		Query query = this.getSession().createQuery("from OrderBean order by OrderDate DESC");
		return (List<OrderBean>)query.list();
	}

	@Override
	public List<OrderBean> selectByDate(String orderDate) {
		Query query = this.getSession().createQuery("from OrderBean where CONVERT(VARCHAR, OrderDate , 120) like ? order by OrderDate DESC");
		query.setParameter(0, "%"+orderDate+"%");
		return (List<OrderBean>)query.list();
	}

	@Override
	public List<OrderBean> selectByTel(String customerTel) {
		Query query = this.getSession().createQuery("from OrderBean where CustomerTel like ? order by OrderDate DESC");
		query.setParameter(0, "%"+customerTel+"%");
		return (List<OrderBean>)query.list();
	}

	@Override
	public List<OrderBean> selectByNote(String bossNotes) {
		Query query = this.getSession().createQuery("from OrderBean where BossNotes like ? order by OrderDate DESC");
		query.setParameter(0, "%"+bossNotes+"%");
		return (List<OrderBean>)query.list();
	}

	@Override
	public OrderBean selectByOrderNo(String orderNo) {
		OrderBean result = null;
		if(orderNo!=null && orderNo.length()!=0){
			result = (OrderBean) this.getSession().get(OrderBean.class, orderNo);
		}
		return result;
	}

	@Override
	public OrderBean update2(OrderBean bean) {
		OrderBean result = (OrderBean)this.getSession().get(OrderBean.class, bean.getOrderNo());
		if(result != null) {
			result.setPaymentType(bean.getPaymentType());
			result.setPaymentTypeChargeFee(bean.getPaymentTypeChargeFee());
			result.setAllPayTradeNo(bean.getAllPayTradeNo());
			result.setOrderState("已結帳");
			return bean;
		}
		return null;
	}
	
	

}
