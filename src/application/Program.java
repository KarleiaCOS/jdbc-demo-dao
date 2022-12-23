package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller fyndById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller fyndByIdDepartment ===");
		Department department = new Department(2, null);
		List<Seller> listSeller = sellerDao.findByDepartment(department);
		for (Seller objSeller:listSeller) {
			System.out.println(objSeller);
		}
		
		System.out.println("\n=== Test 3: seller fyndByIdDepartment ===");
		listSeller = sellerDao.findAll();
		for (Seller objSeller:listSeller) {
			System.out.println(objSeller);
		}
		
		System.out.println("\n=== Test 4: seller insertt ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id: " + newSeller.getId());
	}

}
