package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import context.DBContext;
import dao.AccountDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    HttpSession session = request.getSession(false);
	    if(session!=null) {
			session.invalidate();
		}
		request.setAttribute("email", "");
		request.setAttribute("password", "");
		request.getRequestDispatcher("/web/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if(action == null) {
			out.println("unrecognised action");
			return;
		}
		
		Connection conn = null;
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new  ServletException(); 
		}
		//Use connection
		if(action.equals("dologin")) {
			request.getSession(true).invalidate();
			//make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			
			String email = request.getParameter("username");
			String password = request.getParameter("password");
			String allow = request.getParameter("cookies");
			
			HttpSession session = request.getSession(true);
			if(!password.matches(regex)||!email.matches(regexMail)) {
				session.setAttribute("message", "invalid syntax");
				request.getRequestDispatcher("/web/WEB-INF/login.jsp").forward(request, response);
			}
			
			if(allow != null) {
				Cookie uck = new Cookie("username",email);
				Cookie pck = new Cookie("password",password);
				uck.setMaxAge(60*60*24*365);
				pck.setMaxAge(60*60*24*365);
				response.addCookie(uck);
				response.addCookie(pck);
			}
			
			request.setAttribute("email", email);
			request.setAttribute("password", "");
			
			AccountDAO account = new AccountDAO(conn);
			Account user = new Account();
			try {
				user = account.setAccount(email);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				if(account.login(email,password)) {
					request.setAttribute("user", user.getName());
					session.setAttribute("user", user.getName());
					request.getRequestDispatcher("ListController").forward(request, response);
				}else {
					request.setAttribute("message","email address or password not recognised");
					request.getRequestDispatcher("/web/WEB-INF/login.jsp").forward(request, response);
				}
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(action.equals("docreate")) {
			String email = request.getParameter("username");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			String name = request.getParameter("userName");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			
//			User user = new User(email,password);
//			if(!user.validate()) {	
//			}
			request.setAttribute("email", email);
			request.setAttribute("password", "");
			AccountDAO account = new AccountDAO(conn);
			Account user = new Account();
			
			HttpSession session = request.getSession(true);
			if(!password.matches(regex)||!email.matches(regexMail)) {
				session.setAttribute("message", "invalid syntax");
				response.sendRedirect("web/WEB-INF/login.jsp");
			}
			
			try {
				user = account.setAccount(email);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				if(account.exists(email)) {
					request.setAttribute("message", "Account existed");
					request.getRequestDispatcher("/web/WEB-INF/register.jsp").forward(request, response);
				}else {
					account.create( email,  password,  role,  name,  address,  phone);
					request.setAttribute("user", user.getName());
					session.setAttribute("user", user.getName());
					request.setAttribute("message", "Account created successfully!");
					request.getRequestDispatcher("ListController").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else {
			out.println("unrecognised action");
			return;
		}
	}
}
