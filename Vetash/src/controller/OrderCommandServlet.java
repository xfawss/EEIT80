package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Order;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import misc.AllPayCheckMacValue;
import misc.Parse;
import model.OrderBean;
import model.OrderService;
import model.ProductService;
import model.PurchaseRecoderService;
import model.PurchaseRecordBean;

@WebServlet("/OrderCommand")
public class OrderCommandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService service;
	private PurchaseRecoderService service2;
	private ProductService service3;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (OrderService)context.getBean("OrderService");
		service2 = (PurchaseRecoderService)context.getBean("PurchaseRecoderService");
		service3 = (ProductService)context.getBean("ProductService");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String task = req.getParameter("task");
		String housing = req.getParameter("housing");
		String rocker = req.getParameter("rocker");
		String l1 = req.getParameter("l1");
		String l2 = req.getParameter("l2");
		String r1 = req.getParameter("r1");
		String r2 = req.getParameter("r2");
		String o = req.getParameter("o");
		String x = req.getParameter("x");
		String square = req.getParameter("square");
		String triangle = req.getParameter("triangle");
		String start = req.getParameter("start");
		String selecter = req.getParameter("selecter");
		String touch = req.getParameter("touch");
		String coverImg = req.getParameter("coverImg");
		String board = req.getParameter("board");
		String bossNotes = req.getParameter("bossNotes");
		String customerTel = req.getParameter("customerTel");
		String orderDate = req.getParameter("orderDate");
		String price = req.getParameter("price");
		String orderState = req.getParameter("orderState");
		String orderNo = req.getParameter("orderNo");
		String deliveryDate = req.getParameter("deliveryDate");
		
		OrderBean bean = new OrderBean();
		List<String> errs = new ArrayList<String>();
		JSONObject jObj = new JSONObject();
		if(task==null || task.length()==0) {
			errs.add("莫名的錯誤");
		} else if(task.equals("all")) {
			List<Map<String, Object>> beans = service.selectAll();
			jObj.put("results", beans);
			out.print(jObj);
			return;
		} else if(task.equals("tel")) {
			if(customerTel==null || customerTel.length()==0) {
				errs.add("沒有關鍵字");
			} else {
				List<Map<String, Object>> beans = service.selectByTel(customerTel);
				jObj.put("results", beans);
				out.print(jObj);
				return;
			}
		} else if(task.equals("date")) {
			if(orderDate==null || orderDate.length()==0) {
				errs.add("沒有關鍵字");
			} else {
				java.util.Date date = Parse.convertDate(orderDate);
				if (date.equals(new java.util.Date(0))) {
					errs.add("格式錯誤");
				} else {
					List<Map<String, Object>> beans = service.selectByDate(date);
					jObj.put("results", beans);
					out.print(jObj);
					return;
				}
			}
		} else if(task.equals("note")) {
			if(bossNotes==null || bossNotes.length()==0) {
				errs.add("沒有關鍵字");
			} else {
				List<Map<String, Object>> beans = service.selectByNote(bossNotes);
				jObj.put("results", beans);
				out.print(jObj);
				return;
			}
		} else if(task.equals("delete")) {
			if(orderNo==null || orderNo.length()==0) {
				errs.add("沒有關鍵字");
			} else {
				if(service.delete(orderNo)) {
					req.getRequestDispatcher("/backend_main.html").forward(req, resp);
					return;
				} else {
					errs.add("刪除失敗");
				}
			}
		} else if(task.equals("update")) {
			if(price!=null && price.length()!=0) {
				int temp = Parse.convertInt(price);
				if(temp > 1) {
					bean.setPrice(temp);
				} else {
					errs.add("價錢型態錯誤");
				}
			}
			if(deliveryDate!=null && deliveryDate.length()!=0) {
				java.util.Date temp = Parse.convertDate(deliveryDate);
				if(!temp.equals(new java.util.Date(0))) {
					bean.setDeliveryDate(temp);
				} else {
					errs.add("日期型態錯誤");
				}
			}
			bean.setOrderNo(orderNo);
			bean.setHousing(housing);
			bean.setRocker(rocker);
			bean.setL1(l1);
			bean.setL2(l2);
			bean.setR1(r1);
			bean.setR2(r2);
			bean.setO(o);
			bean.setX(x);
			bean.setSquare(square);
			bean.setTriangle(triangle);
			bean.setStart(start);
			bean.setSelecter(selecter);
			bean.setTouch(touch);
			bean.setCoverImg(coverImg);
			bean.setBoard(board);
			bean.setBossNotes(bossNotes);
			bean.setOrderState(orderState);
			List<String> temp = new ArrayList<String>();
			temp.add(housing);
			temp.add(rocker);
			temp.add(l1);
			temp.add(l2);
			temp.add(r1);
			temp.add(r2);
			temp.add(o);
			temp.add(x);
			temp.add(square);
			temp.add(start);
			temp.add(selecter);
			temp.add(touch);
			temp.add(board);
			temp.add(triangle);
			
			if(orderState.equals("已出貨")) {
				for(String a: temp) {
					if(a!=null && a.length()!=0) {
						PurchaseRecordBean bean2 = new PurchaseRecordBean();
						bean2.setDate(new java.util.Date());
						bean2.setType("出貨");
						bean2.setProductId(a);
						bean2.setPrize(0);
						bean2.setNumber(1);
						service3.updateQty2(a);
						service2.insert(bean2);
					}
				}
			}
			service.update(bean);
			req.getRequestDispatcher("/backend_main.html").forward(req, resp);
			return;
		} else if(task.equals("checkOrder")) {
			if(orderNo==null || orderNo.length()==0) {
				errs.add("沒有關鍵字");
			} else {
				bean = service.selectByOrderNo(orderNo);
				HttpSession session = req.getSession(false);
				session.setAttribute("joystick", bean);
				if(bean.getOrderState().equals("已確認")) {
					String orderDate2 = Parse.dateToString2(bean.getOrderDate());
					String pricess = Integer.toString(bean.getPrice());
					req.setAttribute("MerchantID", AllPayCheckMacValue.merchantID);
					req.setAttribute("MerchantTradeNo", orderNo);
					req.setAttribute("MerchantTradeDate", orderDate2);
					req.setAttribute("PaymentType", AllPayCheckMacValue.paymentType);
					req.setAttribute("TotalAmount", pricess);
					req.setAttribute("TradeDesc", AllPayCheckMacValue.tradeDesc);
					req.setAttribute("ItemName", AllPayCheckMacValue.itemName);
					req.setAttribute("ReturnURL", AllPayCheckMacValue.returnURL);
					req.setAttribute("ChoosePayment", AllPayCheckMacValue.choosePayment);
					req.setAttribute("IgnorePayment", AllPayCheckMacValue.ignorePayment);
					req.setAttribute("ClientBackURL", AllPayCheckMacValue.clientBackURL);
					req.setAttribute("CheckMacValue", AllPayCheckMacValue.checkMacValue(orderNo, orderDate2, pricess));
					req.setAttribute("AllPay", true);
				}
				req.getRequestDispatcher("/front_custom_orderlist.jsp").forward(req, resp);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
