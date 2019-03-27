package application;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println();

		System.out.println("=== TEST 2: seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);

		System.out.println();

		System.out.println("=== TEST 3: seller findAll =====");
		list = sellerDao.findAll();
		list.forEach(System.out::println);

		System.out.println();

		System.out.println("=== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "Greg Green", "greg@gmail.com", LocalDate.of(1990, 10, 10), 4000.0, department );
		//sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println();

		System.out.println("=== TEST 5: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Martha White");
		seller.setEmail("martha@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println();

		System.out.println("=== TEST 6: seller delete =====");
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
		
	}

}
