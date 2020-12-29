package com.LockedMe.Main;

import com.LockedMe.bo.Impl.menuOperations;
import com.LockedMe.exception.FileException;

public class AppMain {

	public static void main(String[] args) throws FileException {

		System.out.println("Welcome to LockeMe.com.......");
		System.out.println("Developer: Madhulika Vishwakarma");
		System.out.println("Email ID : madhulika.vish@gmail.com");
		System.out.println("Phone No : 886318935");

		menuOperations mop = new menuOperations();
		mop.displayMenu();
	}
}
