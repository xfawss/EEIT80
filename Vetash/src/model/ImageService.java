package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.dao.ImageDAOjdbc;

public class ImageService {

	private ImageDAO imgDao = new ImageDAOjdbc();

	public List<Map<String, Object>> selectByImgCategoryId(int imgCategoryId) {
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		List<ImageBean> beans = imgDao.selectByImgCategoryId(imgCategoryId);

		if (imgCategoryId != 0) {
			for (int i = 0; i < beans.size(); i++) {
				Map<String, Object> map1 = new LinkedHashMap<String, Object>();
				ImageBean bean = beans.get(i);
				map1.put("imageId", bean.getImageId());
				map1.put("imageName", bean.getImageName());
				map1.put("imageDate", bean.getImageDate());
				map1.put("imagePath", bean.getImagePath());
				map1.put("imgCategoryId", bean.getImgCategoryId());
				result.add(map1);
			}
		}
		return result;
	}

	public Map<String, Object> selectById(int imageId) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();

		if (imageId != 0) {
			ImageBean bean = imgDao.selectById(imageId);
			result.put("imageId", bean.getImageId());
			result.put("imageName", bean.getImageName());
			result.put("imageDate", bean.getImageDate());
			result.put("imagePath", bean.getImagePath());
			result.put("imgCategoryId", bean.getImgCategoryId());
		}
		return result;
	}

	public List<Map<String, Object>> selectAll() {
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		List<ImageBean> beans = imgDao.selectAll();

		for (int i = 0; i < beans.size(); i++) {
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			ImageBean bean = beans.get(i);
			map1.put("imageId", bean.getImageId());
			map1.put("imageName", bean.getImageName());
			map1.put("imageDate", bean.getImageDate());
			map1.put("imagePath", bean.getImagePath());
			map1.put("imgCategoryId", bean.getImgCategoryId());
			result.add(map1);
		}
		return result;
	}
 
	public List<Map<String, Object>> selectByName(String imageName) {
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		List<ImageBean> beans = imgDao.selectByName(imageName);
 
		if (imageName != null && imageName.length() != 0) {
			for (int i = 0; i < beans.size(); i++) {
				Map<String, Object> map1 = new LinkedHashMap<String, Object>();
				ImageBean bean = beans.get(i);
				map1.put("imageId", bean.getImageId());
				map1.put("imageName", bean.getImageName());
				map1.put("imageDate", bean.getImageDate());
				map1.put("imagePath", bean.getImagePath());
				map1.put("imgCategoryId", bean.getImgCategoryId());
				result.add(map1);
			}
		}
		return result;
	}

	public String selectLastId() {
		String imageId = imgDao.selectLastId();
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
