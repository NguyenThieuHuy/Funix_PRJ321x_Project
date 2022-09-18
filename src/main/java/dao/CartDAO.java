package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import jakarta.servlet.ServletException;
import model.Product;

public class CartDAO {
	public List<Product> getCart(String characters) throws ServletException, SQLException{
		Connection conn = null;
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new  ServletException(); 
		}
		
		String sql = "SELECT * FROM [ShoppingDB].[dbo].[Cart] WHERE [user_mail] = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, characters);
		
		ResultSet rs = stmt.executeQuery();
		List<Product> products = new ArrayList<Product>();
		if(rs.next()) {
			
			String[] arrayProducts = rs.getString(2).split(",");

			for(int i = 0; i < arrayProducts.length; i++) {
				if(arrayProducts[i]!="") {
					products.add(new ListProductDAO().getProduct(arrayProducts[i]));
				}
			}
		}else {
			sql = "INSERT INTO [ShoppingDB].[dbo].[Cart] (user_mail,products) values(?,?)";	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, characters);
			stmt.setString(2, "");
			stmt.executeQuery();
			stmt.close();
			
		}
		return products;
	}
	
	public void addToCart(String email, int productId) throws SQLException, ServletException{
		Connection conn = null;
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new  ServletException(); 
		}
		if(exists(email)) {
			String sql = "UPDATE [ShoppingDB].[dbo].[Cart] SET products = products + ? WHERE user_mail = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ","+Integer.toString(productId));
			stmt.setString(2, email);
			stmt.executeUpdate();
			stmt.close();
		}else {
			String sql = "INSERT INTO [ShoppingDB].[dbo].[Cart] (user_mail,products) values(?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, Integer.toString(productId));
			stmt.executeUpdate();
			stmt.close();
		}
	}
	
	public void removeFromCart(String email, int productId) throws SQLException, ServletException{
		Connection conn = null;
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new  ServletException(); 
		}
		if(exists(email)) {
			List<Product> products = getCart(email);
			String removed = "";
			for (Product p : products) {
				  if(p.getId() != productId) {
					  removed += p.getId()+",";
				  }
				}
			String sql = "UPDATE [ShoppingDB].[dbo].[Cart] SET products = ? WHERE user_mail = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, removed);
			stmt.setString(2, email);
			stmt.executeUpdate();
			stmt.close();
		}else {
			return;
		}
	}
	
	public boolean exists (String email) throws SQLException, ServletException{
		Connection conn = null;
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new  ServletException(); 
		}
		
		String sql = "select count(*) as count from [ShoppingDB].[dbo].[Cart] where user_mail = ?";
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
	
}
