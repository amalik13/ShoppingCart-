package Website;

import java.util.ArrayList;



import Website.WebsiteDB;
import model.Productdetail;
import model.Shoppinguser;;

public class WebsiteInterface {
	
	
	WebsiteDB db = new WebsiteDB();
	
	public boolean isUserExist(String userName){
		boolean isExist = false;
		
		Shoppinguser t = db.getProfile(userName);
		if (t != null){
			isExist = true;
		}
		
		return isExist;
	}
	
	public boolean isUserMatching(String userName, String pwd)
	{
		boolean isExist = false;
		
		Shoppinguser t = db.getProfile(userName, pwd);
		if (t != null){
			isExist = true;
		}
		
		return isExist;
	}
/*	WebsiteDB db = new WebsiteDB();
	
	public boolean isUserExist(String userName){
		boolean isExist = false;
		
		Twitteruser t = db.getProfile(userName);
		if (t != null){
			isExist = true;
		}
		
		return isExist;
	}
	
	public boolean isUserMatching(String userName, String pwd)
	{
		boolean isExist = false;
		
		Twitteruser t = db.getProfile(userName, pwd);
		if (t != null){
			isExist = true;
		}
		
		return isExist;
	}
	
	
	public boolean createNewAccount(String userName, String password){
		boolean isSuccess = false;
		
		//create new account
		if(db.createNewUser(userName, password)){
			isSuccess = true;
		}
		
		return isSuccess;
		
	}
	
	
	public ArrayList<TwtData> pullProfile(String userName){
		ArrayList<TwtData> twt = null;
		
		return twt;
		
	}
	
	public boolean addNewFeed(String userName, String feed){
		boolean isSuccess = false;
		
		return isSuccess;
		
	}
	
	public ArrayList<TwtDataDetail> pullFeeds(int count){
		ArrayList<TwtDataDetail> twt = null;
		
		return twt;
	}
	
	
	}*/
	public boolean createNewAccount(String userName, String password){
		boolean isSuccess = false;
		
		//create new account
		if(db.createNewUser(userName, password)){
			isSuccess = true;
		}
		
		return isSuccess;
		
	}
	public ArrayList<Productdetail> pullProduct(){
		ArrayList<Productdetail> ProductsList= new ArrayList<Productdetail>();
			WebsiteDB WD = new WebsiteDB();
			ProductsList= WD.getAllProducts();
			
			return ProductsList;
	}
	

}
