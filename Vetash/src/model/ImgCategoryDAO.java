package model;

import java.util.List;

public interface ImgCategoryDAO {
	
	public abstract ImgCategoryBean selectById(int imgCategoryId);
	
	public abstract List<ImgCategoryBean> selectAll();
	
	public abstract int insert(ImgCategoryBean bean);
	
	public abstract int update(String imgCategoryName,int imgCategoryId);	

} 
