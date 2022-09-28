package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.User;

public class UserDAO {

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbc_school";
	String username = "root";
	String password = "root";
	Connection connection = null;

	public String save(User c) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String i_query = "INSERT INTO USER VALUES(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(i_query);
			preparedStatement.setString(1, c.getFirstName());
			preparedStatement.setString(2, c.getLastName());
			preparedStatement.setString(3, c.getEmail());
			preparedStatement.setString(4, c.getPassword());
			preparedStatement.setLong(5, c.getPhone());
			preparedStatement.setString(6, c.getDob());
			preparedStatement.setString(7, c.getGender());
			int row = preparedStatement.executeUpdate();
			if (row == 1) {
				return "SAVED!";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "NOT SAVED!";
	}

	public String update(User c) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String u_query = "UPDATE USER SET email = ?, password=?, phone=? WHERE email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(u_query);
			preparedStatement.setString(1, c.getEmail());
			preparedStatement.setString(2, c.getPassword());
			preparedStatement.setLong(3, c.getPhone());
			preparedStatement.setString(4, c.getEmail());
			int row = preparedStatement.executeUpdate();
			if (row == 1) {
				return "UPDATED!";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "NOT UPDATED!";
	}

	public String delete(String email) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String d_query = "DELETE FROM USER WHERE email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(d_query);
			preparedStatement.setString(1, email);
			int row = preparedStatement.executeUpdate();
			if (row == 1) {
				return "DELETED!";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return "NOT DELETED!";
	}

	public User validate(String email, String password) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, this.password);
			String g_query = "SELECT * FROM USER WHERE email = ? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(g_query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			User c = new User();
			while (rs.next()) {
				c.setFirstName(rs.getString(1));
				c.setLastName(rs.getString(2));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
				c.setPhone(rs.getLong("phone"));
				c.setDob(rs.getString("dob"));
				c.setGender(rs.getString("gender"));
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}

	public List<User> getAll() {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String all_query = "SELECT * FROM USER";
			PreparedStatement preparedStatement = connection.prepareStatement(all_query);
			ResultSet rs = preparedStatement.executeQuery();
			List<User> list = new ArrayList();
			while (rs.next()) {
				User c = new User();
				c.setFirstName(rs.getString(1));
				c.setLastName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setPhone(rs.getLong(5));
				c.setDob(rs.getString(6));
				c.setGender(rs.getString(7));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}
}
