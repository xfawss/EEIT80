package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderBean;

@WebServlet("/joystick")
public class joystickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String housing = req.getParameter("Housing");
		String rocker = req.getParameter("Rocker");
		String l1 = req.getParameter("L1");
		String l2 = req.getParameter("L2");
		String r1 = req.getParameter("R1");
		String r2 = req.getParameter("R2");
		String o = req.getParameter("O");
		String x = req.getParameter("X");
		String square = req.getParameter("Square");
		String triangle = req.getParameter("Triangle");
		String start = req.getParameter("Start");
		String selecter = req.getParameter("Selecter");
		String touch = req.getParameter("Touch");
		String coverImg = req.getParameter("CoverImg");
		String board = req.getParameter("Board");
		String orderNotes = req.getParameter("OrderNotes");
		String coupon = req.getParameter("Coupon");

		List<String> errs = new ArrayList<String>();
		if(housing==null || rocker==null || l1==null || l2==null || r1==null ||
				r2==null || o==null || x==null || square==null || triangle==null || start==null ||
				selecter==null || touch==null || coverImg==null || board==null || orderNotes==null || coupon==null) {
			errs.add("莫名的錯誤");
		}
		
		HttpSession session = req.getSession(true);
		//取得售價
		int price = 100;
		
		java.util.Date now = new java.util.Date();
		String orderNo = Long.toString(now.getTime());
		OrderBean bean = new OrderBean();
		bean.setOrderNo(orderNo);
		bean.setOrderDate(now);
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
		bean.setOrderNotes(orderNotes);
		bean.setCoupon(coupon);
		bean.setPrice(price);
		session.setAttribute("joystick", bean);
		
		req.getRequestDispatcher("/ye/order.html").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	

}
