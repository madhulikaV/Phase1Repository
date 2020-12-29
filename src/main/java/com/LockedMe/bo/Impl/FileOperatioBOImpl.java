package com.LockedMe.bo.Impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import com.LockedMe.bo.FileOperationBO;
import com.LockedMe.exception.FileException;

public class FileOperatioBOImpl implements FileOperationBO {

	@Override
	public void addFileOp() throws FileException {
		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter .txt filename you wish to add (with extension)");
			String filename = sc.nextLine();
			System.out.println("____________________________________________________");
			System.out.println("Enter the path where you wish to place the file ");
			String filepath = sc.nextLine();
			System.out.println("____________________________________________________");
			String fullPath = filepath + "\\" + filename;
			try (FileWriter fw = new FileWriter(fullPath); BufferedWriter bw = new BufferedWriter(fw);) {
				System.out.println("Enter file contents now....");
				System.out.println("Note : Press ':q' to at the end of the contents");
				System.out.println("_________________________________________________");
				while (!sc.hasNext(":q")) {
					bw.write(sc.nextLine());
					bw.newLine();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public boolean deleteFileOp() throws FileException {
		String[] filelist;
		boolean isDeleted = false;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file you wish to delete (with file extension)");
			String filename = sc.nextLine();
			System.out.println("Enter Path where file is located");
			String filePath = sc.nextLine();
			File file = new File(filePath);
			filelist = file.list();
			for (String s1 : filelist) {
				if (s1.equals(filename)) {
					File f1 = new File(filePath + "\\" + s1);
					isDeleted = f1.delete();
				}
			}
		}
		return isDeleted;
	}

	@Override
	public void fileSearchOp() throws FileException {
		String[] filelist;
		boolean found = false;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file you wish to search");
			String filename = sc.nextLine();
			System.out.println("Enter File Path");
			String filePath = sc.nextLine();
			File file = new File(filePath);
			filelist = file.list();
			for (String s1 : filelist) {
				if (s1.equals(filename)) {
					found = true;
					break;
				}
			}
			if (found)
				System.out.println("Specified file is present at the given Location");
			else
				System.out.println("File Not Found!!!");
		}
	}
}
