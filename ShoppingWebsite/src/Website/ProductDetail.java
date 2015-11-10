package Website;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Productdetail;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebsiteInterface WI = new WebsiteInterface();
		ArrayList<Productdetail> ProductsList= new ArrayList<Productdetail>();
		
		ProductsList= WI.pullProduct();
		String tableinfo = "";
		Productdetail pd = new Productdetail();
		HttpSession session = request.getSession();
		 
		String id=request.getParameter("id"); 
		 System.out.println(id);
		 session.setAttribute("id", id);

		for(int i=0;i<ProductsList.size();i++)
		{
			pd=ProductsList.get(i);
			
			if(pd.getProductid().equalsIgnoreCase(id))
			{
			session.setAttribute("Price", pd.getPrice());
			
			tableinfo += "<tr><td>" + pd.getProductid()+"</td><td>" + pd.getProductname()+"</td><td>" + pd.getPrice()+"</td><td>" + pd.getDescription()+"</td><td> <a href=\"Process?id="+id+"\">" + "AddtoCart"+"</td>";
			}
			
		}
		request.setAttribute("tableinfo", tableinfo);

		getServletContext()
		.getRequestDispatcher("/ProductDetail.jsp")
		.forward(request, response);
		
		
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
