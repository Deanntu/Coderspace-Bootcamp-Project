package com.deanntu.user.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.deanntu.inventory.entity.Category;
import com.deanntu.user.entity.User;

public class UserManager {

	private String url = "jdbc:postgresql://localhost/project";
	private String username = "postgres";
	private String password = "123456";
	private String driver = "org.postgresql.Driver";

	public UserManager() {
		try {
			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean create(User user) throws Exception {
		Connection connection = DriverManager.getConnection(url, username, password);

		String sql = "insert into useraccount(username, userpassword,address) values (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUserName());
		statement.setString(2, user.getUserPassword());
		statement.setString(3, user.getAddress());
		int affected = statement.executeUpdate();

		connection.close();
		return affected > 0;
	}

	public User findByUserName(String userUserName) throws Exception{
		User user = null;

        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from useraccount where username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userUserName);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            user = parse(resultSet);
        }
        connection.close();
        return user;
	}

	private User parse(ResultSet resultSet) throws Exception{
		long userId = resultSet.getLong("userid");
		String userName = resultSet.getString("username");
		String userPassword = resultSet.getString("userpassword");
		String address = resultSet.getString("address");
		User user = new User(userId, userName, userPassword,address);
		return user;
	}

    public List<User> list() throws Exception {

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from category";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<User> userList = parseList(resultSet);

        connection.close();

        return userList;
    }

    private List<User> parseList(ResultSet resultSet) throws Exception {
        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
        	User user = parse(resultSet);
        	userList.add(user);
        }
        return userList;
    }
}