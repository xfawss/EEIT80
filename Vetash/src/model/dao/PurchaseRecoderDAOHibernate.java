package model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import misc.Parse;
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
		this.getSession().save(bean);
		return bean;
	}

	@Override
	public List<PurchaseRecordBean> select() {
		Query query = this.getSession().createQuery("from PurchaseRecordBean order by RecordNo DESC");
		return (List<PurchaseRecordBean>)query.list();
	}

	@Override
	public List<PurchaseRecordBean> selectByDate(String date) {
		Query query = this.getSession().createQuery("from PurchaseRecordBean where Date like ? order by RecordNo DESC");
		query.setParameter(0, "%"+date+"%");
		return (List<PurchaseRecordBean>)query.list();
	}

	@Override
	public List<PurchaseRecordBean> selectByType(String type) {
		Query query = this.getSession().createQuery("from PurchaseRecordBean where Type=? order by RecordNo DESC");
		query.setParameter(0, type);
		return (List<PurchaseRecordBean>)query.list();
	}

	@Override
	public List<PurchaseRecordBean> selectByProductId(String productId) {
		Query query = this.getSession().createQuery("from PurchaseRecordBean where ProductId like ? order by RecordNo DESC");
		query.setParameter(0, "%"+productId+"%");
		return (List<PurchaseRecordBean>)query.list();
	}

}
