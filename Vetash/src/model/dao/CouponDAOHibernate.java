package model.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import model.CouponBean;
import model.CouponDAO;



@Component(value="CouponDAO")
public class CouponDAOHibernate implements CouponDAO {
	@Autowired
	private SessionFactory sessionFactory = null;
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public CouponBean createOrUpdate(String coupon, int discount, java.util.Date deadline, Integer times, String notes) {
		CouponBean result = new CouponBean();
		result.setCoupon(coupon);
		result.setDiscount(discount);
		result.setDeadline(deadline);
		result.setTimes(times);
		result.setNotes(notes);
		this.getSession().saveOrUpdate(result);
		return result;
	}

	@Override
	public List<CouponBean> selectAll() {
		Query query = this.getSession().createQuery("from CouponBean");
		return (List<CouponBean>) query.list();
	}

	@Override
	public boolean delete(String coupon) {
		CouponBean result = (CouponBean) this.getSession().get(CouponBean.class, coupon);
		if(result != null){
			this.getSession().delete(result);
			return true;
		}
		return false;
	}

	@Override
	public CouponBean select(String coupon) {
		CouponBean result = null;
		if(coupon!=null && coupon.length()!=0){
			result = (CouponBean) this.getSession().get(CouponBean.class, coupon);
		}
		return result;
	}
	
	

//	public static void main(String[] args) {
//		SessionFactory sessionFactory = null;
//		try {
//			ApplicationContext context =
//					new ClassPathXmlApplicationContext("/beans.config.xml");
//			
//			sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//			sessionFactory.getCurrentSession().beginTransaction();
//	//		List<CouponsBean> bean = dao.selectAll();
//			CouponsDAO dao= new CouponsDAOHibernate();
//			dao.createOrUpdate("888", 88, new java.util.Date(), 88, null);
//			
//			
//			
////			System.out.println(bean);
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} finally {
//			
//		}
//	}

}
