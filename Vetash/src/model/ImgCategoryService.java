package model;

import java.util.ArrayList;
import java.util.List;

import model.dao.ImgCategoryDAOjdbc;

public class ImgCategoryService {
	private ImgCategoryDAO imgCategoryDao = new ImgCategoryDAOjdbc();
	
	public List<ImgCategoryBean> select(ImgCategoryBean bean){
		List<ImgCategoryBean> result = null;
		if(bean!=null && bean.getImgCategoryId()!=0){
			ImgCategoryBean temp = imgCategoryDao.select(bean.getImgCategoryId());
			result = new ArrayList<ImgCategoryBean>();
			result.add(temp);
		}else{
			result = imgCategoryDao.select();
		}
		return result;
	}
	
	public ImgCategoryBean insert(ImgCategoryBean bean){
		ImgCategoryBean result = null;
		if(bean!=null){
			result = imgCategoryDao.insert(bean);
		}
		return result;
	}
	
	public ImgCategoryBean update(ImgCategoryBean bean){
		ImgCategoryBean result = null;
		if(bean!=null){
			result = imgCategoryDao.update(bean.getImgCategoryName(), bean.getImgCategoryId());
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
