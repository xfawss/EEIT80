package model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
			this.getSession().update(bean);
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
		Query query = this.getSession().createQuery("from OrderBean");
		return (List<OrderBean>)query.list();
	}

	@Override
	public List<OrderBean> selectByDate(Date orderDate) {
		Query query = this.getSession().createQuery("from OrderBean where OrderDate like ?");
		query.setParameter(0, orderDate);
		return (List<OrderBean>)query.list();
	}

	@Override
	public List<OrderBean> selectByTel(String customerTel) {
		Query query = this.getSession().createQuery("from OrderBean where CustomerTel = ?");
		query.setParameter(0, customerTel);
		return (List<OrderBean>)query.list();
	}

	@Override
	public List<OrderBean> selectByNote(String bossNotes) {
		Query query = this.getSession().createQuery("from OrderBean where BossNotes = ?");
		query.setParameter(0, bossNotes);
		return (List<OrderBean>)query.list();
	}

}
