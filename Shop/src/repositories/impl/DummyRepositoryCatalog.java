package repositories.impl;


import repositories.IRepository;
import repositories.IRepositoryCatalog;
import repositories.ISellerRepository;
import domain.Commedity;
import domain.Departament;



public class DummyRepositoryCatalog implements IRepositoryCatalog
{
	private DummyDB db = new DummyDB();

	public IRepository<Commedity> getCommeditys() {
		// TODO Auto-generated method stub
		return new DummyCommedityRepository(db);
	}


	public IRepository<Departament> getDepartaments() {
		// TODO Auto-generated method stub
		return new DummyDepartamentRepository(db);
	}

	public ISellerRepository getSelleres() {
		// TODO Auto-generated method stub
		return new DummySellerRepository(db);
	}
	

}