package model.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.AccessBackBean;
import model.AccessBackDAO;
import model.CouponBean;


@Component(value="AccessBackDAO")
public class AccessBackDAOHibernate implements AccessBackDAO {
	@Autowired
	private SessionFactory sessionFactory= null;
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public AccessBackBean getAcess(String bigWave) {
		return (AccessBackBean) this.getSession().get(AccessBackBean.class, bigWave);
	}

	@Override
	public AccessBackBean changePass(String bigWave, byte[] newPassKey) {
		AccessBackBean result = this.getAcess(bigWave);
		result.setPassKey(newPassKey);
		this.getSession().update(result);
		return result;
	}

	@Override
	public AccessBackBean insert(String bigWave, byte[] passKey) {
		AccessBackBean bean = new AccessBackBean();
		bean.setBigWave(bigWave);
		bean.setPassKey(passKey);
		this.getSession().save(bean);
		return bean;
	}
	
	

}
