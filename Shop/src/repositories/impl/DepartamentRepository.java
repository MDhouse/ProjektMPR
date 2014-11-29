package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




import domain.*;
import repositories.IRepository;

public class DepartamentRepository implements IRepository<Departament>{


	
	private Connection connection;

	
	public DepartamentRepository(Connection connection) {
		
		this.setConnection(connection);
		try {
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void add(Departament entity) {

		try 
		{	 PreparedStatement stt = connection.prepareStatement("INSERT INTO departaments VALUES (NULL, ?, ?);");
		
			stt.setString(1, entity.getName());
			stt.setString(2, entity.getTelefonNumber());
			stt.setString(3, entity.getEmail());
			stt.execute();
			
		} 
		
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}



	public void update(Departament entity) {

		try {
			PreparedStatement stt = connection.prepareStatement("UPDATE departaments SET email = ?, pesel = ? WHERE id=?;");
			
			stt.setString(1, entity.getName());
			stt.setString(2, entity.getTelefonNumber());
			stt.setString(3, entity.getEmail());
			stt.setInt(4, entity.getId());
			stt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void delete(Departament entity) {

		try {
			PreparedStatement stt = connection.prepareStatement("DELETE FROM departaments WHERE id=?;");
			
			stt.setInt(1, entity.getId());
			stt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Departament get(int id) {

		try {
			PreparedStatement stt = connection.prepareStatement("SELECT * FROM departaments WHERE id=?;");
						
			stt.setInt(1, id);
			ResultSet rs = stt.executeQuery();
			while(rs.next())
			{
				Departament result = new Departament();
				result.setId(rs.getInt("id"));
				result.setName(rs.getString("name"));
				result.setTelefonNumber(rs.getString("telefon_number"));
				result.setEmail(rs.getString("email"));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Departament> getAll() {

		List<Departament> result = new ArrayList<Departament>();
		
		try {
			PreparedStatement stt = connection.prepareStatement("SELECT * FROM departaments;");
			
			ResultSet rs= stt.executeQuery();
			while(rs.next())
			{
				Departament departament = new Departament();
				departament.setId(rs.getInt("id"));
				departament.setName("name");
				departament.setTelefonNumber("telefon_number");
				departament.setEmail(rs.getString("email"));
				result.add(departament);
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