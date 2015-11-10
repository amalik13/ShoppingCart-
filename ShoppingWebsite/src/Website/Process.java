package Website;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Process
 */
@WebServlet("/Process")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Process() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String id=(String) session.getValue("id");
		String Price=(String) session.getValue("Price");
		session.setAttribute("id", id);
		session.setAttribute("Price", Price);
		float costProduct=0;
		float totalCost=0;
		String cost="";
		
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		out.println("<html>");
        out.println("<body bgcolor=\"white\">");
        out.println("<head>");

        out.println("<title> Update Quantity </title>");
        out.println("</head>");
        out.println("<body>");
        out.print("<form action=\"Calculate\">");
       // out.println("method=POST>");
       // out.println("<a href=\"Process\">" + "");
        out.println("Quantity:  <INPUT TYPE=\"text\" name=\"Quantity\">");        
        out.println("<input type=\"submit\" value=\"submit\">");
        //out.println("<input type=\"hidden\" name=\"\"+id+\"\">");
        out.println("</form>");
       
        out.println("</body>");
        out.println("</html>");
        
		
		
		
		
		
		

		
		String Quantity=request.getParameter("Quantity");
		session.setAttribute("Quantity", Quantity);
		
	

		/* 
		 getServletContext()
			.getRequestDispatcher("/Calculate")
			.forward(request, response);*/
		 
		
		
		
       
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        
        
		
	}

}
