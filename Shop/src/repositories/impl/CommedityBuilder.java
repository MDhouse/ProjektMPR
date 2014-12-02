package repositories.impl;

import java.sql.ResultSet;

import domain.Commedity;

public class CommedityBuilder implements IEntityBuilder<Commedity>
{
	
	public Commedity build(ResultSet rs) throws Exception 
	{
		Commedity result = new Commedity();
		result.setId(rs.getInt("id"));
		result.setName(rs.getString("name"));
		result.setPrice(rs.getString("price"));
		result.setBarCode(rs.getString("bar_code"));
		
		return result;
	}

}
