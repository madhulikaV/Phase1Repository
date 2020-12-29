package com.LockedMe.bo.Impl;

import java.util.Scanner;

import com.LockedMe.exception.FileException;

public class menuOperations {
	Scanner scanner = new Scanner(System.in);

	public void MenuList() {
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Main Menu");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("1. View All Files.");
		System.out.println("2. Perform File Level Operations.");
		System.out.println("3. Exit");
		System.out.println("Please Enter Your Choice (1-3) : ");
	}

	public void SubMenuList() {
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Sub-Menu");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("1. Add File");
		System.out.println("2. Delete File");
		System.out.println("3. Search File");
		System.out.println("4. Main Menu");
		System.out.println("Please Enter the File Operation you wish to perform (1-3):");
	}

	public void displayMenu() throws FileException {
		int choice = 0;

		do {
			menuOperations mop = new menuOperations();
			mop.MenuList();
			try {
				choice = Integer.parseInt(scanner.nextLine());
				if (choice == 1) {
					ViewFilesBOImpl vfbi = new ViewFilesBOImpl();
					vfbi.display();
					menuOperations mops = new menuOperations();
					mops.displayMenu();

				} else if (choice == 2) {
					menuOperations disps = new menuOperations();
					disps.displaySubMenu();
				} else {
					if (choice != 3)
						System.out.println("Invalid Choice!Please Enter digits between 1-3");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid Choice! You are only allowed to enter numbers");
			}

		} while (choice != 3);

		System.out.println("Signing Out ....Thankyou!!!");
		System.out.println("------------------------------------------------------------------------------");

	}

	public void displaySubMenu() {
		int subchoice = 0;
		do {
			menuOperations mops = new menuOperations();
			mops.SubMenuList();

			try {
				subchoice = Integer.parseInt(scanner.nextLine());
				if (subchoice > 4)
					System.out.println("Invalid Choice!!! Please Enter digits between 1-4");

				if (subchoice == 1) {
					FileOperatioBOImpl fobi = new FileOperatioBOImpl();
					try {
						fobi.addFileOp();
					} catch (FileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (subchoice == 2) {
					FileOperatioBOImpl fobi = new FileOperatioBOImpl();
					try {
						fobi.deleteFileOp();
					} catch (FileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (subchoice == 3) {
					FileOperatioBOImpl fobi = new FileOperatioBOImpl();
					try {
						fobi.fileSearchOp();
					} catch (FileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid Choice! You are only allowed to enter numbers");
			}
		} while (subchoice != 4);
	}

}
