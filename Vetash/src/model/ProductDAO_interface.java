package model;

import java.util.List;

import model.ProductVO;

public interface ProductDAO_interface {
	public void insert(ProductVO productVO);
    public void update(ProductVO productVO);
    public void delete(String productId);
    public ProductVO selectById(String productId);
    public List<ProductVO> getAll();
	public ProductVO selectByName(String productName);
	public ProductVO selectByType(String productType);
	public List<ProductVO> selectType();
}
