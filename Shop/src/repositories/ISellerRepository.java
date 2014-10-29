package repositories;

import java.util.List;

import domain.Departament;
import domain.Seller;

public interface ISellerRepository extends IRepository<Seller>

{
	public List<Seller> withDepartament (Departament departament);
	public List<Seller> withDepartament (String departamentName);
	public List<Seller> withDepartament (int departamentId);
} 
