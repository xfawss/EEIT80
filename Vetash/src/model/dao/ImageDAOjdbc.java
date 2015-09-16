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

public class ImageDAOjdbc implements ImageDAO{
	
	private DataSource dataSource;
	public ImageDAOjdbc(){
		try {
			Context ctx = new InitialContext();
			this.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

	private static final String SELECT_BY_IMAGEID="select * from Image where ImageId=?";
	@Override
	public ImageBean select(int imageId) {
		ImageBean result = null;
		ResultSet rset = null;

		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_IMAGEID);){
			
			stmt.setInt(1, imageId);
			rset = stmt.executeQuery();
			while(rset.next()){
				result = new ImageBean();
				result.setImageId(rset.getInt("ImageId"));
				result.setImageName(rset.getString("ImageName"));
				result.setImageDate(rset.getDate("ImageDate"));
				result.setImagePath(rset.getString("ImagePath"));
				result.setImgCategoryId(rset.getInt("ImgCategoryId"));

			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}
	
	private static final String SELECT_BY_IMAGENAME="select * from Image where ImageName like ?";
	@Override
	public List<ImageBean> selectName(String imageName) {
		List<ImageBean> result = null;
		ResultSet rset = null;

		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_IMAGENAME);){
			
			stmt.setString(1,"%"+imageName+"%");
			rset = stmt.executeQuery();
			result = new ArrayList<ImageBean>();
			while(rset.next()){
				ImageBean bean = new ImageBean();
				bean.setImageId(rset.getInt("ImageId"));
				bean.setImageName(rset.getString("ImageName"));
				bean.setImageDate(rset.getDate("ImageDate"));
				bean.setImagePath(rset.getString("ImagePath"));
				bean.setImgCategoryId(rset.getInt("ImgCategoryId"));
				result.add(bean);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}
	
	private static final String SELECT_LAST="select top 1 ImageId from Image order by ImageId desc";
	@Override
	public String selectLast() {
		String id = null;

		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_LAST);
				ResultSet rset = stmt.executeQuery();
				) {
			
			while(rset.next()){
				id=rset.getString("ImageId");
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	private static final String SELECT_ALL="select * from Image";
	@Override
	public List<ImageBean> select() {
		List<ImageBean> result = null;
		
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();){
			
			result = new ArrayList<ImageBean>();
			while(rset.next()){
				ImageBean bean = new ImageBean();
				bean.setImageId(rset.getInt("ImageId"));
				bean.setImageDate(rset.getDate("ImageDate"));
				bean.setImageName(rset.getString("ImageName"));
				bean.setImagePath(rset.getString("ImagePath"));
				bean.setImgCategoryId(rset.getInt("ImgCategoryId"));
				result.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT= "insert into Image (ImageName, ImageDate, ImagePath, ImgCategoryId) values (?,?,?,?)";
	@Override
	public ImageBean insert(ImageBean bean) {
		ImageBean result = null;

		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			
			if(bean!=null){

				stmt.setString(1,bean.getImageName());
				
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				stmt.setTimestamp(2,ts);
				
				stmt.setString(3, bean.getImagePath());
				stmt.setInt(4, bean.getImgCategoryId());
				
				int i = stmt.executeUpdate();
				if(i==1){
					result = bean;
				}
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}
	
	private static final String UPDATE = "update Image set ImageName=? where ImageId=?";
	@Override
	public ImageBean update(String imageName, int imageId) {
		ImageBean result = null;
		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);){
			stmt.setString(1, imageName);
			stmt.setInt(2, imageId);
			
			int i = stmt.executeUpdate();
			if(i==1){
				result = this.select(imageId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static final String DELETE= "delete from Image where ImageId=?";
	@Override
	public boolean delete(int imageId) {

		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE);
				){
			stmt.setInt(1, imageId);
			int i = stmt.executeUpdate();
			if(i==1){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
