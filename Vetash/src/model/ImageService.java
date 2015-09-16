package model;

import java.util.ArrayList;
import java.util.List;

import model.dao.ImageDAOjdbc;

public class ImageService {

	private ImageDAO imgDao = new ImageDAOjdbc();

	public List<ImageBean> select(ImageBean bean) {
		List<ImageBean> result = null;
		if (bean != null && bean.getImageId() != 0) {
			ImageBean temp = imgDao.select(bean.getImageId());

			if (temp != null) {
				result = new ArrayList<ImageBean>();
				result.add(temp);
			}
		} else {
			result = imgDao.select();
		}
		return result;
	}

	public List<ImageBean> selectName(String imageName) {
		List<ImageBean> result = null;
		if (imageName != null) {
			result = imgDao.selectName(imageName);
		}
		return result;
	}

	public String selectLast() {
		String result = imgDao.selectLast();
		return result;
	}

	public ImageBean insert(ImageBean bean) {
		ImageBean result = null;
		if (bean != null) {
			result = imgDao.insert(bean);
		}
		return result;
	}

	public ImageBean update(ImageBean bean) {
		ImageBean result = null;
		if (bean != null) {
			result = imgDao.update(bean.getImageName(), bean.getImageId());
		}
		return result;
	}

	public boolean delete(ImageBean bean) {
		boolean result = false;
		if (bean != null) {
			result = imgDao.delete(bean.getImageId());
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
