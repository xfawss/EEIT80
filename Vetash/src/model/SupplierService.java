package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import misc.Parse;
import model.dao.SupplierDAOjdbc;

public class SupplierService {

	private SupplierDAO suppDao = new SupplierDAOjdbc();
	
	public  SupplierBean  selectById(SupplierBean bean){
		SupplierBean result = null;
		
		if (bean != null) {
			result = suppDao.selectById(bean.getSupplierId());
		}
		return result;
	} 
		
	public  List<Map<String, Object>> selectAll(){
		List<Map<String, Object>> results = new LinkedList<Map<String,Object>>();
		List<SupplierBean> beans = suppDao.selectAll();
		for(int i=0; i<beans.size(); i++){
			SupplierBean bean = beans.get(i);
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("supplierId", bean.getSupplierId());
			map1.put("supplierName", bean.getSupplierName());
			map1.put("supplierTax", bean.getSupplierTax());
			map1.put("supplierContact", bean.getSupplierContact());
			map1.put("supplierTel", bean.getSupplierTel());
			map1.put("supplierAddr", bean.getSupplierAddr());
			map1.put("supplierAcct", bean.getSupplierAcct());
			map1.put("supplierDate", Parse.dateToString(bean.getSupplierDate()));
			map1.put("supplierNote", bean.getSupplierNote());
			results.add(map1);
		}
		return results;
	}
	
	public  List<Map<String, Object>> selectByTel(String supplierTel){
		List<Map<String, Object>> results = new LinkedList<Map<String, Object>>();
		
		
		if(supplierTel != null && supplierTel.length()!=0){
			SupplierBean bean = suppDao.selectByTel(supplierTel);
			if(bean != null){
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("supplierId", bean.getSupplierId());
			map1.put("supplierName", bean.getSupplierName());
			map1.put("supplierTax", bean.getSupplierTax());
			map1.put("supplierContact", bean.getSupplierContact());
			map1.put("supplierTel", bean.getSupplierTel());
			map1.put("supplierAddr", bean.getSupplierAddr());
			map1.put("supplierAcct", bean.getSupplierAcct());
			map1.put("supplierDate", Parse.dateToString(bean.getSupplierDate()));
			map1.put("supplierNote", bean.getSupplierNote());
			results.add(map1);
		}
			}
		return results;
	}

	public  List<Map<String, Object>> selectByName(String supplierName){
		List<Map<String, Object>> results = new LinkedList<Map<String,Object>>();
		List<SupplierBean> beans = suppDao.selectByName(supplierName);
		for(int i=0; i<beans.size(); i++){
			SupplierBean bean = beans.get(i);
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("supplierId", bean.getSupplierId());
			map1.put("supplierName", bean.getSupplierName());
			map1.put("supplierTax", bean.getSupplierTax());
			map1.put("supplierContact", bean.getSupplierContact());
			map1.put("supplierTel", bean.getSupplierTel());
			map1.put("supplierAddr", bean.getSupplierAddr());
			map1.put("supplierAcct", bean.getSupplierAcct());
			map1.put("supplierDate", Parse.dateToString(bean.getSupplierDate()));
			map1.put("supplierNote", bean.getSupplierNote());
			results.add(map1);
		}
		return results;
	}

	public  int insert(SupplierBean bean){
		int result = 0;
		if (bean != null) {
			result = suppDao.insert(bean);
		}	
		return result;
	}

	public  int update(SupplierBean bean){
		
		int result = 0;
		if(bean!=null) {
			result = suppDao.update(bean.getSupplierName(),bean.getSupplierTax(),
					bean.getSupplierContact(),bean.getSupplierTel(),bean.getSupplierAddr(),
					bean.getSupplierAcct(),bean.getSupplierDate(),bean.getSupplierNote(),bean.getSupplierId());
		}
		return result;
	}

	public  int delete(SupplierBean bean){
		int result = 0;
		if(bean != null ){
			result =  suppDao.delete(bean.getSupplierId());
		}
		return result;
	}
	
	public  List<Map<String, Object>> selectSuppliersByProductId(String productId){
		List<Map<String, Object>> results = new LinkedList<Map<String,Object>>();
		List<SupplierBean> beans = suppDao.selectSuppliersById(productId);		
		for(int i=0; i<beans.size(); i++){
			SupplierBean bean = beans.get(i);
			SupplierBean bean1 = suppDao.selectById(bean.getSupplierId());
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("supplierId", bean1.getSupplierId());
			map1.put("supplierName", bean1.getSupplierName());
			map1.put("supplierTax", bean1.getSupplierTax());
			map1.put("supplierContact", bean1.getSupplierContact());
			map1.put("supplierTel", bean1.getSupplierTel());
			map1.put("supplierAddr", bean1.getSupplierAddr());
			map1.put("supplierAcct", bean1.getSupplierAcct());
			map1.put("supplierDate", Parse.dateToString(bean1.getSupplierDate()));
			map1.put("supplierNote", bean1.getSupplierNote());
			results.add(map1);
		}
		return results;
	}
}
