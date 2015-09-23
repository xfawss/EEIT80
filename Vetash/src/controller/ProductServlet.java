package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import model.PurchaseRecoderService;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService service;

	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (ProductService)context.getBean("ProductService");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

		rsp.setContentType("text/html");
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
			if (type != null) {
				if (action.equals("select")) {
					List<Map<String, Object>> result = service.selectByType(type);
					jObj.put("results", result);
					out.print(jObj);
					return;
				}

			}
			if (id != null) {
				if (action.equals("select")) {
					Map<String, Object> result = service.selectById(id);
					jObj.put("results", result);
					out.print(jObj);
					return;
				}
				if (action.equals("select1")) {
					Map<String, Integer> result = service.selectCostById(id);
					jObj.put("results", result);
					out.print(jObj);
					return;

				}
			}
		}
		if (id == null) {
			if (action.equals("select")) {
				List<Map<String, Object>> result = service.getAll();
				jObj.put("results", result);
				out.print(jObj);
				return;
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
		rsp.setContentType("text/html");
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
		String productColor = req.getParameter("productColor");

		JSONObject jObj = new JSONObject();
		PrintWriter out = rsp.getWriter();
		List<String> errors = new ArrayList<String>();
		Map<String, Object> results = new HashMap<String, Object>();

		if (action != null) {
			// 判斷是哪個動作,
			if (action.equals("insert")) {
				if (id == null || id.length() == 0) {
					errors.add("新增或修改時ID名稱為必填欄位，請輸入");
				}
				if (type == null || type.length() == 0) {
					errors.add("新增或修改時種類為必填欄位，請輸入");
				}
				if (name == null || name.length() == 0) {
					errors.add("新增或修改時品名為必填欄位，請輸入");
				}
				if (price == null || price.length() == 0) {

					errors.add("新增或修改時價格為必填欄位，請輸入");
				}
			} else if (action.equals("update")) {
				if (id == null || id.length() == 0) {
					errors.add("新增或修改時ID名稱為必填欄位，請輸入");
				}
				if (name == null || name.length() == 0) {
					errors.add("新增或修改時品名為必填欄位，請輸入");
				}
				if (price == null || price.length() == 0) {
					errors.add("新增或修改時價格為必填欄位，請輸入");
				}
			}

			if (errors != null && !errors.isEmpty()) {
				results.put("errors", errors);
				jObj.put("results", results);
				out.print(jObj);
				return;
			}
		}

		// 轉換資料

		int parsePrice = 0;
		int parseCost = 0;
		int parseQty = 0;
		if (price != null && price.length() != 0){
			parsePrice = Parse.convertInt(price);
		}
		
		if (cost != null && cost.length() != 0){
			parseCost = Parse.convertInt(cost);
		}
		if (qty != null && qty.length() != 0){
			parseQty = Parse.convertInt(qty);
		}

		
		if (errors != null && !errors.isEmpty()) {
			req.getRequestDispatcher("/Wason/ProductTest.jsp").forward(req, rsp);
			return;
		}

		// 呼叫Model
		ProductBean bean = new ProductBean();
		bean.setProductNote(note);
		bean.setProductType(type);
		bean.setProductId(id);
		bean.setProductName(name);
		bean.setProductPrice(parsePrice);
		bean.setProductImgPath(imgPath);
		bean.setProductColor(productColor);
		bean.setProductCost(parseCost);
		bean.setProductQty(parseQty);

		if (action != null && action.equals("insert"))

		{
			ProductBean result = service.insert(bean);
			if (result == null) {
				results.put("state", "新增失敗");
			} else {
				req.setAttribute("insert", result);
				results.put("state", "新增1筆成功");
			}

		} else if (action != null && action.equals("update"))

		{
			ProductBean result = service.update(bean);
			if (result == null) {
				results.put("state", "修改失敗");

			} else {
				req.setAttribute("update", result);
				results.put("state", "修改1筆成功");
			}

			// System.out.println(action + "完成");
		} else if (action != null && action.equals("delete"))

		{
			boolean result = service.delete(id);
			// System.out.println(result);
			if (result) {
				results.put("state", "刪除失敗");

			} else {
				req.setAttribute("delete", result);
				results.put("state", "刪除1筆成功");
			}
		} else {
			results.put("state", "不知道您現在要" + action + "什麼");
		}
		jObj.put("state", results);
		out.print(jObj);
		return;

	}
}
