package repositories.impl;

import java.util.List;

import repositories.IRepository;
import domain.Commedity;

public class DummyCommedityRepository implements IRepository<Commedity>
{
	private DummyDB db;
	
	public DummyCommedityRepository(DummyDB db) {
		this.db = db;
	}
	public void add(Commedity entity) 
	{
		db.commeditys.add(entity);
	}

	public void delete(Commedity entity) 
	{
		db.commeditys.remove(entity);
	}

	public void update(Commedity entity) 
	{
	
	}

	public Commedity get(int id) 
	{
		for(Commedity c: db.commeditys)
			if(c.getId()==id)
				return c;
		return null;
	}

	public List<Commedity> getAll() 
	{
		return db.commeditys;
	}

}
