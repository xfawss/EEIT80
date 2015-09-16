package controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ImageBean;
import model.ImageService;
import model.dao.ImageDAOjdbc;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet(urlPatterns = { "/image.c" })
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ImageDAOjdbc jdbc = new ImageDAOjdbc();
//		 //select by id
		
//		 ImageBean bean = jdbc.select(3);
//		 System.out.println(bean);
 
		//slelct like name		
		
//		 List<ImageBean> result = jdbc.selectName("人");			
//		 System.out.println(result);
		
		
//		// select all
////		 
//		 List<ImageBean> result = jdbc.select();
//		 System.out.println(result);
//
//		 
////		 insert
		
//		ImageBean bean = new ImageBean();
//		bean.setImageName("貓6");
//		bean.setImagePath("img/cat1.jpg");
//		bean.setImgCategoryId(2);
//		jdbc.insert(bean);
//		System.out.println(bean);
////		
//		
//		// update
//		
//		ImageBean bean = new ImageBean();
//		jdbc.update("貓66666", 6);
//		System.out.println(bean);
////		
//		
//		// delete
////		
//		boolean b = jdbc.delete(6);
//		System.out.println(b);
		
		
		//select last
//		
//		String id = jdbc.selectLast();
//		System.out.println(id);
		
		
		
		ImageService ser = new ImageService();
		ImageBean bean = new ImageBean();
		 //select by id (Service)
//		bean.setImageId(4);
//		List<ImageBean> result =ser.select(bean);
//		System.out.println(result);
		
		
		// select all (Service)
//		List<ImageBean> result =ser.select(bean);
//		System.out.println(result);
		
		
		//select like name (Service)
		
		List<ImageBean> result =ser.selectName("鐵");
		System.out.println(result);

		
		//insert (Service)
//		Timestamp ts = new Timestamp(System.currentTimeMillis()); 
//		bean.setImageName("超人");
//		bean.setImageDate(ts);
//		bean.setImagePath("http://tw.yahoo.com");
//		bean.setImgCategoryId(2);
//		bean = ser.insert(bean);
//		System.out.println(bean);
		
		
//		// update (Service)
		
//		bean.setImageName("超人的哥哥叫超哥");
//		bean.setImageId(7);
//		bean = ser.update(bean);
//		System.out.println(bean);
		
		
//		// delete (Service)
//		bean.setImageId(7);
//		boolean result = ser.delete(bean);
//		System.out.println(result);
		
		
		//select last (Service)
//		String result = ser.selectLast();
//		System.out.println(result);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

//		 DiskFileUpload fu = new DiskFileUpload();
//		 fu.setSizeMax(10000000); // 上傳的檔案最大可以有1000000 bytes
//		 fu.setSizeThreshold(4096); // 最多可以在memery中有4096 bytes的cache
//		 fu.setRepositoryPath("/"); // 檔案大於getSizeThreshold時的暫存路徑
//		 List fileItems = null;
//		 try {
//		 fileItems = fu.parseRequest(request);
//		 } catch (FileUploadException e) {
//		 e.printStackTrace();
//		 }
//		 Iterator i = fileItems.iterator();
//		 while (i.hasNext()) {
//		 FileItem fi = (FileItem) i.next();
//		 String fileName = getFilename(fi.getName()); 
//		   //得到的是包含路徑的檔名
//		 fi.getName() ;
//		 File f = new File("C:/Spring/workspace/Project/WebContent/img/" +
//		 fileName);
//		 try {
//		 fi.write(f); // 將檔案寫到磁碟
//		 } catch (Exception e1) {
//		 e1.printStackTrace();
//		 }
//		 }
//		 System.out.println("the best");
//		 }
//		
//		 // 將路徑過濾掉，只傳回檔名
//		 public String getFilename(String fullname) {
//		 String filename = null;
//		
//		 fullname = fullname.replace('\\', '/');
//		 StringTokenizer token = new StringTokenizer(fullname, "/");
//		 while (token.hasMoreTokens()) {
//		 filename = token.nextToken();
//		 }
//		 return filename;
		
		
	}
}
