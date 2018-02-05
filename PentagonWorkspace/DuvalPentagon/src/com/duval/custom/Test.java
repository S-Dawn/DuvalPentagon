package com.duval.custom;

import com.duval.utils.Coordinates;

public class Test {
public static void main(String[] args) {
	String test[]= new String [10];
	Coordinates coor1[] = {new Coordinates(0, 0), new Coordinates(1, 1)};
	Coordinates coor2[] = {new Coordinates(0, 0), new Coordinates(1, 1)};
	System.out.println(test[0]);
	System.out.println(coor1.equals(coor2));
}
}
