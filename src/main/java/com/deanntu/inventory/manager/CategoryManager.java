package com.deanntu.inventory.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.deanntu.inventory.entity.Category;



public class CategoryManager {
    private String url = "jdbc:postgresql://localhost/project";
    private String username = "postgres";
    private String password = "123456";
    private String driver = "org.postgresql.Driver";

    public CategoryManager() {
        try {
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean insert(Category category) throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "insert into category(categoryid, categoryname) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, category.getCategoryID());
        statement.setString(2, category.getCategoryName());
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }
    public boolean update(Category category) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "update category set categoryname=? where categoryid=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(2, category.getCategoryID());
        statement.setString(1, category.getCategoryName());
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }

    public boolean delete(long categoryID) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "delete from category where categoryID =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, categoryID);
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }
    public Category find(long categoryID) throws Exception {
    	Category category = null;

        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from category where categoryID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, categoryID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        	category = parse(resultSet);
        }
        connection.close();
        return category;
    }

    public List<Category> list() throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from category";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Category> customerList = parseList(resultSet);

        connection.close();

        return customerList;
    }
    private Category parse(ResultSet resultSet) throws Exception {
        long categoryID = resultSet.getLong("categoryID");
        String categoryName = resultSet.getString("categoryName");
        Category category = new Category(categoryID, categoryName);
        return category;
    }
    private List<Category> parseList(ResultSet resultSet) throws Exception {
        List<Category> customerList = new ArrayList<>();
        while (resultSet.next()) {
        	Category category = parse(resultSet);
            customerList.add(category);
        }
        return customerList;
    }

}
