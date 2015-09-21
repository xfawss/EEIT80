package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.ImgCategoryBean;
import model.ImgCategoryDAO;

public class ImgCategoryDAOjdbc implements ImgCategoryDAO {

	private DataSource dataSource;

	public ImgCategoryDAOjdbc() {
		try {
			Context ctx = new InitialContext();
			this.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	// public static void main(String[] args) {
	// KindImageDAOjdbc jdbc=new KindImageDAOjdbc();
	// KindImageBean bean = jdbc.select(2);
	// System.out.println(bean);
	//
	// }

	private static final String SELECT_BY_IMGCATEGORYID = "select * from ImgCategory where ImgCategoryId=?";

	@Override
	public ImgCategoryBean selectById(int ImgCategoryId) {
		ImgCategoryBean result = null;
		ResultSet rest = null;

		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_IMGCATEGORYID);) {

			stmt.setInt(1, ImgCategoryId);
			rest = stmt.executeQuery();
			if (rest.next()) {
				result = new ImgCategoryBean();
				result.setImgCategoryId(rest.getInt("ImgCategoryId"));
				result.setImgCategoryName(rest.getString("ImgCategoryName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rest != null) {
				try {
					rest.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static final String SELECT_ALL = "select * from ImgCategory";

	@Override
	public List<ImgCategoryBean> selectAll() {
		List<ImgCategoryBean> result = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {

			result = new ArrayList<ImgCategoryBean>();
			while (rset.next()) {
				ImgCategoryBean bean = new ImgCategoryBean();
				bean.setImgCategoryId(rset.getInt("ImgCategoryId"));
				bean.setImgCategoryName(rset.getString("ImgCategoryName"));
				result.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "insert into ImgCategory (ImgCategoryName) values (?)";

	@Override
	public int insert(ImgCategoryBean bean) {
		int result = 0;

		try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			if (bean != null) {
				stmt.setString(1, bean.getImgCategoryName());
				result = stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update ImgCategory set ImgCategoryName=? where ImgCategoryId =?";

	@Override
	public int update(String imgCategoryName, int imgCategoryId) {
		int result = 0;

		try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, imgCategoryName);
			stmt.setInt(2, imgCategoryId);
			result = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
