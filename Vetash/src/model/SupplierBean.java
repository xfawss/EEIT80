package model;

public class SupplierBean {

	private int supplierId;
	private String supplierName;
	private String supplierTax;
	private String supplierContact;
	private String supplierTel;
	private String supplierAddr;
	private String supplierAcct;
	private java.util.Date supplierDate;
	private String supplierNote;
	
	@Override
	public String toString() {
		return "SupplierBean [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierTax="
				+ supplierTax + ", supplierContact=" + supplierContact + ", supplierTel=" + supplierTel
				+ ", supplierAddr=" + supplierAddr + ", supplierAcct=" + supplierAcct + ", supplierDate=" + supplierDate
				+ ", supplierNote=" + supplierNote + "]";
	}
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierTax() {
		return supplierTax;
	}
	public void setSupplierTax(String supplierTax) {
		this.supplierTax = supplierTax;
	}
	public String getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}
	public String getSupplierTel() {
		return supplierTel;
	}
	public void setSupplierTel(String supplierTel) {
		this.supplierTel = supplierTel;
	}
	public String getSupplierAddr() {
		return supplierAddr;
	}
	public void setSupplierAddr(String supplierAddr) {
		this.supplierAddr = supplierAddr;
	}
	public String getSupplierAcct() {
		return supplierAcct;
	}
	public void setSupplierAcct(String supplierAcct) {
		this.supplierAcct = supplierAcct;
	}
	public java.util.Date getSupplierDate() {
		return supplierDate;
	}
	public void setSupplierDate(java.util.Date supplierDate) {
		this.supplierDate = supplierDate;
	}
	public String getSupplierNote() {
		return supplierNote;
	}
	public void setSupplierNote(String supplierNote) {
		this.supplierNote = supplierNote;
	}
}
