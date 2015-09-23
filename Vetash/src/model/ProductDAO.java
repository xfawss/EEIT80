package model;

import java.util.List;

import model.ProductBean;

public interface ProductDAO {
	public abstract ProductBean insert(String productId,String productType,String productName,int productPrice,String productImgPath,String productNote, String productColor);
    public abstract ProductBean update(String productId,String productName,int productPrice,String productImgPath,String productNote, String productColor);
    public abstract boolean delete(String productId);
    public abstract ProductBean selectById(String productId);
    public abstract List<ProductBean> selectByName(String productName);
	public abstract List<ProductBean> selectByType(String productType);
    public abstract List<ProductBean> getAll();
    public abstract boolean updateQty(String productId, int productQty, int productCost);
}
