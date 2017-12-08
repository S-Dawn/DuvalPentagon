package com.duval.userinterface;

import java.util.Scanner;

import com.duval.utils.Controller;

public class Main {
	public static void main(String[] args) throws Exception {

		Controller p = new Controller("G:\\2nd Lab\\DGA DATASET EXCCEL");
		p.predictFaults();

		Scanner sc = new Scanner(System.in);

		int choice = 1;
		showMenu();
		while (choice != 0) {
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				return;
			case 1:
				p.createCanvas();
				break;
			case 2:
				p.plotpoints();
				break;
			case 3:
				p.displayFaultpoints();
				break;
			case 4:
				p.displayOkpoints();
				break;
			case 5:
				System.out.println("Enter Row Number: ");
				int row = sc.nextInt();
				p.displayPentagon(row);
				break;

			default:
				showMenu();
				break;
			}

		}

	}

	public static void showMenu() {
		System.out.println("0: Exit");
		System.out.println("1: Create NEW Canvas");
		System.out.println("2: Plot All Points");
		System.out.println("3: Display Fault Points");
		System.out.println("4: Display Ok Points");
		System.out.println("5: Display Pentagon");

	}
}
