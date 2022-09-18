package model;

import java.sql.Date;
import java.util.List;

public class Orders {
	private int orderId;
	private float price;
	private int status;
	private Date orderDate;
	private String address;
	private String phoneNumber;
	private List<ProductOrders> lp;
	private String userMail;
	private Date recieveDate;
	private String discount;
	
	public Orders() {}
	
	public Orders(int orderId, float price, int status, Date orderDate,
			String address, String phoneNumber, List<ProductOrders> lp,
			String userMail, Date recieveDate) {
		this.orderId = orderId;
		this.price = price;
		this.status = status;
		this.orderDate = orderDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.lp = lp;
		this.userMail = userMail;
		this.recieveDate = recieveDate;
	}
	
	public Orders(String userMail, int status, String discount,
			String address, String phoneNumber, Date recieveDate) {
		this.status = status;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.userMail = userMail;
		this.recieveDate = recieveDate;
		this.discount = discount;
	}
	
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	public String getDiscount() {
		return this.discount;
	}
	
	public Date getReceiveDate() {
		return this.recieveDate;
	}
	
	public void setRecieveDate(Date recieveDate) {
		this.recieveDate = recieveDate;
	}
	
	public String getUserMail() {
		return this.userMail;
	}
	
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	
	public int getOrderId() {
		return this.orderId;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public Date getOrderDate() {
		return this.orderDate;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public List<ProductOrders> getLp(){
		return this.lp;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setLp(List<ProductOrders> lp) {
		this.lp = lp;
	}
}
