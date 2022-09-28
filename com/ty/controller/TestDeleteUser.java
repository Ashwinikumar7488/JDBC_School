package com.ty.controller;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class TestDeleteUser {

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		User c = new User();
		String email = "ashwini46376@gmail.com";
		c.setEmail(email);
		String result = ud.delete(email);
		System.out.println(result);
	}

}
