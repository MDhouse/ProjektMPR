package repositories.impl;

import java.util.List;

import domain.Customers;
import repositories.IRepository;

public class DummyDBCustomers implements IRepository<Customers>{


	public Customers get(int id) 
	{
			return null;
	}

	
	public List<Customers> getAll() 
	{
		return null;
	}

	public void add(Customers entity) 
	{

	}

	public void delete(Customers entity) 
	{
	
	}

	public void update(Customers entity) 
	{
	
	}

}

