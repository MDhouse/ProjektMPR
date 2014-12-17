package repositories.impl;

import java.sql.*;

import unitofwork.IUnitOfWork;
import domain.Seller;

public class SellerRepository extends Repository<Seller>
{

	public SellerRepository(Connection connection, IEntityBuilder<Seller> builder, IUnitOfWork uow) 
	{
		super(connection, builder, uow);
	}

	protected String getTableName() 
	{
		return "sellers";
	}
	
	protected String getInsert() 
	{
		return "INSERT INTO sellers VALUES (NULL, ?, ?);";
	}

	protected String getUpdate() 
	{
		return "UPDATE sellers SET email = ?, pesel = ? WHERE id=?;";
	}

	protected void setUpInsert(Seller entity) throws Exception
	{
		insert.setString(1, entity.getEmail());
		insert.setString(2, entity.getPesel());
	}

	protected void setUpUpdate(Seller entity) throws Exception 
	{
		update.setString(1, entity.getEmail());
		update.setString(2, entity.getPesel());
		update.setInt(3, entity.getId());
	}	
}