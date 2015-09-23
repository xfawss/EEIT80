package model;

public class ImgCategoryBean {

	private int imgCategoryId;
	private String imgCategoryName;
	
	@Override
	public String toString() {
		return "ImgCategoryBean [imgCategoryId=" + imgCategoryId + ", imgCategoryName=" + imgCategoryName + "]";
	}
	
	public int getImgCategoryId() {
		return imgCategoryId;
	}
	public void setImgCategoryId(int imgCategoryId) {
		this.imgCategoryId = imgCategoryId;
	}
	public String getImgCategoryName() {
		return imgCategoryName;
	}
	public void setImgCategoryName(String imgCategoryName) {
		this.imgCategoryName = imgCategoryName;
	}
}
