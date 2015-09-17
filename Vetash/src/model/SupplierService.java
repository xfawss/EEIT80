package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
			map1.put("SupplierId", bean.getSupplierId());
			map1.put("SupplierName", bean.getSupplierName());
			map1.put("SupplierTax", bean.getSupplierTax());
			map1.put("SupplierContact", bean.getSupplierContact());
			map1.put("SupplierTel", bean.getSupplierTel());
			map1.put("SupplierAddr", bean.getSupplierAddr());
			map1.put("SupplierAcct", bean.getSupplierAcct());
			map1.put("SupplierDate", bean.getSupplierDate());
			map1.put("SupplierNote", bean.getSupplierNote());
			results.add(map1);
		}
		return results;
	}
	
	public  Map<String, Object> selectByTel(String supplierTel){
		Map<String, Object> results = new LinkedHashMap<String, Object>();
		SupplierBean bean = null;
		if(supplierTel != null && supplierTel.length()!=0){
			bean = suppDao.selectByTel(supplierTel);
			results.put("SupplierId", bean.getSupplierId());
			results.put("SupplierName", bean.getSupplierName());
			results.put("SupplierTax", bean.getSupplierTax());
			results.put("SupplierContact", bean.getSupplierContact());
			results.put("SupplierTel", bean.getSupplierTel());
			results.put("SupplierAddr", bean.getSupplierAddr());
			results.put("SupplierAcct", bean.getSupplierAcct());
			results.put("SupplierDate", bean.getSupplierDate());
			results.put("SupplierNote", bean.getSupplierNote());
		}
		return results;
	}

	public  List<Map<String, Object>> selectByName(String supplierName){
		List<Map<String, Object>> results = new LinkedList<Map<String,Object>>();
		List<SupplierBean> beans = suppDao.selectByName(supplierName);
		for(int i=0; i<beans.size(); i++){
			SupplierBean bean = beans.get(i);
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			map1.put("SupplierId", bean.getSupplierId());
			map1.put("SupplierName", bean.getSupplierName());
			map1.put("SupplierTax", bean.getSupplierTax());
			map1.put("SupplierContact", bean.getSupplierContact());
			map1.put("SupplierTel", bean.getSupplierTel());
			map1.put("SupplierAddr", bean.getSupplierAddr());
			map1.put("SupplierAcct", bean.getSupplierAcct());
			map1.put("SupplierDate", bean.getSupplierDate());
			map1.put("SupplierNote", bean.getSupplierNote());
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
}
