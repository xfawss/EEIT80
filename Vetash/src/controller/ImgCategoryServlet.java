package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ImgCategoryBean;
import model.ImgCategoryDAO;
import model.ImgCategoryService;
import model.dao.ImgCategoryDAOjdbc;

/**
 * Servlet implementation class KindImageServlet
 */
@WebServlet(urlPatterns={"/ImgCategory.controller"})
public class ImgCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//slect by id
		System.out.println("go");
//		
//		ImgCategoryDAOjdbc jdbc=new ImgCategoryDAOjdbc();
//		ImgCategoryBean bean = jdbc.select(5);
//		System.out.println(bean);
		
//		
//		//slect all
//		
//		ImgCategoryDAOjdbc jdbc=new ImgCategoryDAOjdbc();
//		List<ImgCategoryBean> list = jdbc.select();
//		System.out.println(list);
////		
//		
//		//insert
//		
//		ImgCategoryDAOjdbc jdbc=new ImgCategoryDAOjdbc();
//		ImgCategoryBean bean = new ImgCategoryBean();
//		bean.setImgCategoryName("美女圖");
//		jdbc.insert(bean);
//		System.out.println("id="+bean.getImgCategoryId()+"name="+bean.getImgCategoryName());
////		
//		
//		//update
//		
//		ImgCategoryDAOjdbc jdbc=new ImgCategoryDAOjdbc();
//		ImgCategoryBean bean =jdbc.update("大頭照公館大頭照公館大頭照公館", 1);
//		System.out.println("id="+bean.getImgCategoryId()+"name="+bean.getImgCategoryName());
		
//		
		//select all(Service)
		
		ImgCategoryService imgc = new ImgCategoryService();
		ImgCategoryBean bean = new ImgCategoryBean();
		List<ImgCategoryBean> result = imgc.select(bean);
		System.out.println(result);
		
		
		//select by id(Service)
		
//		ImgCategoryService imgc = new ImgCategoryService();
//		ImgCategoryBean bean = new ImgCategoryBean();
//		bean.setImgCategoryId(5);
//		List<ImgCategoryBean> result = imgc.select(bean);
//		System.out.println(result);
		
		
		//insert(Service)
		
//		ImgCategoryService imgc = new ImgCategoryService();
//		ImgCategoryBean bean = new ImgCategoryBean();
//		bean.setImgCategoryName("螺絲圖");
//		bean = imgc.insert(bean);
//		System.out.println(bean);
//		
		
		//update(Service)
		
//		ImgCategoryService imgc = new ImgCategoryService();
//		ImgCategoryBean bean = new ImgCategoryBean();
//		bean.setImgCategoryName("面版圖");
//		bean.setImgCategoryId(9);
//		bean = imgc.update(bean);
//		System.out.println(bean);
		

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
