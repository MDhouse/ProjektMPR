package repositories.impl;

import java.sql.*;
import domain.Seller;

public class SellerRepository extends Repository<Seller>{

	public SellerRepository(Connection connection, IEntityBuilder<Seller> builder) 
	{
		super(connection, builder);
	}

	protected String getTableName() 
	{
		return "sellers";
	}
	
	protected String getInsert() {
		return "INSERT INTO sellers VALUES (NULL, ?, ?);";
	}

	protected String getUpdate() {
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
	
	/*
	
	
	public void add(Seller entity) {

		try 
		{	 PreparedStatement stt = connection.prepareStatement("INSERT INTO sellers VALUES (NULL, ?, ?);");
		
			stt.setString(1, entity.getEmail());
			stt.setString(2, entity.getPesel());
			stt.execute();
			
		} 
		
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}



	public void update(Seller entity) {

		try {
			PreparedStatement stt = connection.prepareStatement("UPDATE sellers SET email = ?, pesel = ? WHERE id=?;");
			
			stt.setString(1, entity.getEmail());
			stt.setString(2, entity.getPesel());
			stt.setInt(3, entity.getId());
			stt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void delete(Seller entity) {

		try {
			PreparedStatement stt = connection.prepareStatement("DELETE FROM sellers WHERE id=?;");
			
			stt.setInt(1, entity.getId());
			stt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Seller get(int id) {

		try {
			PreparedStatement stt = connection.prepareStatement("SELECT * FROM sellers WHERE id=?;");
						
			stt.setInt(1, id);
			ResultSet rs = stt.executeQuery();
			while(rs.next())
			{
				Seller result = new Seller();
				result.setId(rs.getInt("id"));
				result.setEmail(rs.getString("email"));
				result.setPesel(rs.getString("pesel"));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Seller> getAll() {

		List<Seller> result = new ArrayList<Seller>();
		
		try {
			PreparedStatement stt = connection.prepareStatement("SELECT * FROM sellers;");
			
			ResultSet rs= stt.executeQuery();
			while(rs.next())
			{
				Seller user = new Seller();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPesel(rs.getString("pesel"));
				result.add(user);
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