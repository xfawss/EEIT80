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

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import misc.Parse;
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
		service = (CouponService) context.getBean("CouponService");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String coupon = req.getParameter("coupon");
		String discountString = req.getParameter("discount");
		String deadlineString = req.getParameter("deadline");
		String timesString = req.getParameter("times");
		String notes = req.getParameter("notes");
		String task = req.getParameter("task");
		
		Map<String, String> errs = new HashMap<String, String>();
		req.setAttribute("err", errs);
		if(task==null){
			errs.put("warning1", "你怎進來的");
		}else if(task.equals("select") || task.equals("createOrUpdate") || task.equals("delete") || task.equals("find")) {
			System.out.println(task);
		}else {
			errs.put("warning1", "你怎進來的");
		}
		
		JSONObject jObj = new JSONObject();
		PrintWriter out = resp.getWriter();
		if(task != null){
			if(task.equals("select")){
				List<Map<String, Object>> beans = service.selectAll();
				jObj.put("results", beans);
				out.print(jObj);
				return;
			}
			
			if(task.equals("find")){
				int dis = service.select(coupon);
				jObj.put("discount", dis);
				out.print(jObj);
				return;
			}
			
			if(task.equals("delete")){
				service.delete(coupon);
				req.getRequestDispatcher("/ye/Coupons.html").forward(req, resp);
				return;
			}
		}
		if(coupon==null || coupon.length()==0 || discountString==null || discountString.length()==0){
			errs.put("warning2", "折扣碼、價值不允許空值");
		}
		
		int discount = 0;
		if(discountString!=null && discountString.length()!=0){
			discount = Parse.convertInt(discountString);
		}
		java.util.Date deadline = null;
		if(deadlineString!=null && deadlineString.length()!=0){
			deadline = Parse.convertDate(deadlineString);
		}
		Integer times = null;
		if(timesString!=null && timesString.length()!=0){
			times = (Integer)Parse.convertInt(timesString);
		}
		if(discountString==null || discountString.length()==0){
			errs.put("warning1", "你怎進來的");
		} else if(discount < 1){
			errs.put("warning3", "格式錯誤、價格次數不可小於1");
			
		}
		if(deadline!=null){
			if(deadline.equals(new java.util.Date(0))){
				errs.put("warning4", "日期輸入格式錯誤、不可輸入今天之前");
			} else if(deadline.before(new java.util.Date())){
				errs.put("warning3", "日期輸入格式錯誤、不可輸入今天之前");
			}
		}
		if(times!=null){
			if(times < 1){
				errs.put("warning4", "格式錯誤、價格次數不可小於1");
			}
		}
		if(errs!=null && !errs.isEmpty()){
			req.getRequestDispatcher(
					"/ye/err.jsp").forward(req, resp);
			return;
		}
		
		if(task.equals("createOrUpdate")){
			service.createOrUpdate(coupon, discount, deadline, times, notes);
			req.getRequestDispatcher("/ye/Coupons.html").forward(req, resp);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
