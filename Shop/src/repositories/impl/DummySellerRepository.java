package repositories.impl;

import java.util.ArrayList;
import java.util.List;

import domain.Departament;
import domain.Seller;
import repositories.ISellerRepository;


public class DummySellerRepository implements ISellerRepository
{

	private DummyDB db;
	
	public DummySellerRepository(DummyDB db) 
	{
		super();
		this.db = db;		
	}

	public void add(Seller entity) 
	{
		db.sellers.add(entity);
	}

	
	public void delete(Seller entity) 
	{
		db.sellers.remove(entity);
	}

	
	public void update(Seller entity) 
	{

	}

	public Seller get(int id) 
	{
		for(Seller s : db.sellers)
		{
		if(s.getId()==id)
		return s;
		}
		return null;
				
	}
	
	public List<Seller> getAll() 
	{
		return db.sellers;
	}

	public List<Seller> withDepartament(Departament departament) 
	{
		return withDepartament (departament.getId());
	}


	public List<Seller> withDepartament(String departamentName) 
	{
		for(Departament d : db.departaments)
			if(d.getName().equalsIgnoreCase(departamentName))
				return d.getSeller();
				return new ArrayList<Seller>();
	}

	
	public List<Seller> withDepartament(int departamentId) 
	{
		for(Departament d : db.departaments)		
			if(d.getId()==departamentId)
				return d.getSeller();
					return new ArrayList<Seller>();
	}


}
