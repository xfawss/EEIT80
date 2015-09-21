package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.dao.ProductDAOHibernate;











import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value=" ProductService")
public class ProductService {
	
	private ProductDAOHibernate productDAO = new ProductDAOHibernate();

	
	public ProductBean insert(String productId,String productType,String productName,int productPrice,String productImgPath,String productNote) {		
		return  productDAO.insert(productId, productType, productName, productPrice,productImgPath,productNote);
	}


	public ProductBean update(String productId,String productName, int productPrice,
			String productImgPath, String productNote) {
		
		return productDAO.update(productId,productName, productPrice, productImgPath, productNote) ;
	}

	
	public ProductBean delete(String productId) {
		return  productDAO.delete(productId);		
	}

	
	public Map<String, Object> selectById(String productId) {
		Map<String, Object> results = new LinkedHashMap<String, Object>();
		ProductBean bean = null;
		if(productId != null && productId.length()!=0){
			bean = productDAO.selectById(productId);
			results.put("ProductrId", bean.getProductId());
			results.put("ProductName", bean.getProductName());
			results.put("ProductType", bean.getProductType());
			results.put("ProductPrice", bean.getProductPrice());
			results.put("ProductCost", bean.getProductCost());
			results.put("ProductQty", bean.getProductQty());
			results.put("ProductImgPath", bean.getProductImgPath());
			results.put("ProductNote", bean.getProductNote());
		}
		return results;
	}

	
	public List<Map<String, Object>> selectByName(String productName) {
		List<Map<String, Object>> results = new LinkedList<Map<String,Object>>();
		List<ProductBean> beans = productDAO.selectByName(productName);
		for(int i=0; i<beans.size(); i++){
			ProductBean bean = beans.get(i);
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("ProductrId", bean.getProductId());
			map1.put("ProductName", bean.getProductName());
			map1.put("ProductType", bean.getProductType());
			map1.put("ProductPrice", bean.getProductPrice());
			map1.put("ProductCost", bean.getProductCost());
			map1.put("ProductQty", bean.getProductQty());
			map1.put("ProductImgPath", bean.getProductImgPath());
			map1.put("ProductNote", bean.getProductNote());
			results.add(map1);
		}
		return results;
	}


	public List<Map<String, Object>> selectByType(String productType) {
		List<Map<String, Object>> results = new LinkedList<Map<String,Object>>();
		List<ProductBean> beans = productDAO.selectByType(productType);
		for(int i=0; i<beans.size(); i++){
			ProductBean bean = beans.get(i);
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("ProductrId", bean.getProductId());
			map1.put("ProductName", bean.getProductName());
			map1.put("ProductType", bean.getProductType());
			map1.put("ProductPrice", bean.getProductPrice());
			map1.put("ProductCost", bean.getProductCost());
			map1.put("ProductQty", bean.getProductQty());
			map1.put("ProductImgPath", bean.getProductImgPath());
			map1.put("ProductNote", bean.getProductNote());
			results.add(map1);
		}
		return results;
	}

	
	public List<Map<String, Object>>  getAll() {
		List<Map<String, Object>> results = new LinkedList<Map<String,Object>>();
		List<ProductBean> beans = productDAO. getAll();
		for(int i=0; i<beans.size(); i++){
			ProductBean bean = beans.get(i);
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("ProductrId", bean.getProductId());
			map1.put("ProductName", bean.getProductName());
			map1.put("ProductType", bean.getProductType());
			map1.put("ProductPrice", bean.getProductPrice());
			map1.put("ProductCost", bean.getProductCost());
			map1.put("ProductQty", bean.getProductQty());
			map1.put("ProductImgPath", bean.getProductImgPath());
			map1.put("ProductNote", bean.getProductNote());
			results.add(map1);
		}
		return results;
	}
	
	public List<Map<String, Object>> selectType() {
		List<Map<String, Object>> results = new LinkedList<Map<String,Object>>();
		List<ProductBean> beans = productDAO. selectType();
		for(int i=0; i<beans.size(); i++){
			ProductBean bean = beans.get(i);
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("ProductType", bean.getProductType());			
			results.add(map1);
		}
		return results;
	}
	
}
