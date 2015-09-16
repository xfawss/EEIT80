package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SupplierBean;
import model.SupplierService;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet(urlPatterns = { "/supplier.c" })
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupplierService service;
	@Override
	public void init() throws ServletException {
		service = new SupplierService();
		super.init();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

		System.out.println("go");
		
		SupplierBean bean = new SupplierBean();
		List<SupplierBean> result = service.selectAll();
		
		  
//		String temp1 = request.getParameter("id");
//		String name = request.getParameter("name");
//		String temp2 = request.getParameter("price");
//		String temp3 = request.getParameter("make");
//		String temp4 = request.getParameter("expire");
//		String prodaction = request.getParameter("prodaction");
		
		
		
		
		
//test		
//		SupplierService ser = new SupplierService();
//		SupplierBean bean = new SupplierBean();

		//select by id
//		bean.setSupplierId(3);
//		System.out.println(ser.selectById(bean));
		
		//select by tel
//		System.out.println(ser.selectByTel("0974002547"));
//		
		//select by name
//		System.out.println(ser.selectByName("中"));
		
		//select all
//		System.out.println(ser.selectAll());
		
		//inset
//		bean.setSupplierName("test");
//		bean.setSupplierTax("124");
//		bean.setSupplierContact("124");
//		bean.setSupplierTel("124");
//		bean.setSupplierAddr("124");
//		bean.setSupplierAcct("124");
//		bean.setSupplierDate(new java.util.Date());
//		bean.setSupplierNote("124");
//		System.out.println(ser.insert(bean));
		
		//update
//		bean.setSupplierName("test333");
//		bean.setSupplierTax("124333");
//		bean.setSupplierContact("124333");
//		bean.setSupplierAddr("124333");
//		bean.setSupplierAcct("124333");
//		bean.setSupplierDate(new java.util.Date());
//		bean.setSupplierNote("124333");
//		bean.setSupplierId(6);
//		System.out.println(ser.update(bean));
		
		
		//delete
//		bean.setSupplierId(6);
//		System.out.println(ser.delete(bean));	
		
//		rsp.getWriter().append("Served at: ").append(req.getContextPath());
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
