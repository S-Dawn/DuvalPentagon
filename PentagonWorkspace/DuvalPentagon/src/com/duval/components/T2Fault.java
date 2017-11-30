package com.duval.components;

import com.duval.utils.Coordinates;

public class T2Fault extends Fault{
	
	public T2Fault(int xorigin, int yorigin, int scale) {
		super(xorigin, yorigin, scale, "T2");
		initPoints();
	}
	
		
	public int len() {
		return 3;
	}
	
	@Override
	public void initPoints() {
		Coordinates p[] = new Coordinates[len()];
		p[0] = new Coordinates(1,-32);
		p[1] = new Coordinates(-6,-4);
		p[2] = new Coordinates(-22,-32);
		
		super.points = p;
	}
	
}
