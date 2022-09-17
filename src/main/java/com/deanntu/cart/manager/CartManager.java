package com.deanntu.cart.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.deanntu.cart.entity.Cart;
import com.deanntu.inventory.entity.Category;


public class CartManager {
    private String url = "jdbc:postgresql://localhost/project";
    private String username = "postgres";
    private String password = "123456";
    private String driver = "org.postgresql.Driver";
    public CartManager() {
        try {
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean insert(Cart cart) throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "insert into cart(cartid, customername, total) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        SecretKey secretKey = cart.getCartID();
		String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        statement.setString(1, encodedKey);
        statement.setString(2, cart.getCustomerName());
        statement.setLong(3, cart.getTotalAmount());
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }
    public boolean update(Cart cart) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "update cart set customername=? total=? where cartid=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        SecretKey secretKey = cart.getCartID();
		String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        statement.setString(2, encodedKey);
        statement.setString(1, cart.getCustomerName());
        statement.setLong(1, cart.getTotalAmount());
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }

    public boolean delete(String encodedKey) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "delete from cart where cartID =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, encodedKey);
        int affected = statement.executeUpdate();
        connection.close();
        return affected > 0;
    }
    public Cart find(String encodedKey) throws Exception {
    	Cart cart = null;

        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from cart where categoryID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, encodedKey);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        	cart = parse(resultSet);
        }
        connection.close();
        return cart;
    }
    private Cart parse(ResultSet resultSet) throws Exception {
    	long totalAmount = resultSet.getLong("totalamount");
    	String customerName = resultSet.getString("customername");
    	String encodedKey = resultSet.getString("cartid");

        Cart cart = new Cart(totalAmount, customerName);
        cart.setCartID(encodedKey);
        return cart;
    }
}
