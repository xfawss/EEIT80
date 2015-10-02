package model;



public class ImageBean {
	
	private int imageId;
	private String imageName;
	private java.util.Date imageDate;
	private String imagePath;
	private String imgCategoryName;
	

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

	public String getImgCategoryName() {
		return imgCategoryName;
	}

	public void setImgCategoryName(String imgCategoryName) {
		this.imgCategoryName = imgCategoryName;
	}

}
