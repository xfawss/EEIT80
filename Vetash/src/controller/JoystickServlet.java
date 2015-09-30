package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.CouponService;
import model.OrderBean;
import model.ProductService;

@WebServlet("/joystick")
public class JoystickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
	private CouponService service2;

	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (ProductService)context.getBean("ProductService");
		service2 = (CouponService)context.getBean("CouponService");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String housing = req.getParameter("housing");
		String rocker = req.getParameter("rocker");
		String l1 = req.getParameter("l1");
		String l2 = req.getParameter("l2");
		String r1 = req.getParameter("r1");
		String r2 = req.getParameter("r2");
		String o = req.getParameter("o");
		String x = req.getParameter("x");
		String square = req.getParameter("square");
		String triangle = req.getParameter("triangle");
		String start = req.getParameter("start");
		String selecter = req.getParameter("selecter");
		String touch = req.getParameter("touch");
		String coverImg = req.getParameter("coverImg");
		String board = req.getParameter("board");
		String coupon = req.getParameter("coupon");

		List<String> errs = new ArrayList<String>();
		if(housing==null || rocker==null || l1==null || l2==null || r1==null ||
				r2==null || o==null || x==null || square==null || triangle==null || start==null ||
				selecter==null || touch==null || coverImg==null || board==null || coupon==null) {
			errs.add("莫名的錯誤");
		}

		HttpSession session = req.getSession(true);
		
		int price = 0;
		price += (int)service.selectCostById(housing);
		price += (int)service.selectCostById(rocker);
		price += (int)service.selectCostById(l1);
		price += (int)service.selectCostById(l2);
		price += (int)service.selectCostById(r1);
		price += (int)service.selectCostById(r2);
		price += (int)service.selectCostById(o);
		price += (int)service.selectCostById(x);
		price += (int)service.selectCostById(square);
		price += (int)service.selectCostById(triangle);
		price += (int)service.selectCostById(start);
		price += (int)service.selectCostById(selecter);
		price += (int)service.selectCostById(touch);
		price += (int)service.selectCostById(coverImg);
		price += (int)service.selectCostById(board);
		price += (int)service.selectCostById("000");//工錢
		if(coupon!=null && coupon.length()!=0) {
			price -= service2.select(coupon);
		}
		
		java.util.Date now = new java.util.Date();
		String orderNo = Long.toString(now.getTime());
		OrderBean bean = new OrderBean();
		bean.setOrderNo(orderNo);
		bean.setOrderDate(now);
		bean.setHousing(housing);
		bean.setRocker(rocker);
		bean.setL1(l1);
		bean.setL2(l2);
		bean.setR1(r1);
		bean.setR2(r2);
		bean.setO(o);
		bean.setX(x);
		bean.setSquare(square);
		bean.setTriangle(triangle);
		bean.setStart(start);
		bean.setSelecter(selecter);
		bean.setTouch(touch);
		bean.setCoverImg(coverImg);
		bean.setBoard(board);
		bean.setCoupon(coupon);
		bean.setPrice(price);
		session.setAttribute("joystick", bean);
		
		req.getRequestDispatcher("/front_custom_order.html").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	

}
