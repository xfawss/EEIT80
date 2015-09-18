package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;











import misc.Parse;
import model.ProductBean;
import model.ProductService;








import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (ProductService)context.getBean("ProductService");
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

		// System.out.println("get");

		// 接收資料

		String id = req.getParameter("productId");
		String name = req.getParameter("productName");
		String type = req.getParameter("productType");
		String action = req.getParameter("action");
		// System.out.println(name);
		// System.out.println(tel);
		// System.out.println(action);

		JSONObject jObj = new JSONObject();
		PrintWriter out = rsp.getWriter();

		// StringBuilder sb = new StringBuilder();
		// sb.append("<html><head><meta charset=\"UTF-8\"></head>");
		// sb.append("<body>");

		if (action != null) {
			if (name != null) {
				if (action.equals("select")) {
					List<Map<String, Object>> result = service.selectByName(name);
					jObj.put("results", result);
					out.print(jObj);

					// sb.append(jObj.toString());
					// sb.append("</body></html>");
					// out.write(sb.toString());

					return;
				}
			}
			if (id == null) {
				if (action.equals("select")) {
					List<Map<String, Object>> beans = service.getAll();
					jObj.put("results", beans);
					out.print(jObj);
					return;
				}
			}
			if (id != null) {
				if (action.equals("select")) {
					List<Map<String, Object>> result = service.selectByType(type);
					jObj.put("results", result);
					out.print(jObj);
					return;
				}
			if (id != null) {
				if (action.equals("select")) {
					Map<String, Object> result = service.selectByID(id);
					jObj.put("results", result);
					out.print(jObj);
					return;
				}
			}
		}
			if (id != null) {
				if (action.equals("select")) {
					List<Map<String, Object>> result = service.selectType();
					jObj.put("results", result);
					out.print(jObj);
					return;
				}
			}
	}
}
	// select by name
	// List<Map<String, Object>> results = service.selectByName("k");

	// System.out.println(results);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

		// System.out.println("post");
		// 接收資料
		String id = req.getParameter("productId");
		String type = req.getParameter("productType");
		String name = req.getParameter("productName");
		String price = req.getParameter("productPrice");
		String cost = req.getParameter("productCost");
		String qty = req.getParameter("productQty");
		String imgPath = req.getParameter("productImgPath");
		String note = req.getParameter("productNote");
		String action = req.getParameter("action");

		// System.out.println(name);
		// System.out.println(tel);
		// System.out.println(addr);
		// System.out.println(acct);
		// System.out.println(date);
		// System.out.println(note);
		// System.out.println(action);

		// 驗證資料
		Map<String, String> errs = new HashMap<String, String>();
		req.setAttribute("errMsg", errs);
		


		if (action != null) {
			if (action.equals("insert") || action.equals("update")) {
				if (id == null || id.length() == 0) {
					errs.put("productId", "新增或修改時ID名稱為必填欄位，請輸入");					
				}
				if (type == null || type.length() == 0) {
					errs.put("productType", "新增或修改時種類為必填欄位，請輸入");					
				}
				if (name== null || name.length() == 0) {
					errs.put("productName", "新增或修改時品名為必填欄位，請輸入");
				}
				if (price== null || price.length() == 0) {
					errs.put("productPrice", "新增或修改時價格為必填欄位，請輸入");					
				}				
			}
		}

		// 轉換資料
		

		int parsePrice = 0;
		int parseCost = 0;
		int parseQty = 0;
		if (id != null && id.length() != 0)

		{
			parsePrice = Parse.convertInt(price);
			parseCost  = Parse.convertInt(cost);
			parseQty  = Parse.convertInt(qty);
		}

		// System.out.println(jObj);
		if (errs != null && !errs.isEmpty()) {
			req.getRequestDispatcher("/AlexHo/supplierTest.jsp").forward(req, rsp);
			return;
		}

		// 呼叫Model
		ProductBean bean = new ProductBean();
		bean.setProductNote(note);
		bean.setProductType(type);
		bean.setProductId(id);
		bean.setProductName(name);
		bean.setProductPrice(parsePrice);
		bean.setProductCost(parseCost);
		bean.setProductQty(parseQty);
		bean.setProductImgPath(imgPath);
		
//		note,type,id,name,parsePrice,imgPath

		// System.out.println(bean);

		// 根據Model執行結果導向View

		if (action != null && action.equals("insert"))

		{
			ProductBean result = service.insert(note,type,id,parsePrice,name,imgPath);
			if (result == null) {
				errs.put("result", "新增失敗");
				
			} else {
				req.setAttribute("insert", result);
				errs.put("result", "新增" + result + "筆成功");
				
			}

		} else if (action != null && action.equals("update"))

		{
			ProductBean result = service.update(name,parsePrice,imgPath,note);
			if (result == null) {
				errs.put("result", "修改失敗");
				
			} else {
				req.setAttribute("update", result);
				errs.put("result", "修改1筆成功");
				
			}

			// System.out.println(action + "完成");
		} else if (action != null && action.equals("delete"))

		{
			ProductBean result = service.delete(id);
			// System.out.println(result);
			if (result == null) {
				errs.put("result", "刪除失敗");
				
			} else {
				req.setAttribute("delete", result);
				errs.put("result", "刪除" + result + "筆成功");
				
			}
		} else {
			errs.put("result", "不知道您現在要" + action + "什麼");
			
		}
	}
}
