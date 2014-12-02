package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;
import domain.Entity;

public abstract class Repository <TEntity extends Entity> 
implements IRepository<TEntity> 
{
	
	protected Connection connection;
	protected PreparedStatement insert;
	protected PreparedStatement update;
	protected IEntityBuilder<TEntity> builder;
	
	protected Repository(Connection connection, IEntityBuilder<TEntity> builder)
	{
		this.connection = connection;
		this.builder = builder;
		try 
		{
			insert = connection.prepareStatement(getInsert());
			update = connection.prepareStatement(getUpdate());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void add(TEntity entity) 
	{
		try 
		{
			
			setUpInsert(entity);
			insert.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void update(TEntity entity) 
	{
		try 
		{
			
			setUpUpdate(entity);
			update.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	

	@Override
	public void delete(TEntity entity) {
		try {
			PreparedStatement stt = connection.prepareStatement("DELETE FROM "+ getTableName() +" WHERE id=?;");
			stt.setInt(1, entity.getId());
			stt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public TEntity get(int id) 
	{

		try {
			PreparedStatement stt = connection.prepareStatement("SELECT * FROM "+ getTableName() +" WHERE id=?;");
			stt.setInt(1, id);
			ResultSet rs = stt.executeQuery();
			while(rs.next())
			{
				return builder.build(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<TEntity> getAll() 
	{
		List<TEntity> result = new ArrayList<TEntity>();
		
		try 
		{	PreparedStatement stt = connection.prepareStatement("SELECT * FROM "+ getTableName() +";");
			ResultSet rs= stt.executeQuery();
			while(rs.next())
			{
				result.add(builder.build(rs));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return result;
	}
	protected abstract void setUpUpdate(TEntity entity) throws Exception;
	protected abstract void setUpInsert(TEntity entity) throws Exception;
	protected abstract String getTableName();
	protected abstract String getUpdate();
	protected abstract String getInsert();;
}
