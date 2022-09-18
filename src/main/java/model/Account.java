package model;

public class Account {
	private String usr, pwd;
	private int role;
	private String name, address, phone;
	private int check;
	
	public Account() {
		this.usr = this.pwd = this.name = this.phone = this.address = null;
		this.role = this.check = -1;
	}

	public Account(String urs, String pwd, int role, String name, String address, String phone) {
		this.usr = urs;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getUsr() {
		return this.usr;
	}

	public String getPwd() {
		return this.pwd;
	}

	public int getRole() {
		return this.role;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getPhone() {
		return this.phone;
	}

	public int getCheck() {
		return this.check;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCheck(int check) {
		this.check = check;
	}
}
