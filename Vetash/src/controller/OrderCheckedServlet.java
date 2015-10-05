package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.CouponService;
import model.OrderBean;
import model.OrderService;
import model.ProductService;

@WebServlet("/orderChecked")
public class OrderCheckedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService service;
	private CouponService service2;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (OrderService)context.getBean("OrderService");
		service2 = (CouponService)context.getBean("CouponService");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		JSONObject jObj = new JSONObject();
		
		
		HttpSession session = req.getSession(false);
		if(session==null){
			jObj.put("result", "fail");
			out.print(jObj);
		}
		OrderBean bean = (OrderBean)session.getAttribute("joystick");
		int coupon = service2.updateUse(bean.getCoupon());
		bean.setCoupon(Integer.toString(coupon));
		bean = service.insert(bean);
		if(bean != null) {
			jObj.put("result", "success");
			out.print(jObj);
		}
	}

}
