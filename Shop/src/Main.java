import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import repositories.IRepository;
import repositories.impl.CommedityBuilder;
import repositories.impl.CommedityRepository;
import repositories.impl.DepartamentBuilder;
import repositories.impl.DepartamentRepository;
import repositories.impl.SellerBuilder;
import repositories.impl.SellerRepository;
import unitofwork.IUnitOfWork;
import unitofwork.UnitOfWork;
import domain.Commedity;
import domain.Departament;
import domain.Seller;

public class Main {
		public static void main(String[] args) {
	
		String url			= "jdbc:mysql://localhost";
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
		napoj.setPrice("4.09");
		napoj.setBarCode("11111111111111");
		Commedity cukierki = new Commedity();
		cukierki.setName("Halls");
		cukierki.setPrice("2.19");
		cukierki.setBarCode("1111111111116");
		Commedity chipsy = new Commedity();
		chipsy.setName("Lays");
		chipsy.setPrice("3.15");
		chipsy.setBarCode("11111111111114");
		Commedity wafle = new Commedity();
		wafle.setName("Familijne");
		wafle.setPrice("4.15");
		wafle.setBarCode("11111111111125");
				
		Departament slodycze = new Departament();
		slodycze.setName("Slodycze");
		slodycze.setTelefonNumber("888234345");
		slodycze.setEmail("slodycze@sklep.pl");
		Departament napoje = new Departament();
		napoje.setName("Napoje");
		napoje.setTelefonNumber("888234365");
		napoje.setEmail("napoje@sklep.pl");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection(url, user, password);
			
			Statement stt = (Statement) connection.createStatement();
			IUnitOfWork uow = new UnitOfWork (connection);
			
	     //	stt.execute("DROP DATABASE IF EXISTS shop");
			//stt.execute("CREATE DATABASE shop");
			stt.execute("USE s12032");
			
			stt.execute("DROP TABLE IF EXISTS sellers");
			stt.execute("CREATE TABLE sellers(" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"email TEXT," +
					"pesel BIGINT," +
					"PRIMARY KEY(id)" +
					");");
			
			stt.execute("DROP TABLE IF EXISTS commeditys");
			stt.execute("CREATE TABLE commeditys(" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"name TEXT," +
					"price FLOAT(10,2)," +
					"bar_code BIGINT(20)," +
					"PRIMARY KEY(id)" +
					");");
			
			stt.execute("DROP TABLE IF EXISTS departaments");
			stt.execute("CREATE TABLE departaments(" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"name TEXT," +
					"telefon_number BIGINT(15)," +
					"email TEXT," +
					"PRIMARY KEY(id)" +
					");");
			
			
			IRepository<Seller> sellers = new SellerRepository(connection, new SellerBuilder(), uow);	
			IRepository<Commedity> commeditys = new CommedityRepository(connection, new CommedityBuilder(),uow);
			IRepository<Departament> departaments = new DepartamentRepository(connection, new DepartamentBuilder(), uow);
			
			sellers.add(kkowalski);
			sellers.add(dwitkacy);
			sellers.add(gandruszkiewicz);
			
			List<Seller> sellersFromDB = sellers.getAll();
			
			
			departaments.add(slodycze);
			departaments.add(napoje);
			
			List<Departament> departamentsFromDB = departaments.getAll();
			
			commeditys.add(napoj);
			commeditys.add(chipsy);
			commeditys.add(cukierki);
			
			List<Commedity>  commeditysFromDB = commeditys.getAll();	
			
			uow.commit();
			for(Seller sellerFromDB: sellersFromDB)
				System.out.println(sellerFromDB.getId()+" "+sellerFromDB.getEmail()+" "+sellerFromDB.getPesel());
			
			for (Departament departamentFromDB:departamentsFromDB)
				System.out.println(departamentFromDB.getId()+" "+departamentFromDB.getName()+" "+departamentFromDB.getTelefonNumber()+" "+departamentFromDB.getEmail());
			
			for(Commedity commedityFromDB:commeditysFromDB)
				System.out.println(commedityFromDB.getId()+" "+commedityFromDB.getName()+" "+commedityFromDB.getPrice()+" "+commedityFromDB.getBarCode());
				
			Seller s = sellers.get(1);
			s.setEmail("kkowalski.@gda.pl");
			sellers.update(s);
			
			Seller d = sellers.get(2);
			d.setPesel("65043409093");
			sellers.update(d);
			
			Commedity n = commeditys.get(2);
			n.setPrice("2.80");
			commeditys.update(n);
			commeditys.add(wafle);
			
			uow.commit();				
			for(Seller sellerFromDB: sellers.getAll())
				System.out.println(sellerFromDB.getId()+" "+sellerFromDB.getEmail()+" "+sellerFromDB.getPesel());
			
				
			for(Commedity commedityFromDB:commeditys.getAll())
			System.out.println(commedityFromDB.getId()+" "+commedityFromDB.getName()+" "+commedityFromDB.getPrice()+" "+commedityFromDB.getBarCode());
			
			Seller e = sellers.get(1);
			sellers.delete(e);
			
			
			uow.commit();
			for(Seller sellerFromDB: sellers.getAll())
				System.out.println(sellerFromDB.getId()+" "+sellerFromDB.getEmail()+" "+sellerFromDB.getPesel());
						
			stt.close();
			connection.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();	
			
			System.out.println("blad");
			
		}
		
	}
}
	