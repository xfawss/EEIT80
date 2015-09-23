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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.CustomerBean;
import model.CustomerService;

@WebServlet(urlPatterns = { "/customers" })
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;

	@Override
	public void init() throws ServletException {
		service = new CustomerService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定義存放錯誤訊息的Collection物件
		Map<String, String> errMsgs = new HashMap<String, String>();

		// 回傳值
		List<CustomerBean> result = null;
		// Bean
		CustomerBean bean = new CustomerBean();
		// 錯誤訊息 start
		String msg = null;
		// 錯誤訊息 end
		// 放Customers的Json
		JSONObject jsonErr = new JSONObject();
		JSONObject jsonMsg = new JSONObject();
		request.setAttribute("errMsg", errMsgs); // 顯示錯誤訊息
		// 設定輸入資料的編碼
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 接收資料
		String cust = request.getParameter("action");
		String tel = request.getParameter("customerTel");
		String line = request.getParameter("customerLine");
		String fb = request.getParameter("customerFb");
		String mail = request.getParameter("customerMail");
		String name = request.getParameter("customerName");
		String addr = request.getParameter("customerAddr");
		String note = request.getParameter("customerNote");
		// 塞進Bean
		bean.setCustomerAddr(addr);
		bean.setCustomerTel(tel);
		bean.setCustomerLine(line);
		bean.setCustomerFb(fb);
		bean.setCustomerMail(mail);
		bean.setCustomerName(name);
		bean.setCustomerNote(note);
		// 如果欄位不為空值 則做下列程式判斷
		if (cust != null) {
			switch (cust) {
			case "customerTel":
				try {
					// JSONObject jsonErr = new JSONObject();
					// JSONObject jsonMsg = new JSONObject();
					// V1錯誤訊息 start
					if (tel == null) {
						jsonErr.put("errMsg", "請輸入電話號碼查詢");
						out.print(jsonErr);
					} else {
						result = service.select(bean);
						// 基本寫法使用writeJSONString start
						JSONArray customers = new JSONArray();
						JSONObject customer = new JSONObject();
						for (int i = 0; i < result.size(); i++) {
							customer = bean.writeJSONString(result.get(i));
							customers.put(customer);
						}
						jsonMsg.put("results", customers);
						System.out.println("writeJSONString方法:" + jsonMsg.toString());
						out.print(jsonMsg.toString());
						// 基本寫法使用writeJSONString end
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				break;
			case "customerName":
				try {
					if (name == null) {
						jsonErr.put("errMsg", "請輸入姓名查詢");
						out.print(jsonErr);
					} else {
						result = service.selectLikeName(bean);
						JSONArray customers = new JSONArray();
						JSONObject customer = new JSONObject();
						for (int i = 0; i < result.size(); i++) {
							customer = bean.writeJSONString(result.get(i));
							customers.put(customer);
						}
						jsonMsg.put("results", customers);
						System.out.println("writeJSONString方法:" + jsonMsg.toString());
						out.print(jsonMsg.toString());
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

				break;

			case "customerLine":
				try {
					if (line == null) {
						jsonErr.put("errMsg", "請輸入Line查詢");
						out.print(jsonErr);
					} else {
						result = service.selectLikeLine(bean);
						JSONArray customers = new JSONArray();
						JSONObject customer = new JSONObject();
						for (int i = 0; i < result.size(); i++) {
							customer = bean.writeJSONString(result.get(i));
							customers.put(customer);
						}
						jsonMsg.put("results", customers);
						System.out.println("writeJSONString方法:" + jsonMsg.toString());
						out.print(jsonMsg.toString());
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

				break;
			case "customerFb":
				try {
					if (fb == null) {
						jsonErr.put("errMsg", "請輸入Fb查詢");
						out.print(jsonErr);
					} else {
						result = service.selectLikeFb(bean);
						JSONArray customers = new JSONArray();
						JSONObject customer = new JSONObject();
						for (int i = 0; i < result.size(); i++) {
							customer = bean.writeJSONString(result.get(i));
							customers.put(customer);
						}
						jsonMsg.put("results", customers);
						System.out.println("writeJSONString方法:" + jsonMsg.toString());
						out.print(jsonMsg.toString());
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

				break;
			case "customerMail":

				try {
					if (mail == null) {
						jsonErr.put("errMsg", "請輸入Mail查詢");
						out.print(jsonErr);
					} else {
						result = service.selectLikeMail(bean);
						JSONArray customers = new JSONArray();
						JSONObject customer = new JSONObject();
						for (int i = 0; i < result.size(); i++) {
							customer = bean.writeJSONString(result.get(i));
							customers.put(customer);
						}
						jsonMsg.put("results", customers);
						System.out.println("writeJSONString方法:" + jsonMsg.toString());
						out.print(jsonMsg.toString());
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				break;

			case "customerNote":
				try {
					if (note == null) {
						jsonErr.put("errMsg", "請輸入Note查詢");
						out.print(jsonErr);
					} else {
						result = service.selectLikeNote(bean);
						JSONArray customers = new JSONArray();
						JSONObject customer = new JSONObject();
						for (int i = 0; i < result.size(); i++) {
							customer = bean.writeJSONString(result.get(i));
							customers.put(customer);
						}
						jsonMsg.put("results", customers);
						System.out.println("writeJSONString方法:" + jsonMsg.toString());
						out.print(jsonMsg.toString());
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		out.flush();
		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 接收資料
		String tel = request.getParameter("customerTel");
		String line = request.getParameter("customerLine");
		String fb = request.getParameter("customerFb");
		String mail = request.getParameter("customerMail");
		String name = request.getParameter("customerName");
		String note = request.getParameter("customerNote");
		String addr = request.getParameter("customerAddr");
		String action = request.getParameter("action");

		// 定義存放錯誤訊息的Collection物件 1
		Map<String, Object> results = new HashMap<String, Object>();
		List errors = new ArrayList<String>();
		// 存放錯誤訊息的json物件2
		JSONObject jObj = new JSONObject();

		// 驗證資料
		if (action != null) {
			if (action.equals("insert") || action.equals("update")) {
				if (name == null || name.length() == 0) {
					errors.add("新增或修改顧客姓名為必填欄位");
				}
				if (tel == null || tel.length() == 0) {
					errors.add("新增或修改時電話為必填欄位，請輸入");
				}
				if (tel != null && tel.length() != 0) {
					if (!tel.matches("\\+?\\d{1,4}-?(\\d{4,15})(#\\d{1,5}){0,1}")) {
						errors.add("輸入資料錯誤，電話號碼不能有中文和英文");
					}
				}
				if (addr == null || addr.length() == 0) {
					errors.add("新增或修改顧客地址名為必填欄位");
				}
			}
		}

		if (errors != null && !errors.isEmpty()) {
			results.put("errors", errors);
			try {
				jObj.put("results", results);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			out.print(jObj);
			return;
		}
		// 無轉換資料
		// 呼叫model
		// 塞進Bean
		CustomerBean bean = new CustomerBean();
		bean.setCustomerAddr(addr);
		bean.setCustomerTel(tel);
		bean.setCustomerLine(line);
		bean.setCustomerFb(fb);
		bean.setCustomerMail(mail);
		bean.setCustomerName(name);
		bean.setCustomerNote(note);

		// 根據model執行結果導向View
		if (action != null && action.equals("insert")) {

			int result = service.insert(bean);
			if (result == 0) {
				results.put("result", "新增失敗");

			} else {

				request.setAttribute("Insert", result);
				results.put("state", "新增" + result + "筆成功");
			}

		} else if (action != null && action.equals("update")) {
			int result = service.update(bean);
			if (result == 0) {
				results.put("state", "修改失敗");

			} else {
				request.setAttribute("update", result);
				results.put("state", "修改1筆成功");
			}
		} else if (action != null && action.equals("delete")) {
			int result = service.delete(bean);
			// System.out.println(result);
			if (result == 0) {
				results.put("state", "刪除失敗");
			} else {
				request.setAttribute("delete", result);
				results.put("state", "刪除" + result + "筆成功");
			}
		} else {
			results.put("state", "不知道您現在要" + action + "什麼");
		}
		try {
			jObj.put("results", results);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jObj);
		return;
	}
}