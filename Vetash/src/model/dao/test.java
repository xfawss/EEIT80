package model.dao;

import java.util.List;

import model.ProductBean;
import model.ProductService;

public class test {

	public static void main(String[] args) {
		ProductDAOHibernate dao = new ProductDAOHibernate();
		
		
//		
	ProductBean x = new ProductBean();
//		x.setProductId("dsfsdfsdfs");
//		x.setProductType("案件");
//		x.setProductName("sdfsdf");
//		x.setProductPrice(100);
//		x.setProductNote("dsfsdfdsfgghhhhhhhhhhhh");
//		x.setProductImgPath("");
		
//	dao.delete("NULL");
//	dao.insert("ID2", "TYPE2","NAME2",200,null,"NOTE2");
	dao.update("ID", "NAME2",200,null,"NOTE2");
	

		
			
			
		




			//�� �R��(�p��cascade - �h��emp2.hbm.xml�p�G�]�� cascade="all"��
			// cascade="delete"�N�|�R���Ҧ��������-�]�A���ݳ����P�P�������䥦���u�N�|�@�ֳQ�R��)
			// �ҥH�ثe�b�W��65��67��A�ĥΥh�����p���Y��A�A�R�����覡�A�o�O����w�����覡
//			dao.delete(7014);



			//�� �d��-findByPrimaryKey (�h��emp2.hbm.xml�����]��lazy="false")(�u!)
//			EmpVO empVO3 = dao.findByPrimaryKey(7001);
//			System.out.print(empVO3.getEmpno() + ",");
//			System.out.print(empVO3.getEname() + ",");
//			System.out.print(empVO3.getJob() + ",");
//			System.out.print(empVO3.getHiredate() + ",");
//			System.out.print(empVO3.getSal() + ",");
//			System.out.print(empVO3.getComm() + ",");
//			// �`�N�H�U�T�檺�g�k (�u!)
//			System.out.print(empVO3.getDeptVO().getDeptno() + ",");
//			System.out.print(empVO3.getDeptVO().getDname() + ",");
//			System.out.print(empVO3.getDeptVO().getLoc());
//			System.out.println("\n---------------------");



			//�� �d��-getAll (�h��emp2.hbm.xml�����]��lazy="false")(�u!)
//			List<ProductVO> list1 = dao.selectType();
//			String xx = list1.toString();
//			System.out.print(xx);
//			List<ProductVO> list = dao.getAll();
//			for (ProductVO aEmp : list) {
//				System.out.print(aEmp.getProductId() + ",");
//				System.out.print(aEmp.getProductType() + ",");
//				System.out.print(aEmp.getProductName() + ",");
//				System.out.print(aEmp.getProductPrice() + ",");
//				System.out.print(aEmp.getProductCost() + ",");
//				System.out.print(aEmp.getProductQty() + ",");
				// �`�N�H�U�T�檺�g�k (�u!)
//				System.out.print(aEmp.getDeptVO().getDeptno() + ",");
//				System.out.print(aEmp.getDeptVO().getDname() + ",");
//				System.out.print(aEmp.getDeptVO().getLoc());
//	ProductBean a = dao.selectByID("ddd");
//		System.out.print(a.getProductId() + ",");
//		System.out.print(a.getProductType() + ",");
//		System.out.print(a.getProductName() + ",");
//		System.out.print(a.getProductPrice() + ",");
//		System.out.print(a.getProductCost() + ",");
//		System.out.print(a.getProductQty() + ",");
//		System.out.print(a.getProductNote() + ",");
//
//		System.out.println();
		
		List<ProductBean> list0 = dao.selectType();
		String xx = list0.toString();
		System.out.print(xx);
		
		List<ProductBean> list2 = (List<ProductBean>) dao.selectByName("Name");
		for (ProductBean a : list2) {
			System.out.print(a.getProductId() + ",");
			System.out.print(a.getProductType() + ",");
			System.out.print(a.getProductName() + ",");
			System.out.print(a.getProductPrice() + ",");
			System.out.print(a.getProductCost() + ",");
			System.out.print(a.getProductQty() + ",");
			System.out.print(a.getProductNote() + ",");

			System.out.println();
		}
	
		
		List<ProductBean> list = dao.getAll();
		for (ProductBean aEmp : list) {
			System.out.print(aEmp.getProductId() + ",");
			System.out.print(aEmp.getProductType() + ",");
			System.out.print(aEmp.getProductName() + ",");
			System.out.print(aEmp.getProductPrice() + ",");
			System.out.print(aEmp.getProductCost() + ",");
			System.out.print(aEmp.getProductQty() + ",");
			System.out.print(aEmp.getProductNote() + ",");
	
			System.out.println();
		}
	}

}
