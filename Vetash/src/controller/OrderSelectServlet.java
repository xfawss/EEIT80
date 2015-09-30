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

import model.CustomerBean;
import model.CustomerService;
import model.OrderBean;
import model.OrderService;

@WebServlet("/orderSelect")
public class OrderSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	private OrderService service2;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (CustomerService)context.getBean("CustomerService");
		service2 = (OrderService)context.getBean("OrderService");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String customerTel = req.getParameter("customerTel");
		String receiveType = req.getParameter("receiveType");
		String customerAddr = req.getParameter("customerAddr");
		String receiveNotes = req.getParameter("receiveNotes");
		String orderNotes = req.getParameter("orderNotes");
		String customerMail = req.getParameter("customerMail");
		String customerName = req.getParameter("customerName");
		String customerLine = req.getParameter("customerLine");
		String customerFb = req.getParameter("customerFb");
		
		List<String> errs = new ArrayList<String>();
		if(customerName==null || customerName.length()==0 || receiveType==null || receiveType.length()==0 ||
				customerTel==null || customerTel.length()==0 || customerAddr==null || customerAddr.length()==0) {
			errs.add("有必填選項空白");
		}
		CustomerBean cust = new CustomerBean();
		cust.setCustomerTel(customerTel);
		cust.setCustomerName(customerName);
		cust.setCustomerLine(customerLine);
		cust.setCustomerFb(customerFb);
		cust.setCustomerMail(customerMail);
		cust.setCustomerAddr(customerAddr);
		
		if(service.insert(cust)!=1) {
			service.update(cust);
		}
		
		HttpSession session = req.getSession(false);
		if(session==null){
			errs.add("流程錯誤");
			req.getRequestDispatcher("/front_custom.html").forward(req, resp);
		}
		OrderBean bean = (OrderBean)session.getAttribute("joystick");
		bean.setOrderState("已下訂(待確認)");
		bean.setCustomerTel(customerTel);
		bean.setReceiveNotes(receiveNotes);
		bean.setReceiveType(receiveType);
		bean.setCustomerAddr(customerAddr);
		bean.setReceiveType(receiveType);
		bean.setOrderNotes(orderNotes);
		bean.setPrice(0);
		bean = service2.insert(bean);
		req.getRequestDispatcher("/frontend_main.html").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
