package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.naming.java.javaURLContextFactory;

@Entity
@Table(name="PurchaseRecord")
public class PurchaseRecordBean {
	
	@Id
	@Column(name="RecordNo")
	@SequenceGenerator(name="xxx", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="xxx")
	private int recordNo;
	
	@Column(name="Date")
	private java.util.Date date;
	
	@Column(name="Type")
	private String type;
	
	@Column(name="Notes")
	private String notes;
	
	@Column(name="ProductId")
	private String productId;
	
	@Column(name="Number")
	private int number;
	
	@Column(name="Prize")
	private int prize;
	
	@Column(name="SupplierId")
	private int supplierId;

	public int getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
}
