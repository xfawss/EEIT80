package model;

import java.util.List;

public interface ImgCategoryDAO {
	
	public abstract ImgCategoryBean select(int imgCategoryId);
	
	public abstract List<ImgCategoryBean> select();
	
	public abstract ImgCategoryBean insert(ImgCategoryBean bean);
	
	public abstract ImgCategoryBean update(String imgCategoryName,int imgCategoryId);	

}
