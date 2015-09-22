package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		String orderNotes = req.getParameter("OrderNotes");
		String coupon = req.getParameter("Coupon");
		String bossNotes = req.getParameter("BossNotes");
		String customerTel = req.getParameter("CustomerTel");
		String orderDate = req.getParameter("OrderDate");
		String price = req.getParameter("Price");
		String orderState = req.getParameter("OrderState");
		String orderNo = req.getParameter("OrderNo");
		String receiveType = req.getParameter("ReceiveType");
		String customerAddr = req.getParameter("CustomerAddr");
		String receiveNotes = req.getParameter("ReceiveNotes");
		String customerMail = req.getParameter("CustomerMail");
		String customerName = req.getParameter("CustomerName");
		String customerLine = req.getParameter("CustomerLine");
		String customerFb = req.getParameter("CustomerFb");
		
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
			
		}
//		if(customerName==null || customerName.length()==0 || receiveType==null || receiveType.length()==0 ||
//				customerTel==null || customerTel.length()==0 || customerAddr==null || customerAddr.length()==0) {
//			errs.add("有必填選項空白");
//		}
//		/*新增入顧客Table
//		customerName
//		customerTel
//		customerLine
//		customerFb
//		customerMail
//		receiveType
//		customerAddr
//		*/
//		
//		
//		//BossNotes OrderState 後台
//		java.util.Date now = new java.util.Date();
//		HttpSession session = req.getSession(false);
//		if(session==null){
//			errs.add("流程錯誤");
//			req.getRequestDispatcher("/ye/joystick.html").forward(req, resp);
//		}
//		OrderBean bean = (OrderBean)session.getAttribute("joystick");
//		bean.setOrderNo(now.getTime());
//		bean.setOrderDate(now);
//		bean.setOrderState("已下訂");
//		bean.setCustomerTel(customerTel);
//		bean.setReceiveNotes(receiveNotes);
//		bean.setReceiveType(receiveType);
//		bean.setCustomerAddr(customerAddr);
//		bean.setReceiveType(receiveType);
//		
//		bean = service.insert(bean);
//		if(bean != null) {
//			req.setAttribute("", );
//		} else {
//			errs.add("流程錯誤");
//			req.getRequestDispatcher("/ye/joystick.html").forward(req, resp);
//		}
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
