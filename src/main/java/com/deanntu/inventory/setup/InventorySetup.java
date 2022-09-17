package com.deanntu.inventory.setup;

import com.deanntu.inventory.entity.Category;
import com.deanntu.inventory.entity.Product;
import com.deanntu.inventory.manager.CategoryManager;
import com.deanntu.inventory.manager.ProductManager;

public class InventorySetup {
	public static void main(String[] args) {
		deleteAll();
		baseSetup();
		addExtraProd();
		System.out.println("----");
		printProd();
		printCat();
	}
	private static void baseSetup() {
		try {
			ProductManager productManager = new ProductManager();
		    Product Product = new Product(1,"Cikolatali Gofret", 1, 1);
		    Product Product2 = new Product(2, "Cokonat", 2, 1);
		    Product Product3 = new Product(3, "Selpak", 3, 2);
		    productManager.insert(Product);
		    productManager.insert(Product2);
		    productManager.insert(Product3);
		    CategoryManager categoryManager = new CategoryManager();
		    Category category = new Category(1,"Gofret");
		    Category category2 = new Category(2, "Pecete");
		    categoryManager.insert(category);
		    categoryManager.insert(category2);
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	private static void addExtraProd() {
		try {
		ProductManager productManager = new ProductManager();
	    Product Product = new Product(4,"Beyaz Cikolatali Gofret", 1, 1);
	    Product Product2 = new Product(5, "Cevizli Gofret", 12, 1);
	    Product Product3 = new Product(6, "Papia", 7, 2);
	    productManager.insert(Product);
	    productManager.insert(Product2);
	    productManager.insert(Product3);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void printProd() {
		try {
			ProductManager productManager = new ProductManager();
            for(Product x :productManager.list()) {
            	x.print();
            }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void printCat() {
		try {
			CategoryManager categoryManager = new CategoryManager();
            for(Category x :categoryManager.list()) {
            	x.print();
            }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void deleteAll() {
        try{
        ProductManager productManager = new ProductManager();
        for(Product x :productManager.list()) {
        	x.print();
        	productManager.delete(x.getProductID());

        }
        CategoryManager categoryManager = new CategoryManager();
        for(Category x :categoryManager.list()) {
        	x.print();
        	categoryManager.delete(x.getCategoryID());
        }

        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
}
