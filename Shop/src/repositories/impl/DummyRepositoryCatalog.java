package repositories.impl;


import repositories.IRepository;
import repositories.IRepositoryCatalog;
import repositories.ISellerRepository;
import domain.Commedity;
import domain.Customers;



public class DummyRepositoryCatalog implements IRepositoryCatalog
{
	private DummyDB db;
	@Override
	public IRepository<Commedity> getCommeditys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRepository<Customers> getCustomerses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISellerRepository getSelleres() {
		// TODO Auto-generated method stub
		return new DummySellerRepository(db);
	}
	

}