package lecture464.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.ShoppingcartDB;
import lecture464.model.UserDB;
import lecture464.model.Users;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		PrintWriter out=response.getWriter(); 
		HttpSession session = request.getSession();
		UserDB user=(UserDB)session.getAttribute("userinfo");
	    user=new UserDB(); 
		session.setAttribute("userinfo", user);
		out.println("hello"); 
 
		if(user.check(userName, password)) {
			user.setUsername(userName);
			user.setPassword(password);
			response.sendRedirect("CustomerHomePage.jsp");

		}else {
			response.sendRedirect("Register.jsp");
		}
			;
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
