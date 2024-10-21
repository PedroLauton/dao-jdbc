package application;

import java.time.LocalDate;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department dp = new Department(1, "Books"); 
		Seller sl = new Seller(1, "Pedro", "pedro@gmail.com", LocalDate.now(), 2000.99, dp); 
		System.out.println(dp);
		System.out.println(sl);
	}

}
