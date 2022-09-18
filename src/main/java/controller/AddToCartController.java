package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Product;

import java.io.IOException;
import java.sql.SQLException;

import dao.CartDAO;
import dao.ListProductDAO;

/**
 * Servlet implementation class AddToCartController
 */
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Cart c = new Cart();
		try {
			c = new Cart(new CartDAO().getCart((String) session.getAttribute("user")));
		} catch (ServletException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("cart", c);
		String pageString = request.getParameter("page");
		int page = 1;
		if(pageString != null) {
			page = Integer.parseInt(pageString);
			request.setAttribute("page", page);
		}else {
			request.setAttribute("page", 1);
		}

		request.getRequestDispatcher("/web/WEB-INF/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try{
			HttpSession session = request.getSession(true);
			Cart c = new Cart();
			try {
				c = new Cart(new CartDAO().getCart((String) session.getAttribute("user")));
			} catch (ServletException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("cart", c);
			String idd = request.getParameter("id");
			String action = request.getParameter("action");
			String pageString = request.getParameter("page");
			int page = 1;
			if(pageString != null) {
				page = Integer.parseInt(pageString);
				request.setAttribute("page", page);
			}else {
				request.setAttribute("page", 1);
			}

			if(action != null && action.equalsIgnoreCase("add")) {
				int id = Integer.parseInt(idd);
				Product p = new ListProductDAO().getProduct(""+id);
				c = (Cart) session.getAttribute("cart");
				c.add(new Product(p.getId(),p.getName(),p.getDescription(),p.getPrice(),
						p.getSrc(),p.getType(),p.getBrand(),1));
				new CartDAO().addToCart((String) session.getAttribute("user"), p.getId());
			}else if(action != null && action.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(idd);
				c = (Cart) session.getAttribute("cart");
				c.remove(id);
				new CartDAO().removeFromCart((String) session.getAttribute("user"), id);
			}
			request.getRequestDispatcher("/web/WEB-INF/cart.jsp").forward(request, response);
		}catch(Exception e) {
			response.getWriter().println(e);
		}
	}
}
