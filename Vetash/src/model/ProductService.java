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

	public int price(String productId) {		
		return productDAO.price(productId);
	}
	
	public int price2(OrderBean bean) {
		int result = 0;
		List<ProductBean> beans = productDAO.getAll();
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		for (ProductBean temp1 : beans) {
			map1.put(temp1.getProductId(), temp1.getProductPrice());
		}
		try {
			result += map1.get(bean.getHousing());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getRocker());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getL1());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getL2());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getR1());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getR2());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getO());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getX());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getSquare());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getTriangle());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getStart());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getSelecter());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getTouch());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get(bean.getBoard());
		} catch (Exception e) {
			result += 0;
		}
		try {
			result += map1.get("000");
		} catch (Exception e) {
			result += 0;
		}
		return result;
	}

	public ProductBean update(ProductBean bean) {
		return productDAO.update(bean) ;
	}
	
	public boolean updateQty(String productId, int num, int prize) {
		return productDAO.updateQty(productId, num, prize);
	}
	
	public boolean updateQty2(String productId, int productQty) {
		return productDAO.updateQty2(productId, productQty);
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
