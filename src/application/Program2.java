package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== Test 1: Department insert ===");
		Department newDepartment = new Department(7, "Accessories");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
		
		//Se deixar Id null:
		/*Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because the return value of "model.entities.Department.getId()" is null
		at model.dao.impl.DepartmentDaoJDBC.insert(DepartmentDaoJDBC.java:34)
		at application.Program2.main(Program2.java:15)*/

	}

}
