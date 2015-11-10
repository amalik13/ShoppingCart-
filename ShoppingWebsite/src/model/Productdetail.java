package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the PRODUCTDETAIL database table.
 * 
 */
@Entity
@Table(name="PRODUCTDETAIL", schema="testuserdb")
@NamedQuery(name="Productdetail.findAll", query="SELECT p FROM Productdetail p")
public class Productdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String productid;

	private String description;

	private String price;

	private String productname;

	public Productdetail() {
	}

	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

}