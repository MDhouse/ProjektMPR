package domain;

import java.util.ArrayList;
import java.util.List;

public class Departament extends Entity

{
	
	public Departament()
	{		
		this.customerses=new ArrayList<Customers>();
	}
	
	private String name;
	
	private String telefonNumber;
	
	private String email;
	
	private List<Customers> customerses;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getTelefonNumber() 
	{
		return telefonNumber;
	}
	public void setTelefonNumber(String telefonNumber) 
	{
		this.telefonNumber = telefonNumber;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public List<Customers> getCustomerses() 
	{
		return customerses;
	}
	public void setCustomerses(List<Customers> customerses) 
	{
		this.customerses = customerses;
	}
	public List<Seller> getSeller() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
