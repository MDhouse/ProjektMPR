package repositories.impl;

import java.sql.ResultSet;

import domain.Seller;

public class SellerBuilder implements IEntityBuilder<Seller>
{
	public Seller build(ResultSet rs) throws Exception 
	{
		Seller result = new Seller();
		result.setId(rs.getInt("id"));
		result.setEmail(rs.getString("email"));
		result.setPesel(rs.getString("pesel"));
		return result;
	}

}
