package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import misc.Parse;
import model.ImageBean;
import model.ImageService;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImageService service;

	@Override
	public void init() throws ServletException {
		service = new ImageService();
		super.init();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

		// String id = req.getParameter("imageId");
		// String name = req.getParameter("imageName");
		// String action = req.getParameter("action");

		// ImageDAOjdbc jdbc = new ImageDAOjdbc();
		// //select by id

		// ImageBean bean = jdbc.select(3);
		// System.out.println(bean);

		// slelct like name

		// List<ImageBean> result = jdbc.selectName("人");
		// System.out.println(result);

		// // select all
		////
		// List<ImageBean> result = jdbc.select();
		// System.out.println(result);
		//
		//
		//// insert

		// ImageBean bean = new ImageBean();
		// bean.setImageName("貓6");
		// bean.setImagePath("img/cat1.jpg");
		// bean.setImgCategoryId(2);
		// jdbc.insert(bean);
		// System.out.println(bean);
		////
		//
		// // update
		//
		// ImageBean bean = new ImageBean();
		// jdbc.update("貓66666", 6);
		// System.out.println(bean);
		////
		//
		// // delete
		////
		// boolean b = jdbc.delete(6);
		// System.out.println(b);

		// select last
		//
		// String id = jdbc.selectLast();
		// System.out.println(id);

		ImageService ser = new ImageService();
		ImageBean bean = new ImageBean();
		// select by id (Service)
		// bean.setImageId(4);
		// List<ImageBean> result =ser.select(bean);
		// System.out.println(result);

		// select all (Service)
		// List<ImageBean> result =ser.select(bean);
		// System.out.println(result);

		// select like name (Service)

		List<ImageBean> result = ser.selectName("鐵");
		System.out.println(result);

		 //insert (Service)
//		 Timestamp ts = new Timestamp(System.currentTimeMillis());
//		 bean.setImageName("超人");
//		 bean.setImageDate(ts);
//		 bean.setImagePath("http://tw.yahoo.com");
//		 bean.setImgCategoryId(2);
//		 int q = ser.insert(bean);
//		 System.out.println(q);

		// // update (Service)

		// bean.setImageName("超人的哥哥叫超哥");
		// bean.setImageId(7);
		// bean = ser.update(bean);
		// System.out.println(bean);

		// // delete (Service)
		// bean.setImageId(7);
		// boolean result = ser.delete(bean);
		// System.out.println(result);

		// select last (Service)
		// String result = ser.selectLast();
		// System.out.println(result);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

		rsp.setContentType("text/html ; charset = UTF-8");

		// 接收資料
		String imageId = req.getParameter("imageId");
		String name = req.getParameter("name");
		String path = req.getParameter("path");
		String imgCategoryId = req.getParameter("imgCategoryId");
		String action = req.getParameter("action");

		// 驗證資料
		JSONObject jObj = new JSONObject();
		PrintWriter out = rsp.getWriter();
		Map<String, Object> results = new HashMap<String, Object>();
		List<String> errors = new ArrayList<String>();

		if (action != null) {
			if ("insert".equals(action) || "update".equals(action)) {
				System.out.println("error");
				if (name == null || name.length() == 0) {
					errors.add("請輸入圖片名稱");
				}
			}
		}
		if (errors != null && !errors.isEmpty()) {
			results.put("errors", errors);
			jObj.put("results", results);
			out.print(jObj);
			return;
		}
		// 轉換資料
		int parseImageId = 0;
		if (imageId != null && imageId.length() != 0) {
			parseImageId = Parse.convertInt(imageId);
		}

		int parseCategoryId = 0;
		if (imgCategoryId != null && imgCategoryId.length() != 0) {
			parseCategoryId = Parse.convertInt(imgCategoryId);
		}

		// 呼叫model
		ImageBean bean = new ImageBean();
		bean.setImageId(parseImageId);
		bean.setImageName(name);
		bean.setImagePath(path);
		bean.setImgCategoryId(parseCategoryId);

		// 根據Model執行結果導向View
		int result = 0;
		if (action != null && "insert".equals(action)) {
			result = service.insert(bean);
			if (result == 0) {
				results.put("state", "新增失敗");
			} else {
				req.setAttribute("insert", result);
				results.put("state", "新增" + result + "筆成功");
			}
		}
		if (action != null && "update".equals(action)) {
			result = service.update(bean);
			if (result == 0) {
				results.put("state", "修改失敗");
			} else {
				req.setAttribute("update", result);
				results.put("state", "修改" + result + "筆成功");
			}
		}
		if (action != null && "delete".equals(action)) {
			result = service.delete(bean);
			if (result == 0) {
				results.put("state", "刪除失敗");
			} else {
				req.setAttribute("delete", result);
				results.put("state", "刪除" + result + "筆成功");
			}
		}

		jObj.put("results", results);
		out.print(jObj);
		return;
	}
}

// 上傳多個檔案

// DiskFileUpload fu = new DiskFileUpload();
// fu.setSizeMax(10000000); // 上傳的檔案最大可以有1000000 bytes
// fu.setSizeThreshold(4096); // 最多可以在memery中有4096 bytes的cache
// fu.setRepositoryPath("/"); // 檔案大於getSizeThreshold時的暫存路徑
// List fileItems = null;
// try {
// fileItems = fu.parseRequest(request);
// } catch (FileUploadException e) {
// e.printStackTrace();
// }
// Iterator i = fileItems.iterator();
// while (i.hasNext()) {
// FileItem fi = (FileItem) i.next();
// String fileName = getFilename(fi.getName());
// //得到的是包含路徑的檔名
// fi.getName() ;
// File f = new File("C:/Spring/workspace/Project/WebContent/img/" +
// fileName);
// try {
// fi.write(f); // 將檔案寫到磁碟
// } catch (Exception e1) {
// e1.printStackTrace();
// }
// }
// System.out.println("the best");
// }
//
// // 將路徑過濾掉，只傳回檔名
// public String getFilename(String fullname) {
// String filename = null;
//
// fullname = fullname.replace('\\', '/');
// StringTokenizer token = new StringTokenizer(fullname, "/");
// while (token.hasMoreTokens()) {
// filename = token.nextToken();
// }
// return filename;
