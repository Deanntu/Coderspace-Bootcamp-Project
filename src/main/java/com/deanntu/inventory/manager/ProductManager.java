package com.deanntu.inventory.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.deanntu.inventory.entity.Product;


public class ProductManager {
    private String url = "jdbc:postgresql://localhost/project";
    private String username = "postgres";
    private String password = "123456";
    private String driver = "org.postgresql.Driver";

    public ProductManager() {
        try {
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean insert(Product product) throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "insert into product (productid, productname, salesprice, categoryid) values (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, product.getProductID());
        statement.setString(2, product.getProductName());
        statement.setLong(3, product.getSalesPrice());
        statement.setLong(4, product.getCategoryID());
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }
    public boolean update(Product product) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "update product set productname=?, salesprice=?, categoryid=? where productid=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(4, product.getProductID());
        statement.setString(1, product.getProductName());
        statement.setLong(2, product.getSalesPrice());
        statement.setLong(3, product.getCategoryID());
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }

    public boolean delete(long productID) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "delete from product where productID =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productID);
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }
    public Product find(long productID) throws Exception {
    	Product product = null;

        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from product where productID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        	product = parse(resultSet);
        }
        connection.close();
        return product;
    }

    public List<Product> list() throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from product";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Product> customerList = parseList(resultSet);

        connection.close();

        return customerList;
    }
    public List<Product> listByCategoryID(long categoryID) throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from product where categoryID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, categoryID);
        ResultSet resultSet = statement.executeQuery();
        List<Product> customerList = parseList(resultSet);

        connection.close();

        return customerList;
    }
    private Product parse(ResultSet resultSet) throws Exception {
        long productID = resultSet.getLong("productID");
        String productName = resultSet.getString("productName");
        long salesPrice = resultSet.getLong("salesPrice");
        long categoryID = resultSet.getLong("categoryID");
        Product product = new Product(productID, productName,salesPrice,categoryID);
        return product;
    }
    private List<Product> parseList(ResultSet resultSet) throws Exception {
        List<Product> productList = new ArrayList<>();
        while (resultSet.next()) {
        	Product product = parse(resultSet);
        	productList.add(product);
        }
        return productList;
    }

}
