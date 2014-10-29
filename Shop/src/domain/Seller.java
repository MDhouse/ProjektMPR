package domain;

import java.util.ArrayList;
import java.util.List;


public class Seller extends Entity

{
	public Seller()
	{		
		this.customerses=new ArrayList<Customers>();
	
		this.departaments=new ArrayList<Departament>();
	}
	
		
	private String firstName;
	
	private String surName;
	
	private String pesel;
	
	private String email;
	
	private List<Customers> customerses;
	
	private List<Departament> departaments;

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getSurName() 
	{
		return surName;
	}

	public void setSurName(String surName) 
	{
		this.surName = surName;
	}

	public String getPesel() 
	{
		return pesel;
	}

	public void setPesel(String pesel) 
	{
		this.pesel = pesel;
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

	public List<Departament> getDepartaments() 
	{
		return departaments;
	}

	public void setDepartaments(List<Departament> departaments) 
	{
		this.departaments = departaments;
	}
	
	
	
	
}
