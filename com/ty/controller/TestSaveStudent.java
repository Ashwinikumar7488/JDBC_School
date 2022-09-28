package com.ty.controller;

import com.ty.dao.StudentDAO;
import com.ty.dto.Student;

public class TestSaveStudent {

	public static void main(String[] args) {
		StudentDAO ud = new StudentDAO();
		Student c = new Student();
		int id = 1;
		c.setId(id);
		String name = "Ashwini Kumar";
		c.setName(name);
		int age = 26;
		c.setAge(age);
		Long phone = 7488233140l;
		c.setPhone(phone);
		String gender = "Male";
		c.setGender(gender);

		String result = ud.save(c);
		System.out.println(result);
	}
}
