package repositories.impl;

import java.sql.Connection;
import domain.Commedity;

public class CommedityRepository extends Repository<Commedity>
{
	public CommedityRepository(Connection connection, IEntityBuilder<Commedity> builder) 
	{
		super(connection, builder);
	}
	
	protected String getTableName() 
	{
		return "commeditys";
	}
	
	protected String getInsert() 
	{
		return "INSERT INTO commeditys VALUES (NULL, ?, ?, ?);";
	}

	protected String getUpdate() 
	{
		return "UPDATE commeditys SET name = ?, price = ?, bar_code = ? WHERE id=?;";
	}

	protected void setUpInsert(Commedity entity) throws Exception
	{
		insert.setString(1, entity.getName());
		insert.setString(2, entity.getPrice());
		insert.setString(3, entity.getBarCode());
	}

	protected void setUpUpdate(Commedity entity) throws Exception 
	{
		update.setString(1, entity.getName());
		update.setString(2, entity.getPrice());
		update.setString(3, entity.getBarCode());
		update.setInt(4, entity.getId());
	}
}