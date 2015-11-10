package Website;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Productdetail;

/**
 * Servlet implementation class InsertProduct
 */
@WebServlet("/InsertProduct")
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManager em = Website.DBUtil.getEmFactory().createEntityManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProduct() {
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
		
		 
		 
		 
		
		for(int i=0;i<ProductsList.size();i++)
		{
			pd=ProductsList.get(i);
			System.out.println(pd.getProductname());
			String id1=pd.getProductid();
			tableinfo += "<tr><td>" + pd.getProductid()+"</td><td>" + pd.getProductname()+"</td><td>" + pd.getPrice()+"</td><td> <a href=\"ProductDetail?id="+id1+"\">" + "ClickForDetails"+"</td></tr>";
			
			
		}
		request.setAttribute("tableinfo", tableinfo);

		getServletContext()
		.getRequestDispatcher("/ProductList.jsp")
		.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
