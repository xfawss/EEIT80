package model;

import java.util.ArrayList;
import java.util.List;
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
		
	public  List<SupplierBean> selectAll(){
		List<SupplierBean> result = null;
		
			result = suppDao.selectAll();
	
		return result;
	}
	
	public  SupplierBean selectByTel(String supplierTel){
		SupplierBean result = null;
		if(supplierTel != null && supplierTel.length()!=0){
			result = suppDao.selectByTel(supplierTel);
		}
		return result;
	}

	public  List<SupplierBean> selectByName(String supplierName){
		List<SupplierBean> result = null;
		if(supplierName!=null && supplierName.length()!=0){
			result = suppDao.selectByName(supplierName);
		}
		return result;
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
