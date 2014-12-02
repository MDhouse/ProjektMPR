package repositories.impl;

import java.sql.ResultSet;
import domain.Departament;

public class DepartamentBuilder implements IEntityBuilder<Departament>
{
	public Departament build(ResultSet rs) throws Exception 
	{
		Departament result = new Departament();
		result.setId(rs.getInt("id"));
		result.setName(rs.getString("name"));
		result.setTelefonNumber(rs.getString("telefon_number"));
		result.setEmail(rs.getString("email"));
		
		return result;
	}
}