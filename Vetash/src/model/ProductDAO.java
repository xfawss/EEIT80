package model;

import java.util.List;

import model.ProductBean;

public interface ProductDAO {
	public abstract ProductBean insert(ProductBean bean);
    public abstract ProductBean update(ProductBean bean);
    public abstract boolean delete(String productId);
    public abstract ProductBean selectById(String productId);
    public abstract List<ProductBean> selectByName(String productName);
	public abstract List<ProductBean> selectByType(String productType);
    public abstract List<ProductBean> getAll();
    public abstract boolean updateQty(String productId, int productQty, int productCost);
    public abstract List<ProductBean> selectLikeId(String productId);
    public abstract boolean updateQty2(String productId);
}
