package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component(value = "ProductService")
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	
	public ProductBean insert(ProductBean bean) {		
		return  productDAO.insert(bean);
	}


	public ProductBean update(ProductBean bean) {
		return productDAO.update(bean) ;
	}
	
	public boolean updateQty(String productId, int num, int prize) {
		return productDAO.updateQty(productId, num, prize);
	}
	
	public boolean updateQty2(String productId) {
		return productDAO.updateQty2(productId);
	}
	
	public boolean delete(String productId) {
		return  productDAO.delete(productId);		
	}

	
	public List<Map<String, Object>> selectById(String productId) {
		List<Map<String, Object>> results = new LinkedList<Map<String, Object>>();
		ProductBean bean = null;
		Map<String, Object> map1 = new LinkedHashMap<String, Object>();
		if(productId != null && productId.length()!=0){
			bean = productDAO.selectById(productId);
			map1.put("productId", bean.getProductId());
			map1.put("productName", bean.getProductName());
			map1.put("productType", bean.getProductType());
			map1.put("productPrice", bean.getProductPrice());
			map1.put("productCost", bean.getProductCost());
			map1.put("productQty", bean.getProductQty());
			map1.put("productImgPath", bean.getProductImgPath());
			map1.put("productNote", bean.getProductNote());
			map1.put("productColor", bean.getProductColor());
			results.add(map1);
		}
		return results;
	}

	
	public List<Map<String, Object>> selectByName(String productName) {
		List<Map<String, Object>> results = new LinkedList<Map<String,Object>>();
		List<ProductBean> beans = productDAO.selectByName(productName);
		for(int i=0; i<beans.size(); i++){
			ProductBean bean = beans.get(i);
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("productId", bean.getProductId());
			map1.put("productName", bean.getProductName());
			map1.put("productType", bean.getProductType());
			map1.put("productPrice", bean.getProductPrice());
			map1.put("productCost", bean.getProductCost());
			map1.put("productQty", bean.getProductQty());
			map1.put("productImgPath", bean.getProductImgPath());
			map1.put("productNote", bean.getProductNote());
			map1.put("productColor", bean.getProductColor());
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
			map1.put("productId", bean.getProductId());
			map1.put("productName", bean.getProductName());
			map1.put("productType", bean.getProductType());
			map1.put("productPrice", bean.getProductPrice());
			map1.put("productCost", bean.getProductCost());
			map1.put("productQty", bean.getProductQty());
			map1.put("productImgPath", bean.getProductImgPath());
			map1.put("productNote", bean.getProductNote());
			map1.put("productColor", bean.getProductColor());
			results.add(map1);
		}
		return results;
	}

	
	public List<Map<String, Object>>  getAll() {
		List<Map<String, Object>> results = new LinkedList<Map<String,Object>>();
		List<ProductBean> beans = productDAO.getAll();
		for(int i=0; i<beans.size(); i++){
			ProductBean bean = beans.get(i);
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("productId", bean.getProductId());
			map1.put("productName", bean.getProductName());
			map1.put("productType", bean.getProductType());
			map1.put("productPrice", bean.getProductPrice());
			map1.put("productCost", bean.getProductCost());
			map1.put("productQty", bean.getProductQty());
			map1.put("productImgPath", bean.getProductImgPath());
			map1.put("productNote", bean.getProductNote());
			map1.put("productColor", bean.getProductColor());
			results.add(map1);
		}
		return results;
	}
	
//	public Map<String,String> selectType(String productType) {
//		Map<String,String> results = new LinkedHashMap<String,String>();
//		List<ProductBean> beans = productDAO.selectByType(productType);		
//		
//		for(int i=0; i<beans.size(); i++){
//			Map<String, String> map1 = new LinkedHashMap<String, String>();
//			ProductBean bean = beans.get(i);			
//			map1.put("prodouctTypes", bean.getProductId());			
//		}
//		
//		return results;
//	}
	
	public Map<String,Map<String,String[]>> selectType(String productType) {
		Map<String,Map<String,String[]>> results = new LinkedHashMap<String,Map<String,String[]>>();
		List<ProductBean> beans = productDAO.selectByType(productType);
		String[] str = {};
		
		for(int i=0; i<beans.size(); i++){
			Map<String, String[]> map1 = new LinkedHashMap<String, String[]>();
			ProductBean bean = beans.get(i);
			str[i]=new String (bean.getProductId());
			map1.put("prodouctTypes", str);					
			results.put("results",map1);
		}
		return results;
	}
	
	public int selectCostById(String productId) {
		ProductBean bean = productDAO.selectById(productId);
		if(bean != null) {
			return bean.getProductPrice();
		}
		return 0;
	}
	
	public boolean updateQty(String productId) {
		ProductBean bean = productDAO.selectById(productId);
		if(bean != null) {
			bean.setProductQty(bean.getProductQty()-1);
			productDAO.update(bean);
			return true;
		}
		return false;
	}
	
	public List<Map<String, Object>> selectLikeId(String productId) {
		List<Map<String, Object>> results = new LinkedList<Map<String,Object>>();
		List<ProductBean> beans = productDAO.selectLikeId(productId);
		for(int i=0; i<beans.size(); i++){
			ProductBean bean = beans.get(i);
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("productId", bean.getProductId());
			map1.put("productName", bean.getProductName());
			map1.put("productType", bean.getProductType());
			map1.put("productPrice", bean.getProductPrice());
			map1.put("productCost", bean.getProductCost());
			map1.put("productQty", bean.getProductQty());
			map1.put("productImgPath", bean.getProductImgPath());
			map1.put("productNote", bean.getProductNote());
			results.add(map1);
		}
		return results;
	}
}
