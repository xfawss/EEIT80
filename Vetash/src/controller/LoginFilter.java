package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession(true);
		Object login = session.getAttribute("Login");
		System.out.println("login"+login);
		if(login!=null && (boolean)login) {
			//resp.sendRedirect("/Vetash/backend_main.html");
			req.getRequestDispatcher("/backend_main.html").forward(req, resp);
		} else {
			//resp.sendRedirect("/Vetash/ye/login.html");
			req.getRequestDispatcher("/ye/login.html").forward(req, resp);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
