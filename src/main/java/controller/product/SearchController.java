package controller.product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.ListProductDAO;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
		response.setContentType("text/html;charset=UTF-8");
		String pageString = request.getParameter("page");
		int page = 1;
		if(pageString != null) {
			page = Integer.parseInt(pageString);
			request.setAttribute("page", page);
		}else {
			request.setAttribute("page", 1);
		}
		try(PrintWriter out = response.getWriter()){
			String name = request.getParameter("search");
			List<Product> ls = new ListProductDAO().search(name,page);
			request.setAttribute("products", ls);
			RequestDispatcher rd = request.getRequestDispatcher("/web/WEB-INF/home.jsp");
			rd.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE,null,e);
		}
	}
}
