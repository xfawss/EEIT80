package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import misc.AllPayCheckMacValue;
import misc.Parse;
import model.OrderBean;
import model.OrderService;


@WebServlet("/Order")
public class OrderServlet extends HttpServlet {
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
//		String customerTel = req.getParameter("CustomerTel");
//		String receiveType = req.getParameter("ReceiveType");
//		String customerAddr = req.getParameter("CustomerAddr");
//		String receiveNotes = req.getParameter("ReceiveNotes");
//		String orderNotes = req.getParameter("OrderNotes");
//		String customerMail = req.getParameter("CustomerMail");
//		String customerName = req.getParameter("CustomerName");
//		String customerLine = req.getParameter("CustomerLine");
//		String customerFb = req.getParameter("CustomerFb");
//		
//		List<String> errs = new ArrayList<String>();
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

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String customerTel = req.getParameter("CustomerTel");
		String receiveType = req.getParameter("ReceiveType");
		String customerAddr = req.getParameter("CustomerAddr");
		String receiveNotes = req.getParameter("ReceiveNotes");
		String orderNotes = req.getParameter("OrderNotes");
		String customerMail = req.getParameter("CustomerMail");
		String customerName = req.getParameter("CustomerName");
		String customerLine = req.getParameter("CustomerLine");
		String customerFb = req.getParameter("CustomerFb");
		
		List<String> errs = new ArrayList<String>();
		if(customerName==null || customerName.length()==0 || receiveType==null || receiveType.length()==0 ||
				customerTel==null || customerTel.length()==0 || customerAddr==null || customerAddr.length()==0) {
			errs.add("有必填選項空白");
		}
		/*新增入顧客Table
		customerName
		customerTel
		customerLine
		customerFb
		customerMail
		receiveType
		customerAddr
		*/
		
		
		//BossNotes OrderState 後台
		java.util.Date now = new java.util.Date();
		String orderNo = Long.toString(now.getTime());
		HttpSession session = req.getSession(false);
		if(session==null){
			errs.add("流程錯誤");
			req.getRequestDispatcher("/ye/joystick.html").forward(req, resp);
		}
		OrderBean bean = (OrderBean)session.getAttribute("joystick");
		bean.setOrderNo(orderNo);
		bean.setOrderDate(now);
		bean.setOrderState("已下訂");
		bean.setCustomerTel(customerTel);
		bean.setReceiveNotes(receiveNotes);
		bean.setReceiveType(receiveType);
		bean.setCustomerAddr(customerAddr);
		bean.setReceiveType(receiveType);
		
		bean = service.insert(bean);
		if(bean != null) {
			orderNo = bean.getOrderNo();
			String orderDate = Parse.dateToString2(bean.getOrderDate());
			System.out.println("XXX" + orderDate);
			
			String price = Integer.toString(bean.getPrice());
			req.setAttribute("MerchantID", AllPayCheckMacValue.merchantID);
			req.setAttribute("MerchantTradeNo", orderNo);
			req.setAttribute("MerchantTradeDate", orderDate);
			req.setAttribute("PaymentType", AllPayCheckMacValue.paymentType);
			req.setAttribute("TotalAmount", price);
			req.setAttribute("TradeDesc", AllPayCheckMacValue.tradeDesc);
			req.setAttribute("ItemName", AllPayCheckMacValue.itemName);
			req.setAttribute("ReturnURL", AllPayCheckMacValue.returnURL);
			req.setAttribute("ChoosePayment", AllPayCheckMacValue.choosePayment);
			req.setAttribute("IgnorePayment", AllPayCheckMacValue.ignorePayment);
			req.setAttribute("ClientBackURL", AllPayCheckMacValue.clientBackURL);
			req.setAttribute("CheckMacValue", AllPayCheckMacValue.checkMacValue(orderNo, orderDate, price));
			req.getRequestDispatcher("/ye/orderlist.jsp").forward(req, resp);
		} else {
			errs.add("流程錯誤");
			req.getRequestDispatcher("/ye/joystick.html").forward(req, resp);
		}
	}

}
