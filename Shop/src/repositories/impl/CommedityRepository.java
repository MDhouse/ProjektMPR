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
	
	protected String getInsert() {
		return "INSERT INTO commeditys VALUES (NULL, ?, ?, ?);";
	}

	protected String getUpdate() {
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
	
	/*
	
	private Connection connection;
	
	
	public CommedityRepository(Connection Connection)
		{
		this.setConnection(Connection);
		try{
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		}

	


	public void add(Commedity entity) {

		try 
		{	 PreparedStatement stt = connection.prepareStatement("INSERT INTO commeditys VALUES (NULL, ?, ?, ?);");
		
			stt.setString(1, entity.getName());
			stt.setString(2, entity.getPrice());
			stt.setString(3, entity.getBarCode());
			stt.execute();
			
		} 
		
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}



	public void update(Commedity entity) {

		try {
			PreparedStatement stt = connection.prepareStatement("UPDATE commeditys SET name = ?, price = ?, bar_code = ? WHERE id=?;");
			
			stt.setString(1, entity.getName());
			stt.setString(2, entity.getPrice());
			stt.setString(3, entity.getBarCode());
			stt.setInt(4, entity.getId());
			stt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void delete(Commedity entity) {

		try {
			PreparedStatement stt = connection.prepareStatement("DELETE FROM commeditys WHERE id=?;");
			
			stt.setInt(1, entity.getId());
			stt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Commedity get(int id) {

		try {
			PreparedStatement stt = connection.prepareStatement("SELECT * FROM commeditys WHERE id=?;");
						
			stt.setInt(1, id);
			ResultSet rs = stt.executeQuery();
			while(rs.next())
			{
				Commedity result = new Commedity();
				result.setId(rs.getInt("id"));
				result.setName(rs.getString("name"));
				result.setPrice(rs.getString("price"));
				result.setBarCode(rs.getString("bar_code"));
				return result;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Commedity> getAll() {

		List<Commedity> result = new ArrayList<Commedity>();
		
		try {
			PreparedStatement stt = connection.prepareStatement("SELECT * FROM commeditys;");
			
			ResultSet rs= stt.executeQuery();
			while(rs.next())
			{
				
				result.add(commedity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}


}*/