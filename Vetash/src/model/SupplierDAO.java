package model;

import java.util.List;

public interface SupplierDAO {

	public abstract SupplierBean selectById(int supplierId);
	
	public abstract SupplierBean selectByTel(String supplierTel);

	public abstract List<SupplierBean> selectByName(String supplierName);

	public abstract List<SupplierBean> selectAll();

	public abstract int insert(SupplierBean bean);

	public abstract int update(String supplierName ,String supplierTax ,String supplierContact 
			,String supplierTel ,String supplierAddr,String supplierAcct
			,java.util.Date supplierDate,String supplierNote, int supplierId);

	public abstract int delete(int supplierId);
	
}
