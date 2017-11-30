package com.duval.components;

import com.duval.utils.Coordinates;

public class D2Fault extends Fault{
	
	public D2Fault(int xorigin, int yorigin, int scale) {
		super(xorigin, yorigin, scale, "D2");
		initPoints();
	}
		
	public int len() {
		return 4;
	}
	
	@Override
	public void initPoints() {
		Coordinates p[] = new Coordinates[len()];
		p[0] = new Coordinates(4,16);
		p[1] = new Coordinates(32,-6);
		p[2] = new Coordinates(24,-30);
		p[3] = new Coordinates(-1,-2);
		
		super.points = p;
	}
	

}
