package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.ListProductDAO;

/**
 * Servlet implementation class SearchController2
 */
public class SearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("urf-8");
		String pageString = request.getParameter("page");
		int page = 1;
		if(pageString != null) {
			page = Integer.parseInt(pageString);
			request.setAttribute("page", page);
		}else {
			request.setAttribute("page", 1);
		}
		try {
			String text = request.getParameter("s");
			request.setAttribute("result", new ListProductDAO().search(text,page));
			RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			response.getWriter().println(e);
		}
	}
}
