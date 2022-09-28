package com.ty.controller;

import com.ty.dao.StudentDAO;
import com.ty.dto.Student;

public class TestValidateStudent {

	public static void main(String[] args) {
		StudentDAO ud = new StudentDAO();
		Student s = new Student();
		int id = 1;
		s.setId(id);
		long phone = 7488233140l;
		s.setPhone(phone);
		Student s1 = ud.validate(id,phone);
		if (s1 != null) {
			System.out.println("Welcome " + s1.getName());
		} else {
			System.out.println("INVALID CREDENTIALS!!");
		}
		System.out.println(s1);
	}
}
