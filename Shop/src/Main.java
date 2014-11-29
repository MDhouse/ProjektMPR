import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import repositories.IRepository;
import repositories.impl.CommedityRepository;
import repositories.impl.DepartamentRepository;
import repositories.impl.SellerRepository;
import domain.Commedity;
import domain.Departament;
import domain.Seller;





public class Main {

	public static void main(String[] args) {
	
		String url			="jdbc:mysql://localhost";
		String user 		= "s12032";
		String password 	= "Dam.Junk";
		
		Seller kkowalski = new Seller();
		kkowalski.setEmail("kkowalski@kow.pl");
		kkowalski.setPesel("90090811232");
		Seller dwitkacy = new Seller();
		dwitkacy.setEmail("dwitkacy@dw.com");
		dwitkacy.setPesel("85023409093");
		Seller gandruszkiewicz = new Seller();
		gandruszkiewicz.setEmail("ganruszkiewicz@dw.com");
		gandruszkiewicz.setPesel("73052607092");
		
		Commedity napoj = new Commedity();
		napoj.setName("Cola");
		napoj.setPrice("4,09");
		napoj.setBarCode("11111111111111");
		Commedity cukierki = new Commedity();
		cukierki.setName("");
		cukierki.setPrice("");
		cukierki.setBarCode("");
		Commedity chipsy = new Commedity();
		chipsy.setName("Lays");
		chipsy.setPrice("3,15");
		chipsy.setBarCode("11111111111114");
		
		Departament slodycze = new Departament();
		slodycze.setName("slodycze");
		slodycze.setTelefonNumber("888234345");
		slodycze.setEmail("slodycze@sklep.pl");
		Departament napoje = new Departament();
		napoje.setName("napoje");
		napoje.setTelefonNumber("888234365");
		napoje.setEmail("napoje@sklep.pl");
		
		

		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection(url, user, password);
			
			Statement stt = (Statement) connection.createStatement();
			
	     	stt.execute("DROP DATABASE IF EXISTS shop");
			stt.execute("CREATE DATABASE shop");
			stt.execute("USE shop");
			
			stt.execute("DROP TABLE IF EXISTS sellers");
			stt.execute("CREATE TABLE sellers (" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"email TEXT," +
					"pesel BIGINT," +
					"PRIMARY KEY(id)" +
					");");
			
			stt.execute("DROP TABLE IF EXISTS commeditys");
			stt.execute("CREATE TABLE IF EXISTS commeditys (" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"name TEXT," +
					"price FLOAT(15)" +
					"bar_code BIGINT(20)," +
					"PRIMARY KEY(id)" +
					");");
			
			stt.execute("DROP TABLE IF EXISTS departaments");
			stt.execute("CREATE TABLE departaments (" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"name TEXT," +
					"telefon_number BIGINT(15)" +
					"email TEXT," +
					"PRIMARY KEY(id)" +
					");");
		
			IRepository<Seller> sellers = new SellerRepository(connection);
			IRepository<Commedity> commeditys = new CommedityRepository(connection);
			IRepository<Departament> departaments = new DepartamentRepository(connection);
		
			sellers.add(kkowalski);
			sellers.add(dwitkacy);
			sellers.add(gandruszkiewicz);
			List<Seller> sellersFromDB= sellers.getAll();
			
			for(Seller sellerFromDB: sellersFromDB)
				System.out.println(sellerFromDB.getId()+" "+sellerFromDB.getEmail()+" "+sellerFromDB.getPesel());
			
			Seller s = sellers.get(1);
			s.setEmail("kkowalski.@gda.pl");
			sellers.update(s);
			
			Seller d = sellers.get(2);
			d.setPesel("65043409093");
			sellers.update(d);
						
			for(Seller sellerFromDB: sellers.getAll())
				System.out.println(sellerFromDB.getId()+" "+sellerFromDB.getEmail()+" "+sellerFromDB.getPesel());
			
			sellers.delete(sellersFromDB.get(2));
			
			for(Seller sellerFromDB: sellers.getAll())
				System.out.println(sellerFromDB.getId()+" "+sellerFromDB.getEmail()+" "+sellerFromDB.getPesel());
			
			
			stt.close();
			connection.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();	
			
			System.out.println("Błąd w po��czeniu");
			
		}
		
	}
}
	