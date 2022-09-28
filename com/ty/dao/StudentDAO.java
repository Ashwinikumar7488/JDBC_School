package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Student;

public class StudentDAO {

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbc_school";
	String username = "root";
	String password = "root";
	Connection connection = null;

	public String save(Student s) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String i_query = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(i_query);
			preparedStatement.setInt(1, s.getId());
			preparedStatement.setString(2, s.getName());
			preparedStatement.setInt(3, s.getAge());
			preparedStatement.setLong(4, s.getPhone());
			preparedStatement.setString(5, s.getGender());
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

	public String update(Student s) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String u_query = "UPDATE STUDENT SET phone=? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(u_query);
			preparedStatement.setLong(1, s.getPhone());
			preparedStatement.setInt(2, s.getId());
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

	public String delete(int id) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String d_query = "DELETE FROM STUDENT WHERE ID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(d_query);
			preparedStatement.setInt(1, id);
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

	public Student validate(int id, long phone) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, this.password);
			String g_query = "SELECT * FROM STUDENT WHERE id = ? and phone=?";
			PreparedStatement preparedStatement = connection.prepareStatement(g_query);
			preparedStatement.setInt(1, id);
			preparedStatement.setLong(2, phone);
			ResultSet rs = preparedStatement.executeQuery();
			Student s = new Student();
			while (rs.next()) {
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setAge(rs.getInt(3));
				s.setPhone(rs.getLong(4));
				s.setGender(rs.getString(5));
				return s;
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

	public List<Student> getAll() {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String all_query = "SELECT * FROM STUDENT";
			PreparedStatement preparedStatement = connection.prepareStatement(all_query);
			ResultSet rs = preparedStatement.executeQuery();
			List<Student> list = new ArrayList();
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setAge(rs.getInt(3));
				s.setPhone(rs.getLong(4));
				s.setGender(rs.getString(5));
				list.add(s);
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
