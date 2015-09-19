package model;

import java.util.List;

public interface ImageDAO {

	public abstract List<ImageBean> selectByImageCategoryId(int imageCategoryId);
	
	public abstract ImageBean selectById(int imageId);

	public abstract List<ImageBean> selectByName(String imageName);

	public abstract String selectLast();

	public abstract List<ImageBean> selectAll();

	public abstract int insert(ImageBean bean);

	public abstract int update(String imageName, int imageId);

	public abstract int delete(int imageId);

}
