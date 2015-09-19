package model;

import java.util.ArrayList;
import java.util.List;

import model.dao.ImageDAOjdbc;

public class ImageService {

	private ImageDAO imgDao = new ImageDAOjdbc();

	public List<ImageBean> selectByImageCategoryId(int imageCategoryId) {
		List<ImageBean> result = null;
		if (imageCategoryId != 0) {
			result = new ArrayList<ImageBean>();
			result = imgDao.selectByImageCategoryId(imageCategoryId);
		}
		return result;
	}

	public ImageBean selectById(int imageId) {
		ImageBean bean = null;
		if (imageId != 0) {
			bean = imgDao.selectById(imageId);
		}
		return bean;
	}

	public List<ImageBean> selectAll(ImageBean bean) {
		List<ImageBean> result = null;
		if (bean != null) {
			result = new ArrayList<ImageBean>();
			result = imgDao.selectAll();
		}
		return result;
	}

	public List<ImageBean> selectName(String imageName) {
		List<ImageBean> result = null;
		if (imageName != null) {
			result = imgDao.selectByName(imageName);
		}
		return result;
	}

	public String selectLast() {
		String imageId = imgDao.selectLast();
		return imageId;
	}

	public int insert(ImageBean bean) {
		int result = 0;
		if (bean != null) {
			result = imgDao.insert(bean);
		}
		return result;
	}

	public int update(ImageBean bean) {
		int result = 0;
		if (bean != null) {
			result = imgDao.update(bean.getImageName(), bean.getImageId());
		}
		return result;
	}

	public int delete(ImageBean bean) {
		int result = 0;
		if (bean != null) {
			result = imgDao.delete(bean.getImageId());
		}
		return result;
	}
}
