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

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.AccessBackDAO;
import model.AccessBackService;
import model.dao.AccessBackDAOHibernate;

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
		resp.setContentType("text/html; charset=UTF-8");
		String bigWave = req.getParameter("account");
		String passKey = req.getParameter("password");
		String newPass1 = req.getParameter("newPass1");
		String newPass2 = req.getParameter("newPass2");
		String task = req.getParameter("task");
		
		Map<String, String> errs = new HashMap<String, String>();
		req.setAttribute("err", errs);
		if(task==null || task.length()==0) {
			errs.put("warning1", "你怎進來的");
		} else if(task.equals("login")) {
			if(service.login(bigWave, passKey)){
				errs.put("warning2", "SUCCESSFUL!!");
				req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
				return;
			} else {
				errs.put("warning4", "Fail");
				req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
				return;
			}
		} else if(task.equals("changePass")) {
			if(newPass1.equals(newPass2)) {
				if(service.changePassKey(bigWave, passKey, newPass1)) {
					errs.put("warning2", "SUCCESSFUL!!");
					req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
					return;
				} else {
					errs.put("warning4", "Fail");
					req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
					return;
				}
			} else {
				errs.put("warning3", "新密碼不一致");
				req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
				return;
			}
		} else if(task.equals("insert")) {
			service.insert(bigWave, passKey);
			return;
		}
	}

}
