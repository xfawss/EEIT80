package controller;

import java.io.FileWriter;
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

import misc.Parse;
import misc.SupplierParse;
import model.ProductBean;
import model.SupplierBean;
import model.SupplierService;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet(urlPatterns = { "/supplier.c" })
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupplierService service;

	@Override
	public void init() throws ServletException {
		service = new SupplierService();
		super.init();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse rsp)
			throws ServletException, IOException {

		System.out.println("go");

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
		String task = req.getParameter("task");

		// 驗證資料
		Map<String, String> errs = new HashMap<String, String>();
		req.setAttribute("errMsg", errs);

		if (task != null) {
			if (task.equals("Insert") || task.equals("Update")) {
				if (name == null || name.length() == 0) {
					errs.put("supplierName", "請輸入公司名稱");
				}
				if (contact == null || contact.length() == 0) {
					errs.put("supplierContact", "請輸入聯絡人姓名");
				}
				if (tel == null || tel.length() == 0) {
					errs.put("supplierTel", "請輸入電話");
				}
				if (addr == null || addr.length() == 0) {
					errs.put("supplierAddr", "請輸入地址");
				}
				if (date == null || date.length() == 0) {
					errs.put("supplierDate", "請輸入首次交易日");
				}
			}
			if (task.equals("Delete")) {
				if (date == null || date.length() == 0) {
					errs.put("supplierTel", "請輸入電話");
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

		JSONObject jObj = new JSONObject();
		PrintWriter out = rsp.getWriter();

		if (task!=null) {
			if (tel==null) {
				if (task.equals("select")) {
					List<Map<String, Object>> beans = service.selectAll();
					jObj.put("suppliers", beans);
					out.print(jObj);
					return;
				}	
			}
			if(name!=null){
				if (task.equals("select")) {
					List<Map<String, Object>> result = service.selectByName(name);
					jObj.put("supplier", result);
					out.print(jObj);
					return;
				}	
			}
			if(name!=null){
				if (task.equals("select")) {
					List<Map<String, Object>> result = service.selectByName(name);
					jObj.put("supplier", result);
					out.print(jObj);
					return;
				}					
			}
			
			
			
			
			if (task.equals("find")) {
				int dis = service.select(coupon);
				jObj.put("discount", dis);
				out.print(jObj);
				return;
			}

			if (task.equals("delete")) {
				service.delete(tel);
				req.getRequestDispatcher("/ye/Coupons.html").forward(req, resp);
				return;
			}
		}
		if (coupon == null || coupon.length() == 0 || discountString == null
				|| discountString.length() == 0) {
			errs.put("warning2", "折扣碼、價值不允許空值");
		}

		int discount = 0;
		if (discountString != null && discountString.length() != 0) {
			discount = Parse.convertInt(discountString);
		}
		java.util.Date deadline = null;
		if (deadlineString != null && deadlineString.length() != 0) {
			deadline = Parse.convertDate(deadlineString);
		}
		Integer times = null;
		if (timesString != null && timesString.length() != 0) {
			times = (Integer) Parse.convertInt(timesString);
		}
		if (discountString == null || discountString.length() == 0) {
			errs.put("warning1", "你怎進來的");
		} else if (discount < 1) {
			errs.put("warning3", "格式錯誤、價格次數不可小於1");

		}
		if (deadline != null) {
			if (deadline.equals(new java.util.Date(0))) {
				errs.put("warning4", "日期輸入格式錯誤、不可輸入今天之前");
			} else if (deadline.before(new java.util.Date())) {
				errs.put("warning3", "日期輸入格式錯誤、不可輸入今天之前");
			}
		}
		if (times != null) {
			if (times < 1) {
				errs.put("warning4", "格式錯誤、價格次數不可小於1");
			}
		}
		if (errs != null && !errs.isEmpty()) {
			req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
			return;
		}

		if (task.equals("createOrUpdate")) {
			service.createOrUpdate(coupon, discount, deadline, times, notes);
			req.getRequestDispatcher("/ye/Coupons.html").forward(req, resp);
			return;
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
		// bean.setSupplierAddr("124333");
		// bean.setSupplierAcct("124333");
		// bean.setSupplierDate(new java.util.Date());
		// bean.setSupplierNote("124333");
		// bean.setSupplierId(6);
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
