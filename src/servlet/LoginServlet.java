package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;
import service.LginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "AuthenticateLogin", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName= request.getParameter("userName");
		String password = request.getParameter("password");
		
		// once it capture these two value  then we need to call service to authenticate
		
		LginService loginService= new LginService();
		
		boolean result= loginService.authenticate(userName, password);
	
		if (result){
			User user= loginService.getUserDetails(userName);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("Success.jsp");
		} else{
			response.sendRedirect("Login.jsp");
		}
		
		
	}

}
