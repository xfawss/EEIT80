package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

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
		PrintWriter out = resp.getWriter();
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
				req.getRequestDispatcher("/backend_main.html").forward(req, resp);
				return;
			} else {
				errs.put("warning4", "Fail");
				req.setAttribute("isLoginSuccess", false);
				req.getRequestDispatcher("/backend_login.jsp").forward(req, resp);
				return;
			}
		} else if(task.equals("changePass")) {
			JSONObject jObj = new JSONObject();
			if(newPass1.equals(newPass2)) {
				if(service.changePassKey(bigWave, passKey, newPass1)) {
					jObj.put("state", "success");
					out.print(jObj);
					return;
				} else {
					jObj.put("state", "fail");
					out.print(jObj);
					return;
				}
			} else {
				jObj.put("state", "fail");
				out.print(jObj);
				return;
			}
		} else if(task.equals("insert")) {
			service.insert(bigWave, passKey);
			return;
		} else if(task.equals("logout")) {
			session.setAttribute("Login", false);
			req.getRequestDispatcher("/backend_login.jsp").forward(req, resp);
			return;
		}
	}

}
