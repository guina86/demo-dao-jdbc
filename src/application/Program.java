package application;

import java.time.LocalDate;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department dep = new Department(1, "Books");
		Seller seller = new Seller(21, "bob", "bob@gmail.com", LocalDate.of(1985,05,12), 3000.0, dep );
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println(seller);
		
		

	}

}
