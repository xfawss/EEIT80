package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.ImgCategoryBean;
import model.ImgCategoryService;

@WebServlet("/imgCategory")
public class ImgCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImgCategoryService service;

	public ImgCategoryServlet() {
		super();
	}
 
	@Override
	public void init() throws ServletException {
		service = new ImgCategoryService();
		super.init();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

		rsp.setContentType("text/html;charset=UTF-8");

		// 接收資料
		String id = req.getParameter("imgCategoryId");
		String action = req.getParameter("action");

		// 轉換資料
		int parseId = 0;
		if (id != null && id.length() != 0) {
			parseId = Parse.convertInt(id);
		}

		JSONObject jObj = new JSONObject();
		PrintWriter out = rsp.getWriter();

		if (action != null) {
			if (id != null && id.length()!=0) {
				if ("select".equals(action)) {
					Map<String, Object> result = service.selectById(parseId);
					jObj.put("results", result);
					out.print(jObj);
					return;
				}
			}

			if (id == null || id.length() == 0) {
				if ("select".equals(action)) {
					List<Map<String, Object>> result = service.selectAll();
					jObj.put("results", result);
					out.print(jObj);
					return;
				}
			}
		}
	}
	// //slect by id
	// ImgCategoryDAOjdbc jdbc=new ImgCategoryDAOjdbc();
	// ImgCategoryBean bean = jdbc.select(5);
	// System.out.println(bean);

	//
	// //slect all
	//
	// ImgCategoryDAOjdbc jdbc=new ImgCategoryDAOjdbc();
	// List<ImgCategoryBean> list = jdbc.select();
	// System.out.println(list);
	////
	//
	// //insert
	//
	// ImgCategoryDAOjdbc jdbc=new ImgCategoryDAOjdbc();
	// ImgCategoryBean bean = new ImgCategoryBean();
	// bean.setImgCategoryName("美女圖");
	// jdbc.insert(bean);
	// System.out.println("id="+bean.getImgCategoryId()+"name="+bean.getImgCategoryName());
	////
	//
	// //update
	//
	// ImgCategoryDAOjdbc jdbc=new ImgCategoryDAOjdbc();
	// ImgCategoryBean bean =jdbc.update("大頭照公館大頭照公館大頭照公館", 1);
	// System.out.println("id="+bean.getImgCategoryId()+"name="+bean.getImgCategoryName());

	//
	// select all(Service)

	// ImgCategoryService imgc = new ImgCategoryService();
	// ImgCategoryBean bean = new ImgCategoryBean();
	// List<ImgCategoryBean> result = imgc.select(bean);
	// System.out.println(result);

	// select by id(Service)

	// ImgCategoryService imgc = new ImgCategoryService();
	// ImgCategoryBean bean = new ImgCategoryBean();
	// bean.setImgCategoryId(5);
	// List<ImgCategoryBean> result = imgc.select(bean);
	// System.out.println(result);

	// insert(Service)

	// ImgCategoryService imgc = new ImgCategoryService();
	// ImgCategoryBean bean = new ImgCategoryBean();
	// bean.setImgCategoryName("螺絲圖");
	// bean = imgc.insert(bean);
	// System.out.println(bean);
	//

	// update(Service)

	// ImgCategoryService imgc = new ImgCategoryService();
	// ImgCategoryBean bean = new ImgCategoryBean();
	// bean.setImgCategoryName("面版圖");
	// bean.setImgCategoryId(9);
	// bean = imgc.update(bean);
	// System.out.println(bean);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

		rsp.setContentType("text/html ;charset = UTF-8");
		// 接收資料
		String id = req.getParameter("imgCategoryId");
		String name = req.getParameter("imgCategoryName");
		String action = req.getParameter("action");

		// 驗證資料
		JSONObject jObj = new JSONObject();
		PrintWriter out = rsp.getWriter();
		Map<String, Object> results = new HashMap<String, Object>();
		List<String> errors = new ArrayList<String>();
		if (action != null) {
			if ("insert".equals(action) || "update".equals(action)) {
				if (name == null || name.length() == 0) {
					errors.add("新增或修改時需輸入分類名稱");
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
		int parseId = 0;
		if (id != null && id.length() != 0) {
			parseId = Parse.convertInt(id);
		}

		// 呼叫Model
		ImgCategoryBean bean = new ImgCategoryBean();
		bean.setImgCategoryId(parseId);
		bean.setImgCategoryName(name);

		// 根據Model結果導向View
		if (action != null && "insert".equals(action)) {
			int result = service.insert(bean);
			if (result == 0) {
				results.put("state", "新增失敗");
			} else {
				req.setAttribute("inset", result);
				results.put("state", "新增" + result + "成功");
			}
		}
		if (action != null && "update".equals(action)) {
			int result = service.update(bean);
			if (result == 0) {
				results.put("state", "修改失敗");
			} else {
				req.setAttribute("update", result);
				results.put("state", "修改" + result + "成功");
			}
		}

		jObj.put("results", results);
		out.print(jObj);
		return;
	}
}
