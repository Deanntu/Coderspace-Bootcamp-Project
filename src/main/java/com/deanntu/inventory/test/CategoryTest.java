package com.deanntu.inventory.test;

import com.deanntu.inventory.entity.Category;
import com.deanntu.inventory.manager.CategoryManager;


public class CategoryTest {
    public static void main(String[] args) {
        try {
            CategoryManager categoryManager = new CategoryManager();
            Category category = new Category(1,"Zeki");
            
            boolean isInserted= categoryManager.insert(category);
            if (isInserted)
                System.out.println("Added.");
            else {
                System.out.println("Failed.");
            }
            Category category2 = new Category(2, "Ali Pasa");
            Category category3 = new Category(3, "Mahmut");
            categoryManager.insert(category2);
            categoryManager.insert(category3);
            Category category4 = new Category(2, "Yakup");
            for(Category x :categoryManager.list()) {
            	x.print();
            }
            boolean isUpdated = categoryManager.update(category4);
            if (isUpdated)
                System.out.println("Updated.");
            else {
                System.out.println("Failed.");
            }
            for(Category x :categoryManager.list()) {
            	x.print();
            }
            boolean isDeleted = categoryManager.delete(category4.getCategoryID());
            if (isDeleted)
                System.out.println("Deleted.");
            else {
                System.out.println("Failed.");
            }
            for(Category x :categoryManager.list()) {
            	x.print();
            	categoryManager.delete(x.getCategoryID());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}