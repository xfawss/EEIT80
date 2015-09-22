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

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import misc.Parse;
import model.PurchaseRecoderService;
import model.PurchaseRecordBean;


@WebServlet("/purchase")
public class PurchaseRecoderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PurchaseRecoderService service;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (PurchaseRecoderService)context.getBean("PurchaseRecoderService");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String keyword = req.getParameter("keyword");
		String task = req.getParameter("task");
		
		Map<String, String> errs = new HashMap<String, String>();
		req.setAttribute("err", errs);
		JSONObject jObj = new JSONObject();
		PrintWriter out = resp.getWriter();
		
		if("all".equals(task)) {
			List<Map<String, Object>> beans = service.select();
			jObj.put("results", beans);
			out.print(jObj);
			return;
		} else if("date".equals(task)) {
			if(keyword!=null && keyword.length()!=0){
				java.util.Date date = Parse.convertDate(keyword);
				if (date.equals(new java.util.Date(0))) {
					errs.put("warning2", "格式錯誤");
				} else {
					List<Map<String, Object>> beans = service.selectByDate(date);
					jObj.put("results", beans);
					out.print(jObj);
					return;
				}
			}
		} else if("type".equals(task)) {
			if(keyword!=null && keyword.length()!=0){
				List<Map<String, Object>> beans = service.selectByType(keyword);
				jObj.put("results", beans);
				out.print(jObj);
				return;
			}
		} else if("productid".equals(task)) {
			if(keyword!=null && keyword.length()!=0){
				List<Map<String, Object>> beans = service.selectByProductId(keyword);
				jObj.put("results", beans);
				out.print(jObj);
				return;
			}
		} else if("supplierid".equals(task)) {
			if(keyword!=null && keyword.length()!=0){
				int sid = Parse.convertInt(keyword);
				if(sid < 1) {
					errs.put("warning2", "格式錯誤");
				} else {
					List<Map<String, Object>> beans = service.selectBySupplierId(sid);
					jObj.put("results", beans);
					out.print(jObj);
					return;
				}
			}
		}
		
		String type = req.getParameter("purchaseType");
		String notes = req.getParameter("notes");
		String productId = req.getParameter("productId");
		String tempNum = req.getParameter("number");
		String tempPri = req.getParameter("prize");
		String tempSup = req.getParameter("supplierId");
		
		java.util.Date date2 = new java.util.Date();
		int number = 0;
		int prize = 0;
		int supplierId = 0;
		if(type==null || type.length()==0 || productId==null || productId.length()==0 || tempNum==null ||
					tempNum.length()==0 || tempPri==null || tempPri.length()==0 || tempSup==null || tempSup.length()==0) {
			errs.put("warning3", "有必填欄位空白");
		} else {
			number = Parse.convertInt(tempNum);
			prize = Parse.convertInt(tempPri);
			supplierId = Parse.convertInt(tempSup);
		}
		if(number<1 || prize<1 || supplierId<1){
			errs.put("warning2", "格式錯誤");
		}
		if(errs!=null && !errs.isEmpty()){
			//req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
			return;
		}
		
		PurchaseRecordBean bean = new PurchaseRecordBean();
		bean.setDate(date2);
		bean.setType(type);
		bean.setNotes(notes);
		bean.setProductId(productId);
		bean.setPrize(prize);
		bean.setSupplierId(supplierId);
		bean.setNumber(number);
		
		if(type.equals("purchase")){
			service.insert(bean);
			errs.put("warning2", "SUCCESSFUL!!");
			//req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
		} else if(type.equals("returnoff")){
			service.insert(bean);
			errs.put("warning2", "SUCCESSFUL!!");
			//req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
		} else {
			System.out.println("WTF!!!");
			errs.put("warning2", "??!!");
			//req.getRequestDispatcher("/ye/err.jsp").forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
