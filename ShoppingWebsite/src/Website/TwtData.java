package Website;

import java.io.Serializable;
import java.util.Date;

public class TwtData implements Serializable{
	
	private String feed;
	private Date date;
	
	public TwtData(){}
	
	public String getFeed() {
		return feed;
	}
	public void setFeed(String feed) {
		this.feed = feed;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
