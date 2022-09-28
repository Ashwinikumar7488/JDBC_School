package com.ty.controller;

import com.ty.dao.StudentDAO;
import com.ty.dto.Student;

public class TestUpdateStudent {

	public static void main(String[] args) {
		StudentDAO ud = new StudentDAO();
		Student c = new Student();
		int id = 2;
		c.setId(id);
		String name = "Sandesh Gowda";
		c.setName(name);
		int age = 23;
		c.setAge(age);
		Long phone = 8355218121l;
		c.setPhone(phone);
		String gender = "Male";
		c.setGender(gender);

		String result = ud.save(c);
		System.out.println(result);
	}
}
