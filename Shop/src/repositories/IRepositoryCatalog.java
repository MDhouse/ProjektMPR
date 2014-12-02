package repositories;

import domain.*;

public interface IRepositoryCatalog 
{
	public IRepository<Commedity> getCommeditys();
	
	public IRepository<Departament> getDepartaments();
	
	public ISellerRepository getSelleres();	
}