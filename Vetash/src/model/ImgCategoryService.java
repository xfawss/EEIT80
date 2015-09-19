package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import model.dao.ImgCategoryDAOjdbc;

public class ImgCategoryService {
	private ImgCategoryDAO imgCategoryDao = new ImgCategoryDAOjdbc();

	public ImgCategoryBean selectById(int id) {
		ImgCategoryBean result = null;
		if (id != 0 ) {
			result = imgCategoryDao.selectById(id);
		}
		return result;
	}

	public List<Map<String, Object>> selectAll() {
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		List<ImgCategoryBean> beans = imgCategoryDao.selectAll();

		for (int i = 0; i < beans.size(); i++) {
			Map<String, Object> map1 = new LinkedHashMap<String, Object>();
			ImgCategoryBean bean = beans.get(i);
			map1.put("imgCategoryId", bean.getImgCategoryId());
			map1.put("imgCategoryName", bean.getImgCategoryName());
			result.add(map1);
		}
		return result;
	}

	public int insert(ImgCategoryBean bean) {
		int result = 0;
		if (bean != null) {
			result = imgCategoryDao.insert(bean);
		}
		return result;
	}

	public int update(ImgCategoryBean bean) {
		int result = 0;
		if (bean != null) {
			result = imgCategoryDao.update(bean.getImgCategoryName(), bean.getImgCategoryId());
		}
		return result;
	}
}
