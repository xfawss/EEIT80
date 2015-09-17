package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import model.ProductService;
import model.ProductVO;
import hibernate.util.HibernateUtil;

@WebServlet("/ProductSevlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	private ProductService service;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (ProductService) context.getBean("ProductService");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String productId = req.getParameter("productId");
		String productType = req.getParameter("productType");
		String productName = req.getParameter("productName");
		String productPrice = req.getParameter("productPrice");
		String productImg = req.getParameter("productImg");
		String productNote = req.getParameter("productNote");
		
	}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
