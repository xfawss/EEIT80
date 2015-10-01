package model.dao;

import java.util.List;

import model.OrderBean;
import model.ProductBean;
import model.ProductDAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="ProductDAO")
public class ProductDAOHibernate implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory = null;
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public int sumOfPrice(OrderBean bean) {
		Query query = this.getSession().createQuery("select sum(ProductPrice) from Product where productId in (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		query.setParameter(0, bean.getHousing());
		query.setParameter(1, bean.getRocker());
		query.setParameter(2, bean.getL1());
		query.setParameter(3, bean.getL2());
		query.setParameter(4, bean.getR1());
		query.setParameter(5, bean.getR2());
		query.setParameter(6, bean.getO());
		query.setParameter(7, bean.getX());
		query.setParameter(8, bean.getSelecter());
		query.setParameter(9, bean.getTriangle());
		query.setParameter(10, bean.getSquare());
		query.setParameter(11, bean.getStart());
		query.setParameter(12, bean.getTouch());
		query.setParameter(13, bean.getBoard());
		query.setParameter(14, "000");
		return (int) query.list().get(0);
	}

	@Override
	public boolean delete(String productId) {
		ProductBean result = (ProductBean)this.getSession().get(ProductBean.class, productId);
		if(result != null) {
			this.getSession().delete(result);
			return true;
		}
		return false;
	}

	@Override
	public List<ProductBean> selectByName(String productname) {
		List<ProductBean> result = null;
		Query query = this.getSession().createQuery("from ProductBean where productname like ?");
		query.setParameter(0, "%"+productname+"%");
		result = (List<ProductBean>)query.list();
		return result;
	}

	@Override
	public List<ProductBean> getAll() {
		List<ProductBean> list = null;
		Query query = this.getSession().createQuery("from ProductBean order by productId");
		list = (List<ProductBean>)query.list();
		return list;
	}

	@Override
	public ProductBean insert(ProductBean bean) {
		ProductBean result = (ProductBean)this.getSession().get(ProductBean.class, bean.getProductId());
		if(result == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public ProductBean update(ProductBean bean) {
		ProductBean result = (ProductBean) this.getSession().get(ProductBean.class, bean.getProductId());
		if (result != null) {
			result.setProductType(bean.getProductType());
			result.setProductName(bean.getProductName());
			result.setProductPrice(bean.getProductPrice());
			result.setProductCost(bean.getProductCost());
			result.setProductQty(bean.getProductQty());
			result.setProductImgPath(bean.getProductImgPath());
			result.setProductNote(bean.getProductNote());
			result.setProductColor(bean.getProductColor());
			return bean;
		}
		return null;
	}

	@Override
	public ProductBean selectById(String productId) {
			ProductBean result = null;
			result = (ProductBean) this.getSession().get(ProductBean.class, productId);
			return result;
		}
	@Override
	public List<ProductBean> selectByType(String producttype) {
		List<ProductBean> result = null;
		Query query = this.getSession().createQuery("from ProductBean where ProductType = ?");
		query.setParameter(0, producttype);
		result = (List<ProductBean>)query.list();
		return result;
	}

	@Override
	public boolean updateQty(String productId, int num, int prize) {
		ProductBean bean = (ProductBean)this.getSession().get(ProductBean.class, productId);
		if(bean != null) {
			int Qty = bean.getProductQty();
			double temp = bean.getProductCost();
			bean.setProductQty(Qty+num);
			double productCost = (Qty*temp+prize)/(num+Qty);
			bean.setProductCost(productCost);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateQty2(String productId, int productQty) {
		ProductBean bean = (ProductBean)this.getSession().get(ProductBean.class, productId);
		if(bean != null) {
			bean.setProductQty(bean.getProductQty() + productQty);
			return true;
		}
		return false;
	}

	@Override
	public List<ProductBean> selectLikeId(String productId) {
		List<ProductBean> result = null;
		Query query = this.getSession().createQuery("from ProductBean where productid like :productid ");
		query.setParameter("productid", "%"+productId+"%");
		result = (List<ProductBean>)query.list();
		return result;
	}
}

	



