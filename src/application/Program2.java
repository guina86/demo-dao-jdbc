package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department findById =====");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println();
		
		System.out.println("=== TEST 2: Department findAll =====");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);

		System.out.println();

		System.out.println("=== TEST 3: Department insert =====");
		dep = new Department(null, "Sports");
		//departmentDao.insert(dep);
		System.out.println("Inserted! New id = " + dep.getId());
		
		System.out.println();

		System.out.println("=== TEST 4: Department update =====");
		dep = departmentDao.findById(7);
		dep.setName("Videogames");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		
	}

}
