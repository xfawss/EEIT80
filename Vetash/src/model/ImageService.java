package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import misc.Parse;
import model.dao.ImageDAOjdbc;

public class ImageService {

	private ImageDAO imgDao = new ImageDAOjdbc();


	public List<Map<String, Object>> selectById(int imageId) {
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		Map<String, Object> map1 = new LinkedHashMap<String, Object>();
		if (imageId != 0) {
			ImageBean bean = imgDao.selectById(imageId);
			map1.put("imageId", bean.getImageId());
			map1.put("imageName", bean.getImageName());
			map1.put("imageDate", Parse.dateToString(bean.getImageDate()));
			map1.put("imagePath", bean.getImagePath());
			map1.put("imgCategoryName", bean.getImgCategoryName());
			result.add(map1);
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
			map1.put("imageDate", Parse.dateToString(bean.getImageDate()));
			map1.put("imagePath", bean.getImagePath());
			map1.put("imgCategoryName", bean.getImgCategoryName());
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
				map1.put("imageDate", Parse.dateToString(bean.getImageDate()));
				map1.put("imagePath", bean.getImagePath());
				map1.put("imgCategoryName", bean.getImgCategoryName());
				result.add(map1);
			}
		}
		return result;
	}
	
	public List<Map<String, Object>> selectByImgCategoryName(String imgCategoryName) {
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		List<ImageBean> beans = imgDao.selectByImgCategoryName(imgCategoryName);
		if (imgCategoryName != null && imgCategoryName.length() != 0) {
			for (int i = 0; i < beans.size(); i++) {
				Map<String, Object> map1 = new LinkedHashMap<String, Object>();
				ImageBean bean = beans.get(i);
				map1.put("imageId", bean.getImageId());
				map1.put("imageName", bean.getImageName());
				map1.put("imageDate", Parse.dateToString(bean.getImageDate()));
				map1.put("imagePath", bean.getImagePath());
				map1.put("imgCategoryName", bean.getImgCategoryName());
				result.add(map1);
			}
		}
		return result;
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
			result = imgDao.update(bean.getImageName(),bean.getImagePath(),bean.getImgCategoryName(), bean.getImageId());
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
