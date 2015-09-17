package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import misc.SupplierParse;
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

		System.out.println("get");

		// 接收資料

		String name = req.getParameter("supplierName");
		String tel = req.getParameter("supplierTel");
		String action = req.getParameter("action");
		System.out.println(name);
		System.out.println(tel);
		System.out.println(action);

		JSONObject jObj = new JSONObject();
		PrintWriter out = rsp.getWriter();

		if (action != null) {
			if (tel == null) {
				if (action.equals("select")) {
					List<Map<String, Object>> beans = service.selectAll();
					jObj.put("suppliers", beans);
					out.print(jObj);
					return;
				}
			}
			if (tel != null) {
				if (action.equals("select")) {
					Map<String, Object> result = service.selectByTel(tel);
					jObj.put("supplier", result);
					out.print(jObj);
					return;
				}
			}
			if (name != null) {
				if (action.equals("select")) {
					List<Map<String, Object>> result = service.selectByName(name);
					jObj.put("suppliers", result);
					out.print(jObj);
					return;
				}
			}
		}

		// test
		// SupplierBean bean = new SupplierBean();

		// select by id
		// bean.setSupplierId(3);
		// System.out.println(ser.selectById(bean));

		// select by tel
		// Map<String, Object> results = service.selectByTel("0974002547");
		// System.out.println(results);
		//
		// select by name
		// List<Map<String, Object>> results = service.selectByName("中");
		// System.out.println(results);

		// select all
		// List<Map<String, Object>> results = service.selectAll();
		// System.out.println(results);

		// inset
		// bean.setSupplierName("test");
		// bean.setSupplierTax("124");
		// bean.setSupplierContact("124");
		// bean.setSupplierTel("124");
		// bean.setSupplierAddr("124");
		// bean.setSupplierAcct("124");
		// bean.setSupplierDate(new java.util.Date());
		// bean.setSupplierNote("124");
		// System.out.println(service.insert(bean));

		// update
		// bean.setSupplierName("test333");
		// bean.setSupplierTax("124333");
		// bean.setSupplierContact("124333");
		// bean.setSupplierTel("124");
		// bean.setSupplierAddr("124333");
		// bean.setSupplierAcct("124333");
		// bean.setSupplierDate(new java.util.Date());
		// bean.setSupplierNote("124333");
		// bean.setSupplierId(3);
		// System.out.println(service.update(bean));

		// delete
		// bean.setSupplierId(6);
		// System.out.println(service.delete(bean));

		// rsp.getWriter().append("Served at: ").append(req.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {

		System.out.println("post");

		// 接收資料
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

		System.out.println(name);
		System.out.println(tel);
		System.out.println(addr);
		System.out.println(acct);
		System.out.println(date);
		System.out.println(note);
		System.out.println(action);

		// 驗證資料
		Map<String, String> errs = new HashMap<String, String>();
		req.setAttribute("errMsg", errs);

		if (action != null) {
			if (action.equals("insert") || action.equals("update")) {
				if (name == null || name.length() == 0) {
					errs.put("supplierName", "新增或修改時公司名稱為必填欄位，請輸入");
				}
				if (contact == null || contact.length() == 0) {
					errs.put("supplierContact", "新增或修改時聯絡人姓名為必填欄位，請輸入");
				}
				if (tel == null || tel.length() == 0) {
					errs.put("supplierTel", "新增或修改時聯絡人姓名為必填欄位，請輸入");
				}
				if (addr == null || addr.length() == 0) {
					errs.put("supplierAddr", "新增或修改時地址為必填欄位，請輸入");
				}
				if (date == null || date.length() == 0) {
					errs.put("supplierDate", "新增或修改時首次交易日為必填欄位，請輸入");
				}
			}
			if (action.equals("Delete")) {
				if (date == null || date.length() == 0) {
					errs.put("supplierTel", "刪除時電話為必填欄位，請輸入");
				}
			}
		}

		// 轉換資料
		SupplierParse pasrse = new SupplierParse();
		java.util.Date firstDate = null;
		if (date != null && date.length() != 0) {
			firstDate = pasrse.convertDate(date);
			if (new java.util.Date(0).equals(firstDate)) {
				errs.put("supplierDate", "日期格式必須如範例:2015-01-01 (西元年4碼-月2碼-日2碼)");
			}
		}

		int pasrseId = 0;
		if (id != null && id.length() != 0) {
			pasrseId = pasrse.convertInt(id);
		}

		System.out.println(errs);
		if (errs != null && !errs.isEmpty()) {
			req.getRequestDispatcher("/AlexHo/supplierTest.jsp").forward(req, rsp);
			return;
		}

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
		bean.setSupplierId(pasrseId);

		System.out.println(bean);

		// 根據Model執行結果導向View

		if (action != null && action.equals("insert")) {
			int result = service.insert(bean);
			if (result == 0) {
				errs.put("result", "新增失敗");
			} else {
				req.setAttribute("insert", result);
				errs.put("result", "新增1筆成功");
			}
			req.getRequestDispatcher("/AlexHo/supplierTest.jsp").forward(req, rsp);
		} else if (action != null && action.equals("update")) {
			int result = service.update(bean);
			if (result == 0) {
				errs.put("result", "修改失敗");
			} else {
				req.setAttribute("update", result);
				errs.put("result", "修改1筆成功");
			}
			req.getRequestDispatcher("/AlexHo/supplierTest.jsp").forward(req, rsp);
			System.out.println(action + "完成");
		} else if (action != null && action.equals("delete")) {
			int result = service.delete(bean);
			// System.out.println(result);
			if (result == 0) {
				errs.put("result", "刪除失敗");
			} else {
				req.setAttribute("delete", result);
				errs.put("result", "刪除" + result + "筆成功");
			}
			req.getRequestDispatcher("/AlexHo/supplierTest.jsp").forward(req, rsp);
		} else {
			errs.put("result", "不知道您現在要" + action + "什麼");
			req.getRequestDispatcher("/AlexHo/supplierTest.jsp").forward(req, rsp);
		}
	}
}