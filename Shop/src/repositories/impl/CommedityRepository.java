package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;





import domain.*;
import repositories.IRepository;

public class CommedityRepository implements IRepository<Commedity>{


	
	private Connection connection;

	
	public CommedityRepository(Connection connection) {
		
		this.setConnection(connection);
		try {
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void add(Commedity entity) {

		try 
		{	 PreparedStatement stt = connection.prepareStatement("INSERT INTO commeditys VALUES (NULL, ?, ?);");
		
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
			PreparedStatement stt = connection.prepareStatement("UPDATE commeditys SET email = ?, pesel = ? WHERE id=?;");
			
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
				result.setName(rs.getString("nazwa"));
				result.setPrice(rs.getString("cena"));
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
				Commedity commedity = new Commedity();
				commedity.setId(rs.getInt("id"));
				commedity.setName(rs.getString("nazwa"));
				commedity.setPrice(rs.getString("cena"));
				commedity.setBarCode(rs.getString("bar_code"));
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


}