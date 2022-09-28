package com.ty.controller;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class TestValidateUser {

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		User c = new User();
		String email = "ashwini46376@gmail.com";
		c.setEmail(email);
		String password = "abc123";
		c.setPassword(password);
		User c1 = ud.validate(email, password);
		if (c1 != null) {
			System.out.println("Welcome " + c1.getFirstName());
			System.out.println(c1);
		} else {
			System.out.println("INVALID CREDENTIALS!!");
		}
		
	}

}
