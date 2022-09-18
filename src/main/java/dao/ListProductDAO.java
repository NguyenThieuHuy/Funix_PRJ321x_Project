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

public class ListProductDAO {
	//return the list of products name
	public List<Product> search(String characters, int page) throws ServletException, SQLException{
		Connection conn = null;
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new  ServletException(); 
		}
		
		String sql = "SELECT * FROM "
				+ "(SELECT *,ROW_NUMBER() OVER(ORDER BY product_id) AS row_num FROM [ShoppingDB].[dbo].[Products] WHERE product_name LIKE '%'+?+'%')P "
				+ "WHERE row_num BETWEEN "+((page-1)*9+1)+" AND "+page*9;
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, characters);
		
		ResultSet rs = stmt.executeQuery();
		
		List<Product> products = new ArrayList<Product>();
		
		while(rs.next()) {
			Product p = new Product(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getFloat(4),
					rs.getString(5), rs.getString(6), 
					rs.getString(7));
			products.add(p);
		}
		
		return products;
	}
	
	public int totalPage(String characters) throws SQLException, ServletException {
		
		Connection conn = null;
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new  ServletException(); 
		}
		
		String sql = "select count(*) as count from [ShoppingDB].[dbo].[Products] where product_name LIKE '%'+?+'%'";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, characters);
		
		ResultSet rs = stmt.executeQuery();
		rs.next();
		return rs.getInt("count");
	}	
	
	//get the product
	public Product getProduct(String characters) throws SQLException, ServletException {
		Connection conn = null;
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new  ServletException(); 
		}
		
		String sql = "SELECT * FROM [ShoppingDB].[dbo].[Products] WHERE product_id = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, characters);
		
		ResultSet rs = stmt.executeQuery();
		
		rs.next();
		
		Product p = new Product(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getFloat(4),
					rs.getString(5), rs.getString(6), 
					rs.getString(7));
		
		return p;		
	}
}
