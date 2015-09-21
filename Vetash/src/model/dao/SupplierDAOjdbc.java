package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.SupplierBean;
import model.SupplierDAO;

public class SupplierDAOjdbc implements SupplierDAO {

	private DataSource dataSource;
	public SupplierDAOjdbc(){
		try {
			Context ctx = new InitialContext();
			this.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/Vetash");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SELECT_BY_SUPPLIERID="select * from Supplier where SupplierId=?";
	@Override
	public SupplierBean selectById(int supplierId) {
		SupplierBean result = null;
		ResultSet rset = null;

		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_SUPPLIERID);){
			
			stmt.setInt(1, supplierId);
			rset = stmt.executeQuery();
			while(rset.next()){
				result = new SupplierBean();
				result.setSupplierId(rset.getInt("SupplierId"));
				result.setSupplierName(rset.getString("SupplierName"));
				result.setSupplierTax(rset.getString("SupplierTax"));
				result.setSupplierContact(rset.getString("SupplierContact"));
				result.setSupplierTel(rset.getString("SupplierTel"));
				result.setSupplierAddr(rset.getString("SupplierAddr"));
				result.setSupplierAcct(rset.getString("SupplierAcct"));
				result.setSupplierDate(rset.getDate("SupplierDate"));
				result.setSupplierNote(rset.getString("SupplierNote"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return result;
	}
	
	private static final String SELECT_BY_SUPPLIERTEL="select * from Supplier where SupplierTel=?";
	@Override
	public SupplierBean selectByTel(String supplierTel) {
		SupplierBean result = null;
		ResultSet rset = null;

		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_SUPPLIERTEL);){
			
			stmt.setString(1, supplierTel);
			rset = stmt.executeQuery();
			while(rset.next()){
				result = new SupplierBean();
				result.setSupplierId(rset.getInt("SupplierId"));
				result.setSupplierName(rset.getString("SupplierName"));
				result.setSupplierTax(rset.getString("SupplierTax"));
				result.setSupplierContact(rset.getString("SupplierContact"));
				result.setSupplierTel(rset.getString("SupplierTel"));
				result.setSupplierAddr(rset.getString("SupplierAddr"));
				result.setSupplierAcct(rset.getString("SupplierAcct"));
				result.setSupplierDate(rset.getDate("SupplierDate"));
				result.setSupplierNote(rset.getString("SupplierNote"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}

	private static final String SELECT_BY_SUPPLIERNAME="select * from Supplier where SupplierName like ?";
	@Override
	public List<SupplierBean> selectByName(String supplierName) {
		List<SupplierBean> result = null;
		ResultSet rset = null;

		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_SUPPLIERNAME);){
			
			stmt.setString(1,"%"+supplierName+"%");
			rset = stmt.executeQuery();
			result = new ArrayList<SupplierBean>();
			while(rset.next()){
				SupplierBean bean = new SupplierBean();
				bean.setSupplierId(rset.getInt("SupplierId"));
				bean.setSupplierName(rset.getString("SupplierName"));
				bean.setSupplierTax(rset.getString("SupplierTax"));
				bean.setSupplierContact(rset.getString("SupplierContact"));
				bean.setSupplierTel(rset.getString("SupplierTel"));
				bean.setSupplierAddr(rset.getString("SupplierAddr"));
				bean.setSupplierAcct(rset.getString("SupplierAcct"));
				bean.setSupplierDate(rset.getDate("SupplierDate"));
				bean.setSupplierNote(rset.getString("SupplierNote"));
				result.add(bean);
			}	
		} catch (SQLException e) {
	
			e.printStackTrace();
		}	
		return result;
	}
	
	private static final String SELECT_ALL="select * from Supplier";
	@Override
	public List<SupplierBean> selectAll() {
		List<SupplierBean> result = null;
		
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();){
			
			result = new ArrayList<SupplierBean>();
			while(rset.next()){
				SupplierBean bean = new SupplierBean();
				bean.setSupplierId(rset.getInt("SupplierId"));
				bean.setSupplierName(rset.getString("SupplierName"));
				bean.setSupplierTax(rset.getString("SupplierTax"));
				bean.setSupplierContact(rset.getString("SupplierContact"));
				bean.setSupplierTel(rset.getString("SupplierTel"));
				bean.setSupplierAddr(rset.getString("SupplierAddr"));
				bean.setSupplierAcct(rset.getString("SupplierAcct"));
				bean.setSupplierDate(rset.getDate("SupplierDate"));
				bean.setSupplierNote(rset.getString("SupplierNote"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT= "insert into Supplier (SupplierName, SupplierTax, SupplierContact, "
			+ "SupplierTel,SupplierAddr,SupplierAcct,SupplierDate,SupplierNote) values (?,?,?,?,?,?,?,?)";
	@Override
	public int insert(SupplierBean bean) {
		int result = 0;
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			
			if(bean!=null){
				stmt.setString(1,bean.getSupplierName());
				stmt.setString(2,bean.getSupplierTax());
				stmt.setString(3,bean.getSupplierContact());
				stmt.setString(4,bean.getSupplierTel());
				stmt.setString(5,bean.getSupplierAddr());
				stmt.setString(6,bean.getSupplierAcct());
				
				java.util.Date supplierDate = bean.getSupplierDate();
				if(supplierDate!=null) {
					long time = supplierDate.getTime();
					stmt.setDate(7, new java.sql.Date(time));
				} else {
					stmt.setDate(7, null);				
				}
				
				stmt.setString(8,bean.getSupplierNote());
				result = stmt.executeUpdate();
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return result;
	}

	private static final String UPDATE = "update Supplier set SupplierName=?, SupplierTax=?, SupplierContact=?, "
			+ "SupplierTel=?,SupplierAddr=?,SupplierAcct=?,SupplierDate=?,SupplierNote=? where SupplierId=?";
	@Override
	public int update(String supplierName, String supplierTax, String supplierContact, String supplierTel,
			String supplierAddr, String supplierAcct, Date supplierDate, String supplierNote, int supplierId) {
		
			
		int result = 0;
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);){
			
			stmt.setString(1,supplierName);
			stmt.setString(2,supplierTax);
			stmt.setString(3,supplierContact);
			stmt.setString(4,supplierTel);
			stmt.setString(5,supplierAddr);
			stmt.setString(6,supplierAcct);
			
			if(supplierDate!=null) {
				long time = supplierDate.getTime();
				stmt.setDate(7, new java.sql.Date(time));
			}
			stmt.setString(8, supplierNote);
			stmt.setInt(9,supplierId);
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static final String DELETE= "delete from Supplier where SupplierId=?";
	@Override
	public int delete(int supplierId) {
		int result = 0;
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE);
				){
			stmt.setInt(1, supplierId);
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}
}
