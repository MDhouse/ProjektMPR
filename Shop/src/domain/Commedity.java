package domain;

import java.util.ArrayList;
import java.util.List;

public class Commedity extends Entity

{
	
	public Commedity()
	{		
		this.sellers=new ArrayList<Seller>();
	
	}
	private String idCommedity;
	
	private String name;
	
	private String price;
	
	private String barCode;
	
	private List<Seller> sellers;
	
	public String getIdCommedity() 
	{
		return idCommedity;
	}
	public void setIdCommedity(String idCommedity) 
	{
		this.idCommedity = idCommedity;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getPrice() 
	{
		return price;
	}
	public void setPrice(String price) 
	{
		this.price = price;
	}
	public String getBarCode() 
	{
		return barCode;
	}
	public void setBarCode(String barCode) 
	{
		this.barCode = barCode;
	}
	public List<Seller> getSellers() 
	{
		return sellers;
	}
	public void setSellers(List<Seller> sellers) 
	{
		this.sellers = sellers;
	}
	
	

}
