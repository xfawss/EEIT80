package model;

import java.util.List;

public interface ImageDAO {

	public abstract ImageBean selectById(int imageId);

	public abstract List<ImageBean> selectByName(String imageName);

	public abstract List<ImageBean> selectAll();

	public abstract List<ImageBean> selectByImgCategoryName(String imgCategoryName);

	public abstract int insert(ImageBean bean);

	public abstract int update(String imageName, String imagePath, String imageCategoryname, int imageId);

	public abstract int delete(int imageId);
	
	public abstract List<String> selectByType();

}
