package com.ty.controller;

import com.ty.dao.StudentDAO;
import com.ty.dto.Student;

public class TestDeleteStudent {

	public static void main(String[] args) {
		StudentDAO ud = new StudentDAO();
		Student c = new Student();
		int id = 2;
		c.setId(id);
		String result = ud.delete(id);
		System.out.println(result);
	}
}
