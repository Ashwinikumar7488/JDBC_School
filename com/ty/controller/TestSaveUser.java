package com.ty.controller;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class TestSaveUser {

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		User c = new User();
		String f_name = "Ashutosh";
		c.setFirstName(f_name);
		String l_name = "Kumar";
		c.setLastName(l_name);
		String email = "ashutosh46376@gmail.com";
		c.setEmail(email);
		String password = "pqr@123";
		c.setPassword(password);
		Long phone = 7077113703l;
		c.setPhone(phone);
		String dob= "04/05/2000";
		c.setDob(dob);
		String gender="Male";
		c.setGender(gender);
		
		String result = ud.save(c);
		System.out.println(result);
	}
}
