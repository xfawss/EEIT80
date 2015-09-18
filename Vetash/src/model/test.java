package model;

import java.util.ArrayList;
import java.util.List;

import model.dao.ProductDAOHibernate;

public class test {

	public static void main(String[] args) {
		ProductDAOHibernate dao = new ProductDAOHibernate();
		ProductService ps = new  ProductService();
		
		
		ProductBean x = new ProductBean();
		dao.insert("adasdasd","weqweqe","352352",1,"423423","dfdsfs");
		ps.delete("adasdasd");

		List<ProductBean> list = dao.selectType();
		String xx = list.toString();
		System.out.print(xx);
//		for (ProductBean aEmp : list) {
//			System.out.print(aEmp.getProductId() + ",");
//			System.out.print(aEmp.getProductType() + ",");
//			System.out.print(aEmp.getProductName() + ",");
//			System.out.print(aEmp.getProductPrice() + ",");
//			System.out.print(aEmp.getProductCost() + ",");
//			System.out.print(aEmp.getProductQty() + ",");
//			System.out.print(aEmp.getProductNote() + ",");
//			System.out.println();
//
//	}
		int a = 0;int b = 0;int c = 0;int d = 0;int e = 0;
		
		
		ArrayList<String> myList = new ArrayList<String>(); 
		
		if(a==0){
			if(b==0){
				if(c==0){
					myList.add("1!!!");
				}
				if(d==0){
					myList.add("2!!!");
				}
				if(e==0){
					myList.add("3!!!");
				}
				
				System.out.println(myList);
			}
		}
}}
