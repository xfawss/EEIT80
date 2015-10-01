package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.AccessBackService;

@WebServlet("/accessback")
public class AccessBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccessBackService service;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (AccessBackService)context.getBean("AccessBackService");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String bigWave = req.getParameter("account");
		String passKey = req.getParameter("password");
		String newPass1 = req.getParameter("newPass1");
		String newPass2 = req.getParameter("newPass2");
		String task = req.getParameter("task");
		
		Map<String, String> errs = new HashMap<String, String>();
		req.setAttribute("err", errs);
		HttpSession session = req.getSession(true);
		if(task==null || task.length()==0) {
			errs.put("warning1", "你怎進來的");
		} else if(task.equals("login")) {
			if(service.login(bigWave, passKey)){
				session.setAttribute("Login", true);
				resp.sendRedirect("/Vetash/backend_main.html");
				return;
			} else {
				errs.put("warning4", "Fail");
				session.setAttribute("Login", false);
				resp.sendRedirect("/Vetash/ye/login.html");
				return;
			}
		} else if(task.equals("changePass")) {
			if(newPass1.equals(newPass2)) {
				if(service.changePassKey(bigWave, passKey, newPass1)) {
					resp.sendRedirect("/Vetash/ye/login.html");
					return;
				} else {
					resp.sendRedirect("/Vetash/ye/login.html");
					return;
				}
			} else {
				resp.sendRedirect("/Vetash/ye/login.html");
				return;
			}
		} else if(task.equals("insert")) {
			service.insert(bigWave, passKey);
			return;
		} else if(task.equals("login")) {
			session.setAttribute("Login", false);
			resp.sendRedirect("/Vetash/backend_main.html");
			return;
		}
	}

}
