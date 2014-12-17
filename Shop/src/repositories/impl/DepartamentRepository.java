package repositories.impl;

import java.sql.Connection;

import unitofwork.IUnitOfWork;
import domain.Departament;

public class DepartamentRepository extends Repository<Departament>
{
	public DepartamentRepository(Connection connection, IEntityBuilder<Departament> builder, IUnitOfWork uow) 
	{
		super(connection, builder, uow);
	}

	protected String getTableName() 
	{
		return "departaments";
	}
	
	protected String getInsert() 
	{
		return "INSERT INTO departaments VALUES (NULL, ?, ?, ?);";
	}

	protected String getUpdate() 
	{
		return "UPDATE departaments SET name = ?, telfon_number = ? email = ? WHERE id=?;";
	}

	protected void setUpInsert(Departament entity) throws Exception
	{
		insert.setString(1, entity.getName());
		insert.setString(2, entity.getTelefonNumber());
		insert.setString(3, entity.getEmail());
	}

	protected void setUpUpdate(Departament entity) throws Exception 
	{
		update.setString(1, entity.getName());
		update.setString(2, entity.getTelefonNumber());
		update.setString(3, entity.getEmail());
		update.setInt(4, entity.getId());
	}
}