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


@WebServlet("/PurchaseRecoder")
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
		resp.setContentType("text/html; charset=UTF-8");
		String keyword = req.getParameter("keyword");
		String task = req.getParameter("task");
		
		Map<String, String> errs = new HashMap<String, String>();
		req.setAttribute("err", errs);
		JSONObject jObj = new JSONObject();
		PrintWriter out = resp.getWriter();
		
		if(task==null || task.length()==0 || keyword==null || keyword.length()==0) {
			errs.put("warning1", "你怎進來的");
		} else if(task.equals("all")) {
			List<Map<String, Object>> beans = service.select();
			jObj.put("results", beans);
			out.print(jObj);
			return;
		} else if(task.equals("date")) {
			java.util.Date date = Parse.convertDate(keyword);
			if(date.equals(new java.util.Date(0))) {
				errs.put("warning2", "格式錯誤");
			} else {
				List<Map<String, Object>> beans = service.selectByDate(date);
				jObj.put("results", beans);
				out.print(jObj);
				return;
			}
		} else if(task.equals("type")) {
			List<Map<String, Object>> beans = service.selectByType(keyword);
			jObj.put("results", beans);
			out.print(jObj);
			return;
		} else if(task.equals("ProductId")) {
			List<Map<String, Object>> beans = service.selectByProductId(keyword);
			jObj.put("results", beans);
			out.print(jObj);
			return;
		} else if(task.equals("SupplierId")) {
			int sid = Parse.convertInt(keyword);
			if(sid < 1) {
				errs.put("warning2", "格式錯誤");
			} else {
				List<Map<String, Object>> beans = service.selectBySupplierId(sid);
				jObj.put("results", beans);
				out.print(jObj);
				return;
			}
		} else {
			errs.put("warning1", "你怎進來的");
		}
		
		String tempRec = req.getParameter("recordNo");
		String tempDate = req.getParameter("date");
		String type = req.getParameter("type");
		String notes = req.getParameter("notes");
		String productId = req.getParameter("productId");
		String tempNum = req.getParameter("number");
		String tempPri = req.getParameter("prize");
		String tempSup = req.getParameter("supplierId");
		
		if(tempRec==null || tempRec.length()==0 || tempDate==null || tempDate.length()==0 ||
					type==null || type.length()==0 || productId==null || productId.length()==0 || tempNum==null ||
					tempNum.length()==0 || tempPri==null || tempPri.length()==0 || tempSup==null || tempSup.length()==0) {
			errs.put("warning3", "有必填欄位空白");
		} else {
			int recordNo = Parse.convertInt(tempRec);
			java.util.Date date = Parse.convertDate(tempDate);
			int number = Parse.convertInt(tempNum);
			int prize = Parse.convertInt(tempPri);
			int supplierId = Parse.convertInt(tempSup);
			
			
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
