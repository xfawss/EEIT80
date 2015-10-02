package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.ImageBean;
import model.ImageDAO;

public class ImageDAOjdbc implements ImageDAO {
	private DataSource dataSource;

	public ImageDAOjdbc() {
		try {
			Context ctx = new InitialContext();
			this.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/vetash");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private static final String SELECT_BY_IMAGEID = "select * from Image where ImageId=?";

	@Override
	public ImageBean selectById(int imageId) {
		ImageBean result = null;
		ResultSet rset = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_IMAGEID);) {
			stmt.setInt(1, imageId);
			rset = stmt.executeQuery();
			while (rset.next()) {
				result = new ImageBean();
				result.setImageId(rset.getInt("ImageId"));
				result.setImageName(rset.getString("ImageName"));
				result.setImageDate(rset.getDate("ImageDate"));
				result.setImagePath(rset.getString("ImagePath"));
				result.setImgCategoryName(rset.getString("ImgCategoryName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_BY_IMAGENAME = "select * from Image where ImageName like ?";

	@Override
	public List<ImageBean> selectByName(String imageName) {
		List<ImageBean> result = null;
		ResultSet rset = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_IMAGENAME);) {
			stmt.setString(1, "%" + imageName + "%");
			rset = stmt.executeQuery();
			result = new ArrayList<ImageBean>();
			while (rset.next()) {
				ImageBean bean = new ImageBean();
				bean.setImageId(rset.getInt("ImageId"));
				bean.setImageName(rset.getString("ImageName"));
				bean.setImageDate(rset.getDate("ImageDate"));
				bean.setImagePath(rset.getString("ImagePath"));
				bean.setImgCategoryName(rset.getString("ImgCategoryName"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	private static final String SELECT_ALL = "select * from Image";

	@Override
	public List<ImageBean> selectAll() {
		List<ImageBean> result = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			result = new ArrayList<ImageBean>();
			while (rset.next()) {
				ImageBean bean = new ImageBean();
				bean.setImageId(rset.getInt("ImageId"));
				bean.setImageDate(rset.getDate("ImageDate"));
				bean.setImageName(rset.getString("ImageName"));
				bean.setImagePath(rset.getString("ImagePath"));
				bean.setImgCategoryName(rset.getString("ImgCategoryName"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_TYPE = "select DISTINCT ImgCategoryName from Image";
	
	@Override
	public List<String> selectByType() {
		List<String> result = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_TYPE);
				ResultSet rset = stmt.executeQuery();) {
			result = new ArrayList<String>();
			while (rset.next()) {
				result.add(rset.getString("ImgCategoryName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "insert into Image (ImageName, ImageDate, ImagePath, ImgCategoryName) values (?,?,?,?)";

	@Override
	public int insert(ImageBean bean) {
		int result = 0;
		try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			if (bean != null) {
				stmt.setString(1, bean.getImageName());
				stmt.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
				stmt.setString(3, bean.getImagePath());
				stmt.setString(4, bean.getImgCategoryName());
				result = stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update Image set ImageName=? ,ImagePath=?,ImgCategoryname=? where ImageId=?";

	@Override
	public int update(String imageName, String imagePath, String imageCategoryname, int imageId) {
		int result = 0;
		try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, imageName);
			stmt.setString(2, imagePath);
			stmt.setString(3, imageCategoryname);
			stmt.setInt(4, imageId);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String DELETE = "delete from Image where ImageId=?";

	@Override
	public int delete(int imageId) {
		int result = 0;
		try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			stmt.setInt(1, imageId);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String SELECT_BY_IMGCATEGORYNAME = "select * from Image where ImgCategoryName like ?";

	@Override
	public List<ImageBean> selectByImgCategoryName(String imgCategoryName) {
		List<ImageBean> result = null;
		ResultSet rset = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_IMGCATEGORYNAME);) {
			stmt.setString(1, "%" + imgCategoryName + "%");
			rset = stmt.executeQuery();
			result = new ArrayList<ImageBean>();
			while (rset.next()) {
				ImageBean bean = new ImageBean();
				bean.setImageId(rset.getInt("ImageId"));
				bean.setImageName(rset.getString("ImageName"));
				bean.setImageDate(rset.getDate("ImageDate"));
				bean.setImagePath(rset.getString("ImagePath"));
				bean.setImgCategoryName(rset.getString("ImgCategoryName"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
