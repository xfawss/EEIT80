package misc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class OpenSessionInViewFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			chain.doFilter(req, resp);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				if (sessionFactory.getCurrentSession().getTransaction().isActive()) {
					sessionFactory.getCurrentSession().getTransaction().rollback();
				}
			} catch (Throwable ex) {
				ex.printStackTrace();
			}
			throw new ServletException(e);
		}
	}
	private SessionFactory sessionFactory; 

	@Override
	public void init(FilterConfig config) throws ServletException {
		String sessionFactoryBeanName = config.getInitParameter("sessionFactoryBeanName");
		ServletContext application = config.getServletContext();
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(application);
		sessionFactory = (SessionFactory) context.getBean(sessionFactoryBeanName);
	}
	@Override
	public void destroy() {

	}
}
