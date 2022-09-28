package com.ty.controller;

import java.util.List;

import com.ty.dao.StudentDAO;
import com.ty.dto.Student;

public class GetAllStudent {

	public static void main(String[] args) {
		StudentDAO ud = new StudentDAO();
		List<Student> l = ud.getAll();
		System.out.println(l);
	}
}
