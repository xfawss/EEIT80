package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Order;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import misc.Parse;
import model.OrderBean;
import model.OrderService;

@WebServlet("/OrderCommand")
public class OrderCommandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService service;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (OrderService)context.getBean("OrderService");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String task = req.getParameter("task");
		String housing = req.getParameter("Housing");
		String rocker = req.getParameter("Rocker");
		String l1 = req.getParameter("L1");
		String l2 = req.getParameter("L2");
		String r1 = req.getParameter("R1");
		String r2 = req.getParameter("R2");
		String o = req.getParameter("O");
		String x = req.getParameter("X");
		String square = req.getParameter("Square");
		String triangle = req.getParameter("Triangle");
		String start = req.getParameter("Start");
		String selecter = req.getParameter("Selecter");
		String touch = req.getParameter("Touch");
		String coverImg = req.getParameter("CoverImg");
		String board = req.getParameter("Board");
		String bossNotes = req.getParameter("BossNotes");
		String customerTel = req.getParameter("CustomerTel");
		String orderDate = req.getParameter("OrderDate");
		String price = req.getParameter("Price");
		String orderState = req.getParameter("OrderState");
		String orderNo = req.getParameter("OrderNo");
		String deliveryDate = req.getParameter("DeliveryDate");
		
		OrderBean bean = new OrderBean();
		List<String> errs = new ArrayList<String>();
		JSONObject jObj = new JSONObject();
		if(task==null || task.length()==0) {
			errs.add("莫名的錯誤");
		} else if(task.equals("all")) {
			List<Map<String, Object>> beans = service.selectAll();
			jObj.put("results", beans);
			out.print(jObj);
			return;
		} else if(task.equals("tel")) {
			if(customerTel==null || customerTel.length()==0) {
				errs.add("沒有關鍵字");
			} else {
				List<Map<String, Object>> beans = service.selectByTel(customerTel);
				jObj.put("results", beans);
				out.print(jObj);
				return;
			}
		} else if(task.equals("date")) {
			if(orderDate==null || orderDate.length()==0) {
				errs.add("沒有關鍵字");
			} else {
				java.util.Date date = Parse.convertDate(orderDate);
				if (date.equals(new java.util.Date(0))) {
					errs.add("格式錯誤");
				} else {
					List<Map<String, Object>> beans = service.selectByDate(date);
					jObj.put("results", beans);
					out.print(jObj);
					return;
				}
			}
		} else if(task.equals("note")) {
			if(bossNotes==null || bossNotes.length()==0) {
				errs.add("沒有關鍵字");
			} else {
				List<Map<String, Object>> beans = service.selectByNote(bossNotes);
				jObj.put("results", beans);
				out.print(jObj);
				return;
			}
		} else if(task.equals("delete")) {
			if(orderNo==null || orderNo.length()==0) {
				errs.add("沒有關鍵字");
			} else {
				if(service.delete(orderNo)) {
					req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
				} else {
					errs.add("刪除失敗");
				}
			}
		} else if(task.equals("update")) {
			if(price!=null && price.length()!=0) {
				int temp = Parse.convertInt(price);
				if(temp > 1) {
					bean.setPrice(temp);
				} else {
					errs.add("價錢型態錯誤");
				}
			}
			if(deliveryDate!=null && deliveryDate.length()!=0) {
				java.util.Date temp = Parse.convertDate(deliveryDate);
				if(!temp.equals(new java.util.Date(0))) {
					bean.setDeliveryDate(temp);
				} else {
					errs.add("日期型態錯誤");
				}
			}
			bean.setOrderNo(orderNo);
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
			bean.setBossNotes(bossNotes);
			bean.setOrderState(orderState);
			service.update(bean);
			req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
