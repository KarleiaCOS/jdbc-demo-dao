package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	//depois tem que fazer o commit (1) desse aruivo

	public static void main(String[] args) {
		
		Department obj = new Department(1, "books");
		
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), obj, 3000.0);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println(obj);
		
		System.out.println(seller);

	}

}
