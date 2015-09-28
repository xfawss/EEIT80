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
import org.springframework.core.env.SystemEnvironmentPropertySource;

import misc.Parse;
import model.SupplierBean;
import model.SupplierService;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/suppliers")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupplierService service;

	@Override
	public void init() throws ServletException {
		service = new SupplierService();
		super.init();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		rsp.setContentType("text/html");
		
		List<Map<String, Object>> resultss = service.selectByTel("0910147523");
		System.out.println(resultss);
		
		// System.out.println("get");

		// 接收資料
		String id = req.getParameter("productId");
		String name = req.getParameter("supplierName");
		String tel = req.getParameter("supplierTel");
		String action = req.getParameter("action");
		// System.out.println(name);
		// System.out.println(tel);
		// System.out.println(action);

		PrintWriter out = rsp.getWriter();
		List<String> errors = new ArrayList<String>();
		JSONObject jObj = new JSONObject();

		if ("selectByName".equals(action)) {
			if (name != null && name.length() != 0) {
				// format correct
				List<Map<String, Object>> result = service.selectByName(name);
				jObj.put("results", result);
				out.print(jObj);
				return;
			} else {
				// format incorrect
				errors.add("格式不正確");
			}
		}

		if ("selectAll".equals(action)) {
			List<Map<String, Object>> result = service.selectAll();
			jObj.put("results", result);
			out.print(jObj);
			return;

		}
		if ("selectSuppliersByProductId".equals(action)) {
			List<Map<String, Object>> result  = service.selectSuppliersByProductId(id);
			jObj.put("results", result);
			out.print(jObj);
			return;

		}
		if ("selectByTel".equals(action)) {

			if (tel.matches("\\+?\\d{1,4}-?(\\d{4,15})(#\\d{1,5}){0,1}")) {

				List<Map<String, Object>> result = service.selectByTel(tel);
				jObj.put("results", result);
				out.print(jObj);
				return;
			} else {
				errors.add("格式不正確");
			}
		}
		for (String temp : errors) {
			System.out.println(temp);
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
		String id = req.getParameter("supplierId");
		String name = req.getParameter("supplierName");
		String tax = req.getParameter("supplierTax");
		String contact = req.getParameter("supplierContact");
		String tel = req.getParameter("supplierTel");
		String addr = req.getParameter("supplierAddr");
		String acct = req.getParameter("supplierAcct");
		String date = req.getParameter("supplierDate");
		String note = req.getParameter("supplierNote");
		String action = req.getParameter("action");

		JSONObject jObj = new JSONObject();
		PrintWriter out = rsp.getWriter();
		List<String> errors = new ArrayList<String>();
		Map<String, Object> results = new HashMap<String, Object>();
		java.util.Date firstDate = null;
		if (action != null) {
			if ("insert".equals(action) || "update".equals(action)) {
				if (name == null || name.length() == 0) {
					errors.add("新增或修改時公司名稱為必填欄位，請輸入");
				}
				if (contact == null || contact.length() == 0) {
					errors.add("新增或修改時聯絡人姓名為必填欄位，請輸入");
				}
				if (tel == null || tel.length() == 0) {
					errors.add("新增或修改時電話為必填欄位，請輸入");
				}
				if (tel != null && tel.length() != 0) {
					if (!tel.matches("\\+?\\d{1,4}-?(\\d{4,15})(#\\d{1,5}){0,1}")) {
						errors.add("輸入資料錯誤，電話號碼不能有中文或英文，如:02-27450475#123");
					}
				}

				if (addr == null || addr.length() == 0) {
					errors.add("新增或修改時地址為必填欄位，請輸入");
				}
				if (date == null || date.length() == 0) {
					errors.add("新增或修改時首次交易日為必填欄位，請輸入");
				}
				
				if (date != null && date.length() != 0)

				{
					firstDate = Parse.convertDate(date);
					if (new java.util.Date(0).equals(firstDate)) {
						errors.add("日期格式必須如範例:2015/01/01 (西元年4碼/月2碼/日2碼)");
					}
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
		if (id != null && id.length() != 0)

		{
			parseId = Parse.convertInt(id);
		}

		// System.out.println(jObj);

		// 呼叫Model
		SupplierBean bean = new SupplierBean();
		bean.setSupplierName(name);
		bean.setSupplierTax(tax);
		bean.setSupplierContact(contact);
		bean.setSupplierTel(tel);
		bean.setSupplierAddr(addr);
		bean.setSupplierAcct(acct);
		bean.setSupplierDate(firstDate);
		bean.setSupplierNote(note);
		bean.setSupplierId(parseId);

		// System.out.println(bean);

		// 根據Model執行結果導向View

		if (action != null && "insert".equals(action)) {
			int result = service.insert(bean);
			if (result == 0) {
				results.put("state", "新增失敗");
			} else {
				req.setAttribute("insert", result);
				results.put("state", "新增" + result + "筆成功");
			}
		} else if (action != null && "update".equals(action)) {
			int result = service.update(bean);
			if (result == 0) {
				results.put("state", "修改失敗");
			} else {
				req.setAttribute("update", result);
				results.put("state", "修改" + result + "筆成功");
			}

			// System.out.println(action + "完成");
		} else if (action != null && "delete".equals(action)) {
			int result = service.delete(bean);
			// System.out.println(result);
			if (result == 0) {
				results.put("state", "刪除失敗");
			} else {
				req.setAttribute("delete", result);
				results.put("state", "刪除" + result + "筆成功");
			}
		} else {
			results.put("state", "不知道您現在要" + action + "什麼");
		}
		jObj.put("results", results);
		out.print(jObj);
		return;
	}
}