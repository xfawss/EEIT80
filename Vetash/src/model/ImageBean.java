package model;

import java.util.Arrays;

public class ImageBean {
	
	private int imageId;
	private String imageName;
	private java.util.Date imageDate;
	private String imagePath;
	private int imgCategoryId;
	
	@Override
	public String toString() {
		return "ImageBean [imageId=" + imageId + ", imageName=" + imageName + ", imageDate=" + imageDate
				+ ", imagePath=" + imagePath + ", imgCategoryId=" + imgCategoryId + ", toString()=" + super.toString()
				+ "]";
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public java.util.Date getImageDate() {
		return imageDate;
	}

	public void setImageDate(java.util.Date imageDate) {
		this.imageDate = imageDate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getImgCategoryId() {
		return imgCategoryId;
	}

	public void setImgCategoryId(int imgCategoryId) {
		this.imgCategoryId = imgCategoryId;
	}

}
