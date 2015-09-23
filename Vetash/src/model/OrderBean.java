package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orderlist")
public class OrderBean {
	
	@Id
	@Column(name="OrderNo")
	private String orderNo;
	
	@Column(name="CustomerTel")
	private String customerTel;
	
	@Column(name="ReceiveType")
	private String receiveType;
	
	@Column(name="CustomerAddr")
	private String customerAddr;
	
	@Column(name="ReceiveNotes")
	private String receiveNotes;
	
	@Column(name="OrderDate")
	private java.util.Date orderDate;
	
	@Column(name="OrderNotes")
	private String orderNotes;

	@Column(name="Coupon")
	private String coupon;
	
	@Column(name="Price")
	private int price;

	@Column(name="BossNotes")
	private String bossNotes;
	
	@Column(name="OrderState")
	private String orderState;
	
	@Column(name="Housing")
	private String housing;

	@Column(name="Rocker")
	private String rocker;
	
	@Column(name="L1")
	private String l1;
	
	@Column(name="L2")
	private String l2;
	
	@Column(name="R1")
	private String r1;
	
	@Column(name="R2")
	private String r2;
	
	@Column(name="O")
	private String o;
	
	@Column(name="X")
	private String x;
	
	@Column(name="Square")
	private String square;
	
	@Column(name="Triangle")
	private String triangle;
	
	@Column(name="Start")
	private String start;
	
	
	@Column(name="Selecter")
	private String selecter;
	
	@Column(name="Touch")
	private String touch;
	
	@Column(name="CoverImg")
	private String coverImg;
	
	@Column(name="Board")
	private String board;
	
	@Column(name="PaymentType")
	private String PaymentType;
	
	@Column(name="PaymentTypeChargeFee")
	private int PaymentTypeChargeFee;
	
	@Column(name="AllPayTradeNo")
	private String AllPayTradeNo;
	
	@Column(name="DeliveryDate")
	private java.util.Date deliveryDate;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCustomerTel() {
		return customerTel;
	}

	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}

	public String getReceiveType() {
		return receiveType;
	}

	public void setReceiveType(String receiveType) {
		this.receiveType = receiveType;
	}

	public String getCustomerAddr() {
		return customerAddr;
	}

	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}

	public String getReceiveNotes() {
		return receiveNotes;
	}

	public void setReceiveNotes(String receiveNotes) {
		this.receiveNotes = receiveNotes;
	}

	public java.util.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderNotes() {
		return orderNotes;
	}

	public void setOrderNotes(String orderNotes) {
		this.orderNotes = orderNotes;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBossNotes() {
		return bossNotes;
	}

	public void setBossNotes(String bossNotes) {
		this.bossNotes = bossNotes;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getHousing() {
		return housing;
	}

	public void setHousing(String housing) {
		this.housing = housing;
	}

	public String getRocker() {
		return rocker;
	}

	public void setRocker(String rocker) {
		this.rocker = rocker;
	}

	public String getL1() {
		return l1;
	}

	public void setL1(String l1) {
		this.l1 = l1;
	}

	public String getL2() {
		return l2;
	}

	public void setL2(String l2) {
		this.l2 = l2;
	}

	public String getR1() {
		return r1;
	}

	public void setR1(String r1) {
		this.r1 = r1;
	}

	public String getR2() {
		return r2;
	}

	public void setR2(String r2) {
		this.r2 = r2;
	}

	public String getO() {
		return o;
	}

	public void setO(String o) {
		this.o = o;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getSquare() {
		return square;
	}

	public void setSquare(String square) {
		this.square = square;
	}

	public String getTriangle() {
		return triangle;
	}

	public void setTriangle(String triangle) {
		this.triangle = triangle;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getSelecter() {
		return selecter;
	}

	public void setSelecter(String selecter) {
		this.selecter = selecter;
	}

	public String getTouch() {
		return touch;
	}

	public void setTouch(String touch) {
		this.touch = touch;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getPaymentType() {
		return PaymentType;
	}

	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}

	public int getPaymentTypeChargeFee() {
		return PaymentTypeChargeFee;
	}

	public void setPaymentTypeChargeFee(int paymentTypeChargeFee) {
		PaymentTypeChargeFee = paymentTypeChargeFee;
	}

	public String getAllPayTradeNo() {
		return AllPayTradeNo;
	}

	public void setAllPayTradeNo(String allPayTradeNo) {
		AllPayTradeNo = allPayTradeNo;
	}

	public java.util.Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(java.util.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
}
