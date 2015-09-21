package model.dao;

import java.util.List;

import model.ProductBean;
import model.ProductDAO;
import model.dao.ProductDAOHibernate;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

public class ProductDAOHibernate implements ProductDAO {
	private static final String GET_ALL_STMT = "from ProductBean order by productId";
	
	@Override
	public List<ProductBean> selectType() {
		List<ProductBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			String HQL_QUERY = "select distinct productType from ProductBean";
			Query query = session.createQuery(HQL_QUERY);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return list;
	}



	@Override
	public ProductBean delete(String productId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ProductBean result = new ProductBean();
		try {
			session.beginTransaction();
			result.setProductId(productId);
			session.delete(result);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}		
		return result;
	}

	@Override
	public List<ProductBean> selectByName(String productname) {
		List<ProductBean> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ProductBean where productname = :productname ");
			query.setParameter("productname", productname);
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}

		return result;
	}

	@Override
	public List<ProductBean> getAll() {
		List<ProductBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return list;
	}

	@Override
	public ProductBean insert(String productId, String productType,
			String productName, int productPrice, String productImgPath,
			String productNote) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ProductBean result = new ProductBean();
		try {
			session.beginTransaction();
			
			result.setProductId(productId);
			result.setProductType(productType);
			result.setProductName(productName);
			result.setProductPrice(productPrice);
			result.setProductImgPath(productImgPath);
			result.setProductNote(productNote);
			session.saveOrUpdate(result);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return result;
	}

	@Override
	public ProductBean update(String productId,String productName, int productPrice,
			String productImgPath, String productNote) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ProductBean result = new ProductBean();
		try {
			session.beginTransaction();
			Query query = session.createQuery("update ProductBean set productname=:productname ,productprice=:productprice,productimgpath=:productimgpath,productnote=:productnote where productid = :productid");
			query.setParameter("productid", productId);
			query.setParameter("productname", productName);
			query.setParameter("productprice", productPrice);
			query.setParameter("productimgpath", productImgPath);
			query.setParameter("productnote", productNote);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return result;
	}

	@Override
	public ProductBean selectById(String productId) {
			ProductBean result = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				result = (ProductBean) session.get(ProductBean.class, productId);
				session.getTransaction().commit();
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}
			return result;
		}
	
	@Override
	public List<ProductBean> selectByType(String producttype) {
		List<ProductBean> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ProductBean where producttype = :producttype");
			query.setParameter("producttype", producttype);
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}

		return result;
	}
}

	



