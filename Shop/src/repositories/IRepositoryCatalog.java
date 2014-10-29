package repositories;

import domain.*;

public interface IRepositoryCatalog 
{
	public IRepository<Commedity> getCommeditys();
	
	public IRepository<Customers> getCustomerses();
	
	public ISellerRepository getSelleres();
	
}