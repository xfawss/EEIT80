package model;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 




@Table(name = "Vetash")
public class ProductVO implements java.io.Serializable {
	private String productId;
	private String productType;
	private String productName;
	private int productPrice;
	private int productCost;
	private int productQty;
	private String productImgPath;
	private String productNote;
	
	public String getProductNote() {
		return productNote;
	}

	public void setProductNote(String productNote) {
		this.productNote = productNote;
	}

	//@JoinColumn(name = "ProductId") 
	public String getProductId() {
		return productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	//@JoinColumn(name = "ProductType") 
	
	
	//@JoinColumn(name = "ProductName") 
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	//@JoinColumn(name = "ProductPrice") 
	public int getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	//@JoinColumn(name = "ProductCost") 
	public int getProductCost() {
		return productCost;
	}
	
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	//@JoinColumn(name = "ProductQty") 
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	//@JoinColumn(name = "ProductImgPath") 
	public String getProductImgPath() {
		return productImgPath;
	}
	public void setProductImgPath(String productImgPath) {
		this.productImgPath = productImgPath;
	}
	
	}

