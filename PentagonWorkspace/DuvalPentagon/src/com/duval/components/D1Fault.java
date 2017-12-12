package com.duval.components;

import com.duval.utils.Coordinates;

public class D1Fault extends Fault{
	
	public D1Fault(int xorigin, int yorigin, int scale) {
		super(xorigin, yorigin, scale, "D1");
		initPoints();
	}
	
	public int len() {
		return 5;
	}

	@Override
	public void initPoints() {
		Coordinates p[] = new Coordinates[len()];
		p[0] = new Coordinates(0, 40);
		p[1] = new Coordinates(38, 12.4);
		p[2] = new Coordinates(32,-6);
		p[3] = new Coordinates(4, 16);
		p[4] = new Coordinates(0, 1.5);
		
		super.points = p;
	}
	
	
	
}
