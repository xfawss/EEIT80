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



import model.CustomerBean;
import model.CustomerDAO;

public class CustomerDAOJdbc implements CustomerDAO {
	private DataSource dataSource;
	public CustomerDAOJdbc() {
		try {
			Context ctx = new InitialContext();
			this.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/Vetash");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SELECT_BY_CUSTOMERTEL =
			"select * from Customer where customerTel=?";
	@Override
	public CustomerBean selectByTel(String customerTel) {
		CustomerBean result = null;
		ResultSet rset = null;
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_CUSTOMERTEL);) {
			
			stmt.setString(1, customerTel);
			rset = stmt.executeQuery();
			while(rset.next()) {
				result = new CustomerBean();
				result.setCustomerName(rset.getString("customerName"));
				result.setCustomerTel(rset.getString("customerTel"));
				result.setCustomerLine(rset.getString("customerLine"));
				result.setCustomerFb(rset.getString("customerFb"));
				result.setCustomerMail(rset.getString("customerMail"));
				result.setCustomerAddr(rset.getString("customerAddr"));
				result.setCustomerNote(rset.getString("customerNote"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	private static final String SELECT_ALL =
			"select * from Customer";
	@Override
	public List<CustomerBean> selectAll() {
		List<CustomerBean> result = null;
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			
			result = new ArrayList<CustomerBean>();
			while(rset.next()) {
				CustomerBean bean = new CustomerBean();				
				bean.setCustomerName(rset.getString("customerName"));
				bean.setCustomerTel(rset.getString("customerTel"));
				bean.setCustomerLine(rset.getString("customerLine"));
				bean.setCustomerFb(rset.getString("customerFb"));
				bean.setCustomerMail(rset.getString("customerMail"));
				bean.setCustomerAddr(rset.getString("customerAddr"));
				bean.setCustomerNote(rset.getString("customerNote"));
				
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	private static final String INSERT =
			"insert into Customer (customerName, customerTel, customerLine, customerFb, customerMail,customerAddr,customerNote) values (?, ?, ?, ?, ?,?,?)";
	@Override
	public int insert(CustomerBean bean) {
		int result = 0;
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			if(bean!=null) {
				stmt.setString(1, bean.getCustomerName());
				stmt.setString(2, bean.getCustomerTel());
				stmt.setString(3, bean.getCustomerLine());
				stmt.setString(4, bean.getCustomerFb());
				stmt.setString(5, bean.getCustomerMail());
				stmt.setString(6, bean.getCustomerAddr());
				stmt.setString(7, bean.getCustomerNote());
				result = stmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	private static final String UPDATE =
			"update Customer set customerName=?, customerLine=?, customerFb=?, customerMail=? ,customerAddr=? ,customerNote=? where customerTel=?";
	@Override
	public int update(String customerName, String customerLine, String customerFb,
			String customerMail, String customerAddr, String customerNote, String customerTel) {
		int result = 0;
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, customerName);			
			stmt.setString(2, customerLine);
			stmt.setString(3, customerFb);
			stmt.setString(4, customerMail);
			stmt.setString(5, customerAddr);
			stmt.setString(6, customerNote);
			stmt.setString(7, customerTel);
			result = stmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	private static final String DELETE =
			"delete from Customer where customerTel=?";
	@Override
	public int delete(String customerTel) {
		int result=0;
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
			stmt.setString(1, customerTel);
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static final String SELECT_LIKE_CUSTOMER_NAME = "select * from Customer where customerName like ?";
	@Override
	public List<CustomerBean> selectLikeName(String customerName) {
		List<CustomerBean> result = null;		
		ResultSet rset=null;		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_LIKE_CUSTOMER_NAME);
				) {
			stmt.setString(1, "%"+customerName+"%");
			rset = stmt.executeQuery();
			result =new ArrayList<CustomerBean>();
			while(rset.next()) {
				CustomerBean bean = new CustomerBean();				
				bean.setCustomerName(rset.getString("customerName"));
				bean.setCustomerTel(rset.getString("customerTel"));
				bean.setCustomerLine(rset.getString("customerLine"));
				bean.setCustomerFb(rset.getString("customerFb"));
				bean.setCustomerMail(rset.getString("customerMail"));
				bean.setCustomerAddr(rset.getString("customerAddr"));
				bean.setCustomerNote(rset.getString("customerNote"));
				
				result.add(bean);
				
						}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
}
	public static final String SELECT_LIKE_CUSTOMER_LINE = "select * from Customer where customerLine like ?";
	@Override
	public List<CustomerBean> selectLikeLine(String customerLine) {
		List<CustomerBean> result = null;		
		ResultSet rset=null;		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_LIKE_CUSTOMER_LINE);
				) {
			stmt.setString(1, "%"+customerLine+"%");
			rset = stmt.executeQuery();
			result =new ArrayList<CustomerBean>();
			while(rset.next()) {
				CustomerBean bean = new CustomerBean();				
				bean.setCustomerName(rset.getString("customerName"));
				bean.setCustomerTel(rset.getString("customerTel"));
				bean.setCustomerLine(rset.getString("customerLine"));
				bean.setCustomerFb(rset.getString("customerFb"));
				bean.setCustomerMail(rset.getString("customerMail"));
				bean.setCustomerAddr(rset.getString("customerAddr"));
				bean.setCustomerNote(rset.getString("customerNote"));
				
				result.add(bean);
				
						}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
}
	
	public static final String SELECT_LIKE_CUSTOMER_FB = "select * from Customer where customerFb like ?";
	@Override
	public List<CustomerBean> selectLikeFb(String customerFb) {
		List<CustomerBean> result = null;		
		ResultSet rset=null;		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_LIKE_CUSTOMER_FB);
				) {
			stmt.setString(1, "%"+customerFb+"%");
			rset = stmt.executeQuery();
			result =new ArrayList<CustomerBean>();
			while(rset.next()) {
				CustomerBean bean = new CustomerBean();				
				bean.setCustomerName(rset.getString("customerName"));
				bean.setCustomerTel(rset.getString("customerTel"));
				bean.setCustomerLine(rset.getString("customerLine"));
				bean.setCustomerFb(rset.getString("customerFb"));
				bean.setCustomerMail(rset.getString("customerMail"));
				bean.setCustomerAddr(rset.getString("customerAddr"));
				bean.setCustomerNote(rset.getString("customerNote"));
				
				result.add(bean);
				
						}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

}
	
	public static final String SELECT_LIKE_CUSTOMER_MAIL = "select * from Customer where customerMail like ?";
	@Override
	public List<CustomerBean> selectLikeMail(String customerMail) {
		List<CustomerBean> result = null;		
		ResultSet rset=null;		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_LIKE_CUSTOMER_MAIL);
				) {
			stmt.setString(1, "%"+customerMail+"%");
			rset = stmt.executeQuery();
			result =new ArrayList<CustomerBean>();
			while(rset.next()) {
				CustomerBean bean = new CustomerBean();				
				bean.setCustomerName(rset.getString("customerName"));
				bean.setCustomerTel(rset.getString("customerTel"));
				bean.setCustomerLine(rset.getString("customerLine"));
				bean.setCustomerFb(rset.getString("customerFb"));
				bean.setCustomerMail(rset.getString("customerMail"));
				bean.setCustomerAddr(rset.getString("customerAddr"));
				bean.setCustomerNote(rset.getString("customerNote"));
				
				result.add(bean);
				
						}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

}
	
	public static final String SELECT_LIKE_CUSTOMER_NOTE = "select * from Customer where customerNote like ?";
	@Override
	public List<CustomerBean> selectLikeNote(String customerNote) {
		List<CustomerBean> result = null;		
		ResultSet rset=null;		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_LIKE_CUSTOMER_NOTE);
				) {
			stmt.setString(1, "%"+customerNote+"%");
			rset = stmt.executeQuery();
			result =new ArrayList<CustomerBean>();
			while(rset.next()) {
				CustomerBean bean = new CustomerBean();				
				bean.setCustomerName(rset.getString("customerName"));
				bean.setCustomerTel(rset.getString("customerTel"));
				bean.setCustomerLine(rset.getString("customerLine"));
				bean.setCustomerFb(rset.getString("customerFb"));
				bean.setCustomerMail(rset.getString("customerMail"));
				bean.setCustomerAddr(rset.getString("customerAddr"));
				bean.setCustomerNote(rset.getString("customerNote"));
				
				result.add(bean);
				
						}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

}
	
}
