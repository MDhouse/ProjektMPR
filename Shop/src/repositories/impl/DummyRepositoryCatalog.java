package repositories.impl;

import repositories.IRepository;
import repositories.IRepositoryCatalog;
import repositories.ISellerRepository;
import domain.Commedity;
import domain.Departament;

public class DummyRepositoryCatalog implements IRepositoryCatalog
{
	private DummyDB db = new DummyDB();
/*	private Connection connection;
	private IUnitOfWork uow;
	
	public DummyRepositoryCatalog(Connection connection, IUnitOfWork uow)
	{
		super();
	
	}*/
	

	public IRepository<Commedity> getCommeditys() 
	{
		return new DummyCommedityRepository(db);
	}

	public IRepository<Departament> getDepartaments() 
	{
		return new DummyDepartamentRepository(db);
	}
	
	public ISellerRepository getSelleres() 
	{
		return new DummySellerRepository(db);
	}
}