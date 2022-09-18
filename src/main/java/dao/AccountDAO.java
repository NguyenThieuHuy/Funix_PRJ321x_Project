package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class AccountDAO {
	private Connection conn;
	
	public AccountDAO(Connection conn) {
		this.conn = conn;
	}
	
	public boolean login(String email, String password) throws SQLException {
//		return true;
		String sql = "select * from [dbo].[Account] where user_mail = ? and password = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(sql);
		
		stmt.setString(1, email);
		stmt.setString(2, password);
		
		ResultSet rs = stmt.executeQuery();
		
		return rs.next();
	}
	
	public boolean exists (String email) throws SQLException{
		String sql = "select count(*) as count from [dbo].[Account] where user_mail = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		int count = 0;
		if(rs.next()) {
			count = rs.getInt("count");
		}
		if(count==0) {
			return false;
		}else {
			return true;
		}
	}
	
	public Account setAccount(String email) throws SQLException {
		String sql = "select * from [dbo].[Account] where user_mail = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		String urs = rs.getString(1);
		String pwd = rs.getString(2);
		int role = rs.getInt(3);
		String name = rs.getString(4);
		String address = rs.getString(5);
		String phone = rs.getString(6);
		
		
		
		return new Account( urs,  pwd,  role,  name,  address,  phone);
	}
	
	public void create(String email, String password, String role, String name, String address, String phone) throws SQLException{
		String sql = "insert into [dbo].[Account] (user_mail,password,account_role,user_name,user_address,user_phone) values(?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, password);
		stmt.setString(3, role);
		stmt.setString(4, name);
		stmt.setString(5, address);
		stmt.setString(6, phone);
		stmt.executeUpdate();
		stmt.close();
	}
	
	
}
