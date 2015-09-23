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
	
	public  Map<String, Object> selectByTel(String supplierTel){
		Map<String, Object> results = new LinkedHashMap<String, Object>();
		SupplierBean bean = null;
		if(supplierTel != null && supplierTel.length()!=0){
			bean = suppDao.selectByTel(supplierTel);
			results.put("supplierId", bean.getSupplierId());
			results.put("supplierName", bean.getSupplierName());
			results.put("supplierTax", bean.getSupplierTax());
			results.put("supplierContact", bean.getSupplierContact());
			results.put("supplierTel", bean.getSupplierTel());
			results.put("supplierAddr", bean.getSupplierAddr());
			results.put("supplierAcct", bean.getSupplierAcct());
			results.put("supplierDate", Parse.dateToString(bean.getSupplierDate()));
			results.put("supplierNote", bean.getSupplierNote());
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
