package model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.PurchaseRecoderDAO;
import model.PurchaseRecordBean;

@Component(value="PurchaseRecoderDAO")
public class PurchaseRecoderDAOHibernate implements PurchaseRecoderDAO {

	@Autowired
	private SessionFactory sessionFactory = null; 
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public PurchaseRecordBean insert(PurchaseRecordBean bean) {
		PurchaseRecordBean result = (PurchaseRecordBean) this.getSession().get(PurchaseRecordBean.class, bean.getRecordNo());
		if(result == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public List<PurchaseRecordBean> select() {
		Query query = this.getSession().createQuery("from PurchaseRecordBean");
		return (List<PurchaseRecordBean>)query.list();
	}

	@Override
	public List<PurchaseRecordBean> selectByDate(Date date) {
		Query query = this.getSession().createQuery("from PurchaseRecordBean where Date=?");
		query.setParameter(0, date);
		return (List<PurchaseRecordBean>)query.list();
	}

	@Override
	public List<PurchaseRecordBean> selectByType(String type) {
		Query query = this.getSession().createQuery("from PurchaseRecordBean where Type=?");
		query.setParameter(0, type);
		return (List<PurchaseRecordBean>)query.list();
	}

	@Override
	public List<PurchaseRecordBean> selectByProductId(String productId) {
		Query query = this.getSession().createQuery("from PurchaseRecordBean where ProductId=?");
		query.setParameter(0, productId);
		return (List<PurchaseRecordBean>)query.list();
	}

	@Override
	public List<PurchaseRecordBean> selectBySupplierId(int supplierId) {
		Query query = this.getSession().createQuery("from PurchaseRecordBean where SupplierId=?");
		query.setParameter(0, supplierId);
		return (List<PurchaseRecordBean>)query.list();
	}

}
