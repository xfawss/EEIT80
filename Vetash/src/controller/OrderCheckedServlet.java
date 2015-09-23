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

import model.OrderBean;
import model.OrderService;

@WebServlet("/orderChecked")
public class OrderCheckedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService service;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (OrderService)context.getBean("OrderService");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		List<String> errs = new ArrayList<String>();
		
		HttpSession session = req.getSession(false);
		if(session==null){
			errs.add("流程錯誤");
			req.getRequestDispatcher("/ye/joystick.html").forward(req, resp);
		}
		OrderBean bean = (OrderBean)session.getAttribute("joystick");
		bean = service.insert(bean);
	}

}
