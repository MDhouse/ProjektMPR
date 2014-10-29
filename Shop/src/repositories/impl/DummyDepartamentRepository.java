package repositories.impl;

import java.util.List;

import repositories.IRepository;
import domain.Departament;

public class DummyDepartamentRepository implements IRepository<Departament>
{
	private DummyDB db;
	
	public DummyDepartamentRepository(DummyDB db) {
		this.db = db;
	}
	public void add(Departament entity) 
	{
		db.departaments.add(entity);
	}

	public void delete(Departament entity) 
	{
		db.departaments.remove(entity);
	}

	public void update(Departament entity) 
	{

	}
	
	public Departament get(int id) 
	{
		for(Departament d: db.departaments)
			if(d.getId()==id)
				return d;
		return null;
	}

	public List<Departament> getAll()
	{
		return db.departaments;
	}

}
