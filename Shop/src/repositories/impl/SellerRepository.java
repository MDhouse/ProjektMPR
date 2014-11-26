package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




import domain.*;
import repositories.IRepository;

public class SellerRepository implements IRepository<Seller>{


	
	private Connection connection;

	
	public SellerRepository(Connection connection) {
		
		this.setConnection(connection);
		try {
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
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


}