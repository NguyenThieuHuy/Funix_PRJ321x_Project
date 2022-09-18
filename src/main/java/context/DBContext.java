package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	
	private final String serverName = "NGUYENTHIEUHUY";
	private final String dbName = "ShoppingDB";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "Huy";
	private final String password = "123";
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://"+serverName+":"+portNumber+"\\"+instance+";databaseName="+dbName+";integratedSecurity=false;trustServerCertificate=true";
		if(instance==null||instance.trim().isEmpty()) {
			url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName+";integratedSecurity=false;trustServerCertificate=true";
		}
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url,userID,password);
	}
}
