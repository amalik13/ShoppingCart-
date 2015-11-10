package Website;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UN= request.getParameter("UserName");
		 String PWD= request.getParameter("Password") ;
		 PrintWriter out = response.getWriter();
		 WebsiteInterface T = new WebsiteInterface();
		 
		 boolean ExistingUser= T.isUserMatching(UN,PWD);
		 //ExistingUser=T.isUserExist(UN);
		 
		 
		 if(ExistingUser)
		 {
			 
			 
			  out.println("<script type=\"text/javascript\">");
			   out.println("alert('User Already Exist');");
			   out.println("location='Signup.html';");
			   out.println("</script>");
		 
		 }
		 else if(UN != null && !UN.isEmpty())
		 {
			 boolean NewUser = T.createNewAccount(UN, PWD);
			 if(NewUser)
			 {
				 HttpSession session=request.getSession(); 
				 session.setAttribute("User", UN);
				  out.println("<script type=\"text/javascript\">");
				   out.println("alert('New User Added');");
				   out.println("location='InsertProduct';");
				   out.println("</script>");

				
			 }
/*			 RequestDispatcher rd = request.getRequestDispatcher("/HomeFeed");
			 rd.forward(request, response); */
		 }
		 else
		 {
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('Enter values');");
			   out.println("location='Login.html';");
			   out.println("</script>");
			 
		 }
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
