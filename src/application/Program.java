package application;

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
		
		System.out.println("\n=== Test : seller fyndByIdDepartment ===");
		listSeller = sellerDao.findAll();
		for (Seller objSeller:listSeller) {
			System.out.println(objSeller);
		}
	}

}
