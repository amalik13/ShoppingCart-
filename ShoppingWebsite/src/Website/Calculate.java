package Website;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Calculate
 */
@WebServlet("/Calculate")
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		float costProduct=0;
		float totalCost=0;
		String cost="";
		cost=(String) session.getValue("cost");
		String id=(String) session.getValue("id");
		String price=(String) session.getValue("Price");
		session.setAttribute("id", id);
		session.setAttribute("Price", price);
		
		
		String quantity=request.getParameter("Quantity");
		session.setAttribute("Quantity", quantity);
		
		
			float Quantity=Float.valueOf(quantity);
			float Price=Float.valueOf(price);	
			if(cost!=null)
			{
			totalCost=Float.valueOf(cost);
			}
			costProduct=Quantity*Price;
			 totalCost = totalCost+costProduct;
			 //cost=String.valueOf(totalCost);
			 session.setAttribute("cost", String.valueOf(totalCost));
			 getServletContext()
				.getRequestDispatcher("/InsertProduct")
				.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
