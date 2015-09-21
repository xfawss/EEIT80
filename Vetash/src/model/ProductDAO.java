package model;

import java.util.List;

import model.ProductBean;

public interface ProductDAO {
	public ProductBean insert(String productId,String productType,String productName,int productPrice,String productImgPath,String productNote);
    public ProductBean update(String productId,String productName,int productPrice,String productImgPath,String productNote);
    public ProductBean delete(String productId);
    public ProductBean selectById(String productId);
    public List<ProductBean> selectByName(String productName);
	public List<ProductBean> selectByType(String productType);
    public List<ProductBean> getAll();
    public List<ProductBean> selectType();
}
