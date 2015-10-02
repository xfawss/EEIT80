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
import org.springframework.core.env.SystemEnvironmentPropertySource;

import misc.Parse;
import model.ImageBean;
import model.ImageService;
import model.dao.ImageDAOjdbc;

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

		rsp.setContentType("text/html;charset=UTF-8");

		// 接收資料
		String imageId = req.getParameter("imageId");
		String name = req.getParameter("imageName");
		String path = req.getParameter("imagePath");
		String imgCategoryName = req.getParameter("imgCategoryName");
		String action = req.getParameter("action");

		// 轉換資料
		
		int parseImageId = 0;
		if (imageId != null && imageId.length() != 0) {
			parseImageId = Parse.convertInt(imageId);
		}
		
		JSONObject jObj = new JSONObject();
		PrintWriter out = rsp.getWriter();

		if (action != null) {
			if (name != null && name.length() != 0) {
				if ("selectByName".equals(action)) {
					List<Map<String, Object>> result = service.selectByName(name);
					jObj.put("results", result);
					out.print(jObj);
					return;
				}
			}
			if (parseImageId != 0) {
				if ("selectById".equals(action)) {
					List<Map<String, Object>> result = service.selectById(parseImageId);
					jObj.put("results", result);
					out.print(jObj);
					return;
				}
			}
			if (parseImageId == 0) {
				if ("selectAll".equals(action)) {
					List<Map<String, Object>> result = service.selectAll();
					jObj.put("results", result);
					out.print(jObj);
					return;
				}
			}
			if (parseImageId == 0) {
				if ("selectByImgCategoryName".equals(action)) {
					List<Map<String, Object>> result = service.selectByImgCategoryName(imgCategoryName);
					jObj.put("results", result);
					out.print(jObj);
					return;
				}
			}
		}
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

		rsp.setContentType("text/html ; charset = UTF-8");

		// 接收資料
		String imageId = req.getParameter("imageId");
		String name = req.getParameter("imageName");
		String path = req.getParameter("imagePath");
		String imgCategoryName = req.getParameter("imgCategoryName");
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
					errors.add("請輸入名稱");
				}
				if(path == null || path.length() == 0){
					errors.add("請輸入圖片連結路徑");
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

		// 呼叫model
		ImageBean bean = new ImageBean();
		bean.setImageId(parseImageId);
		bean.setImageName(name);
		bean.setImagePath(path);
		bean.setImgCategoryName(imgCategoryName);

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


