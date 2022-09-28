package com.ty.controller;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class TestUpdateUser {

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		User c = new User();
		String email = "ashwini46376@gmail.com";
		c.setEmail(email);
		String password = "pqr@123";
		c.setPassword(password);
		Long phone = 7077113703l;
		c.setPhone(phone);

		String result = ud.update(c);
		System.out.println(result);

	}
}
