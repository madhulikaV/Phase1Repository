package com.LockedMe.bo.Impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import com.LockedMe.bo.ViewFilesBO;
import com.LockedMe.exception.FileException;

public class ViewFilesBOImpl implements ViewFilesBO {
	static ArrayList<String> al = new ArrayList<>();

	@Override
	public void display() throws FileException {
		System.out.println("Enter the directory you wish to view");
		try (Scanner sc = new Scanner(System.in)) {
			String path = sc.next();
			al = ViewFilesBOImpl.getFiles(path);
		}
		Collections.sort(al);
		for (String f1 : al)
			System.out.println(f1);
	}

	public static ArrayList<String> getFiles(String path) {
		String path1 = "";
		try {
			File file = new File(path);
			File[] s1 = file.listFiles();
			if (s1 != null) {
				for (File s2 : s1) {
					if (s2.isFile()) {
						al.add(s2.getName());
					} else {
						path1 = s2.getAbsolutePath();
						ViewFilesBOImpl.getFiles(path1);
					}
				}
			} else {
				System.out.println("Directory isempty");
			}
		} catch (Exception e) {
			System.out.println("Invalid Path");
		}
		return al;
	}

}
