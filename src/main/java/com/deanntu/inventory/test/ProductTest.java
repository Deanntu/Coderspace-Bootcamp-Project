package com.deanntu.inventory.test;

import com.deanntu.inventory.entity.Product;
import com.deanntu.inventory.manager.ProductManager;

public class ProductTest {
	public static void main(String[] args) {
       //fullTest();
		productByCategoryTest();
	}
	private static void productByCategoryTest() {
		try {
			ProductManager productManager = new ProductManager();
			for(Product x:productManager.listByCategoryID(1)) {
				x.print();
			}
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	private static void fullTest() {
		 try {
	        	ProductManager productManager = new ProductManager();
	            Product Product = new Product(1,"Zeki", 1, 1);
	            boolean isInserted= productManager.insert(Product);
	            if (isInserted)
	                System.out.println("Added.");
	            else {
	                System.out.println("Failed.");
	            }
	            Product Product2 = new Product(2, "Ali Pasa", 2, 2);
	            Product Product3 = new Product(3, "Mahmut", 3, 3);
	            productManager.insert(Product2);
	            productManager.insert(Product3);
	            Product Product4 = new Product(2, "Yakup", 4, 4);
	            for(Product x :productManager.list()) {
	            	x.print();
	            }
	            boolean isUpdated = productManager.update(Product4);
	            if (isUpdated)
	                System.out.println("Updated.");
	            else {
	                System.out.println("Failed.");
	            }
	            for(Product x :productManager.list()) {
	            	x.print();
	            }
	            boolean isDeleted = productManager.delete(Product4.getProductID());
	            if (isDeleted)
	                System.out.println("Deleted.");
	            else {
	                System.out.println("Failed.");
	            }
	            for(Product x :productManager.list()) {
	            	x.print();
	            	productManager.delete(x.getProductID());
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
