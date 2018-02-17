package com.duval.userinterface;

import java.awt.Color;
import java.util.Scanner;

import com.duval.custom.Boundary;
import com.duval.custom.Cluster;
import com.duval.utils.Controller;
import com.duval.utils.Coordinates;
import com.duval.utils.FaultController;

public class Main {
	public static void main(String[] args) throws Exception {

		boolean patch = false;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Do you want to Enable Patch ? (Y/N)");
			String choice = sc.next();

			if (choice.toUpperCase().equals("Y")) {
				patch = true;
				break;
			} else if (choice.toUpperCase().equals("N")) {
				patch = false;
				break;
			} else {
				System.out.println("Enter a valid Choice.");
			}
		}

		Controller p = new Controller("G:\\2nd Lab\\DGA DATASET EXCCEL", patch);
		// Controller p = new Controller("D:\\2nd Lab\\PentagonWorkspace\\DGA
		// DATASET EXCCEL", patch);
		p.predictFaults();

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

			case 6:
				System.out.println("Fault Points Count Detected: " + p.countFaultPoints());
				break;

			case 7:
				System.out.println("Enter Fault: ");
				String name = sc.next();
				p.displayFault(name);
				break;

			case 8:
				FaultController co = new FaultController();
				Coordinates coo = co.getFaultPointCentroid(31, 130, 192, 31, 0);
				System.out.println(coo);
				break;

			case 9:
				System.out.println("Enter Coordinates: ");
				int x = Integer.parseInt(sc.next());
				int y = Integer.parseInt(sc.next());
				Coordinates co1 = new Coordinates(x, y);
				p.plotCoordinate(co1);
				System.out.println("Point (" + x + ", " + y + ") plotted");
				break;

			case 10:
				Cluster gear = new Cluster();
				gear.appendList(p.getDataset());
				if (patch)
					gear.appendListPatch(p.getDatasetPatch());
				gear.startClustering();
				int Map[][] = gear.getMap();
				// for(int m1=0; m1<800; m1++) {
				// for(int m2=0; m2<600; m2++) {
				// System.out.print(Map[m1][m2]);
				// }
				// System.out.println();
				// }
				p.plotMap(Map);
				break;

			case 11:
				Boundary boundary = new Boundary();
				boundary.appendList(p.getDataset());
				if (patch)
					boundary.appendListPatch(p.getDatasetPatch());
				boundary.initiateConvexHull();
				System.out.println("Enter Choice: ");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					p.displayPolygon(boundary.getPDList(), Color.YELLOW);
					break;
				case 2:
					p.displayPolygon(boundary.getD1List(), Color.BLUE);
					break;
				case 3:
					p.displayPolygon(boundary.getD2List(), Color.RED);
					break;
				case 4:
					p.displayPolygon(boundary.getSList(), Color.GREEN);
					break;
				case 5:
					p.displayPolygon(boundary.getTList(), Color.PINK);
					break;
				case 6:
					p.displayPolygon(boundary.getT3List(), Color.ORANGE);
					break;
				default:
					System.out.println("Invalid Input");
				}
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
		System.out.println("6: Count Fault Points");
		System.out.println("7: Show Faults");
		System.out.println("8: Calculate Centroid");
		System.out.println("9: Plot Coordinate");
		System.out.println("10: Start Clustering");
		System.out.println("11: Start Boundary Creation");
	}
}
