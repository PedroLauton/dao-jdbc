package application;

import java.sql.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1: seller FindById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 2: seller FindByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		list.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 3: seller FindAll ===");
		List<Seller> listSeller = sellerDao.findAll();
		listSeller.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 4: seller FindAll ===");
		Seller sellerTest = new Seller(null, "Pedro Lauton", "pedro@gmail.com", new Date(0), 2100.50, dep);
		sellerDao.insert(sellerTest);
		System.out.println("New Id: " + sellerTest.getId());
		
		System.out.println("\n=== TESTE 5: seller FindAll ===");
		Seller cell = sellerDao.findById(1);
		cell.setName("Mago Davy Jones");
		sellerDao.update(cell);
		System.out.println(cell);
	}
}
