package model;

import java.util.List;

public interface ImageDAO {

	public abstract ImageBean select(int imageId);

	public abstract List<ImageBean> selectName(String imageName);

	public abstract String selectLast();

	public abstract List<ImageBean> select();

	public abstract ImageBean insert(ImageBean bean);

	public abstract ImageBean update(String imageName, int imageId);

	public abstract boolean delete(int imageId);

}
