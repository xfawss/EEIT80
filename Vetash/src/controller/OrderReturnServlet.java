package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Id;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import misc.AllPayCheckMacValue;
import misc.Parse;
import model.OrderBean;
import model.OrderService;

@WebServlet("/OrderReturn")
public class OrderReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService service;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		service = (OrderService)context.getBean("OrderService");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		System.out.println("YYYYYY");
		
		String merchantID = req.getParameter("MerchantID");
		String merchantTradeNo = req.getParameter("MerchantTradeNo");
		String rtnCode = req.getParameter("RtnCode");
		String rtnMsg = req.getParameter("RtnMsg");
		String tradeNo = req.getParameter("TradeNo");
		String tradeAmt = req.getParameter("TradeAmt");
		String paymentDate = req.getParameter("PaymentDate");
		String paymentType = req.getParameter("PaymentType");
		String paymentTypeChargeFee = req.getParameter("PaymentTypeChargeFee");
		String tradeDate = req.getParameter("TradeDate");
		String simulatePaid = req.getParameter("SimulatePaid");
		String checkMacValue = req.getParameter("CheckMacValue");
		
		System.out.println("code="+checkMacValue);
		if(AllPayCheckMacValue.merchantID.equals(merchantID)) {
			if(Parse.convertInt(rtnCode) == 1) {//模擬付款
				if(AllPayCheckMacValue.checkMacValueReturn(merchantTradeNo, rtnCode, rtnMsg,
						tradeNo, tradeAmt, paymentDate, paymentType, paymentTypeChargeFee,
						tradeDate, simulatePaid, checkMacValue)) {
					OrderBean bean = new OrderBean();
					bean.setOrderNo(merchantTradeNo);
					bean.setPaymentType(paymentType);
					bean.setPaymentTypeChargeFee(Parse.convertInt(paymentTypeChargeFee));
					bean.setAllPayTradeNo(tradeNo);
					bean.setOrderState("已結帳");
					service.update2(bean);
					out.print("1|OK");
					return;
				} else {
					out.print("0|ErrorMessage");
					return;
				}
			}
		}
		out.print("1|OK");
	}

}
