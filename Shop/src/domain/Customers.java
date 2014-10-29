package domain;

public class Customers extends Entity

{
	private String idCustomers;
	
	private String firstName;
	
	private String surName;
	
	private String pesel;
	
	private String email;
	
	
	public String getIdCustomers() 
	{
		return idCustomers;
	}
	public void setIdCustomers(String idCustomers) 
	{
		this.idCustomers = idCustomers;
	}
	public String getFirstName() 
	{
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
	
}
