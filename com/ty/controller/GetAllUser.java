package com.ty.controller;

import java.util.List;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class GetAllUser {

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		List<User> l = ud.getAll();
		System.out.println(l);
	}
}
