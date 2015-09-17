package model;

import java.util.List;

import model.ProductBean;

public interface ProductDAO {
	public abstract ProductBean insert(String productId,String productType,String productName,int productPrice,String productImgPath,String productNote);
    public abstract ProductBean update(String productName,int productPrice,String productImgPath,String productNote);
    public abstract boolean delete(String productId);
    public abstract ProductBean selectById(String productId);
    public abstract List<ProductBean> getAll();
	public abstract ProductBean selectByName(String productName);
	public abstract ProductBean selectByType(String productType);
	public abstract List<ProductBean> selectType();
}
