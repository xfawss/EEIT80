package model;


import javax.persistence.*;

@Entity
@Table(name = "Product")
public class ProductBean implements java.io.Serializable {
	
	@Id
	@Column(name="productId")
	@SequenceGenerator(name="product", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="product")
	private String productId;
	
	@Column(name="productType")
	private String productType;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productPrice")
	private int productPrice;
	
	@Column(name="productCost")
	private int productCost;
	
	@Column(name="productQty")
	private int productQty;
	
	@Column(name="productImgPath")
	private String productImgPath;
	
	@Column(name="productNote")
	private String productNote;
	
	@Column(name="ProductColor")
	private String productColor;
	
	public String getProductNote() {
		return productNote;
	}

	public void setProductNote(String productNote) {
		this.productNote = productNote;
	}

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

	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCost() {
		return productCost;
	}
	
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	
	public String getProductImgPath() {
		return productImgPath;
	}
	public void setProductImgPath(String productImgPath) {
		this.productImgPath = productImgPath;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	
}

